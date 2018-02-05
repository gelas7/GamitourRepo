package com.proyecto.service;

import java.util.List;

import com.proyecto.modelo.Comentario;

public interface ServiceComentarios {

	public void insertar(Comentario cm);

	public void eliminar(Comentario cm);

	public void actualizar(Comentario cm);

	public Comentario buscarPorClave(Integer id);
	
	public Comentario buscarPorNombre(String nombre);

	public List<Comentario> buscarTodos();

}
