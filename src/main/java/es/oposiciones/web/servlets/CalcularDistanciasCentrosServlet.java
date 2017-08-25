package es.oposiciones.web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import es.oposiciones.modelo.servicios.MapasServicio;
import es.oposiciones.modelo.util.Distancia;

@WebServlet(urlPatterns = {"/calcular-distancias-centros"})
public class CalcularDistanciasCentrosServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String errorGeolocalizacion = "Seleccionada búsqueda por geolocalización. Debe permitirla en el navegador.";
	private static final String errorDireccion = "Seleccionada búsqueda por dirección. Debe introducir una dirección válida.";
	private static final String errorCoordenadas = "Seleccionada búsqueda por coordenadas. Debe introducir unas coordenadas válidas.";
	private static final String errorMapa = "Seleccionada búsqueda por mapa. Debe seleccionar un punto en el mapa.";

	@Autowired
	private MapasServicio mapasServicio;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String calcularDistanciasCentros = "/jsp/calcular-distancias-centros.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(calcularDistanciasCentros);

		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String calcularDistanciasCentros = "/jsp/calcular-distancias-centros.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(calcularDistanciasCentros);
		request.setCharacterEncoding("UTF-8");

		// Se recogen los datos sobre la ubicación
		List<Distancia> distancias = null;
		String error = null;
		String tipoBusqueda = request.getParameter("tipoBusqueda");
		if (tipoBusqueda.equals("geolocalizacion")) {
			String[] geolocalizacion = request.getParameter("geolocalizacion").split(", ");
			if (geolocalizacion.length != 2) {
				error = errorGeolocalizacion;
			} else {
				distancias = mapasServicio.distancias(geolocalizacion[0], geolocalizacion[1]);
				if (distancias == null) {
					error = errorGeolocalizacion;
				}
			}
		} else if (tipoBusqueda.equals("direccion")) {
			distancias = mapasServicio.distancias(request.getParameter("escribirDireccion"));
			if (distancias == null) {
				error = errorDireccion;
			}
		} else if (tipoBusqueda.equals("coordenadas")) {
			distancias = mapasServicio.distancias(request.getParameter("escribirCoordenadaY"), request.getParameter("escribirCoordenadaX"));
			if (distancias == null) {
				error = errorCoordenadas;
			}
		} else if (tipoBusqueda.equals("mapa")) {
			String[] mapa = request.getParameter("mapa").split(", ");
			if (mapa.length != 2) {
				error = errorMapa;
			} else {
				distancias = mapasServicio.distancias(mapa[0], mapa[1]);
				if (distancias == null) {
					error = errorMapa;
				}
			}
		}

		// Si se produce un error, se vuelve a la página de selección de punto de origen
		if (error != null) {
			request.setAttribute("error", error);
		// Se va a la página de distancias a los centros
		} else {
			String listarDistanciasCentros = "/jsp/listar-distancias-centros.jsp";
			dispatcher = getServletContext().getRequestDispatcher(listarDistanciasCentros);
			request.setAttribute("distancias", distancias);
		}

		dispatcher.forward(request, response);
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}

}
