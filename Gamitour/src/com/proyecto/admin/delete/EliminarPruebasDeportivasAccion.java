package com.proyecto.admin.delete;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.service.ServicePruebasDeportivasImp;
import com.proyecto.util.Accion;

public class EliminarPruebasDeportivasAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		
		ServicePruebasDeportivasImp spd= new ServicePruebasDeportivasImp();

		String id = request.getParameter("id");

		spd.eliminar(spd.buscarPorClave(Integer.parseInt(id)));

		return "MostrarAdmin.do?div=pruebasdeportivas";
	}

}
