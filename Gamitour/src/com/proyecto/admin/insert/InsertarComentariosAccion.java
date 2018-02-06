package com.proyecto.admin.insert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.modelo.Cliente;
import com.proyecto.modelo.Comentario;
import com.proyecto.modelo.Multimedia;
import com.proyecto.service.ServiceClientesImp;
import com.proyecto.service.ServiceComentariosImp;
import com.proyecto.service.ServiceMultimediasImp;
import com.proyecto.util.Accion;

public class InsertarComentariosAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

		String cliente = request.getParameter("cliente");
		String multimedia = request.getParameter("multimedia");
		String texto = request.getParameter("texto");
	
		ServiceComentariosImp scom = new ServiceComentariosImp();
		ServiceClientesImp scli = new ServiceClientesImp();
		ServiceMultimediasImp sm = new ServiceMultimediasImp();
		
		Cliente cli = scli.buscarPorClave(Integer.parseInt(cliente));
		Multimedia multi = sm.buscarPorClave(Integer.parseInt(multimedia));

		Comentario c = new Comentario(cli, multi,texto);
		scom.insertar(c); 

		return "MostrarAdmin.do?div=comentarios";
	}

}
