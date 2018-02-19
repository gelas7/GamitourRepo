package com.proyecto.service;

import java.util.List;

import com.proyecto.modelo.Voto;

public interface ServiceVotos {

	public void insertar(Voto v);

	public void eliminar(Voto v);

	public void actualizar(Voto v);

	public Voto buscarPorClave(Integer id);
	
	public List<Voto> buscarTodos();
	
	public List<Voto> buscarVotosPorMultimedia(String idmultimedia);

}
