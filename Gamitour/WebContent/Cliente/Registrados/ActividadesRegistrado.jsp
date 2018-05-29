<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>Gamiastur</title>

<link rel='stylesheet'
	href='/Gamitour/assetsCliente/css/cssGenerico.css' />

<script src="/Gamitour/assetsCliente/js/scriptActividades.js"
	type="text/javascript"></script>
<script defer
	src="https://use.fontawesome.com/releases/v5.0.1/js/all.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script>
<link
	href="https://fonts.googleapis.com/css?family=Amatic+SC|Cuprum|Francois+One|Shadows+Into+Light"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
</head>

<body>

	<div class="cabecera">
		<ul class="menu">
			<li><a href="/Gamitour/Cliente/Registrados/indexRegistrado.jsp"><i
					class="material-icons">home</i><span>INICIO</span></a></li>
			<li><a href="/Gamitour/MostrarPublico.cl?id=rutas"><i
					class="material-icons">map</i><span>RUTAS</span></a></li>
			<li><a href="#"><i class="material-icons">directions_run</i><span>ACTIVIDADES</span></a></li>
			<li class="dropdown"><a href="#" class="dropbtn"><i
					class="material-icons">person</i><span>MI CUENTA</span></a>
				<div class="dropdown-content">
					<a href="/Gamitour/MostrarPublico.cl?id=usuario"><i
						class="material-icons">build</i><span>Mis reservas</span></a> <a
						href="/Gamitour/Logout"><i class="material-icons">exit_to_app</i><span>Logout</span></a>
				</div></li>
		</ul>
	</div>

	<div id="contenido">

		<input type="hidden" id="listaActividades" value='${listaActividades}' />

		<div id="actividades">
			<div id="contenedorActividades"></div>
		</div>

		<div id="actividad">
			<div>
				<button class="boton" id="btnActividades">
					<i class="material-icons">arrow_back_ios</i><a>Volver a las
						actividades</a>
				</button>
			</div>
			<div id="infoActividad"></div>
			
		</div>

	</div>

</body>
</html>

