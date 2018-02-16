package com.proyecto.service;

import java.util.List;
import com.proyecto.util.MySQLDAOFactory;
import com.proyecto.dao.ComentariosDAO;
import com.proyecto.modelo.Comentario;

public class ServiceComentariosImp implements ServiceComentarios{
	
	ComentariosDAO cmd;
	MySQLDAOFactory f;

	public ServiceComentariosImp() {
		
		f= new MySQLDAOFactory();
		cmd = f.getComentariosDAO();

	}

	@Override
	public void insertar(Comentario cm) {
		cmd.insertar(cm);
	}

	@Override
	public void eliminar(Comentario cm) {
		cmd.eliminar(cm);
	}

	@Override
	public void actualizar(Comentario cm) {
		cmd.actualizar(cm);
	}

	@Override
	public Comentario buscarPorClave(Integer id) {
		return cmd.buscarPorClave(id);
	}

	@Override
	public List<Comentario> buscarTodos() {
		return cmd.buscarTodos();
	}

	@Override
	public Comentario buscarPorNombre(String nombre) {
		return cmd.buscarPorNombre(nombre);
	}

	

	@Override
	public List<Comentario> buscarComentPorMultimedia(String idmultimedia) {
		 return cmd.buscarComentPorMultimedia( idmultimedia);
	}
	

}
