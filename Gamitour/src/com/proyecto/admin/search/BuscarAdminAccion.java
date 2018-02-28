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
		String email = (String) request.getParameter("email"); 
		String pass = (String) request.getParameter("password");
		Cliente c = sc.buscarClientePorEmail(email);

		System.out.println("Entro en buscaradmin con url destino: " + url);
		System.out.println("Email: "+email);
		System.out.println("Pass: "+pass);

		String rutaSalida = "errores/incorrect.jsp";

		if (c != null) { // Si usuario existe
			if (c.getPassword().equals(pass)) // Compruebo pass
			{
				String rol = c.getRol().getNombre().toLowerCase(); // Extraigo rol

				if (rol.equals("administrador")) {
					request.getSession().setAttribute("email", c.getEmail());
					rutaSalida = url; // MODIFICO SALIDA
				} else {
					rutaSalida = "errores/error.jsp"; // MODIFICO SALIDA
				}
			}
		}
		System.out.println("Salgo con email: "+email+" y rutasalida: "+rutaSalida);
		return rutaSalida;
	}
}