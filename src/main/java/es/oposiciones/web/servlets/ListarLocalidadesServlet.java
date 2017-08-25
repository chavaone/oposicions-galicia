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

@WebServlet(urlPatterns = {"/listar-localidades"})
public class ListarLocalidadesServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Autowired
	private EntidadesServicio entidadesServicio;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String listarLocalidades = "/jsp/listar-localidades.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(listarLocalidades);
		request.setAttribute("localidades", entidadesServicio.getLocalidades());

		dispatcher.forward(request, response);
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}

}
