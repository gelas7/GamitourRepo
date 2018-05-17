package com.proyecto.admin.update;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.modelo.Actividad;
import com.proyecto.service.ServiceActividadesImp;
import com.proyecto.util.Accion;

public class ModificarActividadesAccion extends Accion {

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");

		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String fechainicio = request.getParameter("fechainicio");
		String fechafin = request.getParameter("fechafin");
		String ubicacion = request.getParameter("ubicacion");
		String numparticipantes = request.getParameter("participantes");
		String precio = request.getParameter("precio");
		String puntos = request.getParameter("puntos");
		Date date1 = null;
		Date date2 = null;

		try {
			date1 = formatter.parse(fechainicio);
			date2 = formatter.parse(fechafin);

		} catch (ParseException e) {
			System.out.println("Fallo al convertir fechas. " + e.getMessage());
		}

		ServiceActividadesImp sa = new ServiceActividadesImp();
		Actividad a = sa.buscarPorClave(Integer.parseInt(id));
		
		if (nombre.length()>0)
			a.setNombre(nombre);
		if (date1 != null)
			a.setFechainicio(date1);
		if (date2 != null)
			a.setFechafin(date2);
		if (ubicacion.length()>0)
			a.setUbicacion(ubicacion);
		if (numparticipantes.length()>0)
			a.setNumparticipantes(Integer.parseInt(numparticipantes));
		if (precio.length()>0)
			a.setPrecio(Float.parseFloat(precio));
		if (puntos.length()>0)
			a.setPuntos(Integer.parseInt(puntos));

		sa.actualizar(a);

		return "MostrarAdmin.do?div=actividades";
	}

}