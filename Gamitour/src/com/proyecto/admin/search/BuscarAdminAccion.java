package com.proyecto.admin.search;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.proyecto.modelo.Cliente;
import com.proyecto.service.ServiceClientesImp;
import com.proyecto.util.Accion;

public class BuscarAdminAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		ServiceClientesImp sc = new ServiceClientesImp();

		String url = (String) session.getAttribute("url");
		String email = (String) request.getParameter("email"); 
		String pass = (String) request.getParameter("password");
		Cliente c = sc.buscarClientePorEmail(email);

		String rutaSalida = "errores/incorrect.jsp";

		if (c != null) { // Si usuario existe
			if (c.getPassword().equals(pass)) // Compruebo pass
			{
				String rol = c.getRol().getNombre().toLowerCase(); // Extraigo rol

				if (rol.equals("administrador")) {
					session.setAttribute("email", c.getEmail());
					rutaSalida = url;
				} else {
					rutaSalida = "errores/error.jsp";
				}
			}
		}
		return rutaSalida;
	}
}