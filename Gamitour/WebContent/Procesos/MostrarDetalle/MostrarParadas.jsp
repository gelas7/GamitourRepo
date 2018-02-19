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
<script defer
	src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
</head>

<body>

	<div class="menu">
		<ul>
			<li><a href="MostrarAdmin.do?div=actividades">Actividades</a></li>
			<li><a href="MostrarAdmin.do?div=clientes">Clientes</a></li>
			<li><a href="MostrarAdmin.do?div=itinerarios">Itinerarios</a></li>
			<li><a href="MostrarAdmin.do?div=noticias">Noticias</a></li>
			<li><a href="MostrarAdmin.do?div=paradas">Paradas</a></li>
			<li><a href="MostrarAdmin.do?div=premios">Premios</a></li>
			<li><a href="MostrarAdmin.do?div=votos">Votos</a></li>
			<li><a href="MostrarAdmin.do?div=multimedias">Multimedia</a></li>
			<li><a href="MostrarAdmin.do?div=pruebasculturales">PC</a></li>
			<li><a href="MostrarAdmin.do?div=pruebasdeportivas">PD</a></li>
			<li><a href="MostrarAdmin.do?div=comentarios">Comentarios</a></li>
		</ul>
	</div>
	<hr />

	<div class="page">

		<div class="logo">
			<h1>
				<a href="MostrarAdmin.do">Panel de Administracion Gamitour</a>
			</h1>
		</div>
		
		<div class="contenedor">

			<h1>Listado de Paradas en ${nombreItinerario}</h1>
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
						<td><a class="eliminar"
							onclick="return confirm('¿Está seguro de que quiere continuar?')"
							href="EliminarParadas.do?id=${parada.idparada}"><i
								class="fas fa-trash-alt"></i></a></td>
						<td><a class="actualizar"
							href="Procesos/Modificar/ModificarParadas.jsp?id=${parada.idparada}"><i
								class="fas fa-edit"></i> </a></td>
					</tr>
				</c:forEach>
			</table>
			<a class="insertar" href="Procesos/Insertar/InsertarParadas.jsp">Insertar
				una parada nueva</a>
		</div>
	</div>

	<div id="footer"></div>
</body>
</html>






