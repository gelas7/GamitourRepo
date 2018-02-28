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
		HttpSession sesion = req.getSession();

		String url = req.getServletPath();

		System.out.println("Entro al filtro con url destino: " + url);
		String urlsesion = (String) req.getSession().getAttribute("url");

		if (url.contains("BuscarAdmin.do") && urlsesion != null) {
			System.out.println("Acabo de loguearme -> Voy a buscarAdmin");
			chain.doFilter(req, res);
		} else if (url.contains("BuscarAdmin.do") && urlsesion == null) {
			System.out.println("No deberias estar aqui sin url jovencito");
			res.sendRedirect("/Gamitour/index.html");
		} else {
			req.getSession().setAttribute("url", url);
			String email = (String) req.getSession().getAttribute("email");
			System.out.println("Compruebo si hay email en sesion: " + email);
			boolean logueado = sesion != null && email != null;

			if (logueado) {
				System.out.println("Si estas logueado");
				chain.doFilter(req, res);
			} else {
				System.out.println("No estas logueado");
				res.sendRedirect("/Gamitour/login.jsp");
			}
		}
	}

	public void destroy() {
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
