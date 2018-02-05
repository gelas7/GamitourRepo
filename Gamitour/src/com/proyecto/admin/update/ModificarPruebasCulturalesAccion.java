package com.proyecto.admin.update;

import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.modelo.PruebaCultural;
import com.proyecto.service.ServiceParadasImp;
import com.proyecto.service.ServicePruebasCulturalesImp;
import com.proyecto.util.Accion;

public class ModificarPruebasCulturalesAccion extends Accion {

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String pregunta = request.getParameter("pregunta");
		String respuesta = request.getParameter("respuesta");
		String puntos = request.getParameter("puntos");
		String parada = request.getParameter("parada");

		ServicePruebasCulturalesImp spc = new ServicePruebasCulturalesImp();
		ServiceParadasImp sp = new ServiceParadasImp();
		
		PruebaCultural prueba = spc.buscarPorClave(Integer.parseInt(id));

		if (nombre != "") 
			prueba.setNombre(nombre);
		if (pregunta != "") 
			prueba.setPregunta(pregunta);
		if (respuesta != "") 
			prueba.setRespuesta(respuesta);
		if (puntos != "") 
			prueba.setPuntos(Integer.parseInt(puntos));
		if (parada != "") 
			prueba.setParada(sp.buscarPorClave(Integer.parseInt(parada)));

		spc.actualizar(prueba);

		return "MostrarAdmin.do?div=pruebasculturales";
	}

}