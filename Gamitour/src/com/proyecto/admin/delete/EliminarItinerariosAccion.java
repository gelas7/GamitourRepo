package com.proyecto.admin.delete;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.service.ServiceItinerarios;
import com.proyecto.service.ServiceItinerariosImp;

import com.proyecto.util.Accion;

public class EliminarItinerariosAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		
		ServiceItinerarios si = new ServiceItinerariosImp();

		String id = request.getParameter("id");

		si.eliminar(si.buscarPorClave(Integer.parseInt(id)));

		return "MostrarAdmin.do?div=itinerarios";
	}

}
