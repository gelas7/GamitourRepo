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
			<li><a href="MostrarAdmin.do?div=roles">Roles</a></li>
			<li><a href="MostrarAdmin.do?div=votos">Votos</a></li>
			<li><a href="MostrarAdmin.do?div=multimedias">Multimedia</a></li>
			<li><a href="MostrarAdmin.do?div=pruebasculturales">PC</a></li>
			<li><a href="MostrarAdmin.do?div=pruebasdeportivas">PD</a></li>
			<li><a href="MostrarAdmin.do?div=comentarios">Comentarios</a></li>
		</ul>
	</div>

	<div class="page">

		<div class="logo">
			<h1>
				<a href="MostrarAdmin.do">Panel de Administracion Gamitour</a>
			</h1>
		</div>
		<div class="contenedor">

			<h1>Listado de Votos en el multimedia</h1>
			<a class="insertar" href="Procesos/Insertar/InsertarVotos.jsp"><i
				class="fas fa-plus"></i></a>
			<table>
				<tr>
					<th>Cliente</th>
					<th>Multimedia</th>
					<th>Puntos</th>
				</tr>
				<c:forEach items="${listaVotos}" var="v">
					<tr>
						<td>${v.cliente.getNombre()}</td>
						<td>${v.multimedia.getIdmultimedia()}</td>
						<td>${v.puntos}</td>
						<td><a class="eliminar"
							href="EliminarVotos.do?id=${v.idvoto}"
							onclick="return confirm('¿Está seguro de que quiere continuar?')"><i
								class="fas fa-trash-alt"></i></a></td>
						<td><a class="actualizar"
							href="Procesos/Modificar/ModificarVotos.jsp?id=${v.idvoto}"><i
								class="fas fa-edit"></i> </a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

	<div id="footer"></div>
</body>
</html>





