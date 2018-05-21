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
		response.setContentType("text/html;charset=UTF-8");
	
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String fechaactivacion = request.getParameter("fechaactivacion");
		String fechaconsumo = request.getParameter("fechaconsumo");
		String idCliente = request.getParameter("cliente");
		String puntos = request.getParameter("puntos");
		Date date1 = null;
		Date date2 = null;

		try {
			if (fechaactivacion .length()>0)
				date1 = formatter.parse(fechaactivacion);
			if (fechaconsumo .length()>0)
				date2 = formatter.parse(fechaconsumo);

		} catch (ParseException e) {
			System.out.println("Fallo al convertir fechas. " + e.getMessage());
		}

		Premio premio = sp.buscarPorClave(Integer.parseInt(id));

		if (nombre .length()>0) // Compruebo si se han hecho cambios
			premio.setNombre(nombre);
		if (descripcion .length()>0)
			premio.setDescripcion(descripcion);
		if (idCliente!=null) {
			Cliente c = sc.buscarPorClave(Integer.parseInt(idCliente));
			premio.setCliente(c);
		}
		if (fechaactivacion .length()>0)
			premio.setFechaactivacion(date1);
		if (fechaconsumo .length()>0)
			premio.setFechaconsumo(date2);
		if (puntos.length() > 0)
			premio.setPuntos(Integer.parseInt(puntos));

		sp.actualizar(premio);

		return "MostrarAdmin.do?div=premios";
	}

}