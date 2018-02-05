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

		String nombre = request.getParameter("nombre");
		String pregunta = request.getParameter("pregunta");
		String respuesta = request.getParameter("respuesta");
		String puntos = request.getParameter("puntos");
		String parada = request.getParameter("parada");
		
		Parada p = sp.buscarPorClave(Integer.parseInt(parada));
		PruebaCultural pc = new PruebaCultural(p,nombre,pregunta,respuesta,Integer.parseInt(puntos));
		spc.insertar(pc);

		return "MostrarAdmin.do?div=pruebasculturales";
	}

}
