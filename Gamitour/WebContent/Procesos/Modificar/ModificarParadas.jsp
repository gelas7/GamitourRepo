<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.proyecto.service.*"%>
<%@ page import="java.util.*"%>
<%!ServiceParadasImp sp = new ServiceParadasImp();%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Panel Admin</title>
<link href="../../assets/css/style.css" rel="stylesheet" type="text/css"
	media="screen" />
</head>

<body>
	<div class="flex">

		<div class="menu">
			<ul>
				<li><a href="../../MostrarAdmin.do?div=actividades">Actividades</a></li>
				<li><a href="../../MostrarAdmin.do?div=clientes">Clientes</a></li>
				<li><a href="../../MostrarAdmin.do?div=itinerarios">Itinerarios</a></li>
				<li><a href="../../MostrarAdmin.do?div=noticias">Noticias</a></li>
				<li><a href="../../MostrarAdmin.do?div=paradas">Paradas</a></li>
				<li><a href="../../MostrarAdmin.do?div=premios">Premios</a></li>
				<li><a href="../../MostrarAdmin.do?div=votos">Votos</a></li>
				<li><a href="../../MostrarAdmin.do?div=multimedias">Multimedia</a></li>
				<li><a href="../../MostrarAdmin.do?div=pruebasculturales">PC</a></li>
				<li><a href="../../MostrarAdmin.do?div=pruebasdeportivas">PD</a></li>
				<li><a href="../../MostrarAdmin.do?div=comentarios">Comentarios</a></li>
			</ul>
		</div>

		<div class="page">
			<div class="logo">
				<h1>
					<a href="../../MostrarAdmin.do">Panel de administración
						Gamitour</a>
				</h1>
			</div>

			<form action="../../ModificarParadas.do" method="get">

				<h2 id="modificar">Modifique los campos necesarios.</h2>
				<h3>Los campos en blanco no sufrirán cambios.</h3>

				<input type="hidden" value="<%=request.getParameter("id")%>"
					name="id">

				<p>
					Nombre: <input type="text" name="nombre"
						placeholder="<%=sp.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getNombre()%>">
				</p>
				<p>
					Numero de parada: <input type="number" name="numeroParada"
						placeholder="<%=sp.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getNumeroParada()%>">
				</p>
				<p>
					Ubicación: <input type="text" name="ubicacion"
						placeholder="<%=sp.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getUbicacion()%>">
				</p>
				<p>
					Historia: <input type="text" name="historia"
						placeholder="<%=sp.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getHistoria()%>">
				</p>
				<p>
					Anecdotario: <input type="text" name="anecdotario"
						placeholder="<%=sp.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getAnecdotario()%>">
				</p>
				<p>
					Gastronomia: <input type="text" name="gastronomia"
						placeholder="<%=sp.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getGastronomia()%>">
				</p>
				<p>
					Itinerario: <select name="itinerario">
						<option value="">Seleccione un itinerario</option>
						<c:forEach items="${listaItinerarios}" var="itinerario">
							<option value="${itinerario.iditinerario}">${itinerario.nombre}</option>
						</c:forEach>
					</select>
				</p>
				<p>
					Imagen: <input type="file" name="imagen"
						onchange="handleFiles(this.files)">
				</p>
				<p>
					<input type="submit" value="Enviar" id="enviar">
				</p>

			</form>
		</div>
	</div>
	<div id="footer"></div>
</body>
</html>