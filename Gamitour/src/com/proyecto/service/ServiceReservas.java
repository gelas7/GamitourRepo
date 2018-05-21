package com.proyecto.service;

import java.util.List;

import com.proyecto.modelo.Reserva;

public interface ServiceReservas {

	public void insertar(Reserva r);

	public void eliminar(Reserva v);

	public void actualizar(Reserva v);

	public Reserva buscarPorClave(Integer id);
	
	public List<Reserva> buscarTodos();
	
}
