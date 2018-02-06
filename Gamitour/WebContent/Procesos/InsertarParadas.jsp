<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.proyecto.service.*"%>
<%@ page import="com.proyecto.modelo.*"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Panel Admin</title>
<link href="../style.css" rel="stylesheet" type="text/css"
	media="screen" />
</head>

<body>
	<div id="logo">
		<h1>
			<a href="../MostrarAdmin.do">Panel de administración Gamitour</a>
		</h1>

	</div>
	<div id="menu">
		<ul>
			<li><a href="../MostrarAdmin.do?div=actividades">Actividades</a></li>
			<li><a href="../MostrarAdmin.do?div=clientes">Clientes</a></li>
			<li><a href="../MostrarAdmin.do?div=itinerarios">Itinerarios</a></li>
			<li><a href="../MostrarAdmin.do?div=noticias">Noticias</a></li>
			<li><a href="../MostrarAdmin.do?div=paradas">Paradas</a></li>
			<li><a href="../MostrarAdmin.do?div=premios">Premios</a></li>
			<li><a href="../MostrarAdmin.do?div=roles">Roles</a></li>
			<li><a href="../MostrarAdmin.do?div=votos">Votos</a></li>
			<li><a href="../MostrarAdmin.do?div=multimedias">Multimedia</a></li>
			<li><a href="../MostrarAdmin.do?div=pruebasculturales">PC</a></li>
			<li><a href="../MostrarAdmin.do?div=pruebasdeportivas">PD</a></li>
			<li><a href="../MostrarAdmin.do?div=comentarios">Comentarios</a></li>
		</ul>
	</div>
	<hr />

	<div class="page">


		<form action="../InsertarParadas.do" method="get">
			<h2>Insertar Parada</h2>
			<p>
				Nombre: <input type="text" name="nombre" required="required">
			</p>
			<p>
				Numero de parada: <input type="number" name="numeroParada"
					required="required">
			</p>
			<p>
				Ubicación: <input type="text" name="ubicacion" required="required">
			</p>
			<p>
				Historia: <input type="text" name="historia" required="required">
			</p>
			<p>
				Anecdotario: <input type="text" name="anecdotario"
					required="required">
			</p>
			<p>
				Gastronomia: <input type="text" name="gastronomia"
					required="required">
			</p>
			<p>
				Itinerario: <select name="itinerario">
					<c:forEach items="${listaItinerarios}" var="itinerario">
						<option value="${itinerario.iditinerario}">${itinerario.nombre}</option>
					</c:forEach>
				</select>
			</p>

			<p>
				Imagen: <input type="file" name="imagen"
					onchange="handleFiles(this.files)" required="required">
			</p>
			<p>
				<input type="submit" value="Enviar" id="enviar">
			</p>
		</form>
	</div>

</body>
</html>