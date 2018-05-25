window.onload = function() {


    var listaActividades = document.getElementById("listaActividades");
    var jsonActividades = JSON.parse(listaActividades.value);
    var botonVolver = document.getElementById("volver");
    botonVolver.addEventListener("click", cargarActividades, false);

    cargarActividades();
    

    function cargarActividades() {

        document.getElementById('contenedorActividades').innerHTML = "";
        document.getElementById('actividades').style.display = 'block';
	    document.getElementById('infoActividad').style.display = 'none';
	    
        for (var j = 0; j < jsonActividades.length; j++) {
        	
	            var divActividad = `<button class="nombreActividad" value=${j}> ${jsonActividades[j].nombre} </button>
	            	`;
	            if(jsonActividades[j].imagen.length>4){
		            divActividad+= `<img class="imagenActividad" 
		            src="http://ambgubuntu.westeurope.cloudapp.azure.com:8080/subidas/actividades/${jsonActividades[j].imagen}"></img>`
	            }
	            divActividad += `<div class="datosActividad">`;
			       	if(jsonActividades[j].fechainicio.length>2)
			       		divActividad+=`<a><b>Fecha:</b> ${jsonActividades[j].fechainicio}</a><br><br>`;
			        if(jsonActividades[j].ubicacion.length>2)
			        	divActividad+=`<a><b>Ubicación:</b> ${jsonActividades[j].ubicacion}</a><br><br>`;
			        if(jsonActividades[j].precio!=null)
			        	divActividad+=`<a><b>Precio:</b> ${jsonActividades[j].precio}</a><br>`;
		        divActividad+=`</div>`;
		        
		        divActividad+=`<button class="botonReserva" value=${jsonActividades[j].id}> Reservar la actividad </button>`
		        		        
		        
	            document.getElementById("contenedorActividades").innerHTML += divActividad;
	            
	      
        }
        
        cargarEnlacesActividades();
    }
    
	function cargarEnlacesActividades() {
	    var botones = document.getElementsByClassName("nombreActividad");
	
	    for (var index = 0; index < botones.length; index++) {
	        let actual = botones[index];
	        actual.addEventListener("click", mostrarInfoActividad, false);
	    }
	}
	
	
	function mostrarInfoActividad(){
		
		var numActividad = this.value;
		
	    var actividad = jsonActividades[numActividad];
	    var divInfoActividad = document.getElementById('infoActividad');
	    
	    document.getElementById('actividades').style.display = 'none';
	    divInfoActividad.style.display = 'block';
	    
	    divInfoActividad.innerHTML = "";

	    var infoActividad = `<div class="datosActividad">`;
	    
	    if(actividad.imagen.length>4){
	    	infoActividad+= `<img class="imagenActividad" 
            src="http://ambgubuntu.westeurope.cloudapp.azure.com:8080/subidas/actividades/${jsonActividades[j].imagen}"></img>`
        }
       	if(actividad.fechainicio.length>2)
       		infoActividad+=`<a><b>Fecha:</b> ${jsonActividades[j].fechainicio}</a><br><br>`;
        if(actividad.ubicacion.length>2)
        	infoActividad+=`<a><b>Ubicación:</b> ${jsonActividades[j].ubicacion}</a><br><br>`;
        if(actividad.precio!=null)
        	infoActividad+=`<a><b>Precio:</b> ${jsonActividades[j].precio}</a><br>`;
        infoActividad+=`</div>`;
	    
        divInfoActividad.innerHTML += infoActividad; // Inserto la info de la
														// actividad

	}
}
    