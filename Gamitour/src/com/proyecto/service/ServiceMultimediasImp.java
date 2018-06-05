package com.proyecto.service;

import java.util.List;

import com.proyecto.dao.MultimediasDAO;
import com.proyecto.modelo.Multimedia;
import com.proyecto.util.MySQLDAOFactory;

public class ServiceMultimediasImp implements ServiceMultimedias{
	
	MultimediasDAO mtd;
	MySQLDAOFactory f;

	public ServiceMultimediasImp() {
		
		f= new MySQLDAOFactory();
		mtd = f.getMultimediasDAO();
	}

	@Override
	public void insertar(Multimedia mt) {
		mtd.insertar(mt);
	}

	@Override
	public void eliminar(Multimedia mt) {
		mtd.eliminar(mt);
	}

	@Override
	public void actualizar(Multimedia mt) {
		mtd.actualizar(mt);
	}

	@Override
	public Multimedia buscarPorClave(Integer id) {
		return mtd.buscarPorClave(id);
	}

	@Override
	public List<Multimedia> buscarTodos() {
		return mtd.buscarTodos();
	}

	@Override
	public Multimedia buscarPorNombre(String nombre) {
		return mtd.buscarPorNombre(nombre);
	}

	@Override
	public List<Multimedia> buscarPorPD(String idprueba) {
		return mtd.buscarPorPD(idprueba);
	}

	

}
