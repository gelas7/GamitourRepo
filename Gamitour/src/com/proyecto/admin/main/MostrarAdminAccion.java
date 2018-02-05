package com.proyecto.admin.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.service.ServiceActividadesImp;
import com.proyecto.service.ServiceClientesImp;
import com.proyecto.service.ServiceItinerarios;
import com.proyecto.service.ServiceItinerariosImp;
import com.proyecto.service.ServiceNoticias;
import com.proyecto.service.ServiceNoticiasImp;
import com.proyecto.service.ServiceParadas;
import com.proyecto.service.ServiceParadasImp;
import com.proyecto.service.ServicePruebasCulturales;
import com.proyecto.service.ServicePruebasCulturalesImp;
import com.proyecto.service.ServicePruebasDeportivas;
import com.proyecto.service.ServicePruebasDeportivasImp;
import com.proyecto.service.ServiceRolesImp;
import com.proyecto.service.ServiceVotos;
import com.proyecto.service.ServiceVotosImp;
import com.proyecto.util.Accion;

public class MostrarAdminAccion extends Accion {

	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

		ServiceNoticias sn = new ServiceNoticiasImp();
		ServiceClientesImp sc = new ServiceClientesImp();
		ServiceItinerarios si = new ServiceItinerariosImp();
		ServiceParadas sp = new ServiceParadasImp();
		ServiceRolesImp sr = new ServiceRolesImp();
		ServiceActividadesImp sa = new ServiceActividadesImp();
		ServicePruebasCulturales spc = new ServicePruebasCulturalesImp();
		ServicePruebasDeportivas spd = new ServicePruebasDeportivasImp();
		ServiceVotos sv = new ServiceVotosImp();

		request.setAttribute("listaVotos", sv.buscarTodos());
		request.setAttribute("listaPruebasDeportivas", spd.buscarTodos());
		request.setAttribute("listaPruebasCulturales", spc.buscarTodos());
		request.setAttribute("listaActividades", sa.buscarTodos());
		request.setAttribute("listaNoticias", sn.buscarTodos());
		request.setAttribute("listaClientes", sc.buscarTodos());
		request.setAttribute("listaNoticias", sn.buscarTodos());

		// Guardo estos en sesion puesto que los necesito además en otros formularios
		request.getSession().setAttribute("listaItinerarios", si.buscarTodos());
		request.getSession().setAttribute("listaParadas", sp.buscarTodos());
		request.getSession().setAttribute("listaRoles", sr.buscarTodos());

		// Aqui guardo el nombre de la tabla que se esta manejando actualmente
		request.setAttribute("divActual", request.getParameter("div"));
		
		return "Procesos/MostrarAdmin.jsp";
	}

}
