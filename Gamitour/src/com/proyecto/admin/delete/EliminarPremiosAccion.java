package com.proyecto.admin.delete;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.service.ServicePremiosImp;
import com.proyecto.util.Accion;

public class EliminarPremiosAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");

		ServicePremiosImp sp = new ServicePremiosImp();

		sp.eliminar(sp.buscarPorClave(Integer.parseInt(id)));

		return "MostrarAdmin.do?div=premios";
	}

}
