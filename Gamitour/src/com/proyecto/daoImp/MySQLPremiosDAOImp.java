package com.proyecto.daoImp;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import com.proyecto.dao.PremiosDAO;
import com.proyecto.modelo.Premio;

public class MySQLPremiosDAOImp extends GenericDAOImp<Premio, Integer> implements PremiosDAO {

	public MySQLPremiosDAOImp(SessionFactory sf) {
		super(sf);
	}
	
	@Override
	public List<Premio> buscarPremiosPorIdCliente(Integer idCliente) {
		List<Premio> lista = null;
		try {
			sf.getCurrentSession().beginTransaction();
			Query q = sf.getCurrentSession().createQuery("select p from Premio p where cliente_idcliente=:id");
			q.setParameter("id", idCliente);
			lista = q.getResultList();
			sf.getCurrentSession().getTransaction().commit();
			
		} catch (RuntimeException e) {
			sf.getCurrentSession().getTransaction().rollback();
		}
		return lista;
	}

}
