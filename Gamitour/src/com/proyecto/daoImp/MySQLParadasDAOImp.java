package com.proyecto.daoImp;

import org.hibernate.SessionFactory;
import com.proyecto.dao.ParadasDAO;
import com.proyecto.modelo.Parada;

public class MySQLParadasDAOImp extends GenericDAOImp<Parada, Integer> implements ParadasDAO {

	public MySQLParadasDAOImp(SessionFactory sf) {
		super(sf);
	}
}
