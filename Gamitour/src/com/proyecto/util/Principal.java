package com.proyecto.util;


import com.proyecto.service.ServiceActividadesImp;
import com.proyecto.service.ServiceClientesImp;
import com.proyecto.service.ServiceComentarios;
import com.proyecto.service.ServiceComentariosImp;
import com.proyecto.service.ServiceItinerarios;
import com.proyecto.service.ServiceItinerariosImp;
import com.proyecto.service.ServiceMultimedias;
import com.proyecto.service.ServiceMultimediasImp;
import com.proyecto.service.ServiceNoticias;
import com.proyecto.service.ServiceNoticiasImp;
import com.proyecto.service.ServiceParadas;
import com.proyecto.service.ServiceParadasImp;
import com.proyecto.service.ServicePremios;
import com.proyecto.service.ServicePremiosImp;
import com.proyecto.service.ServicePruebasCulturales;
import com.proyecto.service.ServicePruebasCulturalesImp;
import com.proyecto.service.ServicePruebasDeportivas;
import com.proyecto.service.ServicePruebasDeportivasImp;
import com.proyecto.service.ServiceRoles;
import com.proyecto.service.ServiceRolesImp;
import com.proyecto.service.ServiceVotos;
import com.proyecto.service.ServiceVotosImp;

public class Principal {

	ServiceClientesImp scli;
	ServiceActividadesImp sa;
	ServiceComentarios scom;
	ServiceItinerarios sit;
	ServiceMultimedias smt;
	ServiceNoticias sn;
	ServiceParadas spa;
	ServicePremios spr;
	ServicePruebasCulturales sPC;
	ServicePruebasDeportivas sPD;
	ServiceRoles sr;
	ServiceVotos sv;

	public Principal() {
		// Inicializo los services
		scli = new ServiceClientesImp();
		sa = new ServiceActividadesImp();
		sr = new ServiceRolesImp();
		scom = new ServiceComentariosImp();
		sit = new ServiceItinerariosImp();
		smt = new ServiceMultimediasImp();
		sn = new ServiceNoticiasImp();
		spa = new ServiceParadasImp();
		spr = new ServicePremiosImp();
		sPC = new ServicePruebasCulturalesImp();
		sPD = new ServicePruebasDeportivasImp();
		sv = new ServiceVotosImp();

	}

	public static void main(String[] args) {
		Principal p = new Principal();

		p.init();

	}

	public void init() {

	}

}
