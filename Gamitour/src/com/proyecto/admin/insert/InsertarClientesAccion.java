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
import com.proyecto.modelo.Rol;
import com.proyecto.service.ServiceClientesImp;
import com.proyecto.service.ServiceRolesImp;

@javax.servlet.annotation.MultipartConfig
@WebServlet("/InsertarClientesAccion")
public class InsertarClientesAccion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	private final String directorio = "/opt/subidas/actividades";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String fechanacimiento = request.getParameter("fechanacimiento");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String telefono = request.getParameter("telefono");
		String direccion = request.getParameter("direccion");
		String codigopostal = request.getParameter("codigopostal");
		String puntosacumulados = request.getParameter("puntosacumulados");
		String rol = request.getParameter("rol");
		Part avatar = request.getPart("avatar");
		Date date1 = null;

		try {
			if (fechanacimiento != "")
				date1 = formatter.parse(fechanacimiento);
		} catch (ParseException e) {
			System.out.println("Fallo al convertir fechas. " + e.getMessage());
		}

		/* Proceso ficheros *///email-archivo.jpg
		String avatarName = email+"-"+Paths.get(avatar.getSubmittedFileName()).getFileName().toString();
		
		InputStream imagenStream = avatar.getInputStream();

		File imagenSalida = new File(directorio + avatarName);

		FileUtils.copyInputStreamToFile(imagenStream, imagenSalida);

		imagenStream.close();
		
		ServiceClientesImp sc = new ServiceClientesImp();
		ServiceRolesImp sr = new ServiceRolesImp();

		Rol r = sr.buscarPorClave(Integer.parseInt(rol));// Creo rol a partir del id

		Cliente c = new Cliente(r, nombre, apellidos, date1, email, password, telefono, direccion, codigopostal, avatarName,
				Integer.parseInt(puntosacumulados), new Date());

		sc.insertar(c); // Inserto cliente

		response.sendRedirect("MostrarAdmin.do?div=clientes");
	}

}
