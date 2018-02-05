package com.proyecto.service;

import java.util.List;

import com.proyecto.modelo.Cliente;


public interface ServiceClientes {

	public void insertar(Cliente c);

	public void eliminar(Cliente c);

	public void actualizar(Cliente c);

	public Cliente buscarPorClave(Integer id);

	public List<Cliente> buscarTodos();
	
	public Cliente buscarPorNombre(String string);

	public Cliente buscarClientePorEmail(String email);

}
