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
import com.proyecto.modelo.Cliente;
import com.proyecto.modelo.Premio;
import com.proyecto.service.ServiceClientesImp;
import com.proyecto.service.ServicePremiosImp;

@MultipartConfig
@WebServlet("/InsertarPremiosAccion")
public class InsertarPremiosAccion extends HttpServlet {

	private static final long serialVersionUID = 1L;
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	private final String directorio = "/opt/subidas/premios/";
	ServicePremiosImp sp = new ServicePremiosImp();
	ServiceClientesImp sc = new ServiceClientesImp();
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		Part imagen = request.getPart("imagen");
		String fechaactivacion = request.getParameter("fechaactivacion");
		String fechaconsumo = request.getParameter("fechaconsumo");
		String cliente = request.getParameter("cliente");
		String puntos = request.getParameter("puntos");
		Date date1 = null;
		Date date2 = null;

		try {
			if (fechaactivacion != "")
				date1 = formatter.parse(fechaactivacion);
			if (fechaconsumo != "")
				date2 = formatter.parse(fechaconsumo);

		} catch (ParseException e) {
			System.out.println("Fallo al convertir fechas. " + e.getMessage());
		}
		
		/* Proceso ficheros (fechaConsumo-fechaActivacion-file.jpg) */
		String imagenName = fechaconsumo+"-"+fechaactivacion+"-"
				+ Paths.get(imagen.getSubmittedFileName()).getFileName().toString();
		
		InputStream imagenStream = imagen.getInputStream();

		File imagenSalida = new File(directorio + imagenName);

		FileUtils.copyInputStreamToFile(imagenStream, imagenSalida);

		imagenStream.close();
		
		Cliente c = sc.buscarPorClave(Integer.parseInt(cliente));

		Premio p = new Premio(c, nombre, descripcion, imagenName, date1, date2, Integer.parseInt(puntos));

		sp.insertar(p);

		response.sendRedirect("MostrarAdmin.do?div=premios");
	}

}
