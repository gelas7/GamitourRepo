<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.proyecto.service.*"%>
<%@ page import="com.proyecto.modelo.*"%>
<%@ page import="java.util.*"%>
<%!ServiceParadasImp sp = new ServiceParadasImp();%>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Inserción Prueba Deportiva</title>
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

			<form action="../../InsertarPruebasDeportivas.do" method="get">

				<h2>
					Insertar Prueba Deportiva en
					<%=sp.buscarPorClave(Integer.parseInt(request.getParameter("idParada"))).getNombre()%></h2>

				<p>
					<label>Nombre: </label><input type="text" name="nombre"
						required="required" maxlength="50">
				</p>
				<p>
					<label>Fecha de Inicio: </label><input type="date"
						name="fechaInicio" required="required">
				</p>
				<p>
					<label>Fecha de Fin: </label><input type="date" name="fechaFin"
						required="required">
				</p>
				<p>
					<label>Explicación: </label> <textarea name="explicacion" required="required" rows="4" cols="50" maxlength="500"></textarea>
				</p>
				<p>
					<label>Puntos: </label><input type="number" name="puntos"
						required="required" max="10000">
				</p>
				<p>
					<input type="text" name="parada"
						value="<%=request.getParameter("idParada")%>" hidden="hidden">
				</p>
				<p>
					<input type="submit" value="Enviar" id="enviar">
				</p>
			</form>
		</div>
	</div>
</body>
</html>