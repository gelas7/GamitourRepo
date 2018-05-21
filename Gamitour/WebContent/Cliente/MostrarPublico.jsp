<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Zona Pública</title>

<link rel='stylesheet' href='Cliente/estilo/cssRutas.css' />
<link href="https://fonts.googleapis.com/css?family=Amatic+SC|Cuprum|Francois+One|Shadows+Into+Light" rel="stylesheet">
<script src="Cliente/js/scriptItinerarios.js" type="text/javascript"></script>
<script defer src="https://use.fontawesome.com/releases/v5.0.1/js/all.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBxkNckJSuxei2lvWHtvjcT2iCaFaLFv7U"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>

<body>

	<div class="cabecera">
		<ul>
			<li><a href="Cliente/inicio.html"><i class="material-icons"
					style="font-size: 35px;">home</i>
					<p>INICIO</p></a></li>
			<li><a href="#"><i class="material-icons"
					style="font-size: 35px;">map</i>
					<p>RUTAS</p></a></li>
			<li><a href="#"><i class="material-icons"
					style="font-size: 35px;">speaker_notes</i>
					<p>COMENTARIOS</p></a></li>
			<li><a href="#"><i class="material-icons"
					style="font-size: 35px;">movie</i>
					<p>MULTIMEDIA</p></a></li>
		</ul>
	</div>

	<div id="contenido">

		<input type="hidden" id="listaItinerarios" value='${listaItinerarios}' />

		<div id="itinerarios">
			<div id="contenedorItinerarios"></div>
		</div>
		
		<div id="paradas">
			<div id="contenedorParadas"></div>
		</div>
	</div>

</body>
</html>
