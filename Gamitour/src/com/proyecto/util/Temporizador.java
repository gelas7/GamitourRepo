package com.proyecto.util;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Temporizador implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		
		Date horaDespertar = new Date(System.currentTimeMillis());
		Calendar c = Calendar.getInstance();
		c.setTime(horaDespertar);

		if(c.get(Calendar.HOUR_OF_DAY)>23)//Si es más tarde de las 23:00
			c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR) + 1);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);

		horaDespertar = c.getTime();
		System.out.println("Arrancando temporizador para el reparto de premios...");
		int tiempoRepeticion = 86400000;

		Timer temporizador = new Timer();
		temporizador.schedule(new RepartoPremios(), horaDespertar, tiempoRepeticion);
	}
}
