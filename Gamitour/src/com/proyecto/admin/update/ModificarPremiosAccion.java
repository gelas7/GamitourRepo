package com.proyecto.admin.update;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.modelo.Cliente;

import com.proyecto.modelo.Premio;
import com.proyecto.service.ServiceClientesImp;

import com.proyecto.service.ServicePremiosImp;
import com.proyecto.util.Accion;

public class ModificarPremiosAccion extends Accion {

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

		ServicePremiosImp sp = new ServicePremiosImp();
		ServiceClientesImp sc = new ServiceClientesImp();

		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String imagen = request.getParameter("imagen");
		String fechaactivacion = request.getParameter("fechaactivacion");
		String fechaconsumo = request.getParameter("fechaconsumo");
		String cliente = request.getParameter("cliente");
		String puntos = request.getParameter("puntos");
		String id = request.getParameter("id");
		Date date1 = null;
		Date date2 = null;

		try {

			if (fechaactivacion != "")
				date1 = formatter.parse(fechaactivacion);

			if (fechaconsumo != "")
				date2 = formatter.parse(fechaconsumo);

		} catch (ParseException e) {
			System.out.println("Fallo al convertir fechas. " + e.getMessage());
		}

		Premio premio = sp.buscarPorClave(Integer.parseInt(id));

		if (nombre != "") // Compruebo si se han hecho cambios
			premio.setNombre(nombre);
		if (descripcion != "")
			premio.setDescripcion(descripcion);
		if (imagen != "")
			premio.setImagen(imagen);
		if (cliente != "") {
			Cliente c = sc.buscarPorClave(Integer.parseInt(cliente));
			premio.setCliente(c);
		}
		if (fechaactivacion != "")
			premio.setFechaactivacion(date1);
		if (fechaconsumo != "")
			premio.setFechaconsumo(date2);
		if (puntos != "")
			premio.setPuntos(Integer.parseInt(puntos));

		sp.actualizar(premio);

		return "MostrarAdmin.do?div=premios";
	}

}