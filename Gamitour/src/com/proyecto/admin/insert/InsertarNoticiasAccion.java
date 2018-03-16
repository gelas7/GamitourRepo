package com.proyecto.admin.insert;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

import java.text.ParseException;
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

import com.proyecto.modelo.Noticia;

import com.proyecto.service.ServiceNoticias;
import com.proyecto.service.ServiceNoticiasImp;

@MultipartConfig
@WebServlet("/InsertarNoticiasAccion")
public class InsertarNoticiasAccion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	private final String directorio = "/opt/subidas/noticias/";
	ServiceNoticias sn = new ServiceNoticiasImp();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombre = request.getParameter("nombre");
		String texto = request.getParameter("texto");
		String fecha = request.getParameter("fechaalta");
		String fechac = request.getParameter("fechacaducidad");
		Part imagen = request.getPart("imagen");

		Date date1 = null;
		Date date2 = null;

		try {

			if (fecha != "")
				date1 = formatter.parse(fecha);
			date2 = formatter.parse(fechac);
		} catch (ParseException e) {
			System.out.println("Fallo al convertir fechas. " + e.getMessage());
		}

		/* Proceso ficheros */
		String imagenName = fecha + "-" + nombre + "-"
				+ Paths.get(imagen.getSubmittedFileName()).getFileName().toString();

		InputStream imagenStream = imagen.getInputStream();

		File imagenSalida = new File(directorio + imagenName);

		FileUtils.copyInputStreamToFile(imagenStream, imagenSalida);

		imagenStream.close();

		sn.insertar(new Noticia(nombre, texto, date1, date2, imagenName)); // Inserto

		request.setAttribute("listaNoticias", sn.buscarTodos()); // Actualizo lista

		response.sendRedirect("MostrarAdmin.do?div=noticias");
	}

}
