<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.proyecto.service.*"%>
<%@ page import="java.util.*"%>
<%!ServiceMultimediasImp sm = new ServiceMultimediasImp();%>

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

	<div id="page">
		<div id="content">
			<div class="post">

				<h2>Modifique los campos que considere oportunos</h2>

				<form action="../ModificarMultimedias.do" method="get">

					<input type="hidden" value="<%=request.getParameter("id")%>"
						name="id">

					<p>
						Cliente: <select name="cliente">
							<option value="">Seleccione un cliente</option>
							<c:forEach items="${listaClientes}" var="cliente">
								<option value="${cliente.idcliente}">${cliente.nombre}</option>
							</c:forEach>
						</select>
					</p>
					<p>
						Fecha: <input type="date" name="fecha">
					</p>
	
					<p>
						Comentario: <input type="text" name="comentario"
							placeholder="<%=sm.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getComentario()%>">
					</p>
					<p>
						Imagen: <input type="text" name="imagen" onchange="handleFiles(this.files)">
					</p>
					<p>
						Video: <input type="text" name="video" onchange="handleFiles(this.files)">
					</p>
					<p>
						Prueba Deportiva: <select name="pruebaD">
							<option value="">Seleccione una Prueba Deportiva</option>
							<c:forEach items="${listaPruebasDeportivas}" var="pruebaD">
								<option value="${pruebaD.idpruebadeportiva}">${pruebaD.nombre}</option>
							</c:forEach>
						</select>
					</p>
					<p>
						Puntos Acumulados: <input type="number" name="puntos"
							placeholder="<%=sm.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getPuntosacumulados()%>">
					</p>
					<p>
						<input type="submit" value="Enviar" id="enviar">
					</p>
				</form>
			</div>
		</div>
	</div>

	<div id="footer"></div>
</body>
</html>