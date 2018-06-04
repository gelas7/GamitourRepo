window.onload = function() {
	
    var listaNoticias = document.getElementById("listaNoticias");
    var jsonNoticias = JSON.parse(listaNoticias.value);
	var slideIndex = 0;
	cargarNoticias();
	carousel();
	
	function carousel() {
	    var i;
	    var x = document.getElementsByClassName("noticia");
	    for (i = 0; i < x.length; i++) {
	      x[i].style.display = "none"; 
	    }
	    slideIndex++;
	    if (slideIndex > x.length) {slideIndex = 1} 
	    x[slideIndex-1].style.display = "block"; 
	    setTimeout(carousel, 5000); 
	}
	
	 function cargarNoticias() {
	        document.getElementById('contenedorNoticias').innerHTML = "";

	        for (var j = 0; j < jsonNoticias.length; j++) {
	        	var divNoticia = `<div class="noticia">
		            <a class="nombreNoticia"> ${jsonNoticias[j].nombre} </a>`;
		            
		            if(jsonNoticias[j].imagen.length>4){
		            	divNoticia+= `<img class="imagenNoticia" 
			            src="http://ambgubuntu.westeurope.cloudapp.azure.com:8080/subidas/noticias/${jsonNoticias[j].imagen}"></img>`
		            }
		            if(jsonNoticias[j].texto.length>2){
		            	var texto = jsonNoticias[j].texto;
		            	 if(texto.length>100){
		            		 texto = texto.substring(0,100);
		            		 texto = texto.concat("...");
		            	 }
		            		 
		            	divNoticia+= `<div class="textoNoticia"<a>${texto}</a></div>`;
		            }
		            
		            
			        divNoticia+=`</div>`;
		            
			 document.getElementById("contenedorNoticias").innerHTML += divNoticia;   	
		                 
	        }
	}
	
}