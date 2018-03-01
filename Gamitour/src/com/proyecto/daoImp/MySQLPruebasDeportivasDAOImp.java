package com.proyecto.daoImp;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import com.proyecto.dao.PruebasDeportivasDAO;
import com.proyecto.modelo.PruebaDeportiva;

public class MySQLPruebasDeportivasDAOImp  extends GenericDAOImp<PruebaDeportiva, Integer> implements PruebasDeportivasDAO {

	public MySQLPruebasDeportivasDAOImp(SessionFactory sf) {
		super(sf);
	}

	@Override
	public List<PruebaDeportiva> buscarPruebasDepPorParada(String id) {
		List<PruebaDeportiva> lista = null;
		try {
			sf.getCurrentSession().beginTransaction();
			Query q = sf.getCurrentSession().createQuery("select pd from PruebaDeportiva pd where parada_idparada=:id order by nombre");
			q.setParameter("id", id);
			lista = q.getResultList();
			sf.getCurrentSession().getTransaction().commit();
			
		} catch (RuntimeException e) {
			sf.getCurrentSession().getTransaction().rollback();
		}
		return lista;
	}

}
