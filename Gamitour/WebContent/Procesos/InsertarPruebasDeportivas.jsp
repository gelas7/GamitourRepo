<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.proyecto.service.*"%>
<%@ page import="com.proyecto.modelo.*"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Inserción Prueba Deportiva</title>
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
	</div>
	<hr />

	<div id="page">

		<p>Insertar Prueba Deportiva</p>

		<form action="../InsertarPruebasDeportivas.do" method="get">
			<p>
				Nombre: <input type="text" name="nombre" required="required">
			</p>
			<p>
				Fecha de Inicio: <input type="date" name="fechaInicio"
					required="required">
			</p>
			<p>
				Fecha de Fin: <input type="date" name="fechaFin" required="required">
			</p>
			<p>
				Explicación: <input type="text" name="explicacion"
					required="required">
			</p>
			<p>
				Puntos: <input type="number" name="puntos" required="required">
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
</body>
</html>