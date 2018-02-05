package com.proyecto.admin.delete;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.service.ServiceNoticias;
import com.proyecto.service.ServiceNoticiasImp;
import com.proyecto.util.Accion;

public class EliminarNoticiasAccion extends Accion {

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");

		ServiceNoticias sn = new ServiceNoticiasImp();

		sn.eliminar(sn.buscarPorClave(Integer.parseInt(id)));

		return "MostrarAdmin.do?div=noticias";
	}

}
