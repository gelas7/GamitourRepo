window.onload = function() {

	/** DIVS TABLAS**/ 
	var divBienvenida = document.getElementById("divBienvenida");
	var divClientes = document.getElementById("divclientes");
	var divActividades = document.getElementById("divactividades");
	var divNoticias = document.getElementById("divnoticias");
	var divParadas = document.getElementById("divparadas");
	var divItinerarios = document.getElementById("divitinerarios");
	var divPruebasdeportivas = document.getElementById("divpruebasdeportivas");
	var divPruebasculturales = document.getElementById("divpruebasculturales");
	var divMultimedias = document.getElementById("divmultimedias");
	var divPremios = document.getElementById("divpremios");
	var divComentarios = document.getElementById("divcomentarios");
	var divVotos = document.getElementById("divvotos");

	/** DIV ACTUAL (Para regresar al div correcto tras insertar/modificar/eliminar **/
	var divActual = document.getElementById("divActual");

	if (divActual.value != "") {
		mostrarDivActual(divActual.value);
	} else {
		divBienvenida.style.display = "block";
	}
	/** BOTONES MENU (Para asignar la funcion mostrar a todos los botones **/

	var botonesMenu = document.getElementsByClassName("botonMenu");

	for (var i = 0; i < botonesMenu.length; i++) {
		botonesMenu[i].addEventListener("click", mostrar, false);
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
		divItinerarios.style.display = "none";
		divPruebasculturales.style.display = "none";
		divPruebasdeportivas.style.display = "none";
		divPremios.style.display = "none";
		divMultimedias.style.display = "none";
		divComentarios.style.display = "none";
		divVotos.style.display = "none";
	}
}