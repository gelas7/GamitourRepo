package com.proyecto.admin.search;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.service.ServiceParadasImp;
import com.proyecto.service.ServicePruebasDeportivasImp;
import com.proyecto.util.Accion;

public class MostrarPruebasDeportivasAccion extends Accion {

	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

		ServicePruebasDeportivasImp spd = new ServicePruebasDeportivasImp();
		ServiceParadasImp sp = new ServiceParadasImp();

		String id = request.getParameter("id");
		request.setAttribute("nombreParada", sp.buscarPorClave(Integer.parseInt(id)).getNombre());
		request.setAttribute("idParada", id);
		request.getSession().setAttribute("listaPruebasDeportivas", spd.buscarPruebasDepPorParada(id));

		return "Procesos/MostrarDetalle/MostrarPruebasDeportivas.jsp";
	}

}
