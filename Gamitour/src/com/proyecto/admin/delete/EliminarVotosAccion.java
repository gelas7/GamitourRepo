package com.proyecto.admin.delete;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.service.ServiceVotosImp;
import com.proyecto.util.Accion;

public class EliminarVotosAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		
		ServiceVotosImp sv = new ServiceVotosImp();
		
		String id = request.getParameter("id");

		sv.eliminar(sv.buscarPorClave(Integer.parseInt(id)));

		return "MostrarAdmin.do?div=votos";
		
	}

}
