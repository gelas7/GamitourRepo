package com.proyecto.admin.search;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.service.ServiceMultimediasImp;
import com.proyecto.service.ServicePruebasDeportivasImp;
import com.proyecto.util.Accion;

public class MostrarMultimediasAccion extends Accion {

	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

		ServiceMultimediasImp sm = new ServiceMultimediasImp();
		ServicePruebasDeportivasImp spd = new ServicePruebasDeportivasImp();
		
		String id = request.getParameter("id");
		request.getSession().setAttribute("listaMultimedias", sm.mostrarMultimediasPorPd(id));
		request.setAttribute("nombrePruebaDeportiva", spd.buscarPorClave(Integer.parseInt(id)).getNombre());
		
		return "Procesos/MostrarMultimedias.jsp";
	}

}
