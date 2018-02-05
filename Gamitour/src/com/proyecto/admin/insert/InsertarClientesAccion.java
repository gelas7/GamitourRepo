package com.proyecto.admin.insert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.modelo.Cliente;
import com.proyecto.modelo.Rol;
import com.proyecto.service.ServiceClientesImp;
import com.proyecto.service.ServiceRolesImp;
import com.proyecto.util.Accion;

public class InsertarClientesAccion extends Accion {

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String fechanacimiento = request.getParameter("fechanacimiento");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String telefono = request.getParameter("telefono");
		String direccion = request.getParameter("direccion");
		String codigopostal = request.getParameter("codigopostal");
		String puntosacumulados = request.getParameter("puntosacumulados");
		String rol = request.getParameter("rol");
		String avatar = request.getParameter("avatar");
		Date date1 = null;

		try {
			if (fechanacimiento != "")
				date1 = formatter.parse(fechanacimiento);
		} catch (ParseException e) {
			System.out.println("Fallo al convertir fechas. " + e.getMessage());
		}

		ServiceClientesImp sc = new ServiceClientesImp();
		ServiceRolesImp sr = new ServiceRolesImp();

		Rol r = sr.buscarPorClave(Integer.parseInt(rol));// Creo rol a partir del id

		Cliente c = new Cliente(r, nombre, apellidos, date1, email, password, telefono, direccion, codigopostal, avatar,
				Integer.parseInt(puntosacumulados), new Date());

		sc.insertar(c); // Inserto cliente

		return "MostrarAdmin.do?div=clientes";
	}

}
