window.onload = function() {

	var divReservas = document.getElementById("reservas");
	var divAjustes = document.getElementById("ajustes");
	var divPremios = document.getElementById("premios");
	var divTienda = document.getElementById("tienda");

	var btnReservas = document.getElementById("btnReservas");
	var btnAjustes = document.getElementById("btnAjustes");
	var btnPremios = document.getElementById("btnPremios");
	var btnTienda = document.getElementById("btnTienda");

	btnAjustes.addEventListener("click", mostrarAjustes, false);
	btnReservas.addEventListener("click", mostrarReservas, false);
	btnPremios.addEventListener("click", mostrarPremios, false);
	btnTienda.addEventListener("click", mostrarTienda, false);

	function mostrarAjustes() {
		divReservas.style.display = "none";
		divPremios.style.display = "none";
		divTienda.style.display = "none";
		divAjustes.style.display = "block";
	}

	function mostrarReservas() {
		divPremios.style.display = "none";
		divAjustes.style.display = "none";
		divTienda.style.display = "none";
		divReservas.style.display = "block";
		document.getElementById("errorPass").style.display = "none";
	}

	function mostrarPremios() {
		divAjustes.style.display = "none";
		divReservas.style.display = "none";
		divTienda.style.display = "none";
		divPremios.style.display = "block";
	}

	function mostrarTienda() {
		divAjustes.style.display = "none";
		divReservas.style.display = "none";
		divPremios.style.display = "none";
		divTienda.style.display = "block";
	}

	var divReg = document.getElementById("registro");
	var divLog = document.getElementById("login");

	$('#modificarDatos').submit(function(e) {
		if ($('#password1').val() != $('#password2').val()) {
			e.preventDefault();
			document.getElementById("errorPass").style.display = "block";
		} else {
			document.getElementById("errorPass").style.display = "none";
		}
	});

	function ocultarLogin() {
		divLog.style.display = "none";
		divReg.style.display = "block";
	}

	function ocultarRegistro() {
		divLog.style.display = "block";
		divReg.style.display = "none";
	}

}