package com.proyecto.admin.update;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.modelo.Cliente;
import com.proyecto.modelo.Multimedia;
import com.proyecto.modelo.Voto;
import com.proyecto.service.ServiceClientesImp;
import com.proyecto.service.ServiceMultimediasImp;
import com.proyecto.service.ServiceVotosImp;
import com.proyecto.util.Accion;

public class ModificarVotosAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");
		String cliente = request.getParameter("cliente");
		String multimedia = request.getParameter("multimedia");
		String puntos = request.getParameter("puntos");

		ServiceVotosImp sv = new ServiceVotosImp();

		Voto v = sv.buscarPorClave(Integer.parseInt(id));

		if (cliente != "") {
			ServiceClientesImp scli = new ServiceClientesImp();
			Cliente cli = scli.buscarPorClave(Integer.parseInt(cliente));
			v.setCliente(cli);
		}
		if (multimedia != "") {
			ServiceMultimediasImp sm = new ServiceMultimediasImp();
			Multimedia m = sm.buscarPorClave(Integer.parseInt(multimedia));
			v.setMultimedia(m);
		}
		
		if(puntos!="")
			v.setPuntos(Integer.parseInt(puntos));
		
		sv.actualizar(v);
		
		return "MostrarAdmin.do?div=votos";
	}

}
