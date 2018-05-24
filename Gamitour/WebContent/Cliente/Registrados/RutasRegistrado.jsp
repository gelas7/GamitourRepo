<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="es">

<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Gamiastur</title>

<script src="/Gamitour/assetsCliente/js/scriptItinerarios.js"
	type="text/javascript"></script>

<link rel='stylesheet' href='/Gamitour/assetsCliente/css/cssRutas.css' />

<script defer
	src="https://use.fontawesome.com/releases/v5.0.1/js/all.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBxkNckJSuxei2lvWHtvjcT2iCaFaLFv7U"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Amatic+SC|Cuprum|Francois+One|Shadows+Into+Light"
	rel="stylesheet">

</head>

<body>

	<div class="cabecera">
		<ul class="menu">
			<li><a href="Cliente/Registrados/indexRegistrado.jsp"><i class="material-icons"
					style="font-size: 35px;">home</i>INICIO</a></li>
			<li><a href="#"><i class="material-icons"
					style="font-size: 35px;">map</i>RUTAS</a></li>
			<li><a href="#"><i class="material-icons"
					style="font-size: 35px;">speaker_notes</i>ACTIVIDADES</a></li>


			<li class="dropdown">
				<a href="#" class="dropbtn"><i class="material-icons"
					style="font-size: 35px;">person</i>MI CUENTA</a>
				<div class="dropdown-content">
					<a href="#">${email}</a>
					<a href="Logout">Cerrar Sesión</a>
				</div>
			</li>

		</ul>
	</div>


	<div id="contenido">

		<input type="hidden" id="listaItinerarios" value='${listaItinerarios}' />

		<div id="itinerarios">
			<div id="contenedorItinerarios"></div>
		</div>

		<div id="paradas">
			<div id="contenedorParadas"></div>
		</div>
	</div>

</body>
</html>

