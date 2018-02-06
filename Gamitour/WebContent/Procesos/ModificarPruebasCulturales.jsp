<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.proyecto.service.*"%>
<%!ServicePruebasCulturales spc = new ServicePruebasCulturalesImp();%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gestión de usuarios</title>
<link href="../style.css" rel="stylesheet" type="text/css"
	media="screen" />
</head>
<body>

	<div id="logo">
		<h1>
			<a href="../MostrarAdmin.do">Panel de administracion Gamitour</a>
		</h1>

	</div>
	<div id="menu">
		<nav>
		<ul>
			<li><a href="../MostrarAdmin.do?div=actividades">Actividades</a></li>
			<li><a href="../MostrarAdmin.do?div=clientes">Clientes</a></li>
			<li><a href="../MostrarAdmin.do?div=itinerarios">Itinerarios</a></li>
			<li><a href="../MostrarAdmin.do?div=noticias">Noticias</a></li>
			<li><a href="../MostrarAdmin.do?div=paradas">Paradas</a></li>
			<li><a href="../MostrarAdmin.do?div=premios">Premios</a></li>
			<li><a href="../MostrarAdmin.do?div=roles">Roles</a></li>
			<li><a href="../MostrarAdmin.do?div=votos">Votos</a></li>
			<li><a href="../MostrarAdmin.do?div=multimedias">Multimedia</a></li>
			<li><a href="../MostrarAdmin.do?div=pruebasculturales">PC</a></li>
			<li><a href="../MostrarAdmin.do?div=pruebasdeportivas">PD</a></li>
			<li><a href="../MostrarAdmin.do?div=comentarios">Comentarios</a></li>
		</ul>
		</nav>
	</div>
	<hr />

	<div id="page">
		<div id="content">
			<div class="post">
				<p>Modificando Prueba Cultural</p>

				<form action="../ModificarPruebasCulturales.do" method="get">

					<input type="hidden" value="<%=request.getParameter("id")%>"
						name="id">
					<p>
						Nombre: <input type="text" name="nombre" 
							placeholder="<%=spc.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getNombre()%>">
					</p>
					<p>
						Pregunta: <input type="text" name="pregunta"
							placeholder="<%=spc.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getPregunta()%>">
					</p>
					<p>
						Respuesta: <input type="text" name="respuesta"
							placeholder="<%=spc.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getRespuesta()%>">
					</p>
					<p>
						Puntos: <input type="text" name="puntos"
							placeholder="<%=spc.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getPuntos()%>">
					</p>
					<p>
						Parada: <select name="parada">
							<c:forEach items="${listaParadas}" var="parada">
								<option value="${parada.idparada}">${parada.nombre}</option>
							</c:forEach>
						</select>
					</p>
					<p>
						<input type="submit" value="Enviar" id="enviar">
					</p>
				</form>
			</div>
		</div>
	</div>

	<div id="footer"></div>

</body>
</html>