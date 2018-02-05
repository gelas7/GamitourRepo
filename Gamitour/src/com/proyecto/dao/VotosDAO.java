package com.proyecto.dao;

import java.util.List;

import com.proyecto.modelo.Voto;
import com.proyecto.util.GenericDAO;

public interface VotosDAO extends GenericDAO<Voto, Integer> {

	public void insertar(Voto v);

	public void eliminar(Voto v);

	public void actualizar(Voto v);

	public Voto buscarPorClave(Integer id);

	public List<Voto> buscarTodos();

}
