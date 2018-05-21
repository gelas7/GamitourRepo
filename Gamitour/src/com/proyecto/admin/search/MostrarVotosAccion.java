package com.proyecto.admin.search;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.service.ServiceVotosImp;
import com.proyecto.util.Accion;

public class MostrarVotosAccion extends Accion {

	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

		ServiceVotosImp sv = new ServiceVotosImp();

		String id = request.getParameter("id");

		request.getSession().setAttribute("listaVotos", sv.buscarVotosPorMultimedia(id));

		return "Admin/MostrarDetalle/MostrarVotos.jsp";
	}

}
