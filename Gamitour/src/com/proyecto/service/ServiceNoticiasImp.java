package com.proyecto.service;

import java.util.List;

import com.proyecto.dao.NoticiasDAO;
import com.proyecto.modelo.Noticia;
import com.proyecto.util.MySQLDAOFactory;

public class ServiceNoticiasImp implements ServiceNoticias {

	NoticiasDAO nd;
	MySQLDAOFactory f;

	public ServiceNoticiasImp() {

		f = new MySQLDAOFactory();
		nd = f.getNoticiasDAO();
	}

	@Override
	public void insertar(Noticia n) {
		nd.insertar(n);
	}

	@Override
	public void eliminar(Noticia n) {
		nd.eliminar(n);
	}

	@Override
	public void actualizar(Noticia n) {
		nd.actualizar(n);
	}

	@Override
	public Noticia buscarPorClave(Integer id) {
		return nd.buscarPorClave(id);
	}

	@Override
	public List<Noticia> buscarTodos() {
		return nd.buscarTodos();
	}

	@Override
	public Noticia buscarPorNombre(String n) {
		return nd.buscarPorNombre(n);
	}
}
