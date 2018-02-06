package com.proyecto.admin.insert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.modelo.Cliente;
import com.proyecto.modelo.Multimedia;

import com.proyecto.modelo.Voto;
import com.proyecto.service.ServiceClientesImp;
import com.proyecto.service.ServiceMultimediasImp;

import com.proyecto.service.ServiceVotosImp;
import com.proyecto.util.Accion;

public class InsertarVotosAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

		ServiceVotosImp sv = new ServiceVotosImp();
		ServiceClientesImp sc = new ServiceClientesImp();
		ServiceMultimediasImp sm = new ServiceMultimediasImp();

		String cliente = request.getParameter("cliente");
		String multimedia = request.getParameter("multimedia");
		String puntos = request.getParameter("puntos");

		Cliente c = sc.buscarPorClave(Integer.parseInt(cliente));
		Multimedia m = sm.buscarPorClave(Integer.parseInt(multimedia));

		Voto v = new Voto(c, m, Integer.parseInt(puntos));

		sv.insertar(v);

		return "MostrarAdmin.do?div=votos";
	}

}
