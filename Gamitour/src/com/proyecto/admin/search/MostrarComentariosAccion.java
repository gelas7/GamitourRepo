package com.proyecto.admin.search;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.service.ServiceComentariosImp;


import com.proyecto.util.Accion;

public class MostrarComentariosAccion extends Accion {

	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

		ServiceComentariosImp sc = new ServiceComentariosImp();

		String id = request.getParameter("id");

		request.getSession().setAttribute("listaComentarios", sc.buscarComentPorMultimedia(id));

		return "Procesos/MostrarComentarios.jsp";
	}

}
