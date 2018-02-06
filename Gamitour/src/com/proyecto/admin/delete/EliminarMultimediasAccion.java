package com.proyecto.admin.delete;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.service.ServiceMultimediasImp;
import com.proyecto.util.Accion;

public class EliminarMultimediasAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		
		ServiceMultimediasImp sm = new ServiceMultimediasImp();

		String id = request.getParameter("id");

		sm.eliminar(sm.buscarPorClave(Integer.parseInt(id)));

		request.setAttribute("listaMultimedias", sm.buscarTodos());

		return "MostrarAdmin.do?div=multimedias";
	}

}