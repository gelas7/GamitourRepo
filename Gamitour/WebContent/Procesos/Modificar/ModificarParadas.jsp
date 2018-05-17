<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.proyecto.service.*"%>
<%@ page import="java.util.*"%>
<%!ServiceParadasImp sp = new ServiceParadasImp();%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Panel Admin</title>
<link href="../../assets/css/style.css" rel="stylesheet" type="text/css"
	media="screen" />
<script type="text/javascript" src="../../assets/js/scriptMaps.js"></script>
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBxkNckJSuxei2lvWHtvjcT2iCaFaLFv7U&callback=initMap"></script>

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
			</ul>
		</div>
		<div class="page">
			<div class="logo">
				<h1>
					<a href="../../MostrarAdmin.do">Panel de administración
						Gamitour</a>
				</h1>
			</div>

			<form action="../../ModificarParadas.do" method="get">

				<h2 id="modificar">Modifique los campos necesarios.</h2>
				<h3>Los campos en blanco no sufrirán cambios.</h3>

				<input type="hidden" value="<%=request.getParameter("id")%>"
					name="id">

				<p>
					<label>Nombre: </label><input type="text" name="nombre" maxlength="50"
						placeholder="<%=sp.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getNombre()%>">
				</p>
				<p>
					<label>Numero de parada: </label><input type="number"
						name="numeroParada" max="1000"
						placeholder="<%=sp.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getNumeroParada()%>">
				</p>
				<p>
					<label>Ubicación: </label><input type="text" name="ubicacion"
						id="search" maxlength="50"
						placeholder="<%=sp.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getUbicacion()%>">
					<button type="button" id="btnOK">Obtener coordenadas</button>
				</p>
				<p>
					<label>Latitud: </label><input type="text" id="lat" name="latitud"
						readonly placeholder="<%=sp.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getLatitud()%>">
				</p>
				<p>
					<label>Longitud: </label><input type="text" id="lng"
						name="longitud" readonly placeholder="<%=sp.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getLongitud()%>">
				</p>
				<p>
					<label>Historia: </label> <textarea name="historia"  rows="4" cols="50" maxlength="500"
						placeholder="<%=sp.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getHistoria()%>"></textarea>
				</p>
				<p>
					<label>Anecdotario: </label><textarea name="anecdotario" rows="4" cols="50" maxlength="500"
						placeholder="<%=sp.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getAnecdotario()%>"></textarea>
				</p>
				<p>
					<label>Gastronomia: </label><textarea name="gastronomia" rows="4" cols="50" maxlength="500"
						placeholder="<%=sp.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getGastronomia()%>"></textarea>
				</p>
				<p>
					<label>Itinerario: </label><select name="itinerario">
						<option value=""  selected disabled>Seleccione un itinerario</option>
						<c:forEach items="${listaItinerarios}" var="itinerario">
							<option value="${itinerario.iditinerario}">${itinerario.nombre}</option>
						</c:forEach>
					</select>
				</p>
				<p>
					<input type="submit" value="Enviar" id="enviar">
				</p>

			</form>
			<div id="map" class="map" style="width: 400px; height: 400px;"></div>
		</div>
	</div>
	<div id="footer"></div>
</body>
</html>