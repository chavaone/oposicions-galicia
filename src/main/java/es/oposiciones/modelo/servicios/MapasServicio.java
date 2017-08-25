package es.oposiciones.modelo.servicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import es.oposiciones.modelo.util.DistanciaHaversine;
import es.oposiciones.modelo.dao.CentroDao;
import es.oposiciones.modelo.dominio.Centro;
import es.oposiciones.modelo.util.Distancia;

public class MapasServicio {

	private static final String googleMapsKey = "AIzaSyADWRQl_gJg9z7reVzaj8A7btykoJCrxfk";
	private static final String prefijoURLDireccion = "https://maps.googleapis.com/maps/api/geocode/json?address=";
	private static final String sufijoURLDireccion = "&key=";
	private static final String prefijoURL = "http://router.project-osrm.org/table/v1/driving/";
	private static final String sufijoURL = "?sources=0";

	@Autowired
	private CentroDao centroDao;

	public List<Distancia> distancias(String direccion) {
		try {
			String direccionCodificada = URLEncoder.encode(direccion, "UTF-8");
			String url = prefijoURLDireccion + direccionCodificada + sufijoURLDireccion + googleMapsKey;
			JSONObject documentoJSON = new JSONObject(readURL(url));
			String estadoJSON = documentoJSON.getString("status");
			if ("OK".equals(estadoJSON)) {
				JSONObject resultadosJSON = documentoJSON.getJSONArray("results").getJSONObject(0);
				//String direccionFormateada = resultadosJSON.getString("formatted_address");
				JSONObject coordenadas = resultadosJSON.getJSONObject("geometry").getJSONObject("location");
				String coordenadaY = Double.toString(coordenadas.getDouble("lat"));
				String coordenadaX = Double.toString(coordenadas.getDouble("lng"));
				return distancias(coordenadaY, coordenadaX);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Distancia> distancias(String coordenadaY, String coordenadaX) {
		List<Centro> centros = centroDao.buscarTodos();
		List<Distancia> distancias = new ArrayList<Distancia>(centros.size());
		String destinos = coordenadaX + "," + coordenadaY;

		for (Centro centro : centros) {
			destinos += ";" + centro.getCoordenadaX().replaceAll(",", ".") + "," + centro.getCoordenadaY().replaceAll(",", ".");
			Distancia distancia = new Distancia();
			distancia.setCentro(centro);
			Double kms = DistanciaHaversine.calcular(coordenadaY, coordenadaX, centro.getCoordenadaY(), centro.getCoordenadaX());
			distancia.setKms(kms.intValue());
			distancias.add(distancia);
		}

		String url = prefijoURL + destinos + sufijoURL;

		try {
			JSONObject documentoJSON = new JSONObject(readURL(url));
			String codigoJSON = documentoJSON.getString("code");
			if ("Ok".equals(codigoJSON)) {
				JSONArray duracionesJSON = documentoJSON.getJSONArray("durations").optJSONArray(0);
				for (int i = 0; i < centros.size(); i++) {
					long tiempo = duracionesJSON.getLong(i + 1);
					distancias.get(i).setTiempo(tiempo);
					distancias.get(i).setTiempoTexto(getTiempoTexto(tiempo));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

		Collections.sort(distancias, new Comparator<Distancia>() {
			@Override
			public int compare(Distancia d1, Distancia d2) {
				return d1.getTiempo() < d2.getTiempo() ? -1 : 1;
			}
		});
		return distancias;
	}

	private static String getTiempoTexto(long tiempo) {
		String tiempoTexto = "";
		if (tiempo > 3600) {
			tiempoTexto = tiempo / 3600 + " h";
		}
		if (tiempo % 3600 > 60) {
			tiempoTexto += (tiempoTexto.isEmpty() ? "" : " ") + tiempo % 3600 / 60 + " min";
		}
		return tiempoTexto;
	}

	private static String readURL(String urlString) throws IOException {
		BufferedReader reader = null;
		try {
			URL url = new URL(urlString);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuffer buffer = new StringBuffer();
			int read;
			char[] chars = new char[1024];
			while ((read = reader.read(chars)) != -1) {
				buffer.append(chars, 0, read);
			}
			return buffer.toString();
		} finally {
			if (reader != null)
				reader.close();
		}
	}

}
