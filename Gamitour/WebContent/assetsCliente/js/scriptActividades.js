window.onload = function() {


    var listaActividades = document.getElementById("listaActividades");
    var jsonActividades = JSON.parse(listaActividades.value);
    var botonVolver = document.getElementById("btnActividades");
    botonVolver.addEventListener("click", cargarActividades, false);

    cargarActividades();
    

    function cargarActividades() {

        document.getElementById('contenedorActividades').innerHTML = "";
        document.getElementById('actividades').style.display = 'block';
	    document.getElementById('actividad').style.display = 'none';
	    
        for (var j = 0; j < jsonActividades.length; j++) {
        	
	            var divActividad = `<div id="contenedorActividad">
	            <button class="nombreActividad" value=${j}> ${jsonActividades[j].nombre} </button>
	            	`;
	            if(jsonActividades[j].imagen.length>4){
		            divActividad+= `<img class="imagenActividad" 
		            src="http://ambgubuntu.westeurope.cloudapp.azure.com:8080/subidas/actividades/${jsonActividades[j].imagen}"></img>`
	            }
	            
		        divActividad+=`</div>`;
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
	    var divActividad = document.getElementById('actividad');
	    var divInfoActividad = document.getElementById('infoActividad');

	    document.getElementById('actividades').style.display = 'none';
	    divActividad.style.display = 'block';
	    $(window).scrollTop(0);
	    
	    divInfoActividad.innerHTML = "";
	    
	    var infoActividad=`<a class="nombreActividad"> ${actividad.nombre} </a>`;
	    		
	    if(actividad.imagen.length>4){
	    		infoActividad+= `<img class="imagenActividad" 
	    			src="http://ambgubuntu.westeurope.cloudapp.azure.com:8080/subidas/actividades/${actividad.imagen}"></img>`
        }
	    
	    infoActividad += `<a class="btnReserva" id="btnReserva"
				onclick="return confirm('¿Desea confirmar su reserva?')" >Reservar la actividad
			</a><div class="datosActividad">`;
	   
       	if(actividad.fechainicio.length>2)
       		infoActividad+=`<a><b>Fecha:</b> ${actividad.fechainicio}</a><br><br>`;
        if(actividad.ubicacion.length>2)
        	infoActividad+=`<a><b>Ubicación:</b> ${actividad.ubicacion}</a><br><br>`;
        if(actividad.precio!=null)
        	infoActividad+=`<a><b>Precio:</b> ${actividad.precio}€</a><br>`;
        infoActividad+=`</div>`;
        
        divInfoActividad.innerHTML += infoActividad;

	    var botonReserva = document.getElementById('btnReserva');
	    
	    if(botonReserva!=null)
	    {
	    	botonReserva.href = `/Gamitour/ReservarActividad.cl?id=${actividad.idactividad}`;
		}
	    

	}
}
    