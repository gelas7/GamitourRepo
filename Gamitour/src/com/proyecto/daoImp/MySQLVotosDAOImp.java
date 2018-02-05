package com.proyecto.daoImp;

import org.hibernate.SessionFactory;
import com.proyecto.dao.VotosDAO;
import com.proyecto.modelo.Voto;

public class MySQLVotosDAOImp extends GenericDAOImp<Voto, Integer> implements VotosDAO {

	public MySQLVotosDAOImp(SessionFactory sf) {
		super(sf);
	}
}
