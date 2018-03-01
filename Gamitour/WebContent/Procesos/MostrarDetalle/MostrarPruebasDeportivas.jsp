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

				<h1>Listado de Pruebas Deportivas en ${nombreParada}</h1>
				<a class="insertar"
					href="Procesos/Insertar/InsertarPruebasDeportivas.jsp"><i
					class="fas fa-plus-circle"></i> Añadir nuevo</a>
				<p>
					<label for="searchtcomentarios"><i class="fas fa-search"></i></label>
					<input type="text" id="searchtcomentarios" value="" />
				</p>
				<table id="tpruebasdeportivas" class="tablesorter">
					<thead>
						<tr>
							<th>Nombre <i id="icono" class="fas fa-sort"></i></th>
							<th>Inicio <i id="icono" class="fas fa-sort"></i></th>
							<th>Fin <i id="icono" class="fas fa-sort"></i></th>
							<th>Explicación <i id="icono" class="fas fa-sort"></i></th>
							<th>Puntos <i id="icono" class="fas fa-sort"></i></th>
							<th>Parada <i id="icono" class="fas fa-sort"></i></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listaPruebasDeportivas}" var="pD">
							<tr>
								<td>${pD.nombre}</td>
								<td>${pD.fechainicio}</td>
								<td>${pD.fechafin}</td>
								<td>${pD.explicacion}</td>
								<td>${pD.puntos}</td>
								<td>${pD.parada.getNombre()}</td>
								<td><a class="eliminar"
									onclick="return confirm('¿Está seguro de que quiere continuar?')"
									href="EliminarPruebasDeportivas.do?id=${pD.idpruebadeportiva}"><i
										class="fas fa-trash-alt"></i></a></td>
								<td><a class="actualizar"
									href="Procesos/Modificar/ModificarPruebasDeportivas.jsp?id=${pD.idpruebadeportiva}"><i
										class="fas fa-edit"></i> </a></td>
								<td><a class="mostrar"
									href="MostrarMultimedias.do?id=${pD.idpruebadeportiva}">Multimedia</a></td>
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