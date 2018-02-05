package com.proyecto.daoImp;

import org.hibernate.SessionFactory;
import com.proyecto.dao.PruebasCulturalesDAO;
import com.proyecto.modelo.PruebaCultural;

public class MySQLPruebasCulturalesDAOImp extends GenericDAOImp<PruebaCultural, Integer> implements PruebasCulturalesDAO {

	public MySQLPruebasCulturalesDAOImp(SessionFactory sf) {
		super(sf);
	}
	
}
