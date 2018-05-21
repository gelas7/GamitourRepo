window.onload = function() {


    var listaItinerarios = document.getElementById("listaItinerarios");
    var jsonItinerarios = JSON.parse(listaItinerarios.value);

    cargarItinerarios();


    function cargarItinerarios(directionsService, directionsDisplay) {
        document.getElementById('paradas').style.display = 'none';
        document.getElementById('itinerarios').style.display = 'block';

        var origen, destino = "";

        document.getElementById('contenedorItinerarios').innerHTML = "";

        for (var j = 0; j < jsonItinerarios.length; j++) {

            waypts = [];
            if (jsonItinerarios[j].paradas[0] != null)
                origen = jsonItinerarios[j].paradas[0].ubicacion; // Primera
            
            if (jsonItinerarios[j].paradas[jsonItinerarios[j].paradas.length - 1] != null)
                destino = jsonItinerarios[j].paradas[jsonItinerarios[j].paradas.length - 1].ubicacion; // Ultima

            var divMapa = `
                <div id="mapaItinerario${j}" class="mapItinerario">
                </div>
                <button id="tituloItinerario${j}" class="botonesItinerario" value=${j}>${jsonItinerarios[j].nombre}</button> 
                <div id="direccionesItinerario${j}" class="directions">
                </div>
                `;
            document.getElementById("contenedorItinerarios").innerHTML += divMapa;

            if (jsonItinerarios[j].paradas.length > 2) { // Resto de paradas
                for (var i = 1; i < jsonItinerarios[j].paradas.length - 1; i++) {
                    if (jsonItinerarios[j].paradas[i].ubicacion != null) {
                        waypts.push({
                            location: jsonItinerarios[j].paradas[i].ubicacion,
                            stopover: true
                        });
                    }
                }
            }
            pintarItinerario(origen, destino, waypts, j);
            cargarBotones();
        }

        function pintarItinerario(start, end, puntosIntermedios, numMapa) {
            var directionsService = new google.maps.DirectionsService;
            var directionsDisplay = new google.maps.DirectionsRenderer;

            directionsService.route({
                origin: start, // Aqui origen y destino
                destination: end,
                waypoints: puntosIntermedios,
                optimizeWaypoints: true,
                travelMode: 'WALKING' // Modo de viaje
            }, function(response, status) {
            	debugger;

                if (status === 'OK') {
                    var mapaActual = "mapaItinerario" + numMapa;
                    var panelDireccionesActual = 'direccionesItinerario' + numMapa;
                    window[mapaActual] = new google.maps.Map(document.getElementById(mapaActual));

                    directionsDisplay.setMap(window[mapaActual]);
                    directionsDisplay.setDirections(response);
                    var route = response.routes[0];
                    var summaryPanel = document.getElementById(panelDireccionesActual);
                	debugger;
                    for (var i = 0; i < route.legs.length; i++) {
                        var routeSegment = i + 1;
                        summaryPanel.innerHTML += '<b>Parte ' + routeSegment +
                            ' del Itinerario</b><br>';
                        summaryPanel.innerHTML += route.legs[i].start_address + ' hacia ';
                        summaryPanel.innerHTML += route.legs[i].end_address + '<br>';
                        summaryPanel.innerHTML += route.legs[i].distance.text + '<br><br>';
                    }

                } else {
                    window.alert('Error en las direcciones');
                }
            });
        }
    }

	
	function cargarBotones() {
	    var botones = document.getElementsByClassName("botonesItinerario");
	
	    for (var index = 0; index < botones.length; index++) {
	        let actual = botones[index];
	        actual.addEventListener("click", cargarParadas, false);
	    }
	}
	
	
	function cargarParadas() {
	    document.getElementById('itinerarios').style.display = 'none';
	    document.getElementById('paradas').style.display = 'block';
	    var numItinerario = this.value;
	    var divMapa, divDatos = "";
	    contador = 0; // El contador para numeras los mapas empieza en 1
	
	    debugger;
	
	    var paradas = jsonItinerarios[numItinerario].paradas;
	    document.getElementById('contenedorParadas').innerHTML = "";
	
	    for (let parada in paradas) { // Recorro las paradas para pintar
	        // sus
	        // divs con titulo
	        divMapa = `
		                <div id="mapaParada${contador}" class="mapParada"></div>
		                <div id="indicacionesParada${contador}" class="datosParadas">
		                <a class="tituloIndicaciones">Datos de ${paradas[parada].nombre}:</a> <br><br>
		                <a><b>Gastronomia:</b> ${paradas[parada].gastronomia}</a><br><br>
		                <a><b>Historia:</b> ${paradas[parada].historia}</a><br><br>
		                <a><b>Anecdotario:</b> ${paradas[parada].anecdotario}</a><br><br><br>
		                </div>
		                 `;
	        document.getElementById("contenedorParadas").innerHTML += divMapa;
	
	        contador++;
	    }
	    pintarParadas(paradas); // Llamo a pintar mapas pasando las paradas
	
	}
	
	
	function pintarParadas(paradas) { // Le paso el array de paradas
	    contador = 0;
	    for (let parada in paradas) { // Recorro las paradas
	        var mapaActual = "mapaParada" + contador; // Construyo el id del
	        // mapa actual
	        window[mapaActual] = new google.maps.Map(document.getElementById(mapaActual), {
	            center: {
	                lat: paradas[parada].latitud,
	                lng: paradas[parada].longitud
	            },
	            zoom: 12
	        });
	
	        marker = new google.maps.Marker({ // Situo marcadores
	            map: window[mapaActual], // Apunto al objeto mapa recien
	            // creado
	            draggable: true,
	            animation: google.maps.Animation.DROP,
	            position: {
	                lat: paradas[parada].latitud,
	                lng: paradas[parada].longitud
	            }
	        });
	        contador++;
	    }
	
	}
}