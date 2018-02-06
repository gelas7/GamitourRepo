<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.proyecto.service.*"%>
<%!ServiceActividades sa = new ServiceActividadesImp();%>

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



		<form action="../ModificarActividades.do" method="get">

			<h2 id="modificar">Modifique los campos que quiera</h2>
			<h3>Los campos en blanco no sufriran cambios</h3>
			
			<input type="hidden" value="<%=request.getParameter("id")%>"
				name="id">
			<p>
				Nombre: <input type="text" name="nombre"
					placeholder="<%=sa.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getNombre()%>">
			</p>
			<p>
				Fecha de inicio: <input type="date" name="fechainicio"
					placeholder="<%=sa.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getFechainicio()%>">
			</p>
			<p>
				Fecha de fin: <input type="date" name="fechafin"
					placeholder="<%=sa.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getFechafin()%>">
			</p>
			<p>
				Ubicacion: <input type="text" name="ubicacion"
					placeholder="<%=sa.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getUbicacion()%>">
			</p>
			<p>
				Número de participantes: <input type="text" name="participantes"
					placeholder="<%=sa.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getNumparticipantes()%>">
			</p>
			<p>
				Precio: <input type="text" name="precio"
					placeholder="<%=sa.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getPrecio()%>">
			</p>
			<p>
				Imagen: <input type="file" name="imagen"
					onchange="handleFiles(this.files)">
			</p>
			<p>
				Puntos: <input type="text" name="puntos"
					placeholder="<%=sa.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getPuntos()%>">
			</p>

			<p>
				<input type="submit" value="Enviar" id="enviar">
			</p>
		</form>
	</div>
	<div id="footer"></div>
</body>
</html>