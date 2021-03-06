<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.proyecto.service.*"%>
<%@ page import="com.proyecto.modelo.*"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Inserción Prueba Cultural</title>
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

			<form action="../../InsertarPruebasCulturales.do" method="get">

				<h2>Insertar Prueba Cultural</h2>
				<p>
					<label>Nombre: </label><input type="text" name="nombre"
						required="required" maxlength="50">
				</p>
				<p>
					<label>Pregunta: </label>
					<textarea name="pregunta" required="required" rows="4" cols="50"
						maxlength="500"></textarea>
				</p>
				<p>
					<label>Respuesta correcta: </label>
					<textarea name="respuesta" required="required" rows="4" cols="50"
						maxlength="500"></textarea>
				</p>
				<p>
					<label>Respuesta incorrecta 1: </label>
					<textarea name="respuesta2" required="required" rows="4" cols="50"
						maxlength="500"></textarea>
				</p>
				<p>
					<label>Respuesta incorrecta 2: </label>
					<textarea name="respuesta3" required="required" rows="4" cols="50"
						maxlength="500"></textarea>
				</p>
				<p>
					<label>Puntos: </label><input type="number" name="puntos"
						required="required" max="10000">
				</p>
				<p>
					<label>Parada: </label><select name="parada">
						<option value="" selected disabled>Seleccione una
							parada</option>
						<c:forEach items="${listaParadas}" var="parada">
							<option value="${parada.idparada}">${parada.nombre}</option>
						</c:forEach>
					</select>
				</p>
				<p>
					<input type="submit" value="Enviar" id="enviar">
				</p>

			</form>
		</div>
	</div>
</body>
</html>