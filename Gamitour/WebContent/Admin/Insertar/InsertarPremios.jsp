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
<title>Panel Admin</title>
<link href="../../assets/css/style.css" rel="stylesheet" type="text/css"
	media="screen" />
</head>

<body>
	<div class="flex">

		<div class="menu">
			<ul>
				<li><a href="../../MostrarAdmin.do?div=itinerarios">Itinerarios</a></li>
				<li><a href="../../MostrarAdmin.do?div=paradas">Paradas</a></li>
				<li><a href="../../MostrarAdmin.do?div=pruebasculturales">PC</a></li>
				<li><a href="../../MostrarAdmin.do?div=pruebasdeportivas">PD</a></li>
				<li><a href="../../MostrarAdmin.do?div=multimedias">Multimedia</a></li>
				<li><a href="../../MostrarAdmin.do?div=actividades">Actividades</a></li>
				<li><a href="../../MostrarAdmin.do?div=clientes">Clientes</a></li>
				<li><a href="../../MostrarAdmin.do?div=noticias">Noticias</a></li>
				<li><a href="../../MostrarAdmin.do?div=premios">Premios</a></li>
				<li><a href="../../MostrarAdmin.do?div=votos">Votos</a></li>
				<li><a href="../../MostrarAdmin.do?div=comentarios">Comentarios</a></li>
				<li><a href="../../MostrarAdmin.do?div=reservas">Reservas</a></li>
			</ul>
		</div>

		<div class="page">
			<div class="logo">
				<h1>
					<a href="../../MostrarAdmin.do">Panel de administración
						Gamitour</a>
				</h1>
			</div>

			<form action="../../InsertarPremiosAccion" method="post"
				enctype="multipart/form-data">
				<h2>Insertar Premio</h2>
				<p>
					<label>Nombre: </label><input type="text" name="nombre"
						required="required" maxlength="50">
				</p>
				<p>
					<label>Descripcion: </label>
					<textarea name="descripcion" required="required" rows="4" cols="50"
						maxlength="500"></textarea>
				</p>
				<p>
					<label>Ubicación: </label><input type="text" name="ubicacion"
						required="required" maxlength="500">
				</p>
				<p>
					<label>Puntos: </label><input type="number" name="puntos"
						required="required" max="10000">
				</p>
				<p>
					<label>Imagen: </label><input type="file" name="imagen"
						required="required">
				</p>
				<p>
					<label>Fecha de activacion: </label><input type="date"
						name="fechaactivacion" required="required">
				</p>
				<p>
					<label>Fecha de consumo: </label><input type="date"
						name="fechaconsumo" required="required">
				</p>
				<p>
					<input type="submit" value="Enviar" id="enviar">
				</p>
			</form>
		</div>
	</div>
</body>
</html>