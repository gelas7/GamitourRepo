package com.proyecto.admin.search;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.service.ServiceItinerariosImp;
import com.proyecto.service.ServiceParadasImp;
import com.proyecto.util.Accion;

public class MostrarParadasAccion extends Accion {

	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

		ServiceParadasImp sp = new ServiceParadasImp();
		ServiceItinerariosImp si = new ServiceItinerariosImp();
		
		String id = request.getParameter("id");
		request.getSession().setAttribute("listaParadas", sp.buscarParadasPorIt(id));
		request.setAttribute("nombreItinerario", si.buscarPorClave(Integer.parseInt(id)).getNombre());
		
		return "Procesos/MostrarParadas.jsp";
	}

}
