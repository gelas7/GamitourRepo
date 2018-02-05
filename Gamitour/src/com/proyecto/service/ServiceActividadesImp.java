package com.proyecto.service;

import java.util.List;

import com.proyecto.dao.ActividadesDAO;
import com.proyecto.modelo.Actividad;
import com.proyecto.util.MySQLDAOFactory;

public class ServiceActividadesImp implements ServiceActividades {

	ActividadesDAO ad;
	MySQLDAOFactory f;

	public ServiceActividadesImp() {

		f = new MySQLDAOFactory();
		ad = f.getActividadesDAO();

	}

	@Override
	public void insertar(Actividad a) {
		ad.insertar(a);
	}

	@Override
	public void eliminar(Actividad a) {
		ad.eliminar(a);
	}

	@Override
	public void actualizar(Actividad a) {
		ad.actualizar(a);
	}

	@Override
	public Actividad buscarPorClave(Integer id) {
		return ad.buscarPorClave(id);
	}

	@Override
	public List<Actividad> buscarTodos() {
		return ad.buscarTodos();
	}

	@Override
	public Actividad buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return ad.buscarPorNombre(nombre);
	}

}
