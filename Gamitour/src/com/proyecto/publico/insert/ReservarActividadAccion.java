package com.proyecto.publico.insert;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.proyecto.modelo.Actividad;
import com.proyecto.modelo.Cliente;
import com.proyecto.modelo.Reserva;
import com.proyecto.service.ServiceActividadesImp;
import com.proyecto.service.ServiceClientesImp;
import com.proyecto.service.ServiceReservasImp;
import com.proyecto.util.Accion;

public class ReservarActividadAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		ServiceClientesImp sc = new ServiceClientesImp();
		ServiceActividadesImp sa = new ServiceActividadesImp();
		ServiceReservasImp sr = new ServiceReservasImp();

		String idActividad = (String) request.getParameter("id");

		Cliente c = sc.buscarClientePorEmail((String) session.getAttribute("email"));
		Actividad a = sa.buscarPorClave(Integer.parseInt(idActividad));

		String rutaSalida = "/MostrarPublico.cl?id=actividades";

		if (c != null && a != null) {
			Reserva r = new Reserva(c,a,"probando",new Date());
			sr.insertar(r);
		}
		else {
			rutaSalida = "/Gamitour/errores/reservaIncorrecta.jsp";
		}
		
		return rutaSalida;
	}
}