package com.proyecto.dao;

import java.util.List;

import com.proyecto.modelo.Actividad;
import com.proyecto.util.GenericDAO;

public interface ActividadesDAO extends GenericDAO<Actividad,Integer> {

	public void insertar(Actividad a);
	public void eliminar(Actividad a);
	public void actualizar(Actividad a);
	public Actividad buscarPorClave(Integer id);
	public Actividad buscarPorNombre(String nombre);
	public List<Actividad> buscarTodos();
}
