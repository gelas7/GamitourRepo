package com.proyecto.dao;

import java.util.List;

import com.proyecto.modelo.Itinerario;
import com.proyecto.util.GenericDAO;

public interface ItinerariosDAO extends GenericDAO<Itinerario, Integer> {

	public void insertar(Itinerario it);

	public void eliminar(Itinerario it);

	public void actualizar(Itinerario it);

	public Itinerario buscarPorClave(Integer id);

	public List<Itinerario> buscarTodos();

	public Itinerario buscarPorNombre(String nombre);	

}
