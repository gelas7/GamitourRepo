package com.proyecto.admin.search;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

public class MostrarParadasAccion extends Accion {

	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

	
		ServiceParadas sp = new ServiceParadasImp();
		String id = request.getParameter("id");
		request.getSession().setAttribute("listaParadas", sp.buscarParadasPorIt(id));
		
		// Aqui guardo el nombre de la tabla que se esta manejando actualmente
		request.setAttribute("divActual", request.getParameter("div"));

		return "Procesos/MostrarAdmin.jsp";
	}

}
