package com.proyecto.admin.update;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.modelo.Itinerario;

import com.proyecto.service.ServiceItinerarios;
import com.proyecto.service.ServiceItinerariosImp;

import com.proyecto.util.Accion;

public class ModificarItinerariosAccion extends Accion {

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");
		String nombreN = request.getParameter("nombreN");
		String categoria = request.getParameter("categoria");
		String duracion = request.getParameter("duracion");
		String ubicacion = request.getParameter("ubicacion");

		ServiceItinerarios si = new ServiceItinerariosImp();

		Itinerario i = si.buscarPorClave(Integer.parseInt(id));

		if (nombreN != "")
			i.setNombre(nombreN);
		if (categoria != "")
			i.setCategoria(categoria);
		if (duracion != "")
			i.setDuracion(duracion);
		if (ubicacion != "")
			i.setUbicacion(ubicacion);

		si.actualizar(i);

		return "MostrarAdmin.do?div=itinerarios";
	}

}