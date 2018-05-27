<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.proyecto.service.*"%>
<%!ServiceClientesImp sc = new ServiceClientesImp();%>

<!DOCTYPE html>
<html lang="es">

<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Gamiastur</title>

<link rel='stylesheet'
	href='/Gamitour/assetsCliente/css/cssGenerico.css' />

<script src="/Gamitour/assetsCliente/js/scriptUsuario.js"
	type="text/javascript"></script>
<script defer
	src="https://use.fontawesome.com/releases/v5.0.1/js/all.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBxkNckJSuxei2lvWHtvjcT2iCaFaLFv7U"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Amatic+SC|Cuprum|Francois+One|Shadows+Into+Light"
	rel="stylesheet">


</head>

<body>

	<div class="cabecera">
		<ul class="menu">
			<li><a href="/Gamitour/Cliente/Registrados/indexRegistrado.jsp"><i
					class="material-icons">home</i><span>INICIO</span></a></li>
			<li><a href="/Gamitour/MostrarPublico.cl?id=rutas"><i
					class="material-icons">map</i><span>RUTAS</span></a></li>
			<li><a href="/Gamitour/MostrarPublico.cl?id=actividades"><i
					class="material-icons">directions_run</i><span>ACTIVIDADES</span></a></li>
			<li class="dropdown"><a href="#" class="dropbtn"><i
					class="material-icons">person</i><span>MI CUENTA</span></a>
				<div class="dropdown-content">
					<a href="#"><i class="material-icons">build</i><span>Mis
							reservas</span></a> <a href="/Gamitour/Logout"><i class="material-icons">exit_to_app</i><span>Logout</span></a>
				</div></li>
		</ul>
	</div>


	<div id="contenido">

		<div id="reservas">
			<button class="boton" id="btnAjustes">
				<i class="material-icons">build</i><a>Ir a mis ajustes</a>
			</button>
			<div id="contenedorReservas">
				<table id="tclientes" class="tablesorter">
					<thead>
						<tr>
							<th>ACTIVIDAD</th>
							<th>FECHA DE COMPRA</th>
							<th>FECHA DE ACTIVIDAD</th>
							<th>COSTE</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${reservasClienteActual}" var="reserva">
							<tr>
								<td>${reserva.actividad.nombre}</td>
								<td>${reserva.fecha}</td>
								<td>${reserva.actividad.fechainicio}</td>
								<td>${reserva.actividad.precio}€</td>
								<td><a class="eliminar"
									onclick="return confirm('¿Está seguro de que desea cancelar su reserva?')"
									href="EliminarReservasCliente.cl?id=${reserva.idreserva}"><i
										class="fas fa-trash-alt"></i> </a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>


		<div id="ajustes">
			<div>
				<button class="boton" id="btnReservas">
					<i class="material-icons">arrow_back_ios</i><a>Volver a mis
						reservas</a>
				</button>
			</div>
			<div class="contenedorAjustes" id="modificarDatos">
				<form action="/Gamitour/ModificarDatosCliente.cl" method="post">

					<h2>Modifique los campos necesarios.</h2>

					<input type="hidden" value="${cliente.idcliente}" name="id">
					<p>
						<label for="email">E-mail: </label> <input type="text"
							name="email" maxlength="50" placeholder="${cliente.email}">
					</p>
					<p>
						<label for="password1">Contraseña: </label> <input type="password"
							name="password1" id="password1" maxlength="20"> <a
							id="errorPass">Las contraseñas no son iguales</a>
					</p>

					<p>
						<label for="password2">Confirme su contraseña: </label> <input
							type="password" name="password2" id="password2" maxlength="20">
					</p>

					<p class="submit">
						<input type="submit" id="submitReg" value="Enviar"
							class="inputSubmit">
					</p>
				</form>
			</div>
		</div>
	</div>

</body>
</html>

