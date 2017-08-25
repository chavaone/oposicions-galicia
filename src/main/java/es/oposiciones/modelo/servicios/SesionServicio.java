package es.oposiciones.modelo.servicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class SesionServicio {

	public String login(String accessToken, HttpServletResponse response) throws IOException {
		String urlString = "https://graph.facebook.com/me?fields=id,name&access_token=" + accessToken;
		URL url = new URL(urlString);
		HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String responseJSON = in.readLine();
		in.close();
		JSONObject json = new JSONObject(responseJSON);
		String idFacebook = json.getString("id");
		crearCookie("idFacebook", idFacebook, response);
		return idFacebook;
	}

	public void crearCookie(String nombre, String valor, HttpServletResponse response) {
		Cookie cookie = new Cookie(nombre, valor);
		cookie.setMaxAge(60*60*24*30);
		cookie.setHttpOnly(true);
		response.addCookie(cookie);
	}

	public String leerCookie(String nombre, HttpServletRequest request) {
		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equals(nombre)) {
				return cookie.getValue();
			}
		}
		return null;
	}

	public void eliminarCookies(HttpServletRequest request, HttpServletResponse response) {
		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equals("idFacebook") || cookie.getName().equals("accessToken")) {
				cookie.setValue(null);
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
	}

}
