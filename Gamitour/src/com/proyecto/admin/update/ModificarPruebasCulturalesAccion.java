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
		response.setContentType("text/html;charset=UTF-8");
	
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String pregunta = request.getParameter("pregunta");
		String respuesta = request.getParameter("respuesta");
		String respuesta2 = request.getParameter("respuesta2");
		String respuesta3 = request.getParameter("respuesta3");
		String puntos = request.getParameter("puntos");
		String parada = request.getParameter("parada");

		ServicePruebasCulturalesImp spc = new ServicePruebasCulturalesImp();
		ServiceParadasImp sp = new ServiceParadasImp();

		PruebaCultural prueba = spc.buscarPorClave(Integer.parseInt(id));

		if (nombre.length() > 0)
			prueba.setNombre(nombre);
		if (pregunta.length() > 0)
			prueba.setPregunta(pregunta);
		if (respuesta.length() > 0)
			prueba.setRespuesta(respuesta);
		if (respuesta2.length() > 0)
			prueba.setRespuesta2(respuesta2);
		if (respuesta3.length() > 0)
			prueba.setRespuesta3(respuesta3);
		if (puntos.length() > 0)
			prueba.setPuntos(Integer.parseInt(puntos));
		if (parada!=null)
			prueba.setParada(sp.buscarPorClave(Integer.parseInt(parada)));

		spc.actualizar(prueba);

		return "MostrarAdmin.do?div=pruebasculturales";
	}

}