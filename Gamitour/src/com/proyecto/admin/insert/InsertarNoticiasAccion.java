package com.proyecto.admin.insert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.modelo.Noticia;
import com.proyecto.service.ServiceNoticias;
import com.proyecto.service.ServiceNoticiasImp;
import com.proyecto.util.Accion;

public class InsertarNoticiasAccion extends Accion {

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		String nombre = request.getParameter("nombre");
		String texto = request.getParameter("texto");
		String fecha = request.getParameter("fechaalta");
		String fechac = request.getParameter("fechacaducidad");
		String imagen = request.getParameter("imagen");
		Date date = null;
		Date date2 = null;
		
		try {
			date = formatter.parse(fecha);
			date2 = formatter.parse(fechac);

		} catch (ParseException e) {

			e.printStackTrace();
		}

		ServiceNoticias sn = new ServiceNoticiasImp();
		sn.insertar(new Noticia(nombre, texto, date, date2, imagen));

		return "MostrarAdmin.do?div=noticias";
	}

}
