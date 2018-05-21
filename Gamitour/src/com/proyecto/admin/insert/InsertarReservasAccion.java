package com.proyecto.admin.insert;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.modelo.Actividad;
import com.proyecto.modelo.Cliente;
import com.proyecto.modelo.Reserva;
import com.proyecto.service.ServiceActividadesImp;
import com.proyecto.service.ServiceClientesImp;
import com.proyecto.service.ServiceReservasImp;
import com.proyecto.util.Accion;

public class InsertarReservasAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

		ServiceClientesImp sc = new ServiceClientesImp();
		ServiceActividadesImp sa = new ServiceActividadesImp();
		ServiceReservasImp sr = new ServiceReservasImp();
		
		String cliente = request.getParameter("cliente");
		String actividad = request.getParameter("actividad");
		String comentarios = request.getParameter("comentarios");
		Date hoy = new Date();

		Cliente c = sc.buscarPorClave(Integer.parseInt(cliente));
		Actividad a = sa.buscarPorClave(Integer.parseInt(actividad));

		Reserva r = new Reserva(c, a, comentarios,hoy);

		sr.insertar(r);

		return "MostrarAdmin.do?div=reservas";
	}

}
