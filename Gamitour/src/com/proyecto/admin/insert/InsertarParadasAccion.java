package com.proyecto.admin.insert;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.FileUtils;

import com.proyecto.modelo.Itinerario;
import com.proyecto.modelo.Parada;

import com.proyecto.service.ServiceItinerariosImp;
import com.proyecto.service.ServiceParadasImp;

@MultipartConfig
@WebServlet("/InsertarParadasAccion")
public class InsertarParadasAccion extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final String directorio = "/opt/subidas/paradas/";
	ServiceParadasImp sp = new ServiceParadasImp();
	ServiceItinerariosImp si = new ServiceItinerariosImp();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombre = request.getParameter("nombre");
		String numeroParada = request.getParameter("numeroParada");
		String ubicacion = request.getParameter("ubicacion");
		String historia = request.getParameter("historia");
		String anecdotario = request.getParameter("anecdotario");
		String gastronomia = request.getParameter("gastronomia");
		Part imagen = request.getPart("imagen");
		String itinerario = request.getParameter("itinerario");
		String latitud = request.getParameter("latitud");
		String longitud = request.getParameter("longitud");

		float lat=0,lng=0;
		
		try {
			lat = Float.parseFloat(latitud);
			lng = Float.parseFloat(longitud);
		} catch (Exception e) {
			System.out.println("Excepcion controlada al procesar coordenadas.");
		}
		
		/* Proceso ficheros (nombre-numeroParada-file.jpg)*/
		String imagenName = nombre + "-" + numeroParada + "-"
				+ Paths.get(imagen.getSubmittedFileName()).getFileName().toString();

		InputStream imagenStream = imagen.getInputStream();

		File imagenSalida = new File(directorio + imagenName);

		FileUtils.copyInputStreamToFile(imagenStream, imagenSalida);

		imagenStream.close();


		Itinerario i = si.buscarPorClave(Integer.parseInt(itinerario));

		Parada p = new Parada(i, nombre, Integer.parseInt(numeroParada), ubicacion, historia, anecdotario, gastronomia,
				imagenName, lat, lng);

		sp.insertar(p);

		response.sendRedirect("MostrarAdmin.do?div=paradas"); ;
	}

}
