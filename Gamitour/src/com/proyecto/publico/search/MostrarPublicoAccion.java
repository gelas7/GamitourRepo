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
import com.proyecto.service.ServiceNoticias;
import com.proyecto.service.ServiceNoticiasImp;
import com.proyecto.util.Accion;

public class MostrarPublicoAccion extends Accion {

	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF8");

		ServiceNoticias sn = new ServiceNoticiasImp();
		ServiceClientesImp sc = new ServiceClientesImp();
		ServiceItinerarios si = new ServiceItinerariosImp();
		ServiceActividadesImp sa = new ServiceActividadesImp();
		ServiceMultimedias sm = new ServiceMultimediasImp();

		List<Noticia> listaNoticias = sn.buscarTodos();
		List<Cliente> listaClientes = sc.buscarTodos();
		List<Itinerario> listaItinerarios = si.buscarTodos();
		List<Actividad> listaActividades = sa.buscarTodos();
		List<Multimedia> listaMultimedias = sm.buscarTodos();

		// JSON con GSON
		Gson g = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();

		String its = g.toJson(listaItinerarios);// Itinerarios-Paradas-Pruebas
		// System.out.println("Itinerarios: " + its);

		String cls = g.toJson(listaClientes); // Clientes-Premios-Votos-Comentarios-Activiades-Multimedias
		// System.out.println("Clientes: " + cls);

		String ns = g.toJson(listaNoticias);
		// System.out.println("Noticias: " + ns);

		String as = g.toJson(listaActividades);
		// System.out.println("Actividades: " + as);

		String ms = g.toJson(listaMultimedias); // Multimedias-Comentarios-Votos
		// System.out.println("Multimedias: " + ms);

		request.getSession().setAttribute("listaClientes", cls);
		request.getSession().setAttribute("listaItinerarios", its);
		request.getSession().setAttribute("listaNoticias", ns);
		request.getSession().setAttribute("listaActividades", as);
		request.getSession().setAttribute("listaMultimedias", ms);

		String solicitud = request.getParameter("id");// Que info debemos mostrar(rutas,infoCliente,actividades...)

		String email = (String) request.getSession().getAttribute("email");
		String rol = (String) request.getSession().getAttribute("rol");

		String salida = "Cliente/";

		if (email != null && rol != null) {
			salida += "Registrados/";

			switch (solicitud) {
			// CLIENTES

//			case "index":
//				salida += "indexRegistrado.jsp";
//				break;
			case "rutas":
				salida += "RutasRegistrado.jsp";
				break;
			case "actividades":
				salida += "ActividadesCliente.jsp";
				break;
			default:
				System.out.println("Error en eleccion de salida Clientes - MostrarPublicoAccion");
				break;
			}
		}
		
		else {
			switch (solicitud) {
			// CLIENTES
//			case "index":
//				salida += "index.html";
//				break;
			case "rutas":
				salida += "RutasPublico.jsp";
				break;
			case "actividades":
				salida += "ActividadesPublico.jsp";
				break;
			default:
				System.out.println("Error en eleccion de salida Clientes - MostrarPublicoAccion");
				break;
			}
		}

		return salida;
	}

}
