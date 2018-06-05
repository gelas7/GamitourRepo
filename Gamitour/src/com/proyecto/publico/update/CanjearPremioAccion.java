package com.proyecto.publico.update;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proyecto.modelo.Cliente;
import com.proyecto.modelo.Premio;
import com.proyecto.service.ServiceClientesImp;
import com.proyecto.service.ServicePremiosImp;
import com.proyecto.util.Accion;

@javax.servlet.annotation.MultipartConfig
public class CanjearPremioAccion extends Accion {


	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

		response.setContentType("text/html;charset=UTF-8");

		ServiceClientesImp sc = new ServiceClientesImp();
		ServicePremiosImp sp = new ServicePremiosImp();
		
		String idpremio = request.getParameter("id");

		Premio premio = sp.buscarPorClave(Integer.parseInt(idpremio));
		Cliente cliente = sc.buscarClientePorEmail((String) request.getSession().getAttribute("email"));

		if (premio != null && cliente != null) {
			cliente.setPuntosacumulados(cliente.getPuntosacumulados() - premio.getPuntos());
			sc.actualizar(cliente);// Resto puntos cliente
			premio.setCliente(cliente);
			sp.actualizar(premio);// Asigno el premio
		}
		String rutaSalida = "/MostrarPublico.cl?id=usuario";

		return rutaSalida;
	}

}
