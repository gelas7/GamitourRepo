package com.proyecto.daoImp;


import org.hibernate.SessionFactory;
import com.proyecto.dao.PruebasDeportivasDAO;
import com.proyecto.modelo.PruebaDeportiva;

public class MySQLPruebasDeportivasDAOImp  extends GenericDAOImp<PruebaDeportiva, Integer> implements PruebasDeportivasDAO {

	public MySQLPruebasDeportivasDAOImp(SessionFactory sf) {
		super(sf);
	}

}
