package com.proyecto.service;

import java.util.List;

import com.proyecto.modelo.Actividad;

public interface ServiceActividades {

	public void insertar(Actividad a);

	public void eliminar(Actividad a);

	public void actualizar(Actividad a);

	public Actividad buscarPorClave(Integer id);
	
	public Actividad buscarPorNombre(String nombre);

	public List<Actividad> buscarTodos();
}
