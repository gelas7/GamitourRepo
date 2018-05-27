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

</head>

<body>

	<div class="cabecera">
		<ul class="menu">
			<li><a href="#"><i class="material-icons">home</i><span>INICIO</span></a></li>
			<li><a href="/Gamitour/MostrarPublico.cl?id=rutas"><i
					class="material-icons">map</i><span>RUTAS</span></a></li>
            <li><a href="/Gamitour/MostrarPublico.cl?id=actividades"><i class="material-icons">directions_run</i><span>ACTIVIDADES</span></a></li>
			<li class="dropdown"><a href="#" class="dropbtn"><i class="material-icons">person</i><span>MI CUENTA</span></a>
				<div class="dropdown-content">
					<a href="/Gamitour/MostrarPublico.cl?id=usuario"><i class="material-icons">build</i><span>Mis reservas</span></a>
					<a href="/Gamitour/Logout"><i class="material-icons">exit_to_app</i><span>Logout</span></a>
				</div>	
			</li>

		</ul>
	</div>


	<video id="bgvid" playsinline autoplay muted loop>
		<source poster="poster="
			https://s3-us-west-2.amazonaws.com/s.cdpn.io/4273/polina.jpg" src="/Gamitour/assetsCliente/video/v.mp4"
			type="video/mp4">
	</video>

	<div class="pestanaInicio">

		<h1>Bienvenido a Gamiastur</h1>


		<p>Tu guía turístico en Asturias</p>

		<p>
			<button>
				<i class="material-icons" style="font-size: 48px;">public</i>
			</button>
		</p>


	</div>


</body>

</html>