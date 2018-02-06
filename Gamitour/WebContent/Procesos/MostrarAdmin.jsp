<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Panel de Administración</title>
<link href="style.css" rel="stylesheet" type="text/css" media="screen" />
<script src="script.js"></script>
</head>

<body>
	<div id="logo">
		<h1>
			<a href="MostrarAdmin.do">Panel de Administracion Gamitour</a>
		</h1>
	</div>

	<div id="menu">
		<ul>
			<li><button id="actividades">Actividades</button></li>
			<li><button id="clientes">Clientes</button></li>
			<li><button id="itinerarios">Itinerarios</button></li>
			<li><button id="noticias">Noticias</button></li>
			<li><button id="paradas">Paradas</button></li>
			<li><button id="premios">Premios</button></li>
			<li><button id="roles">Roles</button></li>
			<li><button id="votos">Votos</button></li>
			<li><button id="multimedias">Multimedias</button></li>
			<li><button id="comentarios">Comentarios</button></li>
			<li><button id="pruebasdeportivas">PD</button></li>
			<li><button id="pruebasculturales">PC</button></li>
		</ul>
		<button id="divActual" hidden value="${divActual}"></button>
	</div>
	<hr />

	<div id="page">
		<div id="content">
			<div class="post">

				<div id="divBienvenida">
					<h1>Bienvenido. Seleccione una opción del menu superior.</h1>
				</div>

				<div id="divclientes">
					<h1>Listado de Clientes</h1>
					<table>
						<tr>
							<th>Nombre</th>
							<th>Apellidos</th>
							<th>Fecha de Nacimiento</th>
							<th>Email</th>
							<th>Password</th>
							<th>Telefono</th>
							<th>Direccion</th>
							<th>Código Postal</th>
							<th>Puntos</th>
							<th>Fecha de Registro</th>
							<th>Rol</th>
							<th>Avatar</th>
						</tr>
						<c:forEach items="${listaClientes}" var="cliente">
							<tr>
								<td>${cliente.nombre}</td>
								<td>${cliente.apellidos}</td>
								<td>${cliente.fechanacimiento}</td>
								<td>${cliente.email}</td>
								<td>********</td>
								<td>${cliente.telefono}</td>
								<td>${cliente.direccion}</td>
								<td>${cliente.codigopostal}</td>
								<td>${cliente.puntosacumulados}</td>
								<td>${cliente.fecharegistro}</td>
								<td>${cliente.rol.getNombre()}</td>
								<td>${cliente.avatar}</td>
								<td><a id="eliminar"
									href="EliminarClientes.do?id=${cliente.idcliente}">Eliminar</a></td>
								<td><a id="actualizar"
									href="Procesos/ModificarClientes.jsp?id=${cliente.idcliente}">Modificar</a></td>
							</tr>
						</c:forEach>
					</table>
					<a id="insertar" href="Procesos/InsertarClientes.jsp">Insertar
						un cliente nuevo</a>

				</div>

				<div id="divactividades">
					<h1>Listado de Actividades</h1>
					<table>
						<tr>
							<th>Nombre</th>
							<th>Fecha de Inicio</th>
							<th>Fecha de Fin</th>
							<th>Ubicación</th>
							<th>Número de participantes</th>
							<th>Precio</th>
							<th>Imagen</th>
							<th>Puntos</th>
						</tr>

						<c:forEach items="${listaActividades}" var="actividad">
							<tr>
								<td>${actividad.nombre}</td>
								<td>${actividad.fechainicio}</td>
								<td>${actividad.fechafin}</td>
								<td>${actividad.ubicacion}</td>
								<td>${actividad.numparticipantes}</td>
								<td>${actividad.precio}</td>
								<td>${actividad.imagen}</td>
								<td>${actividad.puntos}</td>
								<td><a id="eliminar"
									href="EliminarActividades.do?id=${actividad.idactividad}">Eliminar</a></td>
								<td><a id="actualizar"
									href="Procesos/ModificarActividades.jsp?id=${actividad.idactividad}">Modificar</a></td>
							</tr>
						</c:forEach>
					</table>
					<a id="insertar" href="Procesos/InsertarActividades.html">Insertar
						una actividad nueva </a>
				</div>

				<div id="divitinerarios">
					<h1>Listado de Itinerarios</h1>
					<table>
						<tr>
							<th>Nombre</th>
							<th>Categoria</th>
							<th>Duración</th>
							<th>Ubicación</th>
						</tr>
						<c:forEach items="${listaItinerarios}" var="itinerario">
							<tr>
								<td>${itinerario.nombre}</td>
								<td>${itinerario.categoria}</td>
								<td>${itinerario.duracion}</td>
								<td>${itinerario.ubicacion}</td>
								<td><a id="eliminar"
									href="EliminarItinerarios.do?id=${itinerario.iditinerario}">Eliminar</a></td>
								<td><a id="actualizar"
									href="Procesos/ModificarItinerarios.jsp?id=${itinerario.iditinerario}">Modificar</a></td>
							</tr>
						</c:forEach>
					</table>
					<a id="insertar" href="Procesos/InsertarItinerarios.html">Insertar
						un itinerario nuevo</a>
				</div>

				<div id="divnoticias">
					<h1>Listado de Noticias</h1>
					<table>
						<tr>
							<th>Nombre</th>
							<th>Texto</th>
							<th>Fecha de Alta</th>
							<th>Fecha de Caducidad</th>
							<th>Imagen</th>
						</tr>
						<c:forEach items="${listaNoticias}" var="noticia">
							<tr>
								<td>${noticia.nombre}</td>
								<td>${noticia.texto}</td>
								<td>${noticia.fechaalta}</td>
								<td>${noticia.fechacaducidad}</td>
								<td>${noticia.imagen}</td>
								<td><a id="eliminar"
									href="EliminarNoticias.do?id=${noticia.idnoticia}">Eliminar</a></td>
								<td><a id="actualizar"
									href="Procesos/ModificarNoticias.jsp?id=${noticia.idnoticia}">Modificar</a></td>
							</tr>
						</c:forEach>
					</table>
					<a id="insertar" href="Procesos/InsertarNoticias.html">Insertar
						una noticia nueva</a>
				</div>

				<div id="divparadas">
					<h1>Listado de Paradas</h1>
					<table>
						<tr>
							<th>Nombre</th>
							<th>Número</th>
							<th>Ubicación</th>
							<th>Historia</th>
							<th>Anecdotario</th>
							<th>Gastronomia</th>
							<th>Imagen</th>
							<th>Itinerario</th>
						</tr>
						<c:forEach items="${listaParadas}" var="parada">
							<tr>
								<td>${parada.nombre}</td>
								<td>${parada.numeroParada}</td>
								<td>${parada.ubicacion}</td>
								<td>${parada.historia}</td>
								<td>${parada.anecdotario}</td>
								<td>${parada.gastronomia}</td>
								<td>${parada.imagen}</td>
								<td>${parada.itinerario.getNombre()}</td>
								<td><a id="eliminar"
									href="EliminarParadas.do?id=${parada.idparada}">Eliminar</a></td>
								<td><a id="actualizar"
									href="Procesos/ModificarParadas.jsp?id=${parada.idparada}">Modificar</a></td>
							</tr>
						</c:forEach>
					</table>
					<a id="insertar" href="Procesos/InsertarParadas.jsp">Insertar
						una parada nueva</a>
				</div>

				<div id="divroles">
					<h1>Listado de Roles</h1>
					<table>
						<tr>
							<th>Nombre</th>
						</tr>
						<c:forEach items="${listaRoles}" var="rol">
							<tr>
								<td>${rol.nombre}</td>
								<td><a id="eliminar"
									href="EliminarRoles.do?id=${rol.idrol}">Eliminar</a></td>
								<td><a id="actualizar"
									href="Procesos/ModificarRoles.jsp?id=${rol.idrol}">Modificar</a></td>
							</tr>
						</c:forEach>
					</table>
					<a id="insertar" href="Procesos/InsertarRoles.html">Insertar un
						rol nuevo</a>
				</div>

				<div id="divpruebasculturales">
					<h1>Listado de Pruebas Culturales</h1>
					<table>
						<tr>
							<th>Nombre</th>
							<th>Pregunta</th>
							<th>Respuesta</th>
							<th>Puntos</th>
							<th>Parada</th>
						</tr>
						<c:forEach items="${listaPruebasCulturales}" var="pC">
							<tr>
								<td>${pC.nombre}</td>
								<td>${pC.pregunta}</td>
								<td>${pC.respuesta}</td>
								<td>${pC.puntos}</td>
								<td>${pC.parada.getNombre()}</td>
								<td><a id="eliminar"
									href="EliminarPruebasCulturales.do?id=${pC.idpruebacultural}">Eliminar</a></td>
								<td><a id="actualizar"
									href="Procesos/ModificarPruebasCulturales.jsp?id=${pC.idpruebacultural}">Modificar</a></td>
							</tr>
						</c:forEach>
					</table>
					<a id="insertar" href="Procesos/InsertarPruebasCulturales.jsp">Insertar
						una prueba cultural nueva</a>
				</div>

				<div id="divpruebasdeportivas">
					<h1>Listado de Pruebas Deportivas</h1>
					<table>
						<tr>
							<th>Nombre</th>
							<th>Fecha de inicio</th>
							<th>Fecha de fin</th>
							<th>Explicación</th>
							<th>Puntos</th>
							<th>Parada</th>
						</tr>
						<c:forEach items="${listaPruebasDeportivas}" var="pD">
							<tr>
								<td>${pD.nombre}</td>
								<td>${pD.fechainicio}</td>
								<td>${pD.fechafin}</td>
								<td>${pD.explicacion}</td>
								<td>${pD.puntos}</td>
								<td>${pD.parada.getNombre()}</td>
								<td><a id="eliminar"
									href="EliminarPruebasDeportivas.do?id=${pD.idpruebadeportiva}">Eliminar</a></td>
								<td><a id="actualizar"
									href="Procesos/ModificarPruebasDeportivas.jsp?id=${pD.idpruebadeportiva}">Modificar</a></td>
							</tr>
						</c:forEach>
					</table>
					<a id="insertar" href="Procesos/InsertarPruebasDeportivas.jsp">Insertar
						una prueba deportiva nueva</a>
				</div>

				<div id="divpremios">
					<h1>Listado de Premios</h1>
					<table>
						<tr>
							<th>Cliente</th>
							<th>Nombre</th>
							<th>Descripcion</th>
							<th>Imagen</th>
							<th>Fecha Activacion</th>
							<th>Fecha Consumo</th>
							<th>Puntos</th>
						</tr>
						<c:forEach items="${listaPremios}" var="premio">
							<tr>
								<td>${premio.cliente.getNombre()}</td>
								<td>${premio.nombre}</td>
								<td>${premio.descripcion}</td>
								<td>${premio.imagen}</td>
								<td>${premio.fechaactivacion}</td>
								<td>${premio.fechaconsumo}</td>
								<td>${premio.puntos}</td>

								<td><a id="eliminar"
									href="EliminarPremios.do?id=${premio.idpremio}">Eliminar</a></td>
								<td><a id="actualizar"
									href="Procesos/ModificarPremios.jsp?id=${premio.idpremio}">Modificar</a></td>
							</tr>
						</c:forEach>
					</table>
					<a id="insertar" href="Procesos/InsertarPremios.jsp">Insertar
						un premio nuevo</a>
				</div>

				<div id="divmultimedias">
					<h1>Listado de Elementos Multimedia</h1>
					<table>
						<tr>
							<th>Cliente</th>
							<th>Fecha</th>
							<th>Comentario</th>
							<th>Imagen</th>
							<th>Video</th>
							<th>Puntos</th>
							<th>ID Prueba Deportiva</th>
						</tr>
						<c:forEach items="${listaMultimedias}" var="m">
							<tr>
								<td>${m.cliente.getNombre()}</td>
								<td>${m.fecha}</td>
								<td>${m.comentario}</td>
								<td>${m.imagen}</td>
								<td>${m.video}</td>
								<td>${m.puntosacumulados}</td>
								<td>${m.pruebaDeportivaIdpruebadeportiva}</td>

								<td><a id="eliminar"
									href="EliminarMultimedias.do?id=${m.idmultimedia}">Eliminar</a></td>
								<td><a id="actualizar"
									href="Procesos/ModificarMultimedias.jsp?id=${m.idmultimedia}">Modificar</a></td>
							</tr>
						</c:forEach>
					</table>
					<a id="insertar" href="Procesos/InsertarMultimedias.jsp">Insertar
						una elemento multimedia nuevo</a>
				</div>
				
				<div id="divcomentarios">
					<h1>Listado de Comentarios</h1>
					<table>
						<tr>
							<th>Cliente</th>
							<th>Multimedia</th>
							<th>Comentario</th>
						</tr>
						<c:forEach items="${listaComentarios}" var="com">
							<tr>
								<td>${com.cliente.getNombre()}</td>
								<td>${com.multimedia.getIdmultimedia()}</td>
								<td>${com.texto}</td>
								<td><a id="eliminar"
									href="EliminarComentarios.do?id=${com.idcomentario}">Eliminar</a></td>
								<td><a id="actualizar"
									href="Procesos/ModificarComentarios.jsp?id=${com.idcomentario}">Modificar</a></td>
							</tr>
						</c:forEach>
					</table>
					<a id="insertar" href="Procesos/InsertarComentarios.jsp">Insertar
						un comentario nuevo</a>
				</div>

			</div>
		</div>
	</div>

	<div id="footer"></div>
</body>
</html>






