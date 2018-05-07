package com.proyecto.admin.update;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.modelo.PruebaDeportiva;
import com.proyecto.service.ServiceParadasImp;
import com.proyecto.service.ServicePruebasDeportivasImp;
import com.proyecto.util.Accion;

public class ModificarPruebasDeportivasAccion extends Accion {

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String fechaInicio = request.getParameter("fechaInicio");
		String fechaFin = request.getParameter("fechaFin");
		String explicacion = request.getParameter("explicacion");
		String puntos = request.getParameter("puntos");
		String parada = request.getParameter("parada");
		Date date1 = null;
		Date date2 = null;

		try {
			if (fechaInicio.length() > 0)
				date1 = formatter.parse(fechaInicio);
			if (fechaFin.length() > 0)
				date2 = formatter.parse(fechaFin);

		} catch (ParseException e) {

			e.printStackTrace();
		}

		ServicePruebasDeportivasImp spd = new ServicePruebasDeportivasImp();
		ServiceParadasImp sp = new ServiceParadasImp();
		PruebaDeportiva prueba = spd.buscarPorClave(Integer.parseInt(id));

		if (nombre.length() > 0)
			prueba.setNombre(nombre);
		if (date1 != null)
			prueba.setFechainicio(date1);
		if (date2 != null)
			prueba.setFechainicio(date2);
		if (explicacion.length() > 0)
			prueba.setExplicacion(explicacion);
		if (puntos.length() > 0)
			prueba.setPuntos(Integer.parseInt(puntos));
		if (parada.length() > 0)
			prueba.setParada(sp.buscarPorClave(Integer.parseInt(parada)));

		spd.actualizar(prueba);

		return "MostrarAdmin.do?div=pruebasdeportivas";
	}

}