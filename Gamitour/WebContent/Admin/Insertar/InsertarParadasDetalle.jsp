<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.proyecto.service.*"%>
<%@ page import="com.proyecto.modelo.*"%>
<%@ page import="java.util.*"%>
<%!ServiceItinerariosImp si = new ServiceItinerariosImp();%>


<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Panel Admin</title>

<link href="../../assets/css/style.css" rel="stylesheet" type="text/css"
	media="screen" />
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBxkNckJSuxei2lvWHtvjcT2iCaFaLFv7U&callback=initMap"></script>
<script type="text/javascript" src="../../assets/js/scriptMaps.js"></script>

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
			<div id="formMapa">
				<form action="../../InsertarParadasAccion" method="post"
					enctype="multipart/form-data">
					<h2>
						Insertar Parada en
						<%=si.buscarPorClave(Integer.parseInt(request.getParameter("idItinerario"))).getNombre()%></h2>
					<p>
						<label>Nombre: </label><input type="text" name="nombre" required="required" maxlength="500">
					</p>
					<p>
						<label>Numero de parada: </label><input type="number" name="numeroParada"
							required="required" max="1000">
					</p>

					<p>
						<label>Historia: </label><textarea name="historia" required="required" rows="4" cols="50"  maxlength="500"></textarea>
					</p>
					<p>
						<label>Anecdotario: </label><textarea name="anecdotario" required="required" rows="4" cols="50" maxlength="500"></textarea>
					</p>
					<p>
						<label>Gastronomia: </label><textarea name="gastronomia" required="required" rows="4" cols="50" maxlength="500"></textarea>
					</p>

					<input type="text" name="itinerario"
						value="<%=request.getParameter("idItinerario")%>" hidden="hidden">

					<p>
						<label>Imagen: </label><input type="file" name="imagen"
							required="required">
					</p>
					
					<p>
						<label>Video: </label><input type="file" name="video"
							required="required">
					</p>
					
					<p>
						<label>Ubicación: </label><input type="text" id="search" name="ubicacion"
							required="required" maxlength="500">

						<button type="button" id="btnOK">Obtener coordenadas</button>
					</p>
					<p>
						<label>Latitud: </label><input type="text" id="lat" name="latitud" readonly>
					</p>
					<p>
						<label>Longitud: </label><input type="text" id="lng" name="longitud" readonly>
					</p>
					<p>
						<input type="submit" value="Enviar" id="enviar">
					</p>

				</form>
				<div id="map" class="map" style="width: 400px; height: 400px;"></div>
			</div>
		</div>

	</div>
</body>
</html>