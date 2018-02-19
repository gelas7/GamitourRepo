package com.proyecto.service;

import java.util.List;

import com.proyecto.dao.VotosDAO;
import com.proyecto.modelo.Voto;
import com.proyecto.util.MySQLDAOFactory;

public class ServiceVotosImp implements ServiceVotos {

	VotosDAO vd;
	MySQLDAOFactory f;
	
	public ServiceVotosImp() {
		f = new MySQLDAOFactory();
		vd = f.getVotosDAO();
	}


	@Override
	public void insertar(Voto v) {
		vd.insertar(v);
	}

	@Override
	public void eliminar(Voto v) {
		vd.eliminar(v);
	}

	@Override
	public void actualizar(Voto v) {
		vd.actualizar(v);
	}

	@Override
	public Voto buscarPorClave(Integer id) {
		return vd.buscarPorClave(id);
	}

	@Override
	public List<Voto> buscarTodos() {
		return vd.buscarTodos();
	}


	@Override
	public List<Voto> buscarVotosPorMultimedia(String idmultimedia) {
		return vd.buscarVotosPorMultimedia(idmultimedia);
	}
}
