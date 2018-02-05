package com.proyecto.admin.insert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.modelo.Cliente;

import com.proyecto.modelo.Premio;
import com.proyecto.service.ServiceClientesImp;

import com.proyecto.service.ServicePremiosImp;
import com.proyecto.util.Accion;

public class InsertarPremiosAccion extends Accion {

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

		ServicePremiosImp sp = new ServicePremiosImp();
		ServiceClientesImp sc = new ServiceClientesImp();

		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String imagen = request.getParameter("imagen");
		String fechaactivacion = request.getParameter("fechaactivacion");
		String fechaconsumo = request.getParameter("fechaconsumo");
		String cliente = request.getParameter("cliente");
		String puntos = request.getParameter("puntos");
		Date date1 = null;
		Date date2 = null;

		try {

			if (fechaactivacion != "")
				date1 = formatter.parse(fechaactivacion);

			if (fechaconsumo != "")
				date2 = formatter.parse(fechaconsumo);

		} catch (ParseException e) {
			System.out.println("Fallo al convertir fechas. " + e.getMessage());
		}

		Cliente c = sc.buscarPorClave(Integer.parseInt(cliente));

		Premio p = new Premio(c, nombre, descripcion, imagen, date1, date2, Integer.parseInt(puntos));

		sp.insertar(p);

		return "MostrarAdmin.do?div=premios";
	}

}
