package com.proyecto.admin.insert;

import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.modelo.Parada;
import com.proyecto.modelo.PruebaCultural;
import com.proyecto.service.ServiceParadasImp;
import com.proyecto.service.ServicePruebasCulturalesImp;
import com.proyecto.util.Accion;

public class InsertarPruebasCulturalesAccion extends Accion {
	
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

		ServicePruebasCulturalesImp spc = new ServicePruebasCulturalesImp();
		
		ServiceParadasImp sp = new ServiceParadasImp();
		response.setContentType("text/html;charset=UTF-8");
		
		String nombre = request.getParameter("nombre");
		String pregunta = request.getParameter("pregunta");
		String respuesta = request.getParameter("respuesta");
		String respuesta2 = request.getParameter("respuesta2");
		String respuesta3 = request.getParameter("respuesta3");
		String puntos = request.getParameter("puntos");
		String parada = request.getParameter("parada");
		
		Parada p = sp.buscarPorClave(Integer.parseInt(parada));
		PruebaCultural pc = new PruebaCultural(p,nombre,pregunta,respuesta,respuesta2,respuesta3,Integer.parseInt(puntos));
		spc.insertar(pc);

		return "MostrarAdmin.do?div=pruebasculturales";
	}

}
