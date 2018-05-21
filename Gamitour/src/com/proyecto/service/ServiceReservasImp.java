package com.proyecto.service;

import java.util.List;

import com.proyecto.dao.ReservasDAO;
import com.proyecto.modelo.Reserva;
import com.proyecto.util.MySQLDAOFactory;

public class ServiceReservasImp implements ServiceReservas {

	ReservasDAO rd;
	MySQLDAOFactory f;
	
	public ServiceReservasImp() {
		f = new MySQLDAOFactory();
		rd = f.getReservasDAO();
	}


	@Override
	public void insertar(Reserva r) {
		rd.insertar(r);
	}

	@Override
	public void eliminar(Reserva r) {
		rd.eliminar(r);
	}

	@Override
	public void actualizar(Reserva r) {
		rd.actualizar(r);
	}

	@Override
	public Reserva buscarPorClave(Integer id) {
		return rd.buscarPorClave(id);
	}

	@Override
	public List<Reserva> buscarTodos() {
		return rd.buscarTodos();
	}
}
