<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Panel de Administración</title>

<link href="assets/css/style.css" rel="stylesheet" type="text/css" media="screen" />
<script src="assets/css/script.js"></script>
<script src="assets/css/jquery-3.3.1.js" type="text/javascript"></script>
<script src="assets/css/jquery.tablesorter.min.js" type="text/javascript"></script>
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
			<div class="logo">
				<h1>
					<a href="MostrarAdmin.do">Panel de Administracion Gamitour</a>
				</h1>
			</div>
			<div class="contenedor">

				<h1>Listado de Multimedias en ${nombrePruebaDeportiva}</h1>
				<a class="insertar" href="Procesos/Insertar/InsertarMultimedias.jsp"><i
					class="fas fa-plus-circle"></i> Añadir nuevo</a>
				<table id="tmultimedias" class="tablesorter">
					<thead>
						<tr>
							<th>Cliente <i id="icono" class="fas fa-sort"></i></th>
							<th>Fecha <i id="icono" class="fas fa-sort"></i></th>
							<th>Comentario <i id="icono" class="fas fa-sort"></i></th>
							<th>Imagen <i id="icono" class="fas fa-sort"></i></th>
							<th>Video <i id="icono" class="fas fa-sort"></i></th>
							<th>Puntos <i id="icono" class="fas fa-sort"></i></th>
							<th>ID Prueba Deportiva <i id="icono" class="fas fa-sort"></i></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listaMultimedias}" var="m">
							<tr>
								<td>${m.cliente.getNombre()}</td>
								<td>${m.fecha}</td>
								<td>${m.comentario}</td>
								<td>${m.imagen}</td>
								<td>${m.video}</td>
								<td>${m.puntosacumulados}</td>
								<td>${m.pruebaDeportivaIdpruebadeportiva}</td>

								<td><a class="eliminar"
									onclick="return confirm('¿Está seguro de que quiere continuar?')"
									href="EliminarMultimedias.do?id=${m.idmultimedia}"><i
										class="fas fa-trash-alt"></i></a></td>
								<td><a class="actualizar"
									href="Procesos/Modificar/ModificarMultimedias.jsp?id=${m.idmultimedia}"><i
										class="fas fa-edit"></i> </a></td>
								<td><a class="mostrar"
									href="MostrarComentarios.do?id=${m.idmultimedia}">Comentarios</a></td>
								<td><a class="mostrar"
									href="MostrarVotos.do?id=${m.idmultimedia}">Votos</a></td>
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






