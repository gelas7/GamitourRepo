package com.proyecto.admin.update;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.modelo.Actividad;
import com.proyecto.modelo.Cliente;
import com.proyecto.modelo.Reserva;
import com.proyecto.service.ServiceActividadesImp;
import com.proyecto.service.ServiceClientesImp;
import com.proyecto.service.ServiceReservasImp;
import com.proyecto.util.Accion;

public class ModificarReservasAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");

		String id = request.getParameter("id");
		String cliente = request.getParameter("cliente");
		String actividad = request.getParameter("actividad");
		String comentarios = request.getParameter("comentarios");
		
		ServiceReservasImp sr = new ServiceReservasImp();
		
		Reserva r = sr.buscarPorClave(Integer.parseInt(id));

		if (cliente!=null) {
			ServiceClientesImp scli = new ServiceClientesImp();
			Cliente cli = scli.buscarPorClave(Integer.parseInt(cliente));
			r.setCliente(cli);
		}
		if (actividad!=null) {
			ServiceActividadesImp sa = new ServiceActividadesImp();
			Actividad a = sa.buscarPorClave(Integer.parseInt(actividad));
			r.setActividad(a);
		}

		if (comentarios.length() > 0)
			r.setComentarios(comentarios);

		sr.actualizar(r);

		return "MostrarAdmin.do?div=reservas";
	}

}
