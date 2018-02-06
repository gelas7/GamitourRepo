package com.proyecto.admin.delete;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.proyecto.service.ServiceComentariosImp;
import com.proyecto.util.Accion;

public class EliminarComentariosAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");

		ServiceComentariosImp scom = new ServiceComentariosImp();
		
		scom.eliminar(scom.buscarPorClave(Integer.parseInt(id)));

		return "MostrarAdmin.do?div=comentarios";
	}

}
