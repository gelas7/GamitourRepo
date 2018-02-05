package com.proyecto.dao;

import java.util.List;

import com.proyecto.modelo.Noticia;
import com.proyecto.util.GenericDAO;

public interface NoticiasDAO extends GenericDAO<Noticia,Integer> {
	
	public void insertar(Noticia n);

	public void eliminar(Noticia n);

	public void actualizar(Noticia n);

	public Noticia buscarPorClave(Integer id);

	public List<Noticia> buscarTodos();

	public Noticia buscarPorNombre(String n);

}
