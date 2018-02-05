package com.proyecto.daoImp;

import org.hibernate.SessionFactory;
import com.proyecto.dao.ItinerariosDAO;
import com.proyecto.modelo.Itinerario;

public class MySQLItinerariosDAOImp extends GenericDAOImp<Itinerario, Integer> implements ItinerariosDAO {
	
	public MySQLItinerariosDAOImp(SessionFactory sf) {
		super(sf);
	}
}
