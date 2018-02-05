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
		sf.getCurrentSession().beginTransaction();
		Query q = sf.getCurrentSession().createQuery("select c from Cliente c where email=:email");
		q.setParameter("email", email);

		try {
			c = (Cliente) q.getSingleResult();
		} catch (javax.persistence.NoResultException ex) {
			System.out.println("No hubo resultados en la busqueda de clientes por Email");
		}

		sf.getCurrentSession().getTransaction().commit();
		return c;
	}
}
