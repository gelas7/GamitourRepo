package com.proyecto.service;

import java.util.List;

import com.proyecto.modelo.PruebaCultural;

public interface ServicePruebasCulturales {

	public void insertar(PruebaCultural pC);

	public void eliminar(PruebaCultural pC);

	public void actualizar(PruebaCultural pC);

	public PruebaCultural buscarPorClave(Integer id);

	public PruebaCultural buscarPorNombre(String nombre);
	
	public List<PruebaCultural> buscarTodos();
}
