package com.proyecto.service;

import java.util.List;


import com.proyecto.dao.PremiosDAO;
import com.proyecto.modelo.Premio;
import com.proyecto.util.MySQLDAOFactory;

public class ServicePremiosImp implements ServicePremios {
	
	PremiosDAO pd;
	MySQLDAOFactory f;

	public ServicePremiosImp() {

		f = new MySQLDAOFactory();
		pd = f.getPremiosDAO();
	}

	@Override
	public void insertar(Premio p) {
		pd.insertar(p);
	}

	@Override
	public void eliminar(Premio p) {
		pd.eliminar(p);
	}

	@Override
	public void actualizar(Premio p) {
		pd.actualizar(p);
	}

	@Override
	public Premio buscarPorClave(Integer id) {
		return pd.buscarPorClave(id);
	}

	@Override
	public List<Premio> buscarTodos() {
		return pd.buscarTodos();
	}

	@Override
	public Premio buscarPorNombre(String nombre) {
		return pd.buscarPorNombre(nombre);
	}

	@Override
	public List<Premio> buscarPremiosPorIdCliente(Integer idCliente) {
		return pd.buscarPremiosPorIdCliente(idCliente);
	}

	@Override
	public List<Premio> buscarPremiosNoAsignados() {
		return pd.buscarPremiosNoAsignados();
	}
}
