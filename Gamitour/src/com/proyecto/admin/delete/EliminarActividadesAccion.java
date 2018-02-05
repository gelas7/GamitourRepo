package com.proyecto.admin.delete;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.service.ServiceActividadesImp;
import com.proyecto.util.Accion;

public class EliminarActividadesAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

		ServiceActividadesImp sa = new ServiceActividadesImp();

		String id = request.getParameter("id");

		sa.eliminar(sa.buscarPorClave(Integer.parseInt(id)));

		return "MostrarAdmin.do?div=actividades";
	}

}
