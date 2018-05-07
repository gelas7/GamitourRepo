package com.proyecto.admin.update;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.modelo.Rol;
import com.proyecto.service.ServiceRolesImp;
import com.proyecto.util.Accion;

public class ModificarRolesAccion extends Accion {

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

		ServiceRolesImp sr = new ServiceRolesImp();
		String id = request.getParameter("id"); // Recupero el id original
		String nombreN = request.getParameter("nombreN");

		Rol r = sr.buscarPorClave(Integer.parseInt(id));

		if (nombreN.length() > 0) //Compruebo si se han hecho cambios
			r.setNombre(nombreN);

		sr.actualizar(r);// Actualizo BBDD

		return "MostrarAdmin.do?div=roles";
	}

}