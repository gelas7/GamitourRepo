package com.proyecto.admin.insert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.modelo.Parada;
import com.proyecto.modelo.PruebaDeportiva;
import com.proyecto.service.ServiceParadasImp;
import com.proyecto.service.ServicePruebasDeportivasImp;
import com.proyecto.util.Accion;

public class InsertarPruebasDeportivasAccion extends Accion {
	
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

		ServicePruebasDeportivasImp spd = new ServicePruebasDeportivasImp();
		
		ServiceParadasImp sp = new ServiceParadasImp();
		response.setContentType("text/html;charset=UTF-8");
	
		String nombre = request.getParameter("nombre");
		String fechaInicio = request.getParameter("fechaInicio");
		String fechaFin = request.getParameter("fechaFin");
		String explicacion = request.getParameter("explicacion");
		String puntos = request.getParameter("puntos");
		String parada = request.getParameter("parada");
		Date date1 = null;
		Date date2 = null;
		
		try {
			date1 = formatter.parse(fechaInicio);
			date2 = formatter.parse(fechaFin);

		} catch (ParseException e) {

			e.printStackTrace();
		}

		Parada p = sp.buscarPorClave(Integer.parseInt(parada));
		PruebaDeportiva pd = new PruebaDeportiva(p, nombre, date1, date2, explicacion, Integer.parseInt(puntos));
		spd.insertar(pd);

		return "MostrarAdmin.do?div=pruebasdeportivas";
	}

}
