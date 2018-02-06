package com.proyecto.admin.insert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.modelo.Cliente;

import com.proyecto.modelo.Multimedia;

import com.proyecto.service.ServiceClientes;
import com.proyecto.service.ServiceClientesImp;
import com.proyecto.service.ServiceMultimedias;
import com.proyecto.service.ServiceMultimediasImp;
import com.proyecto.util.Accion;

public class InsertarMultimediasAccion extends Accion {

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

		String cliente = request.getParameter("cliente");
		String fecha = request.getParameter("fecha");
		String comentario = request.getParameter("comentario");
		String imagen = request.getParameter("imagen");
		String video = request.getParameter("video");
		String idPd = request.getParameter("pruebaD");
		String puntos = request.getParameter("puntos");

		Date date1 = null;

		try {

			if (fecha != "")
				date1 = formatter.parse(fecha);

		} catch (ParseException e) {
			System.out.println("Fallo al convertir fechas. " + e.getMessage());
		}

		ServiceMultimedias sm = new ServiceMultimediasImp();

		ServiceClientes sc = new ServiceClientesImp();

		Cliente c = sc.buscarPorClave(Integer.parseInt(cliente));

		sm.insertar(new Multimedia(c, date1, comentario, imagen, video, Integer.parseInt(idPd), Integer.parseInt(puntos)));

		request.setAttribute("listaMultimedias", sm.buscarTodos());

		return "MostrarAdmin.do?div=multimedias";
	}

}