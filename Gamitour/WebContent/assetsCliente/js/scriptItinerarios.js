window.onload = function() {


    var listaItinerarios = document.getElementById("listaItinerarios");
    var jsonItinerarios = JSON.parse(listaItinerarios.value);
    var botonItinerarios = document.getElementById("btnItinerarios");
    var botonParadas= document.getElementById("btnParadas");
    botonItinerarios.addEventListener("click", cargarItinerarios, false);
    botonParadas.addEventListener("click", cargarParadas, false);


    cargarItinerarios();
    

    function cargarItinerarios(directionsService, directionsDisplay) {
        document.getElementById('paradas').style.display = 'none';
        document.getElementById('itinerarios').style.display = 'block';
	    document.getElementById('pruebas').style.display = 'none';
	    
	    $(window).scrollTop(0);
        var origen, destino = "";

        document.getElementById('contenedorItinerarios').innerHTML = "";

        for (var j = 0; j < jsonItinerarios.length; j++) {

        	if(jsonItinerarios[j].paradas.length>0){
        		
	            var waypts = [];
	            
	            var paradaOrigen = jsonItinerarios[j].paradas[0];//
	            var origen = new google.maps.LatLng(paradaOrigen.latitud, paradaOrigen.longitud);
	           
	            var paradaDestino = jsonItinerarios[j].paradas[jsonItinerarios[j].paradas.length - 1];//
	            var destino = new google.maps.LatLng(paradaDestino.latitud, paradaDestino.longitud);
	
	            var divMapa = `
	            	<button class="nombreItinerario" value=${j}>${jsonItinerarios[j].nombre}</button>
	                <div id="mapaItinerario${j}" class="mapItinerario"></div>`;
	            
	            document.getElementById("contenedorItinerarios").innerHTML += divMapa;
	
	            if (jsonItinerarios[j].paradas.length > 2) { // Waypoints
	                for (var i = 1; i < jsonItinerarios[j].paradas.length - 1; i++) {
	                	 var loc = new google.maps.LatLng(jsonItinerarios[j].paradas[i].latitud, jsonItinerarios[j].paradas[i].longitud);
	                    
	                        waypts.push({
	                            location: loc,
	                            stopover: true
	                        });
	                    
	                }
	            }
	            pintarItinerario(origen, destino, waypts, j);
	            cargarListenersItinerarios();
        	}
        }
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
        	
            if (status === 'OK') {
                var mapaActual = "mapaItinerario" + numMapa;
                var panelDireccionesActual = 'direccionesItinerario' + numMapa;
                window[mapaActual] = new google.maps.Map(document.getElementById(mapaActual));
                directionsDisplay.setMap(window[mapaActual]);
                directionsDisplay.setDirections(response);

            } else {
                window.alert('Error en las direcciones: '+status);
            }
        });
    }
	
	
	function cargarParadas() {
	    document.getElementById('itinerarios').style.display = 'none';
	    document.getElementById('paradas').style.display = 'block';
	    document.getElementById('pruebas').style.display = 'none';
	    
	    document.getElementById('btnParadas').value = this.value;  //Para cuando queramos volver a paradas

	    $(window).scrollTop(0);
	    var numItinerario = this.value;
	    var divMapa, divDatos = "";
	    contador = 0;
	
	    var paradas = jsonItinerarios[numItinerario].paradas;
	    document.getElementById('contenedorParadas').innerHTML = "";
		    
	    for (let parada in paradas) {
	        divMapa = `	<a class="nombreParada" value="${parada}-${numItinerario}">${paradas[parada].nombre}</a>
	        			<div id="mapaParada${contador}" class="mapParada"></div>
	        			<div class="botonesPruebas">
	        			<button class="cargarPC" value="${parada}-${numItinerario}">Pruebas Culturales</button>
	        			<button class="cargarPD" value="${parada}-${numItinerario}">Pruebas Deportivas</button>
	        			</div>`;

	        if(paradas[parada].gastronomia.length>2 || paradas[parada].historia.length>2 || paradas[parada].anecdotario.length>2){
		        divMapa += `<div id="indicacionesParada${contador}" class="datosParadas">`;
	        	if(paradas[parada].gastronomia.length>2)
		        	divMapa+=`<a><b>Gastronomia:</b> ${paradas[parada].gastronomia}</a><br><br>`;
		        if(paradas[parada].historia.length>2)
		        	divMapa+=`<a><b>Historia:</b> ${paradas[parada].historia}</a><br><br>`;
		        if(paradas[parada].anecdotario.length>2)
		        	divMapa+=`<a><b>Anecdotario:</b> ${paradas[parada].anecdotario}</a><br>`;
	        }
	        divMapa+=`</div>`;
	        	
	        document.getElementById("contenedorParadas").innerHTML += divMapa;
	
	        contador++;
	    }
	    pintarParadas(paradas); // Llamo a pintar mapas pasando las paradas
	    cargarListenersParadas();
	}
	
	
	function pintarParadas(paradas) { // Le paso el array de paradas
	    contador = 0;
	    
	    for (let parada in paradas) {
	        var mapaActual = "mapaParada" + contador; // mapaParadaX
	        
	        window[mapaActual] = new google.maps.Map(document.getElementById(mapaActual), {
	            center: {
	                lat: paradas[parada].latitud,
	                lng: paradas[parada].longitud
	            },
	            zoom: 13
	        });
	
	        marker = new google.maps.Marker({ // Situo marcadores
	            map: window[mapaActual], 	  // Apunto al objeto mapa recien
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
	
	function cargarPruebasC() {
	    document.getElementById('itinerarios').style.display = 'none';
	    document.getElementById('paradas').style.display = 'none';
	    document.getElementById('pruebas').style.display = 'block';
	    document.getElementById('pruebasC').style.display = 'block';
	    document.getElementById('pruebasD').style.display = 'none';
	    $(window).scrollTop(0);
	    
	    var indices = this.value;
	    var indicesArray = indices.split("-");// 0-0 p.e
	    var pruebasC = jsonItinerarios[indicesArray[0]].paradas[indicesArray[1]].pruebaculturales;
        document.getElementById("contenedorPruebasC").innerHTML = "";

	    if(pruebasC.length>0){
	        for (var i = 0; i < pruebasC.length; i++) {
		        divPrueba = `<a class="nombrePrueba">${pruebasC[i].nombre}</a>
		        		<form action="">`;
		        		divPrueba+=`<a>${pruebasC[i].pregunta}</a><br><br>`;
		        		divPrueba+=`<input type="radio" name="repuesta" value="1">${pruebasC[i].respuesta}<br>`;
		        		divPrueba+=`<input type="radio" name="repuesta" value="0">${pruebasC[i].respuesta2}<br>`;
		        		divPrueba+=`<input type="radio" name="repuesta" value="0">${pruebasC[i].respuesta3}<br>`;
		    }
		        divPrueba+=`</form>`;
		        document.getElementById("contenedorPruebasC").innerHTML += divPrueba;
		}

	}
	
	function cargarPruebasD() {
	    document.getElementById('itinerarios').style.display = 'none';
	    document.getElementById('paradas').style.display = 'none';
	    document.getElementById('pruebas').style.display = 'block';
	    document.getElementById('pruebasC').style.display = 'none';
	    document.getElementById('pruebasD').style.display = 'block';
	    $(window).scrollTop(0);
	    
	    var indices = this.value;
	    var indicesArray = indices.split("-");// 0-0 p.e
	    var pruebasD = jsonItinerarios[indicesArray[0]].paradas[indicesArray[1]].pruebadeportivas;
        document.getElementById("contenedorPruebasD").innerHTML = "";

	    if(pruebasD.length>0){
	        for (var i = 0; i < pruebasC.length; i++) {
		        divPrueba = `<a class="nombrePrueba">${pruebasD[i].nombre}</a>
		        		<div class="pruebaD">`;
		    }
		        divPrueba+=`</div>`;
		        document.getElementById("contenedorPruebasD").innerHTML += divPrueba;
		}
	    		
	}

	function cargarListenersItinerarios() {
	    var botones = document.getElementsByClassName("nombreItinerario");
	
	    for (var index = 0; index < botones.length; index++) {
	        let actual = botones[index];
	        actual.addEventListener("click", cargarParadas, false);
	    }
	}
	
	function cargarListenersParadas() {
	    var botones1 = document.getElementsByClassName("cargarPC");
	    var botones2 = document.getElementsByClassName("cargarPD");
	    for (var index = 0; index < botones1.length; index++) {
	        let actual1 = botones1[index];
	        actual1.addEventListener("click", cargarPruebasC, false);
	    }
	    for (var index = 0; index < botones2.length; index++) {
	        let actual2 = botones2[index];
	        actual2.addEventListener("click", cargarPruebasD, false);
	    }
	}

}