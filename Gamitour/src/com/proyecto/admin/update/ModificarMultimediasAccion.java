package com.proyecto.admin.update;

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
		String idCliente = request.getParameter("cliente");
		String comentario = request.getParameter("comentario");
		Part imagen = request.getPart("imagen");
		Part video = request.getPart("video");
		String idPd = request.getParameter("pruebaD");
		String puntos = request.getParameter("puntos");
		Multimedia m = sm.buscarPorClave(Integer.parseInt(id));
		SimpleDateFormat dt = new SimpleDateFormat("yyyy/MM/dd-hh:mm:ss");
        String hoy = dt.format(new Date());

		if (idCliente != "") {
			Cliente c = sc.buscarPorClave(Integer.parseInt(idCliente));
			m.setCliente(c);
		}

		if (idPd != "") {
			m.setPruebaDeportivaIdpruebadeportiva(Integer.parseInt(idPd));
		}

		if (imagen != null) {
			String imagenName = hoy + "-"
					+ Paths.get(imagen.getSubmittedFileName()).getFileName().toString();
			InputStream imagenStream = imagen.getInputStream();
			File imagenSalida = new File(directorio + imagenName);
			FileUtils.copyInputStreamToFile(imagenStream, imagenSalida);
			imagenStream.close();
			m.setImagen(imagenName);
		}

		if (video != null) {
			String videoName = hoy + "-"
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
