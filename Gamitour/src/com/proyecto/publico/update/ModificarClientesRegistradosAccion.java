package com.proyecto.publico.update;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.modelo.Cliente;

import com.proyecto.service.ServiceClientesImp;
import com.proyecto.service.ServiceRolesImp;

@javax.servlet.annotation.MultipartConfig
@WebServlet("/RegistrarClientesAccion")
public class ModificarClientesRegistradosAccion extends HttpServlet {

	private static final long serialVersionUID = 1L;

	ServiceClientesImp sc = new ServiceClientesImp();
	ServiceRolesImp sr = new ServiceRolesImp();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String email = request.getParameter("email");
		String password = request.getParameter("password1");

		Cliente c = sc.buscarPorClave(Integer.parseInt(id));

		if (password.length() > 0)
			c.setPassword(password);
		if (email.length() > 0)
			c.setEmail(email);

		sc.actualizar(c); // Actualizo cliente

		response.sendRedirect("/Gamitour/Cliente/Login/Register.jsp");
	}

}
