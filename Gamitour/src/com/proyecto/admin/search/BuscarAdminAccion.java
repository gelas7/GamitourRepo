package com.proyecto.admin.search;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.modelo.Cliente;
import com.proyecto.service.ServiceClientesImp;
import com.proyecto.util.Accion;

public class BuscarAdminAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

		ServiceClientesImp sc = new ServiceClientesImp();

		String url = (String) request.getSession().getAttribute("url");
		String email = (String) request.getParameter("email"); // Recojo los parametros del login
		String pass = (String) request.getParameter("password");
		Cliente c = sc.buscarClientePorEmail(email);

		String rutaSalida = ""; // Por aqui seguira el programa al final

		if (c != null) { // Si usuario existe
			if (c.getPassword().equals(pass)) // Compruebo pass
			{
				String rol = c.getRol().getNombre().toLowerCase(); // Extraigo rol

				if (rol.equals("administrador")) {
					System.out.println("Bienvenido admin");
					request.getSession().setAttribute("email", c.getEmail());
					rutaSalida = url;
				} else {
					rutaSalida = "errores/error.jsp";
				}

			} else {// Contraseña mal
				rutaSalida = "errores/incorrect.jsp";
			}
		} else {
			rutaSalida = "errores/incorrect.jsp";
		}
		
		return rutaSalida;
	}
}