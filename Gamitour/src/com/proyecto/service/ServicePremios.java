package com.proyecto.service;

import java.util.List;

import com.proyecto.modelo.Premio;

public interface ServicePremios {

	public void insertar(Premio p);

	public void eliminar(Premio p);

	public void actualizar(Premio p);

	public Premio buscarPorClave(Integer p);

	public Premio buscarPorNombre(String nombre);

	public List<Premio> buscarTodos();

	public List<Premio> buscarPremiosPorIdCliente(Integer idCliente);

	public List<Premio> buscarPremiosNoAsignados();

}
