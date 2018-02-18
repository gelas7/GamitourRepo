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

	<div id="page">
		<div id="contenedor">

			<h1>Listado de Multimedias en ${nombrePruebaDeportiva} </h1>
				<table>
					<tr>
						<th>Cliente</th>
						<th>Fecha</th>
						<th>Comentario</th>
						<th>Imagen</th>
						<th>Video</th>
						<th>Puntos</th>
						<th>ID Prueba Deportiva</th>
					</tr>
					<c:forEach items="${listaMultimedias}" var="m">
						<tr>
							<td>${m.cliente.getNombre()}</td>
							<td>${m.fecha}</td>
							<td>${m.comentario}</td>
							<td>${m.imagen}</td>
							<td>${m.video}</td>
							<td>${m.puntosacumulados}</td>
							<td>${m.pruebaDeportivaIdpruebadeportiva}</td>

							<td><a class="eliminar" onclick="return confirm('¿Está seguro de que quiere continuar?')"
								href="EliminarMultimedias.do?id=${m.idmultimedia}">Eliminar</a></td>
							<td><a class="actualizar"
								href="Procesos/Modificar/ModificarMultimedias.jsp?id=${m.idmultimedia}">Modificar</a></td>
						</tr>
					</c:forEach>
				</table>
				<a class="insertar" href="Procesos/Insertar/InsertarMultimedias.jsp">Insertar
					una elemento multimedia nuevo</a>
		</div>

	</div>

	<div id="footer"></div>
</body>
</html>






