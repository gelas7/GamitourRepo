package com.proyecto.daoImp;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import com.proyecto.dao.ParadasDAO;
import com.proyecto.modelo.Parada;

public class MySQLParadasDAOImp extends GenericDAOImp<Parada, Integer> implements ParadasDAO {

	public MySQLParadasDAOImp(SessionFactory sf) {
		super(sf);
	}
	
	public List<Parada> buscarParadasPorIt(String idItinerario){
		
		List<Parada> lista = null;
		try {
			sf.getCurrentSession().beginTransaction();
		
			Query q = sf.getCurrentSession().createQuery("select p from Parada p where itinerario_iditinerario=:id ");
			q.setParameter("id", idItinerario);
			lista = q.getResultList();
			sf.getCurrentSession().getTransaction().commit();
			
		} catch (RuntimeException e) {
			sf.getCurrentSession().getTransaction().rollback();
		}
		return lista;	
	}
}
