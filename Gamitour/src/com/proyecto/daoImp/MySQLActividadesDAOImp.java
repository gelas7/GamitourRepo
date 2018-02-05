package com.proyecto.daoImp;


import org.hibernate.SessionFactory;

import com.proyecto.dao.ActividadesDAO;
import com.proyecto.modelo.Actividad;

public class MySQLActividadesDAOImp extends GenericDAOImp<Actividad, Integer> implements ActividadesDAO {

	public MySQLActividadesDAOImp(SessionFactory sf) {
		super(sf);
	}

}
