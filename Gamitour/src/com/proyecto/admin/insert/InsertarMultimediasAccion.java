package com.proyecto.admin.insert;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.FileUtils;

import com.proyecto.modelo.Cliente;
import com.proyecto.modelo.Multimedia;
import com.proyecto.service.ServiceClientes;
import com.proyecto.service.ServiceClientesImp;
import com.proyecto.service.ServiceMultimedias;
import com.proyecto.service.ServiceMultimediasImp;

@javax.servlet.annotation.MultipartConfig
@WebServlet("/InsertarMultimediasAccion")
public class InsertarMultimediasAccion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
	private final String directorio = "/Users/Gelas/Desktop/subidas/";
	ServiceMultimedias sm = new ServiceMultimediasImp();
	ServiceClientes sc = new ServiceClientesImp();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cliente = request.getParameter("cliente");
		String fecha = request.getParameter("fecha");
		String comentario = request.getParameter("comentario");
		String idPd = request.getParameter("pruebaD");
		String puntos = request.getParameter("puntos");
		Part imagen = request.getPart("imagen");
		Part video = request.getPart("video");
		Date date = null;

		/* Proceso ficheros */
		String imagenName = Paths.get(imagen.getSubmittedFileName()).getFileName().toString();
		String videoName = Paths.get(video.getSubmittedFileName()).getFileName().toString();

		InputStream imagenStream = imagen.getInputStream();
		InputStream videoStream = video.getInputStream();

		File imagenSalida = new File(directorio + imagenName);
		File videoSalida = new File(directorio + videoName);

		FileUtils.copyInputStreamToFile(imagenStream, imagenSalida);
		FileUtils.copyInputStreamToFile(videoStream, videoSalida);

		imagenStream.close();
		videoStream.close();

		/* Parseo fecha */
		try {
			if (fecha != "")
				date = formatter.parse(fecha);
		} catch (ParseException e) {
			System.out.println("Fallo al convertir fechas. " + e.getMessage());
		}

		Cliente c = sc.buscarPorClave(Integer.parseInt(cliente));

		sm.insertar(new Multimedia(c, date, comentario, imagenName, videoName, Integer.parseInt(idPd),
				Integer.parseInt(puntos))); // Inserto

		request.setAttribute("listaMultimedias", sm.buscarTodos()); // Actualizo lista

		response.sendRedirect("MostrarAdmin.do?div=multimedias");
	}

}
