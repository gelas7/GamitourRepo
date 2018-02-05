package com.proyecto.daoImp;

import org.hibernate.SessionFactory;
import com.proyecto.dao.NoticiasDAO;
import com.proyecto.modelo.Noticia;

public class MySQLNoticiasDAOImp extends GenericDAOImp<Noticia, Integer> implements NoticiasDAO {

	// CONSTRUCTOR CON HERENCIA
	public MySQLNoticiasDAOImp(SessionFactory sf) {
		super(sf);
	}

}
