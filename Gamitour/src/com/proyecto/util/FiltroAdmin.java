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

		String urlsesion = (String) session.getAttribute("url");

		if (url.contains("BuscarAdmin.do") && urlsesion != null) {
			chain.doFilter(req, res);
		} else if (url.contains("BuscarAdmin.do") && urlsesion == null) { // ESTE ES EL FALLO
			res.sendRedirect(res.encodeRedirectURL("/Gamitour/index.html"));
		} else {
			session.setAttribute("url", url);
			String email = (String) session.getAttribute("email");
			boolean logueado = session != null && email != null;

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
