package com.proyecto.daoImp;

import javax.persistence.Query;
import org.hibernate.SessionFactory;
import com.proyecto.dao.ClientesDAO;
import com.proyecto.modelo.Cliente;

public class MySQLClientesDAOImp extends GenericDAOImp<Cliente, Integer> implements ClientesDAO {

	public MySQLClientesDAOImp(SessionFactory sf) {
		super(sf);
	}

	public Cliente buscarClientePorEmail(String email) {
		Cliente c = null;

		try {
			sf.getCurrentSession().beginTransaction();
			Query q = sf.getCurrentSession().createQuery("select c from Cliente c where email=:email");
			q.setParameter("email", email);
			c = (Cliente) q.getSingleResult();
			sf.getCurrentSession().getTransaction().commit();

		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
			sf.getCurrentSession().getTransaction().rollback();
		}

		return c;
	}
}
