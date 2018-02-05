package com.proyecto.admin.delete;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.service.ServiceParadasImp;
import com.proyecto.util.Accion;

public class EliminarParadasAccion extends Accion {

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");

		ServiceParadasImp sp = new ServiceParadasImp();

		sp.eliminar(sp.buscarPorClave(Integer.parseInt(id)));

		return "MostrarAdmin.do?div=paradas";
	}

}
