package com.proyecto.admin.insert;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.modelo.Itinerario;

import com.proyecto.service.ServiceItinerarios;
import com.proyecto.service.ServiceItinerariosImp;

import com.proyecto.util.Accion;

public class InsertarItinerariosAccion extends Accion {

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		String nombre = request.getParameter("nombre");
		String categoria = request.getParameter("categoria");
		String duracion = request.getParameter("duracion");
		String ubicacion = request.getParameter("ubicacion");

		ServiceItinerarios si = new ServiceItinerariosImp();
		si.insertar(new Itinerario(nombre, categoria, duracion, ubicacion));

		return "MostrarAdmin.do?div=itinerarios";
	}

}
