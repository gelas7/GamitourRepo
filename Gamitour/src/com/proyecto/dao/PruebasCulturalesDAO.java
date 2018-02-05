package com.proyecto.dao;

import java.util.List;

import com.proyecto.modelo.PruebaCultural;
import com.proyecto.util.GenericDAO;

public interface PruebasCulturalesDAO extends GenericDAO<PruebaCultural, Integer> {

	public void insertar(PruebaCultural pC);

	public void eliminar(PruebaCultural pC);

	public void actualizar(PruebaCultural pC);

	public PruebaCultural buscarPorClave(Integer id);

	public PruebaCultural buscarPorNombre(String nombre);

	public List<PruebaCultural> buscarTodos();
}
