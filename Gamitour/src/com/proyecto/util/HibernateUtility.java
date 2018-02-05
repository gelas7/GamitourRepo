package com.proyecto.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {

	public static SessionFactory sf;
	
	public static synchronized SessionFactory getSessionFactory() {
	
		if(sf==null)
		{
			sf = new Configuration().configure().buildSessionFactory();
		}
		return sf;
	}
	
	public static void cerrarSesion() {
		
		if(sf!=null) 
			sf.close();
	}
}
