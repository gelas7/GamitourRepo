<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.proyecto.service.*"%>
<%!ServicePruebasCulturales spc = new ServicePruebasCulturalesImp();%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gestión de usuarios</title>
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

			<form action="../../ModificarPruebasCulturales.do" method="get" autocomplete="off">

				<h2 id="modificar">Modifique los campos necesarios.</h2>
				<h3>Los campos en blanco no sufrirán cambios.</h3>

				<input type="hidden" value="<%=request.getParameter("id")%>"
					name="id">
				<p>
					<label>Nombre: </label><input type="text" name="nombre"
						maxlength="50"
						placeholder="<%=spc.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getNombre()%>">
				</p>
				<p>
					<label>Pregunta: </label>
					<textarea name="pregunta" rows="4" cols="50" maxlength="500"
						placeholder="<%=spc.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getPregunta()%>"></textarea>
				</p>
				<p>
					<label>Respuesta Correcta: </label>
					<textarea name="respuesta" rows="4" cols="50" maxlength="500"
						placeholder="<%=spc.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getRespuesta()%>"></textarea>
				</p>
				<p>
					<label>Respuesta incorrecta 1: </label>
					<textarea name="respuesta2" rows="4" cols="50" maxlength="500"
						placeholder="<%=spc.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getRespuesta2()%>"></textarea>
				</p>
				<p>
					<label>Respuesta incorrecta 2: </label>
					<textarea name="respuesta3" rows="4" cols="50" maxlength="500"
						placeholder="<%=spc.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getRespuesta3()%>"></textarea>
				</p>
				<p>
					<label>Puntos: </label><input type="number" name="puntos"
						max="10000"
						placeholder="<%=spc.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getPuntos()%>">
				</p>
				<p>
					<label>Parada: </label><select name="parada">
						<option selected disabled>Seleccione una parada</option>
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
	<div id="footer"></div>

</body>
</html>