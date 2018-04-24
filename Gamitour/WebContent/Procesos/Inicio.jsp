<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Panel de Administración</title>
<style>
.btn-info {
	background-color: pink;
	border-color: white;
}
</style>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="assets/js/script.js" type="text/javascript"></script>
<script src="assets/js/jquery-3.3.1.js" type="text/javascript"></script>
<script src="assets/js/jquery.tablesorter.min.js" type="text/javascript"></script>
<script src="assets/js/pagination-tda-plugin.js" type="text/javascript"></script>
<script defer
	src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
<link href="assets/css/style.css" rel="stylesheet" type="text/css"
	media="screen" />
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>

<body>
	<div class="flex">
		<div class="menu">

			<button id="divActual" value="${divActual}" hidden="hidden"></button>
		</div>

		<div class="page">


			<div class="logo">
				<h1>
					<a href="MostrarAdmin.do">Panel de administración Gamitour</a>
				</h1>

			</div>
			<div class="contenedor">

				<!-- DIV BIENVENIDA -->

				<div class="tablas" id="divBienvenida">
					<hr></hr>
					<h2>Bienvenido. Seleccione una opción del menu.</h2>


					<div class="row">

						<div class="col-md-3" style="width: 200px;">
							<a href="MostrarAdmin.do?div=actividades"
								class="btn btn-block btn-lg btn-primary"> <i
								class="fa fa-gamepad" id="icone_grande"></i> <br> <br>
								<span class="texto_pequeño"> Actividades</span>
							</a>
						</div>
						<div class="col-md-3" style="width: 200px;">
							<a href="MostrarAdmin.do?div=clientes"
								class="btn btn-block btn-lg btn-primary"> <i
								class="fa fa-user" id="icone_grande"></i> <br> <br> <span
								class="texto_pequeño"> Clientes</span>
							</a>
						</div>
						<div class="col-md-3" style="width: 200px;">
							<a href="MostrarAdmin.do?div=itinerarios"
								class="btn btn-block btn-lg btn-primary"> <i
								class="fa fa-map" id="icone_grande"></i> <br> <br> <span
								class="texto_pequeño"> Itinerarios</span>
							</a>
						</div>
						<div class="col-md-3" style="width: 200px;">
							<a href="MostrarAdmin.do?div=noticias"
								class="btn btn-block btn-lg btn-primary"> <i
								class="fa fa-newspaper" id="icone_grande"></i> <br> <br>
								<span class="texto_pequeño"> Noticias</span>
							</a>
						</div>
					</div>

					<div class="row" style="margin-top: 20px;">

						<div class="col-md-3" style="width: 200px;">
							<a href="MostrarAdmin.do?div=premios"
								class="btn btn-block btn-lg btn-primary"> <i
								class="fa fa-trophy" id="icone_grande"></i> <br> <br>
								<span class="texto_pequeño"> Premios</span>
							</a>
						</div>
						<div class="col-md-3" style="width: 200px;">
							<a href="MostrarAdmin.do?div=votos"
								class="btn btn-block btn-lg btn-primary"> <i
								class="fa fa-paste" id="icone_grande"></i> <br> <br> <span
								class="texto_pequeño"> Votos</span>
							</a>
						</div>
						<div class="col-md-3" style="width: 200px;">
							<a href="MostrarAdmin.do?div=multimedia"
								class="btn btn-block btn-lg btn-primary"> <i
								class="fa fa-video" id="icone_grande"></i> <br> <br> <span
								class="texto_pequeño"> Multimedia</span>
							</a>
						</div>
						<div class="col-md-3" style="width: 200px;">
							<a href="MostrarAdmin.do?div=comentarios"
								class="btn btn-block btn-lg btn-primary"> <i
								class="fa fa-pencil-alt" id="icone_grande"></i> <br> <br>
								<span class="texto_pequeño"> Comentarios</span>
							</a>
						</div>
					</div>


				</div>


			</div>
		</div>
	</div>

	<div id="footer"></div>

</body>
</html>

