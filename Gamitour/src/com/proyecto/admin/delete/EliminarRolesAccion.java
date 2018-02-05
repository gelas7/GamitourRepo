package com.proyecto.admin.delete;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.service.ServiceRolesImp;
import com.proyecto.util.Accion;

public class EliminarRolesAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		
		ServiceRolesImp sr= new ServiceRolesImp();

		String id = request.getParameter("id");

		sr.eliminar(sr.buscarPorClave(Integer.parseInt(id)));

		return "MostrarAdmin.do?div=roles";
	}

}
