package com.proyecto.admin.insert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.modelo.Actividad;
import com.proyecto.service.ServiceActividadesImp;
import com.proyecto.util.Accion;

public class InsertarActividadesAccion extends Accion {
	
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

		String nombre = request.getParameter("nombre");
		String fechainicio = request.getParameter("fechainicio");
		String fechafin = request.getParameter("fechafin");
		String ubicacion = request.getParameter("ubicacion");
		String numparticipantes = request.getParameter("participantes");
		String precio = request.getParameter("precio");
		String imagen = request.getParameter("imagen");
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

		Actividad a = new Actividad(nombre, date1, date2, ubicacion, Integer.parseInt(numparticipantes),
				Float.parseFloat(precio), imagen, Integer.parseInt(puntos));

		sa.insertar(a); 

		return "MostrarAdmin.do?div=actividades";
	}

}
