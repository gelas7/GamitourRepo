package com.proyecto.dao;

import java.util.List;

import com.proyecto.modelo.Reserva;
import com.proyecto.util.GenericDAO;

public interface ReservasDAO extends GenericDAO<Reserva, Integer> {

	public void insertar(Reserva v);

	public void eliminar(Reserva v);

	public void actualizar(Reserva v);

	public Reserva buscarPorClave(Integer id);

	public List<Reserva> buscarTodos();
	
	public List<Reserva> buscarReservasPorIdCliente(Integer idCliente);

}
