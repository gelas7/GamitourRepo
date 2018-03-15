package com.proyecto.controlador;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private final String UPLOAD_DIRECTORY1 = "/opt/subidas/";
	@SuppressWarnings("unused")
	private final String UPLOAD_DIRECTORY2 = "/Users/Gelas/Desktop/subidas";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

		if (isMultipart) {
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);

			try {
				List<FileItem> items = upload.parseRequest(request);
				Iterator<FileItem>  iterator = items.iterator();
				while (iterator.hasNext()) {
					FileItem item = (FileItem) iterator.next();

					if (!item.isFormField()) {
						File uploadedFile = new File(UPLOAD_DIRECTORY2 + "/" + item.getName());
						System.out.println(uploadedFile.getAbsolutePath());
						item.write(uploadedFile);
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		request.getRequestDispatcher("errores/end.jsp").forward(request, response);
	}
}
