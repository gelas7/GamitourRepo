package com.proyecto.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/FiltroAdmin")
public class FiltroAdmin implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();

		String url = req.getServletPath();
		
		if (url.contains("BuscarAdmin.do")) { //Si no pasa por index
			session.setAttribute("url", "/MostrarAdmin.do");
			chain.doFilter(req, res);
		} else {
			session.setAttribute("url", url); //Guardo la ruta a la que iba
			String email = (String) session.getAttribute("email");//Saco email y rol de sesion
			String rol = (String) session.getAttribute("rol");

			boolean logueado = email != null && rol.equals("administrador");

			if (logueado)
				chain.doFilter(req, res);
			else
				res.sendRedirect(res.encodeRedirectURL("/Gamitour/login.jsp"));

		}
	}

	public void destroy() {
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
