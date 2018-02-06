<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.proyecto.service.*"%>
<%@ page import="java.util.*"%>
<%!ServicePremiosImp sp = new ServicePremiosImp();%>

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
			<li><a href="../MostrarAdmin.do?div=votos">Votos</a></li>
		</ul>
	</div>
	<hr />

	<div id="page">
		<div id="content">
			<div class="post">

				<h2>Modifique los campos que considere oportunos</h2>

				<form action="../ModificarPremios.do" method="get">

					<input type="hidden" value="<%=request.getParameter("id")%>"
						name="id">

					<p>
						Nombre: <input type="text" name="nombre"
							placeholder="<%=sp.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getNombre()%>">
					</p>
					<p>
						Descripcion: <input type="number" name="descripcion"
							placeholder="<%=sp.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getDescripcion()%>">
					</p>
					<p>
						Imagen: <input type="text" name="imagen"
							placeholder="<%=sp.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getImagen()%>">
					</p>
					<p>
						Puntos: <input type="number" name="puntos"
							placeholder="<%=sp.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getPuntos()%>">
					</p>
					<p>
						Fecha de activacion: <input type="date" name="fechaactivacion">
					</p>

					<p>
						Fecha de consumo: <input type="date" name="fechaconsumo">
					</p>
					<p>
						Cliente: <select name="cliente">
							<option value="">Seleccione un cliente</option>
							<c:forEach items="${listaClientes}" var="cliente">
								<option value="${cliente.idcliente}">${cliente.nombre}</option>
							</c:forEach>
						</select>
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