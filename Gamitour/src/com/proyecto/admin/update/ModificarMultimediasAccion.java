package com.proyecto.admin.update;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.modelo.Cliente;
import com.proyecto.modelo.Comentario;
import com.proyecto.modelo.Multimedia;
import com.proyecto.modelo.Voto;
import com.proyecto.service.ServiceMultimedias;
import com.proyecto.service.ServiceMultimediasImp;
import com.proyecto.util.Accion;


public class ModificarMultimediasAccion extends Accion {
	
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd"); 

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		String idmultimedia = request.getParameter("id");
		String cliente = request.getParameter("cliente");
		String fecha = request.getParameter("fecha");
		String comentario = request.getParameter("comentario");
		String imagen = request.getParameter("imagen");
		String video = request.getParameter("video");
		String pruebaDeportivaIdpruebadeportiva = request.getParameter("pruebaDeportivaIdpruebadeportiva");
		String puntosacumulados = request.getParameter("puntosacumulados");
		
		ServiceMultimedias sm = new ServiceMultimediasImp();
		
		Multimedia m = sm.buscarPorClave(Integer.parseInt(id));
		
		m.setCliente(cliente);
		m.setFecha(fecha);
		m.setComentario(comentario);
		m.setImagen(imagen);
		m.setVideo(video);
		m.setPruebaDeportivaIdpruebadeportiva(pruebaDeportivaIdpruebadeportiva);
		m.setPuntosacumulados(puntosacumulados);
		m.setComentarios(comentarios);
		m.setVideo(video);
		
		sm.actualizar(m);
		
		request.setAttribute("listaMultimedias", sm.buscarTodos());
		return "mostrarMultimedias.jsp";
	}

}
