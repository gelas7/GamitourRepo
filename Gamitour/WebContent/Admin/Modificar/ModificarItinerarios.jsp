<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.proyecto.service.*"%>
<%!ServiceItinerariosImp si = new ServiceItinerariosImp();%>

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

			<form action="../../ModificarItinerarios.do" method="get">

				<h2 id="modificar">Modifique los campos necesarios.</h2>
				<h3>Los campos en blanco no sufrirán cambios.</h3>

				<input type="hidden" value="<%=request.getParameter("id")%>"
					name="id">

				<p>
					<label>Nombre: </label> <input type="text" name="nombreN"
						maxlength="500"
						placeholder="<%=si.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getNombre()%>">
				</p>
				<p>
					<label>Categoria: </label> <input type="text" name="categoria"
						maxlength="500"
						placeholder="<%=si.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getCategoria()%>">
				</p>
				<p>
					<label>Nº de horas: </label><input type="number" name="duracion"
						max="250"
						placeholder="<%=si.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getDuracion()%>">
				</p>
				<p>
					<label for="ubicacion">Ubicacion:</label> <select name="ubicacion">
						<option selected disabled>Seleccione una población</option>
						<option value="Gijón">Gijón</option>
						<option value="Oviedo">Oviedo</option>
						<option value="Avilés">Avilés</option>
						<option value="Siero">Siero</option>
						<option value="Langreo">Langreo</option>
						<option value="Mieres">Mieres</option>
						<option value="Castrillón">Castrillón</option>
						<option value="Villaviciosa">Villaviciosa</option>
						<option value="Llanes">Llanes</option>
					</select>
				</p>
				<p>
					<input type="submit" value="Enviar" id="enviar">
				</p>
			</form>
		</div>
	</div>
</body>
</html>