package com.proyecto.service;

import java.util.List;


import com.proyecto.modelo.Parada;

public interface ServiceParadas {

	public void insertar(Parada p);

	public void eliminar(Parada p);

	public void actualizar(Parada p);

	public Parada buscarPorClave(Integer p);

	public Parada buscarPorNombre(String nombre);

	public List<Parada> buscarTodos();
	
	public List<Parada> buscarParadasPorIt(String idItinerario);

}
