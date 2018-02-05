package com.proyecto.service;

import java.util.List;

import com.proyecto.modelo.PruebaDeportiva;

public interface ServicePruebasDeportivas {
	public void insertar(PruebaDeportiva pD);

	public void eliminar(PruebaDeportiva pD);

	public void actualizar(PruebaDeportiva pD);

	public PruebaDeportiva buscarPorClave(Integer id);
	
	public PruebaDeportiva buscarPorNombre(String nombre);

	public List<PruebaDeportiva> buscarTodos();
}
