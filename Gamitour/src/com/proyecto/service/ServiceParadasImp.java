package com.proyecto.service;

import java.util.List;

import com.proyecto.dao.ParadasDAO;

import com.proyecto.modelo.Parada;
import com.proyecto.modelo.PruebaCultural;
import com.proyecto.modelo.PruebaDeportiva;
import com.proyecto.util.MySQLDAOFactory;

public class ServiceParadasImp implements ServiceParadas {

	ParadasDAO pd;
	ServicePruebasCulturalesImp spc;
	ServicePruebasDeportivasImp spd;
	MySQLDAOFactory f;

	public ServiceParadasImp() {
		f = new MySQLDAOFactory();
		pd = f.getParadasDAO();
		spd = new ServicePruebasDeportivasImp();
		spc = new ServicePruebasCulturalesImp();
	}

	@Override
	public void insertar(Parada p) {
		System.out.println("ENTRO EN INSERTAR PARADA");
		pd.insertar(p);
		for (PruebaDeportiva pd : p.getPruebadeportivas()) {
			spd.insertar(pd);
		}
		for (PruebaCultural pc : p.getPruebaculturals()) {
			spc.insertar(pc);
		}
	}

	@Override
	public void eliminar(Parada p) {
		for (PruebaDeportiva pd : p.getPruebadeportivas()) {
			spd.eliminar(pd);
		}
		for (PruebaCultural pc : p.getPruebaculturals()) {
			spc.eliminar(pc);
		}
		pd.eliminar(p);
	}

	@Override
	public void actualizar(Parada p) {
		for (PruebaDeportiva pd : p.getPruebadeportivas()) {
			spd.actualizar(pd);
		}
		for (PruebaCultural pc : p.getPruebaculturals()) {
			spc.actualizar(pc);
		}
		pd.actualizar(p);
	}

	@Override
	public Parada buscarPorClave(Integer id) {
		return pd.buscarPorClave(id);
	}

	@Override
	public List<Parada> buscarTodos() {
		return pd.buscarTodos();
	}

	@Override
	public Parada buscarPorNombre(String nombre) {
		return pd.buscarPorNombre(nombre);
	}

	@Override
	public List<Parada> buscarParadasPorIt(String idItinerario) {

		return pd.buscarParadasPorIt(idItinerario);
	}
}
