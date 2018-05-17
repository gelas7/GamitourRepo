package com.proyecto.admin.update;

import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.modelo.Itinerario;
import com.proyecto.modelo.Parada;
import com.proyecto.service.ServiceItinerariosImp;
import com.proyecto.service.ServiceParadasImp;
import com.proyecto.util.Accion;

public class ModificarParadasAccion extends Accion {

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
	ServiceParadasImp sp = new ServiceParadasImp();
	ServiceItinerariosImp si = new ServiceItinerariosImp();

	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String numeroParada = request.getParameter("numeroParada");
		String ubicacion = request.getParameter("ubicacion");
		String historia = request.getParameter("historia");
		String anecdotario = request.getParameter("anecdotario");
		String gastronomia = request.getParameter("gastronomia");
		String itinerario = request.getParameter("itinerario");
		String latitud = request.getParameter("latitud");
		String longitud = request.getParameter("longitud");

		Parada parada = sp.buscarPorClave(Integer.parseInt(id));

		if (nombre.length() > 0) // Compruebo si se han hecho cambios
			parada.setNombre(nombre);
		if (numeroParada.length() > 0)
			parada.setNumeroParada(Integer.parseInt(numeroParada));
		if (ubicacion.length() > 0 && latitud.length() > 0 && longitud.length() > 0) {
			float lat = Float.parseFloat(latitud);
			float lng = Float.parseFloat(longitud);
			parada.setUbicacion(ubicacion);
			parada.setLatitud(lat);
			parada.setLongitud(lng);
		}
		if (historia.length() > 0)
			parada.setHistoria(historia);
		if (anecdotario.length() > 0)
			parada.setAnecdotario(anecdotario);
		if (gastronomia.length() > 0)
			parada.setGastronomia(gastronomia);
		if (itinerario.length() > 0) {
			Itinerario it = si.buscarPorClave(Integer.parseInt(itinerario));
			parada.setItinerario(it);
		}

		sp.actualizar(parada);

		return "MostrarAdmin.do?div=paradas";
	}

}