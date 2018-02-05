package com.proyecto.service;

import java.util.List;

import com.proyecto.dao.ClientesDAO;
import com.proyecto.modelo.Cliente;
import com.proyecto.util.MySQLDAOFactory;

public class ServiceClientesImp implements ServiceClientes {

	ClientesDAO cd;
	MySQLDAOFactory f;

	public ServiceClientesImp() {

		f = new MySQLDAOFactory();
		cd = f.getClientesDAO();
	}

	@Override
	public void insertar(Cliente c) {
		cd.insertar(c);
	}

	@Override
	public void eliminar(Cliente c) {
		cd.eliminar(c);
	}

	@Override
	public void actualizar(Cliente c) {
		cd.actualizar(c);
	}

	@Override
	public Cliente buscarPorClave(Integer id) {
		return cd.buscarPorClave(id);
	}

	@Override
	public List<Cliente> buscarTodos() {
		return cd.buscarTodos();
	}

	@Override
	public Cliente buscarClientePorEmail(String email) {
		return cd.buscarClientePorEmail(email);
	}
	
	@Override
	public Cliente buscarPorNombre(String string) {
		return cd.buscarPorNombre(string);
	}

}
