package com.proyecto.util;

import org.hibernate.SessionFactory;

import com.proyecto.dao.ActividadesDAO;
import com.proyecto.dao.ClientesDAO;
import com.proyecto.dao.ComentariosDAO;
import com.proyecto.dao.ItinerariosDAO;
import com.proyecto.dao.MultimediasDAO;
import com.proyecto.dao.NoticiasDAO;
import com.proyecto.dao.ParadasDAO;
import com.proyecto.dao.PremiosDAO;
import com.proyecto.dao.PruebasCulturalesDAO;
import com.proyecto.dao.PruebasDeportivasDAO;
import com.proyecto.dao.RolesDAO;
import com.proyecto.dao.VotosDAO;
import com.proyecto.daoImp.MySQLActividadesDAOImp;
import com.proyecto.daoImp.MySQLClientesDAOImp;
import com.proyecto.daoImp.MySQLComentariosDAOImp;
import com.proyecto.daoImp.MySQLItinerariosDAOImp;
import com.proyecto.daoImp.MySQLMultimediasDAOImp;
import com.proyecto.daoImp.MySQLNoticiasDAOImp;
import com.proyecto.daoImp.MySQLParadasDAOImp;
import com.proyecto.daoImp.MySQLPremiosDAOImp;
import com.proyecto.daoImp.MySQLPruebasCulturalesDAOImp;
import com.proyecto.daoImp.MySQLPruebasDeportivasDAOImp;
import com.proyecto.daoImp.MySQLRolesDAOImp;
import com.proyecto.daoImp.MySQLVotosDAOImp;


public class MySQLDAOFactory {

	SessionFactory sf;

	public MySQLDAOFactory() {
		// Recupero la info del fichero hibernate.cfg y realizo conexion a BBDD
		// Además crea una factoria de sesiones.
		// Desactivo los mensajes info de hibernate (Avisa a partir de warning)
		@SuppressWarnings("unused")
		org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
	    java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.WARNING);
		
	    try {
			sf = HibernateUtility.getSessionFactory();
		}

		catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

	public ClientesDAO getClientesDAO() {
		return new MySQLClientesDAOImp(sf);
	}

	public ActividadesDAO getActividadesDAO() {
		return new MySQLActividadesDAOImp(sf);
	}
	
	public PruebasCulturalesDAO getPruebasCulturalesDAO() {
		return new MySQLPruebasCulturalesDAOImp(sf);
	}
	
	public PruebasDeportivasDAO getPruebasDeportivasDAO() {
		return new MySQLPruebasDeportivasDAOImp(sf);
	}
	
	public RolesDAO getRolesDAO() {
		return new MySQLRolesDAOImp(sf);
	}
	
	public PremiosDAO getPremiosDAO() {
		return new MySQLPremiosDAOImp(sf);
	}
	
	public ParadasDAO getParadasDAO() {
		return new MySQLParadasDAOImp(sf);
	}
	
	public NoticiasDAO getNoticiasDAO() {
		return new MySQLNoticiasDAOImp(sf);
	}
	
	public ComentariosDAO getComentariosDAO() {
		return new MySQLComentariosDAOImp(sf);
	}

	public ItinerariosDAO getItinerariosDAO() {
		return new MySQLItinerariosDAOImp(sf);
	}

	public MultimediasDAO getMultimediasDAO() {
		return new MySQLMultimediasDAOImp(sf);
	}

	public VotosDAO getVotosDAO() {
		return new MySQLVotosDAOImp(sf);
	}

}
