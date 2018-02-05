package com.proyecto.admin.update;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.modelo.Cliente;
import com.proyecto.service.ServiceClientesImp;
import com.proyecto.util.Accion;

public class ModificarClientesAccion extends Accion {

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String fechanacimiento = request.getParameter("fechanacimiento");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String telefono = request.getParameter("telefono");
		String direccion = request.getParameter("direccion");
		String codigopostal = request.getParameter("codigopostal");
		String puntosacumulados = request.getParameter("puntosacumulados");
		String avatar = request.getParameter("avatar");
		Date date1 = null;

		try {
			if (fechanacimiento != "")
				date1 = formatter.parse(fechanacimiento);
		} catch (ParseException e) {
			System.out.println("Fallo al convertir fechas. " + e.getMessage());
		}

		ServiceClientesImp sc = new ServiceClientesImp();
		Cliente c = sc.buscarPorClave(Integer.parseInt(id));

		if (nombre != "")
			c.setNombre(nombre);
		if (apellidos != "")
			c.setApellidos(apellidos);
		if (date1 != null)
			c.setFechanacimiento(date1);
		if (email != "")
			c.setEmail(email);
		if (password != "")
			c.setPassword(password);
		if (telefono != "")
			c.setTelefono(telefono);
		if (direccion != "")
			c.setDireccion(direccion);
		if (codigopostal != "")
			c.setCodigopostal(codigopostal);
		if (puntosacumulados != "")
			c.setPuntosacumulados(Integer.parseInt(puntosacumulados));
		if (avatar != "")
			c.setAvatar(avatar);

		sc.actualizar(c);

		return "MostrarAdmin.do?div=clientes";
	}

}