package com.proyecto.service;

import java.util.List;

import com.proyecto.modelo.Rol;

public interface ServiceRoles {
	public void insertar(Rol r);

	public void eliminar(Rol r);

	public void actualizar(Rol r);

	public Rol buscarPorClave(Integer id);

	public Rol buscarPorNombre(String nombre);

	public List<Rol> buscarTodos();
}
