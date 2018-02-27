<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Panel de Administración</title>

<link href="assets/css/style.css" rel="stylesheet" type="text/css"
	media="screen" />
<link
	href="https://fonts.googleapis.com/css?family=Oswald|Ubuntu|Neucha"
	rel="stylesheet">
<script src="assets/js/script.js"></script>
<script src="assets/js/jquery-3.3.1.js" type="text/javascript"></script>
<script src="assets/js/jquery.tablesorter.min.js" type="text/javascript"></script>
<script src="assets/js/pagination-tda-plugin.js" type="text/javascript"></script>

<script defer
	src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
</head>

<body>
	<div class="flex">

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

			<header>
				<ul>
					<li><a><i class="far fa-user"></i> ${email}</a></li>
					<li><a href="Logout"><i class="fas fa-sign-out-alt"></i>
							Cerrar sesión</a></li>
				</ul>
			</header>

			<div class="logo">
				<h1>
					<a href="MostrarAdmin.do">Panel de Administracion Gamitour</a>
				</h1>
			</div>

			<div class="contenedor">

				<h1>Listado de Paradas en ${nombreItinerario}</h1>
				<a class="insertar" href="Procesos/Insertar/InsertarParadas.jsp"><i
					class="fas fa-plus-circle"></i> Añadir nuevo</a>
				<table id="tparadas" class="tablesorter">
					<thead>
						<tr>
							<th>Nombre <i id="icono" class="fas fa-sort"></i></th>
							<th>Número <i id="icono" class="fas fa-sort"></i></th>
							<th>Ubicación <i id="icono" class="fas fa-sort"></i></th>
							<th>Historia <i id="icono" class="fas fa-sort"></i></th>
							<th>Anecdotario <i id="icono" class="fas fa-sort"></i></th>
							<th>Gastronomia <i id="icono" class="fas fa-sort"></i></th>
							<th>Imagen <i id="icono" class="fas fa-sort"></i></th>
							<th>Itinerario <i id="icono" class="fas fa-sort"></i></th>
						</tr>
					</thead>
					<tbody>
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
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div id="footer"></div>
</body>
</html>






