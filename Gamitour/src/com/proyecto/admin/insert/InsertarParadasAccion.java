package com.proyecto.admin.insert;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	private final String directorio = "/opt/tomcat/webapps/subidas/paradas/";
	ServiceParadasImp sp = new ServiceParadasImp();
	ServiceItinerariosImp si = new ServiceItinerariosImp();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String nombre = request.getParameter("nombre");
		String numeroParada = request.getParameter("numeroParada");
		String ubicacion = request.getParameter("ubicacion");
		String historia = request.getParameter("historia");
		String anecdotario = request.getParameter("anecdotario");
		String gastronomia = request.getParameter("gastronomia");
		Part imagen = request.getPart("imagen");
		Part video = request.getPart("video");
		String itinerario = request.getParameter("itinerario");
		String latitud = request.getParameter("latitud");
		String longitud = request.getParameter("longitud");
		String imagenName = "";
		String videoName = "";
		InputStream imagenStream = null;
		InputStream videoStream = null;
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd(hh:mm:ss)");
		String hoy = dt.format(new Date());

		float lat = 0, lng = 0;

		try {
			lat = Float.parseFloat(latitud);
			lng = Float.parseFloat(longitud);
		} catch (Exception e) {
			System.out.println("Error al procesar coordenadas." + e.getMessage());
		}

		try {

			imagenName = hoy + "-" + Paths.get(imagen.getSubmittedFileName()).getFileName().toString();

			videoName = hoy + "-" + Paths.get(video.getSubmittedFileName()).getFileName().toString();

			imagenStream = imagen.getInputStream();
			videoStream = video.getInputStream();

			File imagenSalida = new File(directorio + imagenName);
			File videoSalida = new File(directorio + videoName);

			FileUtils.copyInputStreamToFile(imagenStream, imagenSalida);
			FileUtils.copyInputStreamToFile(videoStream, videoSalida);

		}

		catch (Exception e) {
			System.out.println("Error al gestionar ficheros. " + e.getMessage());
		} finally {
			imagenStream.close();
			videoStream.close();
		}

		Itinerario i = si.buscarPorClave(Integer.parseInt(itinerario));

		Parada p = new Parada(i, nombre, Integer.parseInt(numeroParada), ubicacion, historia, anecdotario, gastronomia,
				imagenName, videoName, lat, lng);

		sp.insertar(p);

		response.sendRedirect("MostrarAdmin.do?div=paradas");

	}

}
