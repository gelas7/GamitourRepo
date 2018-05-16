<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.proyecto.service.*"%>
<%@ page import="java.util.*"%>
<%!ServiceMultimediasImp sm = new ServiceMultimediasImp();%>

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

			<form action="../../ModificarMultimediasAccion" method="post"
				enctype="multipart/form-data">

				<h2 id="modificar">Modifique los campos necesarios.</h2>
				<h3>Los campos en blanco no sufrirán cambios.</h3>

				<input type="hidden" value="<%=request.getParameter("id")%>"
					name="id">

				<p>
					<label> Cliente: </label> <select name="cliente">
						<option value="">Seleccione un cliente</option>
						<c:forEach items="${listaClientes}" var="cliente">
							<option value="${cliente.idcliente}">${cliente.nombre}</option>
						</c:forEach>
					</select>
				</p>

				<p>
					<label>Comentario: </label> <textarea name="comentario" required="required" rows="4" cols="50" maxlength="500"
						placeholder="<%=sm.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getComentario()%>"></textarea>
				</p>
				<p>
					<label> Puntos Acumulados: </label><input type="number" max="100000"
						name="puntos"
						placeholder="<%=sm.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getPuntosacumulados()%>">
				</p>
				<p>
					<label> Prueba Deportiva: </label><select name="pruebaD">
						<option value="">Seleccione una Prueba Deportiva</option>
						<c:forEach items="${listaPruebasDeportivas}" var="pruebaD">
							<option value="${pruebaD.idpruebadeportiva}">${pruebaD.nombre}</option>
						</c:forEach>
					</select>
				</p>
				<p>
					<label> Imagen: </label><input type="file" name="imagen">
				</p>
				<p>
					<label>Video: </label><input type="file" name="video">
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