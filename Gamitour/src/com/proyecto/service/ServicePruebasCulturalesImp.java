package com.proyecto.service;

import java.util.List;


import com.proyecto.dao.PruebasCulturalesDAO;
import com.proyecto.modelo.PruebaCultural;
import com.proyecto.util.MySQLDAOFactory;

public class ServicePruebasCulturalesImp implements ServicePruebasCulturales{
	
	PruebasCulturalesDAO pcd;
	MySQLDAOFactory f;
	
	public ServicePruebasCulturalesImp() {
		
		f = new MySQLDAOFactory();
		pcd = f.getPruebasCulturalesDAO();

	}

	@Override
	public void insertar(PruebaCultural pC) {
		pcd.insertar(pC);
	}

	@Override
	public void eliminar(PruebaCultural pC) {
		pcd.eliminar(pC);
	}

	@Override
	public void actualizar(PruebaCultural pC) {
		pcd.actualizar(pC);
	}

	@Override
	public PruebaCultural buscarPorClave(Integer id) {
		return pcd.buscarPorClave(id);
	}

	@Override
	public List<PruebaCultural> buscarTodos() {
		return pcd.buscarTodos();
	}

	@Override
	public PruebaCultural buscarPorNombre(String nombre) {
		return pcd.buscarPorNombre(nombre);
	}

}
