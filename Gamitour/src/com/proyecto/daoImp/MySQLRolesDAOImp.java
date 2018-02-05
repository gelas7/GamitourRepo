package com.proyecto.daoImp;

import org.hibernate.SessionFactory;
import com.proyecto.dao.RolesDAO;
import com.proyecto.modelo.Rol;

public class MySQLRolesDAOImp extends GenericDAOImp<Rol, Integer> implements RolesDAO {

	public MySQLRolesDAOImp(SessionFactory sf) {
		super(sf);
	}
}
