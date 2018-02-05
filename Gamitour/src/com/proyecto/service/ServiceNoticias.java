package com.proyecto.service;

import java.util.List;

import com.proyecto.modelo.Noticia;

public interface ServiceNoticias {

	public void insertar(Noticia n);

	public void eliminar(Noticia n);

	public void actualizar(Noticia n);

	public Noticia buscarPorClave(Integer n);

	public List<Noticia> buscarTodos();

	public Noticia buscarPorNombre(String n);

}
