window.onload = function() {

	var divReservas = document.getElementById("reservas");
	var divAjustes = document.getElementById("ajustes");
	var btnReservas = document.getElementById("btnReservas");
	var btnAjustes = document.getElementById("btnAjustes");


	btnAjustes.addEventListener("click", mostrarAjustes, false);
	btnReservas.addEventListener("click", mostrarReservas, false);


	function mostrarAjustes() {
		divReservas.style.display = "none";
		divAjustes.style.display = "block";
	}
	function mostrarReservas() {
		divReservas.style.display = "block";
		divAjustes.style.display = "none";
		document.getElementById("errorPass").style.display = "none";
	}
	
	var divReg = document.getElementById("registro");
	var divLog = document.getElementById("login");

	
	$('#modificarDatos').submit(function(e) {
		if($('#password1').val()!= $('#password2').val()){	
			e.preventDefault();
			document.getElementById("errorPass").style.display = "block";
		}
		else{
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