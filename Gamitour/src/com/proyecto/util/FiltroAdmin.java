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

		// Convertimos de ServletRequest a HttpServletRequest
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		HttpSession sesion = req.getSession();
		String url = req.getServletPath();

		if (url.contains("BuscarAdmin.do") || url.contains("login.jsp") || url.contains("index.html")) {
			chain.doFilter(req, res);
		} else {

			sesion.setAttribute("url", url); // Guardo ruta

			String email = (String) req.getSession().getAttribute("email");

			email = email.toLowerCase();

			boolean logueado = sesion != null && email != null;

			if (logueado)
				chain.doFilter(req, res);
			else
				res.sendRedirect("/Gamitour/login.jsp");
		}
	}

	public void destroy() {
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
