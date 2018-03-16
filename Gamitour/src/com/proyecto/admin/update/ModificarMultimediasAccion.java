package com.proyecto.admin.update;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.text.DateFormat;
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
@WebServlet("/ModificarMultimediasAccion")
public class ModificarMultimediasAccion extends HttpServlet {

	private static final long serialVersionUID = 1L;
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	private final String directorio = "/opt/subidas/multimedias/";
	ServiceMultimedias sm = new ServiceMultimediasImp();
	ServiceClientes sc = new ServiceClientesImp();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String cliente = request.getParameter("cliente");
		String comentario = request.getParameter("comentario");
		Part imagen = request.getPart("imagen");
		Part video = request.getPart("video");
		String idPd = request.getParameter("pruebaD");
		String puntos = request.getParameter("puntos");

		Multimedia m = sm.buscarPorClave(Integer.parseInt(id));

		DateFormat dateFormat = new SimpleDateFormat("yyyy:MM:dd-HH.mm.ss");
		Date date = new Date();
		String fecha = dateFormat.format(date); // 2016/11/16 12:08:43

		if (cliente != "") {
			Cliente c = sc.buscarPorClave(Integer.parseInt(cliente));
			m.setCliente(c);
		}

		if (idPd != "") {
			m.setPruebaDeportivaIdpruebadeportiva(Integer.parseInt(idPd));
		}

		if (imagen != null) {
			String imagenName = fecha + "-" + cliente + "-"
					+ Paths.get(imagen.getSubmittedFileName()).getFileName().toString();
			InputStream imagenStream = imagen.getInputStream();
			File imagenSalida = new File(directorio + imagenName);
			FileUtils.copyInputStreamToFile(imagenStream, imagenSalida);
			imagenStream.close();
			m.setImagen(imagenName);
		}

		if (video != null) {
			String videoName = fecha + "-" + cliente + "-"
					+ Paths.get(video.getSubmittedFileName()).getFileName().toString();
			InputStream videoStream = video.getInputStream();
			File videoSalida = new File(directorio + videoName);
			FileUtils.copyInputStreamToFile(videoStream, videoSalida);
			videoStream.close();
			m.setVideo(videoName);
		}

		if (comentario != "")
			m.setComentario(comentario);

		if (puntos != "")
			m.setPuntosacumulados(Integer.parseInt(puntos));

		sm.actualizar(m);

		response.sendRedirect("MostrarAdmin.do?div=multimedias");
	}

}
