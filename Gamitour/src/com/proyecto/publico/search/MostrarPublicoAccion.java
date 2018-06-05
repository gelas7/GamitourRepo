package com.proyecto.publico.search;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.proyecto.modelo.Actividad;
import com.proyecto.modelo.Cliente;
import com.proyecto.modelo.Itinerario;
import com.proyecto.modelo.Multimedia;
import com.proyecto.modelo.Noticia;
import com.proyecto.service.ServiceActividadesImp;
import com.proyecto.service.ServiceClientesImp;
import com.proyecto.service.ServiceItinerarios;
import com.proyecto.service.ServiceItinerariosImp;
import com.proyecto.service.ServiceMultimedias;
import com.proyecto.service.ServiceMultimediasImp;
import com.proyecto.service.ServiceNoticiasImp;
import com.proyecto.service.ServicePremiosImp;
import com.proyecto.service.ServiceReservasImp;
import com.proyecto.util.Accion;

public class MostrarPublicoAccion extends Accion {

	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {

		ServiceNoticiasImp sn = new ServiceNoticiasImp();
		ServiceClientesImp sc = new ServiceClientesImp();
		ServiceItinerarios si = new ServiceItinerariosImp();
		ServiceActividadesImp sa = new ServiceActividadesImp();
		ServiceMultimedias sm = new ServiceMultimediasImp();
		ServiceReservasImp sr = new ServiceReservasImp();
		ServicePremiosImp sp = new ServicePremiosImp();

		Gson g = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();

		String solicitud = request.getParameter("id");
		String email = (String) request.getSession().getAttribute("email");
		String rol = (String) request.getSession().getAttribute("rol");

		String salida = "Cliente/";

		if (email != null && rol != null) { // REGISTRADOS
			salida += "Registrados/";

			switch (solicitud) {

			case "index":
				salida += "indexRegistrado.jsp";
				List<Noticia> listaNoticias = sn.buscarTodos();
				String ns = g.toJson(listaNoticias);
				request.getSession().setAttribute("listaNoticias", ns);
				break;
			case "rutas":
				salida += "RutasRegistrado.jsp";
				List<Itinerario> listaItinerarios = si.buscarTodos();
				String its = g.toJson(listaItinerarios);
				request.getSession().setAttribute("listaItinerarios", its);
				List<Multimedia> listaMultimedias = sm.buscarTodos();
				String ms = g.toJson(listaMultimedias); // Multimedias-Comentarios-Votos
				request.getSession().setAttribute("listaMultimedias", ms);
				break;
			case "actividades":
				salida += "ActividadesRegistrado.jsp";
				List<Actividad> listaActividades = sa.buscarTodos();
				String as = g.toJson(listaActividades);
				request.getSession().setAttribute("listaActividades", as);
				break;
			case "usuario":
				salida += "UsuarioRegistrado.jsp";
				Cliente cliente = sc.buscarClientePorEmail(email);
				request.getSession().setAttribute("cliente", cliente);
				request.getSession().setAttribute("reservasClienteActual",
						sr.buscarReservasPorIdCliente(cliente.getIdcliente()));
				request.getSession().setAttribute("premiosClienteActual", cliente.getPremios());
				request.getSession().setAttribute("premiosLibres", sp.buscarPremiosNoAsignados());
				break;

			default:
				System.out.println("Error en eleccion de salida Clientes - MostrarPublicoAccion");
				break;
			}
		}

		else {
			switch (solicitud) {
			case "index":
				salida += "index.jsp";
				List<Noticia> listaNoticias = sn.buscarTodos();
				String ns = g.toJson(listaNoticias);
				request.getSession().setAttribute("listaNoticias", ns);
				break;
			case "rutas":
				salida += "RutasPublico.jsp";
				List<Itinerario> listaItinerarios = si.buscarTodos();
				String its = g.toJson(listaItinerarios);
				request.getSession().setAttribute("listaItinerarios", its);
				break;
			case "actividades":
				salida += "ActividadesPublico.jsp";
				List<Actividad> listaActividades = sa.buscarTodos();
				String as = g.toJson(listaActividades);
				request.getSession().setAttribute("listaActividades", as);
				break;
			case "usuario":
				salida += "Register.jsp";
				break;
			default:
				System.out.println("Error en eleccion de salida Clientes - MostrarPublicoAccion");
				break;
			}
		}

		return salida;
	}

}
