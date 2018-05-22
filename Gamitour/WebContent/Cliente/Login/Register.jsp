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
<title>Gamiastur</title>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href="../../assetsCliente/css/style.css" rel="stylesheet"
	type="text/css" media="screen" />
</head>

<body>

	<div class="cabecera">
		<ul>
			<li><a href="../index.html"><i class="material-icons"
					style="font-size: 35px;">home</i>INICIO</a></li>
			<li><a href="../../MostrarPublico.cl"><i
					class="material-icons" style="font-size: 35px;">map</i>RUTAS</a></li>
			<li><a href="#"><i class="material-icons"
					style="font-size: 35px;">speaker_notes</i>COMENTARIOS</a></li>
			<li><a href="../Login/Register.jsp"><i class="material-icons"
					style="font-size: 35px;">perm_identity</i>REGISTRO</a></li>
		</ul>
	</div>

	<div class="main">
		<h2>Datos personales: </h2>
		<form action="/Gamitour/RegistrarClientesAccion" method="post"
			enctype="multipart/form-data">

			<p>
				<label for="nombre">Nombre:</label> <input type="text" name="nombre"
					required="required" maxlength="100">
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
				<label for="password">Contraseña:</label> <input type="password"
					name="password" required="required" maxlength="30">
			</p>

			<p>
				<label for="password2">Repita su contraseña:</label> <input
					type="password" name="password2" required="required" maxlength="30">
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
				<label for="avatar">Foto de perfil:</label> <input type="file"
					name="avatar" required="required">
			</p>

			<p>
				<input type="submit" value="Enviar" id="enviar" >
			</p>

		</form>
	</div>
</body>
</html>