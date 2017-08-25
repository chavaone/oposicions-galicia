package es.oposiciones.web.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import es.oposiciones.modelo.servicios.EntidadesServicio;

@WebServlet(urlPatterns = {"/listar-centros"})
public class ListarCentrosServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Autowired
	private EntidadesServicio entidadesServicio;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String listarCentros = "/jsp/listar-centros.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(listarCentros);
		request.setAttribute("centros", entidadesServicio.getCentros());

		dispatcher.forward(request, response);
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}

}
