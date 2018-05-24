package com.proyecto.publico.insert;

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
@WebServlet("/RegistrarClientesAccion")
public class RegistrarClientesAccion extends HttpServlet {

	private static final long serialVersionUID = 1L;
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	private final String directorio = "/opt/tomcat/webapps/subidas/clientes/";
	ServiceClientesImp sc = new ServiceClientesImp();
	ServiceRolesImp sr = new ServiceRolesImp();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String fechanacimiento = request.getParameter("fechanacimiento");
		String email = request.getParameter("email");
		String password = request.getParameter("password1");
		String telefono = request.getParameter("telefono");
		String direccion = request.getParameter("direccion");
		String codigopostal = request.getParameter("codigopostal");
		Part avatar = request.getPart("avatar");
		Date dateNacimiento = null;
		InputStream imagenStream = null;
		String avatarName = "";
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd(hh:mm:ss)");
		Date fechaHoy = new Date();
		String hoy = dt.format(fechaHoy);

		try {
			if (fechanacimiento != "")
				dateNacimiento = formatter.parse(fechanacimiento);
		} catch (ParseException e) {
			System.out.println("Fallo al convertir fechas. " + e.getMessage());
		}

		try {
			avatarName = hoy + "-" + Paths.get(avatar.getSubmittedFileName()).getFileName().toString();
			imagenStream = avatar.getInputStream();
			File imagenSalida = new File(directorio + avatarName);
			FileUtils.copyInputStreamToFile(imagenStream, imagenSalida);

		} catch (Exception e) {
			System.out.println("Fallo al gestionar ficheros. " + e.getMessage());
		} finally {
			imagenStream.close();
		}
		

		Rol r = sr.buscarPorClave(4); // Recupero el rol registrado

		Cliente c = new Cliente(r, nombre, apellidos, dateNacimiento, email, password, telefono, direccion,
				codigopostal, avatarName, 0, fechaHoy);

		sc.insertar(c); // Inserto cliente

		response.sendRedirect("/Gamitour/Cliente/Login/Register.jsp");
	}

}
