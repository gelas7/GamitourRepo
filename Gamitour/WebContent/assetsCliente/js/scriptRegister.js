window.onload = function() {

	var divReg = document.getElementById("registro");
	var divLog = document.getElementById("login");
	var regToLog = document.getElementById("regToLog");
	var logToReg = document.getElementById("logToReg");

	regToLog.addEventListener("click", ocultarRegistro, false);
	logToReg.addEventListener("click", ocultarLogin, false);
	
	$('#registro').submit(function(e) {
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