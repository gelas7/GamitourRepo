package com.proyecto.daoImp;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;

import com.proyecto.dao.ReservasDAO;
import com.proyecto.modelo.Reserva;

public class MySQLReservasDAOImp extends GenericDAOImp<Reserva, Integer> implements ReservasDAO {

	public MySQLReservasDAOImp(SessionFactory sf) {
		super(sf);
	}
	
	@Override
	public List<Reserva> buscarReservasPorIdCliente(Integer idCliente) {
		List<Reserva> lista = null;
		try {
			sf.getCurrentSession().beginTransaction();
			Query q = sf.getCurrentSession().createQuery("select r from Reserva r where cliente_idcliente=:id");
			q.setParameter("id", idCliente);
			lista = q.getResultList();
			sf.getCurrentSession().getTransaction().commit();
			
		} catch (RuntimeException e) {
			sf.getCurrentSession().getTransaction().rollback();
		}
		return lista;
	}
	
	
	
}
