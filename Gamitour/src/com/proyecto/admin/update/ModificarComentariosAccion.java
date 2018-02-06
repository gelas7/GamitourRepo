package com.proyecto.admin.update;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.modelo.Cliente;
import com.proyecto.modelo.Comentario;
import com.proyecto.modelo.Itinerario;
import com.proyecto.modelo.Multimedia;
import com.proyecto.service.ServiceClientesImp;
import com.proyecto.service.ServiceComentariosImp;
import com.proyecto.service.ServiceMultimediasImp;
import com.proyecto.util.Accion;

public class ModificarComentariosAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");
		String cliente = request.getParameter("cliente");
		String multimedia = request.getParameter("multimedia");
		String texto = request.getParameter("comentario");

		ServiceComentariosImp scom = new ServiceComentariosImp();

		Comentario com = scom.buscarPorClave(Integer.parseInt(id));

		if (cliente != "") {
			ServiceClientesImp scli = new ServiceClientesImp();
			Cliente cli = scli.buscarPorClave(Integer.parseInt(cliente));
			com.setCliente(cli);
		}
		if (multimedia != "") {
			ServiceMultimediasImp sm = new ServiceMultimediasImp();
			Multimedia m = sm.buscarPorClave(Integer.parseInt(multimedia));
			com.setMultimedia(m);
		}
		
		if(texto!="")
			com.setTexto(texto);
		
		scom.actualizar(com);
		
		return "MostrarAdmin.do?div=comentarios";
	}

}
