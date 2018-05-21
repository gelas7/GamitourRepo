package com.proyecto.daoImp;

import org.hibernate.SessionFactory;

import com.proyecto.dao.ReservasDAO;
import com.proyecto.modelo.Reserva;

public class MySQLReservasDAOImp extends GenericDAOImp<Reserva, Integer> implements ReservasDAO {

	public MySQLReservasDAOImp(SessionFactory sf) {
		super(sf);
	}
	
}
