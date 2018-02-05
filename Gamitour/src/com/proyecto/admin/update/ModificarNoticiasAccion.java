package com.proyecto.admin.update;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.modelo.Noticia;
import com.proyecto.service.ServiceNoticias;
import com.proyecto.service.ServiceNoticiasImp;
import com.proyecto.util.Accion;

public class ModificarNoticiasAccion extends Accion {

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");
		String nombreN = request.getParameter("nombreN");
		String texto = request.getParameter("texto");
		String fecha = request.getParameter("fechaalta");
		String fechac = request.getParameter("fechacaducidad");
		String imagen = request.getParameter("imagen");
		Date date = null;
		Date date2 = null;

		try {
			if (fecha != "")
				date = formatter.parse(fecha);
			if (fechac != "")
				date2 = formatter.parse(fechac);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		ServiceNoticias sn = new ServiceNoticiasImp();
		Noticia noticia = sn.buscarPorClave(Integer.parseInt(id));

		if (nombreN != "") // Compruebo si se han hecho cambios
			noticia.setNombre(nombreN);

		if (texto != "") // Compruebo si se han hecho cambios
			noticia.setTexto(texto);

		if (date != null) // Compruebo si se han hecho cambios
			noticia.setFechaalta(date);

		if (date2 != null) // Compruebo si se han hecho cambios
			noticia.setFechacaducidad(date2);

		if (imagen != "") // Compruebo si se han hecho cambios
			noticia.setImagen(imagen);

		sn.actualizar(noticia);

		return "MostrarAdmin.do?div=noticias";
	}

}