package com.proyecto.daoImp;

import org.hibernate.SessionFactory;
import com.proyecto.dao.PremiosDAO;
import com.proyecto.modelo.Premio;

public class MySQLPremiosDAOImp extends GenericDAOImp<Premio, Integer> implements PremiosDAO {

	public MySQLPremiosDAOImp(SessionFactory sf) {
		super(sf);
	}

}
