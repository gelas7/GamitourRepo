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
				<li><a href="../../MostrarAdmin.do?div=actividades">Actividades</a></li>
				<li><a href="../../MostrarAdmin.do?div=clientes">Clientes</a></li>
				<li><a href="../../MostrarAdmin.do?div=itinerarios">Itinerarios</a></li>
				<li><a href="../../MostrarAdmin.do?div=noticias">Noticias</a></li>
				<li><a href="../../MostrarAdmin.do?div=paradas">Paradas</a></li>
				<li><a href="../../MostrarAdmin.do?div=premios">Premios</a></li>
				<li><a href="../../MostrarAdmin.do?div=votos">Votos</a></li>
				<li><a href="../../MostrarAdmin.do?div=multimedias">Multimedia</a></li>
				<li><a href="../../MostrarAdmin.do?div=pruebasculturales">PC</a></li>
				<li><a href="../../MostrarAdmin.do?div=pruebasdeportivas">PD</a></li>
				<li><a href="../../MostrarAdmin.do?div=comentarios">Comentarios</a></li>
			</ul>
		</div>

		<div class="page">
			<div class="logo">
				<h1>
					<a href="../../MostrarAdmin.do">Panel de administración
						Gamitour</a>
				</h1>
			</div>
			<form action="../../InsertarClientesAccion" method="post"
				enctype="multipart/form-data">
				
				<h2>Insertar Cliente</h2>
				<p>
					<label for="nombre">Nombre:</label> <input type="text" name="nombre" required="required" maxlength="50">
				</p>
				<p>
					<label for="apellidos">Apellidos:</label> <input type="text" name="apellidos" required="required" maxlength="50">
				</p>
				<p>
					<label for="fechanacimiento">Fecha de nacimiento:</label> <input type="date" name="fechanacimiento"
						required="required">
				</p>
				<p>
					<label for="email">Email:</label> <input type="email" name="email" required="required" maxlength="50">
				</p>
				<p>
					<label for="password">Password:</label> <input type="password" name="password"
						required="required" maxlength="20">
				</p>
				<p>
					<label for="telefono">Telefono:</label> <input type="tel" name="telefono" required="required" maxlength="10">
				</p>
				<p>
					<label for="direccion">Direccion:</label> <input type="text" name="direccion" required="required" maxlength="50">
				</p>
				<p>
					<label for="codigopostal">Codigo Postal:</label> <input type="text" name="codigopostal"
						required="required" maxlength="5">
				</p>
				<p>
					<label for="puntosacumulados">Puntos Acumulados:</label> <input type="number" name="puntosacumulados"
						required="required" max="100000">
				</p>
				<p>

					<label for="rol">Rol:</label> <select name="rol">
						<c:forEach items="${listaRoles}" var="rol">
							<option value="${rol.idrol}">${rol.nombre}</option>
						</c:forEach>
					</select>
				</p>
				<p>
					<label for="avatar">Avatar:</label> <input type="file" name="avatar" required="required">
				</p>

				<p>
					<input type="submit" value="Enviar" id="enviar">
				</p>

			</form>
		</div>
	</div>
</body>
</html>