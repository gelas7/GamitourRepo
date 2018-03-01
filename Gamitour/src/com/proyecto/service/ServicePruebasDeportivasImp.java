package com.proyecto.service;

import java.util.List;

import com.proyecto.dao.PruebasDeportivasDAO;
import com.proyecto.modelo.PruebaDeportiva;
import com.proyecto.util.MySQLDAOFactory;

public class ServicePruebasDeportivasImp implements ServicePruebasDeportivas {

	PruebasDeportivasDAO pdd;
	MySQLDAOFactory f;
	
	public ServicePruebasDeportivasImp() {

		f = new MySQLDAOFactory();
		pdd = f.getPruebasDeportivasDAO();
	}

	@Override
	public void insertar(PruebaDeportiva pD) {
		pdd.insertar(pD);
	}

	@Override
	public void eliminar(PruebaDeportiva pD) {
		pdd.eliminar(pD);
	}

	@Override
	public void actualizar(PruebaDeportiva pD) {
		pdd.actualizar(pD);
	}

	@Override
	public PruebaDeportiva buscarPorClave(Integer id) {
		return pdd.buscarPorClave(id);
	}

	@Override
	public List<PruebaDeportiva> buscarTodos() {
		return pdd.buscarTodos();
	}

	@Override
	public PruebaDeportiva buscarPorNombre(String nombre) {
		return pdd.buscarPorNombre(nombre);
	}
	
	@Override
	public List<PruebaDeportiva> buscarPruebasDepPorParada(String id) {
		return pdd.buscarPruebasDepPorParada(id);
	}

}
