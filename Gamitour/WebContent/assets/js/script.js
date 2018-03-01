window.onload = function() {

	var tablas = document.getElementsByClassName("tablas");// Cargo divs de
	// tablas
	var divActual = document.getElementById("divActual");// Almaceno div que
	// se está mostrando
	var botonesMenu = document.getElementsByClassName("botonMenu");

	for (var i = 0; i < botonesMenu.length; i++) {// Event listeners botones
		// de menu
		botonesMenu[i].addEventListener("click", mostrar, false);
	}

	var tablesorter = document.getElementsByClassName("tablesorter");

	ordenar();
	paginar();
	buscar();

	if (divActual.value != "") { // Si hay divActual lo muestro al recargar
		mostrarDivActual(divActual.value);
	} else { // Si no lo hay muestro la bienvenida
		divBienvenida.style.display = "block";
	}

	function ordenar() {
		$('.tablesorter').tablesorter();
	}

	function paginar() { // # + el id de la tabla a ordenar (Así funciona el
		// plugin)
		for (var i = 0; i < tablesorter.length; i++) {
			$("#" + tablesorter[i].id).paginationTdA({
				elemPerPage : 5
			});
			buscar(tablesorter[i].id);
		}
	}

	function mostrarDivActual(div) { // Funcion mostrar con 1 parametro
		ocultarTodos();
		var concateno = "div" + div;
		document.getElementById(concateno).style.display = "block";
	}

	function mostrar() {
		ocultarTodos();
		var concateno = "div" + this.id;
		this.style.color = "#a1c3ff";
		document.getElementById(concateno).style.display = "block";
	}

	function ocultarTodos() { // Oculto todos los divs de tablas
		for (var i = 0; i < tablas.length; i++) {
			tablas[i].style.display = "none";
		}
		for (var i = 0; i < botonesMenu.length; i++) {
			botonesMenu[i].style.color = "white";
		}
	}

	function buscar(table) {
		$("#search" + table).keyup(
				// Botones #searchtclientes
				function() {
					if ($(this).val() != "") {
						$("#" + table + " tbody>tr").hide();
						$(
								"#" + table + " td:contains-ci('"
										+ $(this).val() + "')").parent("tr")
								.show();
					} else
						$("#" + table + " tbody>tr").show();

				});

		$.extend($.expr[":"],
				{
					"contains-ci" : function(elem, i, match, array) {
						return (elem.textContent || elem.innerText
								|| $(elem).text() || "").toLowerCase().indexOf(
								(match[3] || "").toLowerCase()) >= 0;
					}
				});
	}
}