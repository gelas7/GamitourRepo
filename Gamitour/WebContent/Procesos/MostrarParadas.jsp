<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Panel de Administración</title>
<link href="style.css" rel="stylesheet" type="text/css" media="screen" />
<script src="script.js"></script>
</head>

<body>
	<div id="logo">
		<h1>
			<a href="MostrarAdmin.do">Panel de Administracion Gamitour</a>
		</h1>
	</div>

	<div id="menu">
		<ul>
			<li><button id="actividades">Actividades</button></li>
			<li><button id="clientes">Clientes</button></li>
			<li><button id="itinerarios">Itinerarios</button></li>
			<li><button id="noticias">Noticias</button></li>
			<li><button id="paradas">Paradas</button></li>
			<li><button id="premios">Premios</button></li>
			<li><button id="roles">Roles</button></li>
			<li><button id="multimedias">Multimedias</button></li>
			<li><button id="comentarios">Comentarios</button></li>
			<li><button id="pruebasdeportivas">PD</button></li>
			<li><button id="pruebasculturales">PC</button></li>
			<li><button id="votos">Votos</button></li>
		</ul>
		<button id="divActual" value="${divActual}" hidden=""></button>

	</div>
	<hr />

	<div id="page">
		<div id="contenedor">

			<h1>Listado de Paradas</h1>
			<table>
				<tr>
					<th>Nombre</th>
					<th>Número</th>
					<th>Ubicación</th>
					<th>Historia</th>
					<th>Anecdotario</th>
					<th>Gastronomia</th>
					<th>Imagen</th>
					<th>Itinerario</th>
				</tr>
				<c:forEach items="${listaParadas}" var="parada">
					<tr>
						<td>${parada.nombre}</td>
						<td>${parada.numeroParada}</td>
						<td>${parada.ubicacion}</td>
						<td>${parada.historia}</td>
						<td>${parada.anecdotario}</td>
						<td>${parada.gastronomia}</td>
						<td>${parada.imagen}</td>
						<td>${parada.itinerario.getNombre()}</td>
						<td><a id="eliminar"
							href="EliminarParadas.do?id=${parada.idparada}">Eliminar</a></td>
						<td><a id="actualizar"
							href="Procesos/ModificarParadas.jsp?id=${parada.idparada}">Modificar</a></td>
					</tr>
				</c:forEach>
			</table>
			<a id="insertar" href="Procesos/InsertarParadas.jsp">Insertar una
				parada nueva</a>
		</div>

	</div>

	<div id="footer"></div>
</body>
</html>






