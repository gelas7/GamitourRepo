package com.proyecto.admin.update;

import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.modelo.Cliente;

import com.proyecto.modelo.Multimedia;

import com.proyecto.service.ServiceClientes;
import com.proyecto.service.ServiceClientesImp;
import com.proyecto.service.ServiceMultimedias;
import com.proyecto.service.ServiceMultimediasImp;

import com.proyecto.util.Accion;

public class ModificarMultimediasAccion extends Accion {

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");
		String cliente = request.getParameter("cliente");
		String comentario = request.getParameter("comentario");
		String imagen = request.getParameter("imagen");
		String video = request.getParameter("video");
		String idPd = request.getParameter("pruebaD");
		String puntos = request.getParameter("puntos");


		ServiceMultimedias sm = new ServiceMultimediasImp();
		ServiceClientes sc = new ServiceClientesImp();

		Multimedia m = sm.buscarPorClave(Integer.parseInt(id));

		if (cliente != "") {
			Cliente c = sc.buscarPorClave(Integer.parseInt(cliente));
			m.setCliente(c);
		}

		if (idPd != "") {

			m.setPruebaDeportivaIdpruebadeportiva(Integer.parseInt(idPd));
		}

		if (imagen != "")
			m.setImagen(imagen);

		if (video != "")
			m.setVideo(video);

		if (comentario != "")
			m.setComentario(comentario);

		if (puntos != "")
			m.setPuntosacumulados(Integer.parseInt(puntos));

		sm.actualizar(m);

		return "MostrarAdmin.do?div=multimedias";
	}

}
