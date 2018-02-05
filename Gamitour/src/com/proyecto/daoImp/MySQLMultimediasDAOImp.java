package com.proyecto.daoImp;

import org.hibernate.SessionFactory;


import com.proyecto.dao.MultimediasDAO;

import com.proyecto.modelo.Multimedia;

public class MySQLMultimediasDAOImp extends GenericDAOImp<Multimedia, Integer> implements MultimediasDAO  {
	
	public MySQLMultimediasDAOImp(SessionFactory sf) {
		super(sf);
	}

}
