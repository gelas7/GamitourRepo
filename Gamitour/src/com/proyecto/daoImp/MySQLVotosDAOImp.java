package com.proyecto.daoImp;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import com.proyecto.dao.VotosDAO;
import com.proyecto.modelo.Voto;

public class MySQLVotosDAOImp extends GenericDAOImp<Voto, Integer> implements VotosDAO {

	public MySQLVotosDAOImp(SessionFactory sf) {
		super(sf);
	}
	
	@Override
	public List<Voto> buscarVotosPorMultimedia(String idmultimedia) {
		List<Voto> lista = null;
		try {
			sf.getCurrentSession().beginTransaction();
			Query q = sf.getCurrentSession().createQuery("select v from Voto v where multimedia_idmultimedia=:id");
			q.setParameter("id", idmultimedia);
			lista = q.getResultList();
			sf.getCurrentSession().getTransaction().commit();
			
		} catch (RuntimeException e) {
			sf.getCurrentSession().getTransaction().rollback();
		}
		
		return lista;
		
	}
}
