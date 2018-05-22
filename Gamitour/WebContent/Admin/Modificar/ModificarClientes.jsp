<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.proyecto.service.*"%>
<%!ServiceClientesImp sc = new ServiceClientesImp();%>
<%!ServiceRolesImp sr = new ServiceRolesImp();%>

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

			<form action="../../ModificarClientesAccion" method="post"
				enctype="multipart/form-data">

				<h2 id="modificar">Modifique los campos necesarios.</h2>
				<h3>Los campos en blanco no sufrirán cambios.</h3>

				<input type="hidden" value="<%=request.getParameter("id")%>"
					name="id">
				<p>
					<label for="nombre">Nombre: </label> <input type="text" name="nombre" maxlength="500"
						placeholder="<%=sc.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getNombre()%>">
				</p>
				<p>
				<label for="apellido">Apellido: </label> <input type="text" name="apellidos" maxlength="500"
						placeholder="<%=sc.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getApellidos()%>">
				</p>
				<p>
					<label for="fechanacimiento">Fecha de nacimiento:</label> <input type="date" name="fechanacimiento"
						placeholder="<%=sc.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getFechanacimiento()%>">
				</p>
				<p>
				<label for="email">Email: </label> <input type="text" name="email" maxlength="50"
						placeholder="<%=sc.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getEmail()%>">
				</p>
				<p>
					<label for="password">Contraseña: </label> <input type="password" name="password" maxlength="20"
						placeholder="********">
				</p>
				<p>
					<label for="telefono">Telefono: </label><input type="tel" name="telefono" maxlength="10"
						placeholder="<%=sc.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getTelefono()%>">
				</p>
				<p>
					<label for="direccion">Direccion: </label> <input type="text" name="direccion" maxlength="500"
						placeholder="<%=sc.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getDireccion()%>">
				</p>
				<p>
				<label for="codigopostal">CP: </label> <input type="text" name="codigopostal" maxlength="5"
						placeholder="<%=sc.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getCodigopostal()%>">
				</p>
				<p>
				<label for="puntosacumulados">Putos acumulados: </label> <input type="number" name="puntosacumulados" max="100000"
						placeholder="<%=sc.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getPuntosacumulados()%>">
				</p>
				<p>
				<label for="rol">Rol: </label> <select name="rol">
						<option selected disabled>Seleccione un rol</option>
						<c:forEach items="${listaRoles}" var="rol">
							<option value="${rol.idrol}">${rol.nombre}</option>
						</c:forEach>
					</select>
				</p>
				<p>
					<label for="avatar">Avatar:</label> <input type="file"
						name="avatar">
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