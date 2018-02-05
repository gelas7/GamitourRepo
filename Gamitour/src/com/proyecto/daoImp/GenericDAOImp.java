package com.proyecto.daoImp;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.SessionFactory;
import com.proyecto.util.GenericDAO;

public abstract class GenericDAOImp<T, Id extends Serializable> implements GenericDAO<T, Id> {

	SessionFactory sf;
	private Class<T> clase;

	public GenericDAOImp(SessionFactory sessionFactory) {
		this.sf = sessionFactory;
		this.clase = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

	}

	public GenericDAOImp() {
		this.clase = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public void insertar(T t) {
		try {
			sf.getCurrentSession().beginTransaction();
			sf.getCurrentSession().save(t);
			sf.getCurrentSession().getTransaction().commit();
		}
		catch(Exception e)
		{
			sf.getCurrentSession().getTransaction().rollback();
		}
	}

	public void eliminar(T t) {
		try {
			sf.getCurrentSession().beginTransaction();
			sf.getCurrentSession().delete(t);
			sf.getCurrentSession().getTransaction().commit();
		}
		catch(Exception e)
		{
			sf.getCurrentSession().getTransaction().rollback();
		}
	}

	public void actualizar(T t) {
		try {
			sf.getCurrentSession().beginTransaction();
			sf.getCurrentSession().update(t);
			sf.getCurrentSession().getTransaction().commit();
		}
		catch(Exception e)
		{
			sf.getCurrentSession().getTransaction().rollback();
		}
	}

	public List<T> buscarTodos() {

		List<T> lista = null;
		try {
			sf.getCurrentSession().beginTransaction();
			Query q = sf.getCurrentSession().createQuery("select o from " +clase.getSimpleName()+" o");
			lista = q.getResultList();
			sf.getCurrentSession().getTransaction().commit();
			
		} catch (RuntimeException e) {
			sf.getCurrentSession().getTransaction().rollback();
		}
		return lista;
		
	}

	public T buscarPorClave(Id id) {
		T objeto = null;

		sf.getCurrentSession().beginTransaction();
		Query q = sf.getCurrentSession().createQuery("select c from "+clase.getSimpleName()+" c where id=:id");
		q.setParameter("id", id);

		try {
			objeto = (T) q.getSingleResult();
		} catch (javax.persistence.NoResultException ex) {
			System.out.println("No hubo resultados en la busqueda por id. ");
		}

		sf.getCurrentSession().getTransaction().commit();
		return objeto;

	}
	
	public T buscarPorNombre(String nombre) {
		T objeto = null;

		sf.getCurrentSession().beginTransaction();
		Query q = sf.getCurrentSession().createQuery("select c from "+ clase.getSimpleName() +" c where nombre=:nombre");
		q.setParameter("nombre", nombre);

		try {
			objeto = (T) q.getSingleResult();
		} catch (javax.persistence.NoResultException ex) {
			System.out.println("No hubo resultados en la busqueda por nombre. ");
		}

		sf.getCurrentSession().getTransaction().commit();
		return objeto;

	}
}