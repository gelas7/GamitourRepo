package com.proyecto.admin.update;

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
@WebServlet("/ModificarClientesAccion")
public class ModificarClientesAccion extends HttpServlet {

	private static final long serialVersionUID = 1L;
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	private final String directorio = "/opt/subidas/clientes/";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
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

		ServiceClientesImp sc = new ServiceClientesImp();
		ServiceRolesImp sr = new ServiceRolesImp();

		Cliente c = sc.buscarPorClave(Integer.parseInt(id));

		if (nombre != "")
			c.setNombre(nombre);
		if (apellidos != "")
			c.setApellidos(apellidos);
		if (date1 != null)
			c.setFechanacimiento(date1);
		if (email != "")
			c.setEmail(email);
		if (password != "")
			c.setPassword(password);
		if (telefono != "")
			c.setTelefono(telefono);
		if (direccion != "")
			c.setDireccion(direccion);
		if (codigopostal != "")
			c.setCodigopostal(codigopostal);
		if (puntosacumulados != "")
			c.setPuntosacumulados(Integer.parseInt(puntosacumulados));
		if (rol != "") {
			Rol r = sr.buscarPorClave(Integer.parseInt(rol));
			c.setRol(r);
		}
		if (avatar != null){
			/* (idCliente-fecha-nombreFichero.jpg) */
			String avatarName = c.getIdcliente() + "-" + new Date() + "-" 
			+ Paths.get(avatar.getSubmittedFileName()).getFileName().toString();

			InputStream imagenStream = avatar.getInputStream();
			File imagenSalida = new File(directorio + avatarName);
			FileUtils.copyInputStreamToFile(imagenStream, imagenSalida);

			imagenStream.close();
			c.setAvatar(avatarName);
		}

		sc.actualizar(c);

		response.sendRedirect("MostrarAdmin.do?div=clientes");
	}

}