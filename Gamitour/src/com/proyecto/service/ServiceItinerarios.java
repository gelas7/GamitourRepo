package com.proyecto.service;

import java.util.List;

import com.proyecto.modelo.Itinerario;

public interface ServiceItinerarios {

	public void insertar(Itinerario it);

	public void eliminar(Itinerario it);

	public void actualizar(Itinerario it);

	public Itinerario buscarPorClave(Integer id);

	public Itinerario buscarPorNombre(String nombre);

	public List<Itinerario> buscarTodos();
}
