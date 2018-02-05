package com.proyecto.dao;

import java.util.List;

import com.proyecto.modelo.Cliente;
import com.proyecto.util.GenericDAO;

public interface ClientesDAO extends GenericDAO<Cliente, Integer> {

	public void insertar(Cliente a);

	public void eliminar(Cliente a);

	public void actualizar(Cliente a);

	public Cliente buscarPorClave(Integer id);

	public List<Cliente> buscarTodos();

	public Cliente buscarPorNombre(String string);
	
	public Cliente buscarClientePorEmail(String string);

}
