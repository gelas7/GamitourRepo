package com.proyecto.admin.search;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.modelo.Actividad;
import com.proyecto.modelo.Cliente;
import com.proyecto.modelo.Comentario;
import com.proyecto.modelo.Itinerario;
import com.proyecto.modelo.Multimedia;
import com.proyecto.modelo.Noticia;
import com.proyecto.modelo.Parada;
import com.proyecto.modelo.Premio;
import com.proyecto.modelo.PruebaCultural;
import com.proyecto.modelo.PruebaDeportiva;
import com.proyecto.modelo.Reserva;
import com.proyecto.modelo.Voto;
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
import com.proyecto.service.ServiceReservasImp;
import com.proyecto.service.ServiceRolesImp;
import com.proyecto.service.ServiceVotos;
import com.proyecto.service.ServiceVotosImp;
import com.proyecto.util.Accion;

public class MostrarAdminAccion extends Accion {

	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF8");

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
		ServiceReservasImp srv = new ServiceReservasImp();

		List<Noticia> listaNoticias = sn.buscarTodos();
		List<Cliente> listaClientes = sc.buscarTodos();
		List<Itinerario> listaItinerarios = si.buscarTodos();
		List<Parada> listaParadas = sp.buscarTodos();
		List<Actividad> listaActividades = sa.buscarTodos();
		List<Comentario> listaComentarios = scom.buscarTodos();
		List<Premio> listaPremios = spr.buscarTodos();
		List<PruebaCultural> listaPruebasCulturales = spc.buscarTodos();
		List<PruebaDeportiva> listaPruebasDeportivas = spd.buscarTodos();
		List<Voto> listaVotos = sv.buscarTodos();
		List<Multimedia> listaMultimedias = sm.buscarTodos();
		List<Reserva> listaReservas = srv.buscarTodos();

		request.getSession().setAttribute("listaPremios", listaPremios);
		request.getSession().setAttribute("listaVotos", listaVotos);
		request.getSession().setAttribute("listaPruebasCulturales", listaPruebasCulturales);
		request.getSession().setAttribute("listaNoticias", listaNoticias);
		request.getSession().setAttribute("listaComentarios", listaComentarios);
		request.getSession().setAttribute("listaClientes", listaClientes);
		request.getSession().setAttribute("listaItinerarios", listaItinerarios);
		request.getSession().setAttribute("listaParadas", listaParadas);
		request.getSession().setAttribute("listaRoles", sr.buscarTodos());
		request.getSession().setAttribute("listaPruebasDeportivas", listaPruebasDeportivas);
		request.getSession().setAttribute("listaMultimedias", listaMultimedias);
		request.getSession().setAttribute("listaReservas", listaReservas);
		request.getSession().setAttribute("listaActividades", listaActividades);

		// Aqui guardo el nombre de la tabla que se esta manejando actualmente
		request.getSession().setAttribute("divActual", request.getParameter("div"));

		return "Admin/MostrarAdmin.jsp";
	}

}
