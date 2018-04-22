package com.proyecto.admin.insert;

import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.modelo.Rol;
import com.proyecto.service.ServiceRolesImp;
import com.proyecto.util.Accion;

public class InsertarRolesAccion extends Accion {

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
	ServiceRolesImp sr= new ServiceRolesImp();

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		String nombre = request.getParameter("nombre");

		sr.insertar(new Rol(nombre,null));

		return "MostrarAdmin.do?div=roles";
	}

}
