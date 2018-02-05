package com.proyecto.admin.delete;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.service.ServiceClientesImp;

import com.proyecto.util.Accion;

public class EliminarClientesAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

		ServiceClientesImp sc = new ServiceClientesImp();

		String id = request.getParameter("id");

		sc.eliminar(sc.buscarPorClave(Integer.parseInt(id)));

		return "MostrarAdmin.do?div=clientes";
	}

}
