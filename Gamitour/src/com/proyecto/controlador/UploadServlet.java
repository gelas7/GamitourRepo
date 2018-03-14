package com.proyecto.controlador;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private final String UPLOAD_DIRECTORY1 = "/opt/subidas/";
	@SuppressWarnings("unused")
	private final String UPLOAD_DIRECTORY2 = "/User/Gelas/Desktop/";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
			for (FileItem item : multiparts) {
				if (!item.isFormField()) {
					item.write(new File(UPLOAD_DIRECTORY1 + File.separator + item.getName()));
				}
			}

		} catch (Exception ex) {
			System.out.println("Error al manejar los ficheros.");
		}

		request.getRequestDispatcher("errores/end.jsp").forward(request, response);
	}
}
