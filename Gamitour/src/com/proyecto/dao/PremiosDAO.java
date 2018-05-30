package com.proyecto.dao;

import java.util.List;

import com.proyecto.modelo.Premio;

import com.proyecto.util.GenericDAO;

public interface PremiosDAO extends GenericDAO<Premio, Integer> {

	public void insertar(Premio p);

	public void eliminar(Premio p);

	public void actualizar(Premio p);

	public Premio buscarPorClave(Integer id);
	
	public Premio buscarPorNombre(String nombre);

	public List<Premio> buscarTodos();
	
	public List<Premio> buscarPremiosPorIdCliente(Integer idCliente);


}
