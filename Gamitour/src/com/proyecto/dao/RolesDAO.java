package com.proyecto.dao;

import java.util.List;

import com.proyecto.modelo.Rol;
import com.proyecto.util.GenericDAO;

public interface RolesDAO extends GenericDAO<Rol, Integer> {

	public void insertar(Rol r);

	public void eliminar(Rol r);

	public void actualizar(Rol r);

	public Rol buscarPorClave(Integer id);

	public Rol buscarPorNombre(String nombre);

	public List<Rol> buscarTodos();
}