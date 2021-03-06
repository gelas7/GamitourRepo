<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.proyecto.service.*"%>
<%@ page import="java.util.*"%>
<%!ServicePremiosImp sp = new ServicePremiosImp();%>

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

			<form action="../../ModificarPremios.do" method="get" autocomplete="off">

				<h2 id="modificar">Modifique los campos necesarios.</h2>
				<h3>Los campos en blanco no sufrirán cambios.</h3>

				<input type="hidden" value="<%=request.getParameter("id")%>"
					name="id">

				<p>
					<label>Nombre: </label><input type="text" name="nombre" maxlength="500"
						placeholder="<%=sp.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getNombre()%>">
				</p>
				<p>
					<label>Descripcion: </label> <textarea name="descripcion"  rows="4" cols="50" maxlength="500"
						placeholder="<%=sp.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getDescripcion()%>"></textarea>
				</p>
				<p>
					<label>Puntos: </label><input type="number" name="puntos" max="10000"
						placeholder="<%=sp.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getPuntos()%>">
				</p>
				<p>
					<label>Fecha de activacion: </label><input type="date" name="fechaactivacion">
				</p>

				<p>
					<label>Fecha de consumo: </label><input type="date" name="fechaconsumo">
				</p>
<!-- 				<p> -->
<!-- 					<label>Cliente: </label><select name="cliente"> -->
<!-- 						<option selected disabled>Seleccione un cliente</option> -->
<%-- 						<c:forEach items="${listaClientes}" var="cliente"> --%>
<%-- 							<option value="${cliente.idcliente}">${cliente.nombre}</option> --%>
<%-- 						</c:forEach> --%>
<!-- 					</select> -->
<!-- 				</p> -->
				<p>
					<input type="submit" value="Enviar" id="enviar">
				</p>
			</form>
		</div>
	</div>
	<div id="footer"></div>
</body>
</html>