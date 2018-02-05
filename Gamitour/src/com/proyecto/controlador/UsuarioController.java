package com.proyecto.controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.proyecto.util.Accion;

@WebServlet("/UsuarioController")
public class UsuarioController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public UsuarioController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher despachador = null;
		Accion accion = null;

		// Recuperamos la parte de la url de la peticion que llama a un servlet
		// inclyendo el caracter '/'.
		String url = request.getServletPath();

		// El método getAccion devuelve la instancia de un objeto correspondiente con
		// la
		// accion que ha elegido el usuario.
		// Le quitamos el .do
		accion = Accion.getAccion(url.substring(1, url.length() - 3));

		// Realizamos el metodo ejecutar de la accion escogida por el usuario
		despachador = request.getRequestDispatcher(accion.ejecutar(request, response));

		// Transferimos el control a la url que decide el metodo ejecutar
		despachador.forward(request, response);
	}
}