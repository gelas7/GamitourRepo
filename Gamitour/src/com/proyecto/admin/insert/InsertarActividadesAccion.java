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

import com.proyecto.modelo.Actividad;
import com.proyecto.service.ServiceActividadesImp;

@MultipartConfig
@WebServlet("/InsertarActividadesAccion")
public class InsertarActividadesAccion extends HttpServlet {

	private static final long serialVersionUID = 1L;
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	private final String directorio = "/opt/subidas/actividades/";
	ServiceActividadesImp sa = new ServiceActividadesImp();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String fechainicio = request.getParameter("fechainicio");
		String fechafin = request.getParameter("fechafin");
		String ubicacion = request.getParameter("ubicacion");
		String numparticipantes = request.getParameter("participantes");
		String precio = request.getParameter("precio");
		Part imagen = request.getPart("imagen");
		String puntos = request.getParameter("puntos");
		Date date1 = null;
		Date date2 = null;
		InputStream imagenStream = null;
		String imagenName = "";
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd(hh:mm:ss)");
		String hoy = dt.format(new Date());

		try {
			date1 = formatter.parse(fechainicio);
			date2 = formatter.parse(fechafin);

		} catch (ParseException e) {
			System.out.println("Fallo al convertir fechas. " + e.getMessage());
		}
		try {

			imagenName = hoy + "-" + Paths.get(imagen.getSubmittedFileName()).getFileName().toString();

			imagenStream = imagen.getInputStream();

			File imagenSalida = new File(directorio + imagenName);

			FileUtils.copyInputStreamToFile(imagenStream, imagenSalida);

		} catch (Exception e) {
			System.out.println("Fallo al gestionar ficheros. " + e.getMessage());
		} finally {
			imagenStream.close();
		}

		Actividad a = new Actividad(nombre, date1, date2, ubicacion, Integer.parseInt(numparticipantes),
				Float.parseFloat(precio), imagenName, Integer.parseInt(puntos));

		sa.insertar(a);

		response.sendRedirect("MostrarAdmin.do?div=actividades");
	}
}
