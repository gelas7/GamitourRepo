<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="es">
<head>
<title>Gamiastur</title>

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='stylesheet' href='/Gamitour/assetsCliente/css/cssIndex.css' />
<link
	href="https://fonts.googleapis.com/css?family=Amatic+SC|Cuprum|Francois+One|Shadows+Into+Light"
	rel="stylesheet">
<script defer
	src="https://use.fontawesome.com/releases/v5.0.1/js/all.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<script src="/Gamitour/assetsCliente/js/scriptIndex.js"
	type="text/javascript"></script>

</head>

<body>

	<div class="cabecera">
		<ul class="menu">
			<li style="background-color: black;"><a style="color: white;"
				href="#"><i class="material-icons">home</i><span>INICIO</span></a></li>
			<li><a href="/Gamitour/MostrarPublico.cl?id=rutas"><i
					class="material-icons">map</i><span>RUTAS</span></a></li>
			<li><a href="/Gamitour/MostrarPublico.cl?id=actividades"><i
					class="material-icons">directions_run</i><span>ACTIVIDADES</span></a></li>
			<li class="dropdown"><a
				href="/Gamitour/MostrarPublico.cl?id=usuario" class="dropbtn"><i
					class="material-icons">person</i><span>MI CUENTA</span></a>
				<div class="dropdown-content">
					<a href="/Gamitour/Logout"><i class="material-icons">exit_to_app</i><span>Logout</span></a>
				</div></li>

		</ul>
	</div>

	<input type="hidden" id="listaNoticias" value='${listaNoticias}' />
	
	<div class="pestanaInicio">

		<h1>Bienvenido a Gamiastur</h1>


		<p>Tu guía turístico en Asturias</p>

		<p>
			<button>
				<i class="material-icons" style="font-size: 48px;">public</i>
			</button>
		</p>


	</div>

	<div class="noticias">

		<h1>Tablón de noticias</h1>

		<div id="contenedorNoticias"></div>

	</div>



</body>

</html>