package com.proyecto.dao;

import java.util.List;

import com.proyecto.modelo.Multimedia;
import com.proyecto.util.GenericDAO;

public interface MultimediasDAO extends GenericDAO<Multimedia, Integer> {

	public void insertar(Multimedia mt);

	public void eliminar(Multimedia mt);

	public void actualizar(Multimedia mt);

	public Multimedia buscarPorClave(Integer id);
	
	public Multimedia buscarPorNombre(String nombre);
	
	public List<Multimedia> buscarTodos();

}
