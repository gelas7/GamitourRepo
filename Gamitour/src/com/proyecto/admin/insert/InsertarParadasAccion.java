package com.proyecto.admin.insert;

import java.text.NumberFormat;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.modelo.Itinerario;
import com.proyecto.modelo.Parada;

import com.proyecto.service.ServiceItinerariosImp;
import com.proyecto.service.ServiceParadasImp;
import com.proyecto.util.Accion;

public class InsertarParadasAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

		ServiceParadasImp sp = new ServiceParadasImp();

		ServiceItinerariosImp si = new ServiceItinerariosImp();

		String nombre = request.getParameter("nombre");
		String numeroParada = request.getParameter("numeroParada");
		String ubicacion = request.getParameter("ubicacion");
		String historia = request.getParameter("historia");
		String anecdotario = request.getParameter("anecdotario");
		String gastronomia = request.getParameter("gastronomia");
		String imagen = request.getParameter("imagen");
		String itinerario = request.getParameter("itinerario");
		String latitud = request.getParameter("latitud");
		String longitud = request.getParameter("longitud");
		
		float lat = Float.parseFloat(latitud);
		float lng = Float.parseFloat(longitud);
		
		Itinerario i = si.buscarPorClave(Integer.parseInt(itinerario));

		Parada p = new Parada(i, nombre, Integer.parseInt(numeroParada), ubicacion, historia, anecdotario, gastronomia,
				imagen, lat, lng);

		sp.insertar(p);

		return "MostrarAdmin.do?div=paradas";
	}

}
