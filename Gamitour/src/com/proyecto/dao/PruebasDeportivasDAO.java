package com.proyecto.dao;

import java.util.List;

import com.proyecto.modelo.PruebaDeportiva;
import com.proyecto.util.GenericDAO;

public interface PruebasDeportivasDAO extends GenericDAO<PruebaDeportiva, Integer> {

	public void insertar(PruebaDeportiva pD);

	public void eliminar(PruebaDeportiva pD);

	public void actualizar(PruebaDeportiva pD);

	public PruebaDeportiva buscarPorClave(Integer id);

	public PruebaDeportiva buscarPorNombre(String nombre);

	public List<PruebaDeportiva> buscarTodos();
}
