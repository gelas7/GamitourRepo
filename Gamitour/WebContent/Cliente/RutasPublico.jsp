<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>Gamiastur</title>

<link rel='stylesheet' href='/Gamitour/assetsCliente/css/cssRutas.css' />

<script src="/Gamitour/assetsCliente/js/scriptItinerarios.js"
	type="text/javascript"></script>
<script defer
	src="https://use.fontawesome.com/releases/v5.0.1/js/all.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script>
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
		<ul>
			<li><a href="/Gamitour/Cliente/index.html"><i
					class="material-icons">home</i><span>INICIO</span></a></li>
			<li><a href="#"><i class="material-icons">map</i><span>RUTAS</span></a></li>
			<li><a href="#"><i class="material-icons">speaker_notes</i><span>ACTIVIDADES</span></a></li>
			<li><a href="/Gamitour/Cliente/Login/Register.jsp"><i
					class="material-icons">person</i><span>INICIAR SESIÓN</span></a></li>
		</ul>
	</div>

	<div id="contenido">

		<input type="hidden" id="listaItinerarios" value='${listaItinerarios}' />
	
		<div id="itinerarios">
			<div id="contenedorItinerarios"></div>
		</div>

		<div id="paradas">
			<div class="volver">
				<button id="volver">
					<i class="material-icons">map</i><a>Volver a las rutas</a>
				</button>
			</div>
			<div id="contenedorParadas"></div>
		</div>
	</div>

</body>
</html>

