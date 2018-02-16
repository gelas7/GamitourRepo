package com.proyecto.daoImp;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import com.proyecto.dao.ComentariosDAO;
import com.proyecto.modelo.Comentario;


public class MySQLComentariosDAOImp extends GenericDAOImp<Comentario, Integer> implements ComentariosDAO {

	public MySQLComentariosDAOImp(SessionFactory sf) {
		super(sf);
	}

	@Override
	public List<Comentario> buscarComentPorMultimedia(String idmultimedia) {
		List<Comentario> lista = null;
		try {
			sf.getCurrentSession().beginTransaction();
			Query q = sf.getCurrentSession().createQuery("select c from Comentario c where multimedia_idmultimedia=:id");
			q.setParameter("id", idmultimedia);
			lista = q.getResultList();
			sf.getCurrentSession().getTransaction().commit();
			
		} catch (RuntimeException e) {
			sf.getCurrentSession().getTransaction().rollback();
		}
		
		System.out.println(lista.toString());
		return lista;
		
	}
}
