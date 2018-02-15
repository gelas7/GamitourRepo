package com.proyecto.admin.search;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.service.ServiceParadas;
import com.proyecto.service.ServiceParadasImp;
import com.proyecto.util.Accion;

public class MostrarParadasAccion extends Accion {

	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

	
		ServiceParadas sp = new ServiceParadasImp();
		String id = request.getParameter("id");
		request.getSession().setAttribute("listaParadas", sp.buscarParadasPorIt(id));
		
		// Aqui guardo el nombre de la tabla que se esta manejando actualmente
		request.setAttribute("divActual", request.getParameter("div"));

		return "Procesos/MostrarParadas.jsp";
	}

}
