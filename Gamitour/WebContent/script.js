window.onload = function() {

	/** BOTONES MENU * */
	var actividades = document.getElementById("actividades");
	var clientes = document.getElementById("clientes");
	var itinerarios = document.getElementById("itinerarios");
	var noticias = document.getElementById("noticias");
	var paradas = document.getElementById("paradas");
	var roles = document.getElementById("roles");
	var pruebasdeportivas = document.getElementById("pruebasdeportivas");
	var pruebasculturales = document.getElementById("pruebasculturales");
	var multimedias = document.getElementById("multimedias");
	var premios = document.getElementById("premios");
	var comentarios = document.getElementById("comentarios");
	var votos = document.getElementById("votos");

	/** DIVS TABLAS* */
	var divBienvenida = document.getElementById("divBienvenida");
	var divClientes = document.getElementById("divclientes");
	var divActividades = document.getElementById("divactividades");
	var divNoticias = document.getElementById("divnoticias");
	var divParadas = document.getElementById("divparadas");
	var divRoles = document.getElementById("divroles");
	var divItinerarios = document.getElementById("divitinerarios");
	var divPruebasdeportivas = document.getElementById("divpruebasdeportivas");
	var divPruebasculturales = document.getElementById("divpruebasculturales");
	var divMultimedias = document.getElementById("divmultimedias");
	var divPremios = document.getElementById("divpremios");
	var divComentarios = document.getElementById("divcomentarios");
	var divVotos = document.getElementById("divvotos");

	/** EVENT LISTENERS BOTONES MENU* */
	clientes.addEventListener("click", mostrar, false);
	actividades.addEventListener("click", mostrar, false);
	itinerarios.addEventListener("click", mostrar, false);
	noticias.addEventListener("click", mostrar, false);
	paradas.addEventListener("click", mostrar, false);
	roles.addEventListener("click", mostrar, false);
	pruebasculturales.addEventListener("click", mostrar, false);
	pruebasdeportivas.addEventListener("click", mostrar, false);
	multimedias.addEventListener("click", mostrar, false);
	premios.addEventListener("click", mostrar, false);
	comentarios.addEventListener("click", mostrar, false);
	votos.addEventListener("click", mostrar, false);

	/** DIV ACTUAL* */
	var divActual = document.getElementById("divActual");

	if (divActual.value != "") {
		mostrarDivActual(divActual.value);
	} else {
		divBienvenida.style.display = "block";
	}

	function mostrarDivActual(div) { // Funcion mostrar con 1 param
		ocultarTodos();
		var concateno = "div" + div;
		document.getElementById(concateno).style.display = "block";
	}

	function mostrar() {
		ocultarTodos();
		var concateno = "div" + this.id;
		document.getElementById(concateno).style.display = "block";
	}

	function ocultarTodos() {
		divBienvenida.style.display = "none";
		divActividades.style.display = "none";
		divClientes.style.display = "none";
		divNoticias.style.display = "none";
		divParadas.style.display = "none";
		divRoles.style.display = "none";
		divItinerarios.style.display = "none";
		divPruebasculturales.style.display = "none";
		divPruebasdeportivas.style.display = "none";
		divPremios.style.display = "none";
		divMultimedias.style.display = "none";
		divComentarios.style.display = "none";
		divVotos.style.display = "none";
	}
}