package com.proyecto.daoImp;

import org.hibernate.SessionFactory;
import com.proyecto.dao.ComentariosDAO;
import com.proyecto.modelo.Comentario;

public class MySQLComentariosDAOImp extends GenericDAOImp<Comentario, Integer> implements ComentariosDAO {

	public MySQLComentariosDAOImp(SessionFactory sf) {
		super(sf);
	}
}
