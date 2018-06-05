package com.proyecto.util;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import com.proyecto.modelo.Cliente;
import com.proyecto.modelo.Multimedia;
import com.proyecto.modelo.PruebaDeportiva;
import com.proyecto.service.ServiceMultimedias;
import com.proyecto.service.ServiceMultimediasImp;
import com.proyecto.service.ServicePruebasDeportivasImp;

public class RepartoPremios extends TimerTask {

	@Override
	public void run() {
		ServiceMultimedias sm = new ServiceMultimediasImp();
		ServicePruebasDeportivasImp sp = new ServicePruebasDeportivasImp();
		List<PruebaDeportiva> listaPD = sp.buscarTodos();
		Calendar hoy = Calendar.getInstance();
		Calendar fechaMultimedia = Calendar.getInstance();

		hoy.setTime(new Date());
		System.out.println("Repartiendo premios...");

		for (PruebaDeportiva p : listaPD) {
			int puntosMaximos = 0;
			Cliente c = null;
			List<Multimedia> listaMultimedias = sm.buscarPorPD(String.valueOf(p.getIdpruebadeportiva()));

			for (Multimedia m : listaMultimedias) {
				fechaMultimedia.setTime(m.getFecha());// Fecha de multimedia actual
				boolean sameDay = hoy.get(Calendar.YEAR) == fechaMultimedia.get(Calendar.YEAR)
						&& hoy.get(Calendar.DAY_OF_YEAR) == fechaMultimedia.get(Calendar.DAY_OF_YEAR);

				if (sameDay)// Si es de hoy
					if (m.getPuntosacumulados() > puntosMaximos) {
						puntosMaximos = m.getPuntosacumulados();
						c = m.getCliente();
					}
			}

			if (puntosMaximos > 0 && c != null)
				c.setPuntosacumulados(c.getPuntosacumulados() + puntosMaximos);
		}

		System.out.println("Reparto de puntos completado.");
	}
}
