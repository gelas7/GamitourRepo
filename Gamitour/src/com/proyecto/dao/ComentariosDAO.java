package com.proyecto.dao;

import java.util.List;

import com.proyecto.modelo.Comentario;
import com.proyecto.util.GenericDAO;

public interface ComentariosDAO extends GenericDAO<Comentario, Integer> {

	public void insertar(Comentario cm);

	public void eliminar(Comentario cm);

	public void actualizar(Comentario cm);

	public Comentario buscarPorClave(Integer id);
	
	public Comentario buscarPorNombre(String nombre);

	public List<Comentario> buscarTodos();

}
