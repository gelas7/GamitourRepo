package com.proyecto.service;

import java.util.List;

import com.proyecto.dao.RolesDAO;
import com.proyecto.modelo.Rol;
import com.proyecto.util.MySQLDAOFactory;

public class ServiceRolesImp implements ServiceRoles{

	RolesDAO rd;
	MySQLDAOFactory f;
	
	public ServiceRolesImp() {

		f = new MySQLDAOFactory();
		rd = f.getRolesDAO();
	}

	@Override
	public void insertar(Rol r) {
		rd.insertar(r);
	}

	@Override
	public void eliminar(Rol r) {
		rd.eliminar(r);
	}

	@Override
	public void actualizar(Rol r) {
		rd.actualizar(r);
	}

	@Override
	public Rol buscarPorClave(Integer id) {
		return rd.buscarPorClave(id);
	}

	@Override
	public List<Rol> buscarTodos() {
		return rd.buscarTodos();
	}

	@Override
	public Rol buscarPorNombre(String nombre) {
		return rd.buscarPorNombre(nombre);
	}

}
