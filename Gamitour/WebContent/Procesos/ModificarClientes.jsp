<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.proyecto.service.*"%>
<%!ServiceClientesImp sc = new ServiceClientesImp();%>
<%!ServiceRolesImp sr = new ServiceRolesImp();%>

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



			<form action="../ModificarClientes.do" method="get">
				<h2 id="modificar">Modifique los campos que quiera</h2>
			<h3>Los campos en blanco no sufriran cambios</h3>

				<input type="hidden" value="<%=request.getParameter("id")%>"
					name="id">
				<p>
					Nombre: <input type="text" name="nombre"
						placeholder="<%=sc.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getNombre()%>">
				</p>
				<p>
					Apellidos: <input type="text" name="apellidos"
						placeholder="<%=sc.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getApellidos()%>">
				</p>
				<p>
					Fecha de nacimiento: <input type="date" name="fechanacimiento"
						placeholder="<%=sc.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getFechanacimiento()%>">
				</p>
				<p>
					Email: <input type="text" name="email"
						placeholder="<%=sc.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getEmail()%>">
				</p>
				<p>
					Password: <input type="password" name="password"
						placeholder="<%=sc.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getPassword()%>">
				</p>
				<p>
					Telefono: <input type="text" name="telefono"
						placeholder="<%=sc.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getTelefono()%>">
				</p>
				<p>
					Direccion: <input type="text" name="direccion"
						placeholder="<%=sc.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getDireccion()%>">
				</p>
				<p>
					Codigo Postal: <input type="text" name="codigopostal"
						placeholder="<%=sc.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getCodigopostal()%>">
				</p>
				<p>
					Puntos Acumulados: <input type="text" name="puntosacumulados"
						placeholder="<%=sc.buscarPorClave(Integer.parseInt(request.getParameter("id"))).getPuntosacumulados()%>">
				</p>
				<p>
					Avatar: <input type="text" name="avatar"  onchange="handleFiles(this.files)">
				</p>
				<p>
					<input type="submit" value="Enviar" id="enviar">
				</p>
			</form>
		</div>
	<div id="footer"></div>
</body>
</html>