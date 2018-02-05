package com.proyecto.admin.delete;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.service.ServicePruebasCulturalesImp;
import com.proyecto.util.Accion;

public class EliminarPruebasCulturalesAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		
		ServicePruebasCulturalesImp spc= new ServicePruebasCulturalesImp();

		String id = request.getParameter("id");

		spc.eliminar(spc.buscarPorClave(Integer.parseInt(id)));

		return "MostrarAdmin.do?div=pruebasculturales";
	}

}
