window.onload = function() {


    var listaActividades = document.getElementById("listaActividades");
    var jsonActividades = JSON.parse(listaActividades.value);


    cargarActividades();
    

    function cargarActividades() {

        document.getElementById('contenedorActividades').innerHTML = "";

        for (var j = 0; j < jsonActividades.length; j++) {
        	
	            var divActividad = `<button class="nombreActividad" value=${j}> ${jsonActividades[j].nombre} </button>
	            	`;
	            
	            if(jsonActividades[j].fechainicio.length>2 || jsonActividades[j].ubicacion.length>2 || jsonActividades[j].precio!=null){
	            	divActividad += `<div class="datosActividad">`;
			        	if(jsonActividades[j].fechainicio.length>2)
			        		divActividad+=`<a><b>Fecha:</b> ${jsonActividades[j].fechainicio}</a><br><br>`;
				        if(jsonActividades[j].ubicacion.length>2)
				        	divActividad+=`<a><b>Ubicación:</b> ${jsonActividades[j].ubicacion}</a><br><br>`;
				        if(jsonActividades[j].precio!=null)
				        	divActividad+=`<a><b>Precio:</b> ${jsonActividades[j].precio}</a><br>`;
			        divActividad+=`</div>`;
		        }
		        
		        
	            document.getElementById("contenedorActividades").innerHTML += divActividad;
	            
	      
        }
    }
}
    