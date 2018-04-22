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

import com.proyecto.modelo.Cliente;
import com.proyecto.modelo.Multimedia;
import com.proyecto.service.ServiceClientes;
import com.proyecto.service.ServiceClientesImp;
import com.proyecto.service.ServiceMultimedias;
import com.proyecto.service.ServiceMultimediasImp;

@MultipartConfig
@WebServlet("/InsertarMultimediasAccion")
public class InsertarMultimediasAccion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	private final String directorio = "/opt/subidas/multimedias/";
	ServiceMultimedias sm = new ServiceMultimediasImp();
	ServiceClientes sc = new ServiceClientesImp();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cliente = request.getParameter("cliente");
		String comentario = request.getParameter("comentario");
		String idPd = request.getParameter("pruebaD");
		String puntos = request.getParameter("puntos");
		Part imagen = request.getPart("imagen");
		Part video = request.getPart("video");

		String imagenName = "", videoName = "";
		InputStream imagenStream = null, videoStream = null;

		Date date = new Date();
		String fecha = formatter.format(date); // 2016-11-16

		/* Proceso ficheros(cliente-fecha-file.jpg) */
		try {
			imagenName = cliente + "-" + fecha + "-"
					+ Paths.get(imagen.getSubmittedFileName()).getFileName().toString();
			videoName = cliente + "-" + fecha + "-" + Paths.get(video.getSubmittedFileName()).getFileName().toString();

			imagenStream = imagen.getInputStream();
			videoStream = video.getInputStream();

			File imagenSalida = new File(directorio + imagenName);
			File videoSalida = new File(directorio + videoName);

			FileUtils.copyInputStreamToFile(imagenStream, imagenSalida);
			FileUtils.copyInputStreamToFile(videoStream, videoSalida);
		} catch (Exception e) {
			System.out.println("Fallo al gestionar ficheros. " + e.getMessage());
		} finally {
			imagenStream.close();
			videoStream.close();
		}

		Cliente c = sc.buscarPorClave(Integer.parseInt(cliente));

		sm.insertar(new Multimedia(c, date, comentario, imagenName, videoName, Integer.parseInt(idPd),
				Integer.parseInt(puntos))); // Inserto

		request.setAttribute("listaMultimedias", sm.buscarTodos()); // Actualizo lista

		response.sendRedirect("MostrarAdmin.do?div=multimedias");
	}

}
