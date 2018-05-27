package com.proyecto.publico.delete;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.service.ServiceReservasImp;
import com.proyecto.util.Accion;

public class EliminarReservasClienteAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		
		ServiceReservasImp sr = new ServiceReservasImp();
		
		String id = request.getParameter("id");

		sr.eliminar(sr.buscarPorClave(Integer.parseInt(id)));

		return "/MostrarPublico.cl?id=usuario";
		
	}

}
