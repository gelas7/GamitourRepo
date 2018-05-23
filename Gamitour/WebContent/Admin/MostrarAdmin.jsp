<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Panel de Administración</title>

<script src="assets/js/script.js" type="text/javascript"></script>
<script src="assets/js/jquery-3.3.1.js" type="text/javascript"></script>
<script src="assets/js/jquery.tablesorter.min.js" type="text/javascript"></script>
<script src="assets/js/pagination-tda-plugin.js" type="text/javascript"></script>
<script defer
	src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
<link href="assets/css/style.css" rel="stylesheet" type="text/css">

</head>

<body>
	<%!String url = "http://ambgubuntu.westeurope.cloudapp.azure.com:8080/subidas";%>
	<div class="flex">
		<div class="menu">
			<ul>
				<li><a class="botonMenu" id="itinerarios">Itinerarios</a></li>
				<li><a class="botonMenu" id="paradas">Paradas</a></li>
				<li><a class="botonMenu" id="pruebasculturales">PC</a></li>
				<li><a class="botonMenu" id="pruebasdeportivas">PD</a></li>
				<li><a class="botonMenu" id="multimedias">Multimedia</a></li>
				<li><a class="botonMenu" id="actividades">Actividades</a></li>
				<li><a class="botonMenu" id="clientes">Clientes</a></li>
				<li><a class="botonMenu" id="noticias">Noticias</a></li>
				<li><a class="botonMenu" id="premios">Premios</a></li>
				<li><a class="botonMenu" id="votos">Votos</a></li>
				<li><a class="botonMenu" id="comentarios">Comentarios</a></li>
				<li><a class="botonMenu" id="reservas">Reservas</a></li>
			</ul>
			<button id="divActual" value="${divActual}" hidden="hidden"></button>
		</div>

		<div class="page">
			<header>
				<ul>
					<li><a><i class="far fa-user"></i> ${email}</a></li>
					<li><a id="logout" href="Logout"><i
							class="fas fa-sign-out-alt"></i> Cerrar sesión</a></li>
					<li><a
						href="http://ambgubuntu.westeurope.cloudapp.azure.com:8080/EmailSendingWebApp">
							<i class="fas fa-info-circle"></i> Ayuda
					</a></li>
				</ul>
			</header>

			<div class="logo">
				<h1>
					<a href="MostrarAdmin.do">Panel de administración Gamiastur</a>
				</h1>

			</div>
			<div class="contenedor">

				<!-- DIV BIENVENIDA -->

				<div class="tablas" id="divBienvenida">
					<hr></hr>
					<h2>Última revisión:  22/05/2018 </h2><br>
					<h2>Seleccione una opción del menu lateral para comenzar.</h2>

					<br> <a id="guia" style="text-decoration: none"
						href="assets/pdf/guia.pdf">
						<h3 style="font-size: 22px; color: #666666;">
							Manual del usuario <i class="fas fa-file-pdf"> </i>
						</h3>
					</a> <br> <br> <img style="width: 30%;"
						src="assets/css/images/asturias.png"></img>
				
				</div>

				<!-- DIV CLIENTES -->


				<div class="tablas" id="divclientes">
					<h1>Listado de Clientes</h1>
					<a class="insertar" href="Admin/Insertar/InsertarClientes.jsp"><i
						class="fas fa-plus-circle"></i> Añadir nuevo</a>
					<p>
						<label for="searchtclientes"><i class="fas fa-search"></i></label>
						<input type="text" id="searchtclientes" value="" />
					</p>
					<table id="tclientes" class="tablesorter">
						<thead>
							<tr>
								<th>Nombre <i id="icono" class="fas fa-sort"></i></th>
								<th>Apellidos <i id="icono" class="fas fa-sort"></i></th>
								<th>Nacimiento <i id="icono" class="fas fa-sort"></i></th>
								<th>Mail <i id="icono" class="fas fa-sort"></i></th>
								<th>Teléfono <i id="icono" class="fas fa-sort"></i></th>
								<th>Direccion <i id="icono" class="fas fa-sort"></i></th>
								<th>CP <i id="icono" class="fas fa-sort"></i></th>
								<th>Puntos <i id="icono" class="fas fa-sort"></i></th>
								<th>Registro <i id="icono" class="fas fa-sort"></i></th>
								<th>Rol <i id="icono" class="fas fa-sort"></i></th>
								<th>Avatar <i id="icono" class="fas fa-sort"></i></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listaClientes}" var="cliente">
								<tr>
									<td>${cliente.nombre}</td>
									<td>${cliente.apellidos}</td>
									<td>${cliente.fechanacimiento}</td>
									<td>${cliente.email}</td>
									<td>${cliente.telefono}</td>
									<td>${cliente.direccion}</td>
									<td>${cliente.codigopostal}</td>
									<td>${cliente.puntosacumulados}</td>
									<td>${cliente.fecharegistro}</td>
									<td>${cliente.rol.getNombre()}</td>
									<td><img style="width: 40px; height: 40px;"
										src=" <%=url%>/clientes/${cliente.avatar}"></img></td>

									<td><a class="eliminar"
										onclick="return confirm('¿Está seguro de que quiere continuar? Los comentarios, votos y premios asociados al cliente también se eliminarán.')"
										href="EliminarClientes.do?id=${cliente.idcliente}"><i
											class="fas fa-trash-alt"></i></a></td>
									<td><a class="actualizar"
										href="Admin/Modificar/ModificarClientes.jsp?id=${cliente.idcliente}"><i
											class="fas fa-edit"></i> </a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

				<!-- DIV ACTIVIDADES -->

				<div class="tablas" id="divactividades">
					<h1>Listado de Actividades</h1>
					<a class="insertar"
						href="Admin/Insertar/InsertarActividades.html"><i
						class="fas fa-plus-circle"></i> Añadir nuevo</a>
					<p>
						<label for="searchtactividades"><i class="fas fa-search"></i></label>
						<input type="text" id="searchtactividades" value="" />
					</p>
					<table id="tactividades" class="tablesorter">
						<thead>
							<tr>
								<th>Nombre <i id="icono" class="fas fa-sort"></i></th>
								<th>Inicio <i id="icono" class="fas fa-sort"></i></th>
								<th>Fin <i id="icono" class="fas fa-sort"></i></th>
								<th>Ubicación <i id="icono" class="fas fa-sort"></i></th>
								<th>Participantes <i id="icono" class="fas fa-sort"></i></th>
								<th>Precio <i id="icono" class="fas fa-sort"></i></th>
								<th>Imagen <i id="icono" class="fas fa-sort"></i></th>
								<th>Puntos <i id="icono" class="fas fa-sort"></i></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listaActividades}" var="actividad">
								<tr>
									<td>${actividad.nombre}</td>
									<td>${actividad.fechainicio}</td>
									<td>${actividad.fechafin}</td>
									<td>${actividad.ubicacion}</td>
									<td>${actividad.numparticipantes}</td>
									<td>${actividad.precio}</td>
									<td><img style="width: 40px; height: 40px;"
										src=" <%=url%>/actividades/${actividad.imagen}"></img></td>
									<td>${actividad.puntos}</td>
									<td><a class="eliminar"
										onclick="return confirm('¿Está seguro de que quiere continuar?')"
										href="EliminarActividades.do?id=${actividad.idactividad}"><i
											class="fas fa-trash-alt"></i></a></td>
									<td><a class="actualizar"
										href="Admin/Modificar/ModificarActividades.jsp?id=${actividad.idactividad}"><i
											class="fas fa-edit"></i> </a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

				<!-- DIV ITINERARIOS -->

				<div class="tablas" id="divitinerarios">
					<h1>Listado de Itinerarios</h1>
					<a class="insertar"
						href="Admin/Insertar/InsertarItinerarios.html"><i
						class="fas fa-plus-circle"></i> Añadir nuevo</a>
					<p>
						<label for="searchtitinerarios"><i class="fas fa-search"></i></label>
						<input type="text" id="searchtitinerarios" value="" />
					</p>
					<table id="titinerarios" class="tablesorter">
						<thead>
							<tr>
								<th>Nombre <i id="icono" class="fas fa-sort"></i></th>
								<th>Categoria <i id="icono" class="fas fa-sort"></i></th>
								<th>Duración <i id="icono" class="fas fa-sort"></i></th>
								<th>Ubicación <i id="icono" class="fas fa-sort"></i></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listaItinerarios}" var="itinerario">
								<tr>
									<td>${itinerario.nombre}</td>
									<td>${itinerario.categoria}</td>
									<td>${itinerario.duracion}</td>
									<td>${itinerario.ubicacion}</td>
									<td><a class="eliminar"
										onclick="return confirm('¿Está seguro de que quiere continuar? Las paradas asociadas a este itinerario también se eliminarán.')"
										href="EliminarItinerarios.do?id=${itinerario.iditinerario}"><i
											class="fas fa-trash-alt"></i></a></td>
									<td><a class="actualizar"
										href="Admin/Modificar/ModificarItinerarios.jsp?id=${itinerario.iditinerario}"><i
											class="fas fa-edit"></i> </a></td>
									<td><a class="mostrar"
										href="MostrarParadas.do?id=${itinerario.iditinerario}">Paradas</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

				<!-- DIV NOTICIAS -->

				<div class="tablas" id="divnoticias">
					<h1>Listado de Noticias</h1>
					<a class="insertar" href="Admin/Insertar/InsertarNoticias.html"><i
						class="fas fa-plus-circle"></i> Añadir nuevo</a>
					<p>
						<label for="searchtnoticias"><i class="fas fa-search"></i></label>
						<input type="text" id="searchtnoticias" value="" />
					</p>
					<table id="tnoticias" class="tablesorter">
						<thead>
							<tr>
								<th>Nombre <i id="icono" class="fas fa-sort"></i></th>
								<th>Alta <i id="icono" class="fas fa-sort"></i></th>
								<th>Caducidad <i id="icono" class="fas fa-sort"></i></th>
								<th>Imagen <i id="icono" class="fas fa-sort"></i></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listaNoticias}" var="noticia">
								<tr>
									<td>${noticia.nombre}</td>
									<td>${noticia.fechaalta}</td>
									<td>${noticia.fechacaducidad}</td>
									<td><img style="width: 40px; height: 40px;"
										src=" <%=url%>/noticias/${noticia.imagen}"></img></td>
									<td><a class="eliminar"
										onclick="return confirm('¿Está seguro de que quiere continuar?')"
										href="EliminarNoticias.do?id=${noticia.idnoticia}"><i
											class="fas fa-trash-alt"></i></a></td>
									<td><a class="actualizar"
										href="Admin/Modificar/ModificarNoticias.jsp?id=${noticia.idnoticia}"><i
											class="fas fa-edit"></i> </a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

				<!-- DIV PARADAS -->
				<div class="tablas" id="divparadas">
					<h1>Listado de Paradas</h1>
					<a class="insertar" href="Admin/Insertar/InsertarParadas.jsp"><i
						class="fas fa-plus-circle"></i> Añadir nuevo</a>
					<p>
						<label for="searchtparadas"><i class="fas fa-search"></i></label>
						<input type="text" id="searchtparadas" value="" />
					</p>
					<table id="tparadas" class="tablesorter">
						<thead>
							<tr>
								<th>Nombre <i id="icono" class="fas fa-sort"></i></th>
								<th>Número <i id="icono" class="fas fa-sort"></i></th>
								<th>Ubicación <i id="icono" class="fas fa-sort"></i></th>
								<th>Imagen <i id="icono" class="fas fa-sort"></i></th>
								<th>Video <i id="icono" class="fas fa-sort"></i></th>
								<th>Itinerario <i id="icono" class="fas fa-sort"></i></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listaParadas}" var="parada">
								<tr>
									<td>${parada.nombre}</td>
									<td>${parada.numeroParada}</td>
									<td>${parada.ubicacion}</td>
									<td><img style="width: 40px; height: 40px;"
										src=" <%=url%>/paradas/${parada.imagen}"></img></td>
									<td><img style="width: 40px; height: 40px;"
										src=" <%=url%>/paradas/${parada.video}"></img></td>
									<td>${parada.itinerario.getNombre()}</td>
									<td><a class="eliminar"
										onclick="return confirm('¿Está seguro de que quiere continuar? Las pruebas culturales asociadas a esta parada también se eliminarán.')"
										href="EliminarParadas.do?id=${parada.idparada}"><i
											class="fas fa-trash-alt"></i></a></td>
									<td><a class="actualizar"
										href="Admin/Modificar/ModificarParadas.jsp?id=${parada.idparada}"><i
											class="fas fa-edit"></i> </a></td>
									<td><a class="mostrar"
										href="MostrarPruebasDeportivas.do?id=${parada.idparada}">Pruebas
											Deportivas</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

				<!-- DIV PRUEBAS CULTURALES -->

				<div class="tablas" id="divpruebasculturales">
					<h1>Listado de Pruebas Culturales</h1>
					<a class="insertar"
						href="Admin/Insertar/InsertarPruebasCulturales.jsp"><i
						class="fas fa-plus-circle"></i> Añadir nuevo</a>
					<p>
						<label for="searchtpruebasculturales"><i
							class="fas fa-search"></i></label> <input type="text"
							id="searchtpruebasculturales" value="" />
					</p>
					<table id="tpruebasculturales" class="tablesorter">
						<thead>
							<tr>
								<th>Nombre <i id="icono" class="fas fa-sort"></i></th>
								<th>Puntos <i id="icono" class="fas fa-sort"></i></th>
								<th>Parada <i id="icono" class="fas fa-sort"></i></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listaPruebasCulturales}" var="pC">
								<tr>
									<td>${pC.nombre}</td>
									<td>${pC.puntos}</td>
									<td>${pC.parada.getNombre()}</td>
									<td><a class="eliminar"
										onclick="return confirm('¿Está seguro de que quiere continuar?')"
										href="EliminarPruebasCulturales.do?id=${pC.idpruebacultural}"><i
											class="fas fa-trash-alt"></i></a></td>
									<td><a class="actualizar"
										href="Admin/Modificar/ModificarPruebasCulturales.jsp?id=${pC.idpruebacultural}"><i
											class="fas fa-edit"></i> </a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

				<!-- DIV PRUEBAS DEPORTIVAS -->

				<div class="tablas" id="divpruebasdeportivas">
					<h1>Listado de Pruebas Deportivas</h1>
					<a class="insertar"
						href="Admin/Insertar/InsertarPruebasDeportivas.jsp"><i
						class="fas fa-plus-circle"></i> Añadir nuevo</a>
					<p>
						<label for="searchtpruebasdeportivas"><i
							class="fas fa-search"></i></label> <input type="text"
							id="searchtpruebasdeportivas" value="" />
					</p>
					<table id="tpruebasdeportivas" class="tablesorter">
						<thead>
							<tr>
								<th>Nombre <i id="icono" class="fas fa-sort"></i></th>
								<th>Inicio <i id="icono" class="fas fa-sort"></i></th>
								<th>Fin <i id="icono" class="fas fa-sort"></i></th>
								<th>Puntos <i id="icono" class="fas fa-sort"></i></th>
								<th>Parada <i id="icono" class="fas fa-sort"></i></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listaPruebasDeportivas}" var="pD">
								<tr>
									<td>${pD.nombre}</td>
									<td>${pD.fechainicio}</td>
									<td>${pD.fechafin}</td>
									<td>${pD.puntos}</td>
									<td>${pD.parada.getNombre()}</td>
									<td><a class="eliminar"
										onclick="return confirm('¿Está seguro de que quiere continuar?')"
										href="EliminarPruebasDeportivas.do?id=${pD.idpruebadeportiva}"><i
											class="fas fa-trash-alt"></i></a></td>
									<td><a class="actualizar"
										href="Admin/Modificar/ModificarPruebasDeportivas.jsp?id=${pD.idpruebadeportiva}"><i
											class="fas fa-edit"></i> </a></td>
									<td><a class="mostrar"
										href="MostrarMultimedias.do?id=${pD.idpruebadeportiva}">Multimedia</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

				<!-- DIV PREMIOS -->

				<div class="tablas" id="divpremios">
					<h1>Listado de Premios</h1>
					<a class="insertar" href="Admin/Insertar/InsertarPremios.jsp"><i
						class="fas fa-plus-circle"></i> Añadir nuevo</a>
					<p>
						<label for="searchtpremios"><i class="fas fa-search"></i></label>
						<input type="text" id="searchtpremios" value="" />
					</p>
					<table id="tpremios" class="tablesorter">
						<thead>
							<tr>
								<th>Cliente <i id="icono" class="fas fa-sort"></i></th>
								<th>Nombre <i id="icono" class="fas fa-sort"></i></th>
								<th>Imagen <i id="icono" class="fas fa-sort"></i></th>
								<th>Activacion <i id="icono" class="fas fa-sort"></i></th>
								<th>Consumo <i id="icono" class="fas fa-sort"></i></th>
								<th>Puntos <i id="icono" class="fas fa-sort"></i></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listaPremios}" var="premio">
								<tr>
									<td>${premio.cliente.getNombre()}</td>
									<td>${premio.nombre}</td>
									<td><img style="width: 40px; height: 40px;"
										src=" <%=url%>/premios/${premio.imagen}"></img></td>
									<td>${premio.fechaactivacion}</td>
									<td>${premio.fechaconsumo}</td>
									<td>${premio.puntos}</td>
									<td><a class="eliminar"
										onclick="return confirm('¿Está seguro de que quiere continuar?')"
										href="EliminarPremios.do?id=${premio.idpremio}"><i
											class="fas fa-trash-alt"></i></a></td>
									<td><a class="actualizar"
										href="Admin/Modificar/ModificarPremios.jsp?id=${premio.idpremio}"><i
											class="fas fa-edit"></i> </a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

				<!-- DIV  MULTIMEDIAS -->

				<div class="tablas" id="divmultimedias">
					<h1>Listado de elementos Multimedia</h1>
					<a class="insertar"
						href="Admin/Insertar/InsertarMultimedias.jsp"><i
						class="fas fa-plus-circle"></i> Añadir nuevo</a>
					<p>
						<label for="searchtmultimedias"><i class="fas fa-search"></i></label>
						<input type="text" id="searchtmultimedias" value="" />
					</p>
					<table id="tmultimedias" class="tablesorter">
						<thead>
							<tr>
								<th>Cliente <i id="icono" class="fas fa-sort"></i></th>
								<th>Fecha <i id="icono" class="fas fa-sort"></i></th>
								<th>Imagen <i id="icono" class="fas fa-sort"></i></th>
								<th>Video <i id="icono" class="fas fa-sort"></i></th>
								<th>Puntos <i id="icono" class="fas fa-sort"></i></th>
								<th>ID P.Deportiva <i id="icono" class="fas fa-sort"></i></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listaMultimedias}" var="m">
								<tr>
									<td>${m.cliente.getNombre()}</td>
									<td>${m.fecha}</td>
									<td><img style="width: 40px; height: 40px;"
										src=" <%=url%>/multimedias/${m.imagen}"></img></td>
									<td><img style="width: 40px; height: 40px;"
										src=" <%=url%>/multimedias/${m.video}"></img></td>
									<td>${m.puntosacumulados}</td>
									<td>${m.pruebaDeportivaIdpruebadeportiva}</td>
									<td><a class="eliminar"
										onclick="return confirm('¿Está seguro de que quiere continuar?' Los comentarios y votos asociados a este elemento multimedia también se eliminarán.)"
										href="EliminarMultimedias.do?id=${m.idmultimedia}"><i
											class="fas fa-trash-alt"></i></a></td>
									<td><a class="actualizar"
										href="Admin/Modificar/ModificarMultimedias.jsp?id=${m.idmultimedia}"><i
											class="fas fa-edit"></i> </a></td>
									<td><a class="mostrar"
										href="MostrarComentarios.do?id=${m.idmultimedia}">Comentarios</a></td>
									<td><a class="mostrar"
										href="MostrarVotos.do?id=${m.idmultimedia}">Votos</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

				<!-- DIV COMENTARIOS -->

				<div class="tablas" id="divcomentarios">
					<h1>Listado de Comentarios</h1>
					<a class="insertar"
						href="Admin/Insertar/InsertarComentarios.jsp"><i
						class="fas fa-plus-circle"></i> Añadir nuevo</a>
					<p>
						<label for="searchtcomentarios"><i class="fas fa-search"></i></label>
						<input type="text" id="searchtcomentarios" value="" />
					</p>
					<table id="tcomentarios" class="tablesorter">
						<thead>
							<tr>
								<th>Cliente <i id="icono" class="fas fa-sort"></i></th>
								<th>Multimedia <i id="icono" class="fas fa-sort"></i></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listaComentarios}" var="com">
								<tr>
									<td>${com.cliente.getNombre()}</td>
									<td>${com.multimedia.getIdmultimedia()}</td>
									<td><a class="eliminar"
										onclick="return confirm('¿Está seguro de que quiere continuar?')"
										href="EliminarComentarios.do?id=${com.idcomentario}"><i
											class="fas fa-trash-alt"></i></a></td>
									<td><a class="actualizar"
										href="Admin/Modificar/ModificarComentarios.jsp?id=${com.idcomentario}"><i
											class="fas fa-edit"></i> </a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

				<!-- DIV VOTOS -->

				<div class="tablas" id="divvotos">
					<h1>Listado de votos</h1>
					<a class="insertar" href="Admin/Insertar/InsertarVotos.jsp"><i
						class="fas fa-plus-circle"></i> Añadir nuevo</a>
					<p>
						<label for="searchtvotos"><i class="fas fa-search"></i></label> <input
							type="text" id="searchtvotos" value="" />
					</p>
					<table id="tvotos" class="tablesorter">
						<thead>
							<tr>
								<th>Cliente <i id="icono" class="fas fa-sort"></i></th>
								<th>Multimedia <i id="icono" class="fas fa-sort"></i></th>
								<th>Puntos <i id="icono" class="fas fa-sort"></i></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listaVotos}" var="v">
								<tr>
									<td>${v.cliente.getNombre()}</td>
									<td>${v.multimedia.getIdmultimedia()}</td>
									<td>${v.puntos}</td>
									<td><a class="eliminar"
										href="EliminarVotos.do?id=${v.idvoto}"
										onclick="return confirm('¿Está seguro de que quiere continuar?')"><i
											class="fas fa-trash-alt"></i></a></td>
									<td><a class="actualizar"
										href="Admin/Modificar/ModificarVotos.jsp?id=${v.idvoto}"><i
											class="fas fa-edit"></i> </a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

				<!-- DIV RESERVAS -->

				<div class="tablas" id="divreservas">
					<h1>Listado de reservas</h1>
					<a class="insertar" href="Admin/Insertar/InsertarReservas.jsp">
						<i class="fas fa-plus-circle"></i> Añadir nuevo
					</a>
					<p>
						<label for="searchtreservas"><i class="fas fa-search"></i></label>
						<input type="text" id="searchtreservas" value="" />
					</p>
					<table id="treservas" class="tablesorter">
						<thead>
							<tr>
								<th>Cliente <i id="icono" class="fas fa-sort"></i></th>
								<th>Actividad <i id="icono" class="fas fa-sort"></i></th>
								<th>Comentarios <i id="icono" class="fas fa-sort"></i></th>
								<th>Fecha <i id="icono" class="fas fa-sort"></i></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listaReservas}" var="r">
								<tr>
									<td>${r.cliente.getNombre()}</td>
									<td>${r.actividad.getNombre()}</td>
									<td>${r.comentarios}</td>
									<td>${r.fecha}</td>
									<td><a class="eliminar"
										href="EliminarReservas.do?id=${r.idreserva}"
										onclick="return confirm('¿Está seguro de que quiere continuar?')"><i
											class="fas fa-trash-alt"></i></a></td>
									<td><a class="actualizar"
										href="Admin/Modificar/ModificarReservas.jsp?id=${r.idreserva}"><i
											class="fas fa-edit"></i> </a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

	<div id="footer"></div>

</body>
</html>

