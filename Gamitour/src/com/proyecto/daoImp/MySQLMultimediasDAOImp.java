package com.proyecto.daoImp;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import com.proyecto.dao.MultimediasDAO;
import com.proyecto.modelo.Multimedia;

public class MySQLMultimediasDAOImp extends GenericDAOImp<Multimedia, Integer> implements MultimediasDAO  {
	
	public MySQLMultimediasDAOImp(SessionFactory sf) {
		super(sf);
	}
	
	public List<Multimedia> mostrarMultimediasPorPd(String idprueba)
	{
		List<Multimedia> lista = null;
		try {
			sf.getCurrentSession().beginTransaction();
			Query q = sf.getCurrentSession().createQuery("select m from Multimedia m where pruebaDeportiva_idpruebadeportiva=:id");
			q.setParameter("id", idprueba);
			lista = q.getResultList();
			sf.getCurrentSession().getTransaction().commit();
			
		} catch (RuntimeException e) {
			sf.getCurrentSession().getTransaction().rollback();
		}
		return lista;
		
	}

}
