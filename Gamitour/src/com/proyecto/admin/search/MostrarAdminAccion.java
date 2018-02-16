package com.proyecto.admin.search;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.modelo.Parada;
import com.proyecto.service.ServiceActividadesImp;
import com.proyecto.service.ServiceClientesImp;
import com.proyecto.service.ServiceComentariosImp;
import com.proyecto.service.ServiceItinerarios;
import com.proyecto.service.ServiceItinerariosImp;
import com.proyecto.service.ServiceMultimedias;
import com.proyecto.service.ServiceMultimediasImp;
import com.proyecto.service.ServiceNoticias;
import com.proyecto.service.ServiceNoticiasImp;
import com.proyecto.service.ServiceParadas;
import com.proyecto.service.ServiceParadasImp;
import com.proyecto.service.ServicePremiosImp;
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
		ServicePremiosImp spr = new ServicePremiosImp();
		ServiceMultimedias sm = new ServiceMultimediasImp();
		ServiceComentariosImp scom = new ServiceComentariosImp();

		request.setAttribute("listaPremios", spr.buscarTodos());
		request.setAttribute("listaVotos", sv.buscarTodos());
		request.setAttribute("listaPruebasCulturales", spc.buscarTodos());
		request.setAttribute("listaActividades", sa.buscarTodos());
		request.setAttribute("listaNoticias", sn.buscarTodos());
		request.setAttribute("listaComentarios", scom.buscarTodos());
				
		// Guardo estos en sesion puesto que los necesito además en otros formularios
		request.getSession().setAttribute("listaClientes", sc.buscarTodos());
		request.getSession().setAttribute("listaItinerarios", si.buscarTodos());
		List<Parada> listaParadas = sp.buscarTodos();
		Collections.sort(listaParadas);
		request.getSession().setAttribute("listaParadas", listaParadas);
		request.getSession().setAttribute("listaRoles", sr.buscarTodos());
		request.getSession().setAttribute("listaPruebasDeportivas", spd.buscarTodos());
		request.getSession().setAttribute("listaMultimedias", sm.buscarTodos());

		// Aqui guardo el nombre de la tabla que se esta manejando actualmente
		request.setAttribute("divActual", request.getParameter("div"));

		return "Procesos/MostrarAdmin.jsp";
	}

}
