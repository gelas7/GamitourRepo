package com.proyecto.service;

import java.util.List;

import com.proyecto.modelo.Multimedia;

public interface ServiceMultimedias {
	public void insertar(Multimedia mt);

	public void eliminar(Multimedia mt);

	public void actualizar(Multimedia mt);

	public Multimedia buscarPorClave(Integer id);

	public Multimedia buscarPorNombre(String nombre);

	public List<Multimedia> buscarTodos();
	
	public List<Multimedia> mostrarMultimediasPorPd(String idprueba);

}
