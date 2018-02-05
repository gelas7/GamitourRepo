package com.proyecto.admin.insert;

import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.modelo.Rol;
import com.proyecto.service.ServiceRolesImp;
import com.proyecto.util.Accion;

public class InsertarRolesAccion extends Accion {

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		String nombre = request.getParameter("nombre");

		ServiceRolesImp sr= new ServiceRolesImp();
		sr.insertar(new Rol(nombre,null));

		return "MostrarAdmin.do?div=roles";
	}

}
