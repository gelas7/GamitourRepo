<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.proyecto.service.*"%>
<%@ page import="com.proyecto.modelo.*"%>
<%@ page import="java.util.*"%>

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
			<h2>Insertar Multimedia</h2>

			<form action="../../InsertarMultimediasAccion" method="post"
				enctype="multipart/form-data">

				<p>
					<label for="cliente">Cliente:</label> <select name="cliente">
						<option value="" selected disabled>Seleccione un cliente</option>
						<c:forEach items="${listaClientes}" var="cliente">
							<option value="${cliente.idcliente}">${cliente.nombre}</option>
						</c:forEach>
					</select>
				</p>

				<p>
					<label for="comentario">Comentario:</label> <textarea name="comentario" required="required" rows="4" cols="50" maxlength="500"></textarea>
				</p>
				<p>
					<label for="puntos">Puntos Acumulados:</label> <input type="number"
						name="puntos" required="required" max="10000">
				</p>
				<p>
					<label for="pruebaD">Prueba Deportiva: </label> <select
						name="pruebaD">
						<option value="" selected disabled>Seleccione una Prueba Deportiva</option>
						<c:forEach items="${listaPruebasDeportivas}" var="pruebaD">
							<option value="${pruebaD.idpruebadeportiva}">${pruebaD.nombre}</option>
						</c:forEach>
					</select>
				</p>
				<p>
					<label for="imagen">Imagen: </label> <input type="file"
						name="imagen"/><br>
				</p>
				<p>
					<label for="video">Video: </label> <input type="file"
						name="video"/><br /> <br />
				</p>
				<p>
					<input type="submit" value="Enviar" id="enviar">
				</p>
			</form>

		</div>
	</div>
</body>
</html>