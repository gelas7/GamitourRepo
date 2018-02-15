package com.proyecto.dao;

import java.util.List;

import com.proyecto.modelo.Itinerario;
import com.proyecto.modelo.Parada;

import com.proyecto.util.GenericDAO;

public interface ParadasDAO extends GenericDAO<Parada, Integer> {

	public void insertar(Parada p);

	public void eliminar(Parada p);

	public void actualizar(Parada p);

	public Parada buscarPorClave(Integer id);
	
	public Parada buscarPorNombre(String nombre);

	public List<Parada> buscarTodos();

	public List<Parada> buscarParadasPorIt(Itinerario i);

}
