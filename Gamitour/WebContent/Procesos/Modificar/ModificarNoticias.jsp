<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.proyecto.service.*"%>
<%!ServiceNoticiasImp sn = new ServiceNoticiasImp();%>

<!DOCTYPE html>
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

			<form action="../../ModificarNoticias.do" method="get">

				<h2 id="modificar">Modifique los campos necesarios.</h2>
				<h3>Los campos en blanco no sufrirán cambios.</h3>

				<input type="hidden" value="<%=request.getParameter("id")%>"
					name="id">
				<p>
					<label>Nombre: </label><input type="text" name="nombreN" maxlength="50"
						placeholder="<%=sn.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getNombre()%>">
				</p>
				<p>
					<label>Texto: </label><textarea name="texto" required="required" rows="4" cols="50" maxlength="500"
						placeholder="<%=sn.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getTexto()%>"></textarea>
				</p>
				<p>
					<label>Fecha de Alta: </label><input type="date" name="fechaalta"
						placeholder="<%=sn.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getFechaalta()%>">
				</p>
				<p>
					<label>Fecha de Caducidad: </label><input type="date"
						name="fechacaducidad"
						placeholder="<%=sn.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getFechacaducidad()%>">
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