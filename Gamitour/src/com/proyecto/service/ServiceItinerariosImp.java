package com.proyecto.service;

import java.util.List;

import com.proyecto.dao.ItinerariosDAO;
import com.proyecto.modelo.Itinerario;
import com.proyecto.modelo.Parada;
import com.proyecto.util.MySQLDAOFactory;

public class ServiceItinerariosImp implements ServiceItinerarios {
	
	MySQLDAOFactory f;
	ItinerariosDAO itd;
	ServiceParadasImp sp;
	
	public ServiceItinerariosImp() {
		f = new MySQLDAOFactory();
		itd = f.getItinerariosDAO();
		sp = new ServiceParadasImp();
	}

	@Override
	public void insertar(Itinerario it) {
		itd.insertar(it);
		for(Parada p : it.getParadas())
		{
			sp.insertar(p);
		}
	}

	@Override
	public void eliminar(Itinerario it) {
		for(Parada p : it.getParadas())
		{
			sp.eliminar(p);
		}
		itd.eliminar(it);
	}

	@Override
	public void actualizar(Itinerario it) {
		for(Parada p : it.getParadas())
		{
			sp.actualizar(p);
		}
		itd.actualizar(it);
	}

	@Override
	public Itinerario buscarPorClave(Integer id) {
		return itd.buscarPorClave(id);
	}

	@Override
	public List<Itinerario> buscarTodos() {
		return itd.buscarTodos();
	}

	@Override
	public Itinerario buscarPorNombre(String nombre) {
		return itd.buscarPorNombre(nombre);
	}

}
