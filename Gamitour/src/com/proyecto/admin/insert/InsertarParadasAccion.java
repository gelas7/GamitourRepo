package com.proyecto.admin.insert;

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

		Itinerario i = si.buscarPorClave(Integer.parseInt(itinerario));

		Double latitud = 1.1;
		Double longitud = 1.1;

		// AQUI PROCESAMOS LATITUD Y LONGITUD EN FUNCIÓN DE LA UBICACION

		Parada p = new Parada(i, nombre, Integer.parseInt(numeroParada), ubicacion, historia, anecdotario, gastronomia,
				imagen, latitud, longitud);

		sp.insertar(p);

		return "MostrarAdmin.do?div=paradas";
	}

}
