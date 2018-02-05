package com.proyecto.admin.insert;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.modelo.Voto;
import com.proyecto.service.ServiceVotosImp;
import com.proyecto.util.Accion;

public class InsertarVotosAccion extends Accion {
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		
		ServiceVotosImp sv = new ServiceVotosImp();
		sv.insertar(new Voto(null, null));
		
		return "MostrarAdmin.do?div=votos";
	}

}
