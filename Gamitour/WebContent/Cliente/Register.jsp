<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.proyecto.service.*"%>
<%@ page import="com.proyecto.modelo.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0">

<title>Gamiastur</title>

<link href="/Gamitour/assetsCliente/css/cssRegister.css"
	rel="stylesheet" type="text/css" media="screen" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<script defer
	src="https://use.fontawesome.com/releases/v5.0.1/js/all.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script>
<script src="/Gamitour/assetsCliente/js/scriptRegister.js"></script>
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBxkNckJSuxei2lvWHtvjcT2iCaFaLFv7U"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Amatic+SC|Cuprum|Francois+One|Shadows+Into+Light"
	rel="stylesheet">

<link href="https://fonts.googleapis.com/css?family=Dosis"
	rel="stylesheet">

</head>

<body>

	<div class="cabecera">
		<ul>
			<li><a href="/Gamitour/Cliente/index.html"><i
					class="material-icons">home</i><span>INICIO</span></a></li>
			<li><a href="/Gamitour/MostrarPublico.cl?id=rutas"><i
					class="material-icons">map</i><span>RUTAS</span></a></li>
			<li><a href="/Gamitour/MostrarPublico.cl?id=actividades"><i
					class="material-icons">directions_run</i><span>ACTIVIDADES</span></a></li>
			<li style="background-color:black;"><a style="color:#f4d03f;" href="#"><i class="material-icons">person</i><span>INICIAR
						SESIÓN</span></a></li>
		</ul>
	</div>

	<div class="main">
		<div id="registro" class="registro">
			<h2>Regístrate</h2>
			<form action="/Gamitour/RegistrarClientesAccion" method="post"
				enctype="multipart/form-data" autocomplete="off">

				<p>
					<label for="nombre">Nombre:</label> <input type="text"
						name="nombre" required="required" maxlength="100">
				</p>

				<p>
					<label for="apellidos">Apellidos:</label> <input type="text"
						name="apellidos" required="required" maxlength="200">
				</p>

				<p>
					<label for="fechanacimiento">Fecha de nacimiento:</label> <input
						type="date" name="fechanacimiento" required="required">
				</p>

				<p>
					<label for="email">E-mail:</label> <input type="email" name="email"
						required="required" maxlength="100">
				</p>

				<p>
					<label for="password1">Contraseña:</label> <input type="password"
						name="password1" id="password1" required="required" maxlength="30">
					<a id="errorPass">Las contraseñas no son iguales</a>
				</p>

				<p>
					<label for="password2">Repita su contraseña:</label> <input
						type="password" name="password2" id="password2"
						required="required" maxlength="30">
				</p>

				<p>
					<label for="telefono">Teléfono:</label> <input type="tel"
						name="telefono" required="required" maxlength="10">
				</p>

				<p>
					<label for="direccion">Dirección:</label> <input type="text"
						name="direccion" required="required" maxlength="500">
				</p>

				<p>
					<label for="codigopostal">Código Postal:</label> <input type="text"
						name="codigopostal" required="required" maxlength="5">
				</p>

				<p>
					<input type="file" name="avatar" id="avatar" class="inputFile"
						required="required"> <label for="avatar">Escoge tu
						foto de perfil <i class="fas fa-file-image"></i>
					</label>
				</p>

				<p class="submit">
					<input type="submit" " value="¡Adelante!" class="submitUser">
				</p>

				<h3>
					<a id="regToLog">Si ya tienes una cuenta, incia sesión aquí</a>
				</h3>

			</form>
		</div>
		<div id="login" class="login">
			<h2>Inicia sesión</h2>
			<form action="/Gamitour/BuscarCliente.cl" method="post" autocomplete="off">
				<p>
					<label for="email">E-mail:</label> <input type="email" name="email"
						required="required" maxlength="100">
				</p>

				<p>
					<label for="password">Contraseña:</label> <input type="password"
						name="password" required="required" maxlength="30">
				</p>

				<p class="submit">
					<input type="submit" value="¡Adelante!" class="submitUser">
				</p>

				<h3>
					<a id="logToReg">Si no estás registrado hazlo aquí</a>
				</h3>

			</form>
		</div>
	</div>
</body>
</html>