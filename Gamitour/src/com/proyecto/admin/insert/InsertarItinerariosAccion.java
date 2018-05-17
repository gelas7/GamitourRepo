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
	ServiceItinerarios si = new ServiceItinerariosImp();

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

		response.setContentType("text/html;charset=UTF-8");

		String nombre = request.getParameter("nombre");
		String categoria = request.getParameter("categoria");
		String duracion = request.getParameter("duracion");
		String ubicacion = request.getParameter("ubicacion");

		si.insertar(new Itinerario(nombre, categoria, duracion, ubicacion));

		return "MostrarAdmin.do?div=itinerarios";
	}

}
