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
		System.out.println(url);

		if (url.contains("BuscarAdmin.do")) {
			chain.doFilter(req, res); // Si esta logueandose
		} else {
			
			sesion.setAttribute("url", url); // Guardo ruta

			String email = (String) req.getSession().getAttribute("email");

			boolean logueado = sesion != null && email != null;

			if (logueado) {
				System.out.println("Adelante");
				chain.doFilter(req, res);
			}

			else {
				System.out.println("Usuario no logueado");
				res.sendRedirect("/Gamitour/login.jsp");
			}
		}
	}

	public FiltroAdmin() {
	}

	public void destroy() {
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
