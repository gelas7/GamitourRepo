window.onload = function() {

	var botonOK = document.getElementById("btnOK");
	botonOK.addEventListener("click", getCoords, false);
	var geocoder = new google.maps.Geocoder();

	function getCoords() {

		address = document.getElementById("search").value;

		geocoder.geocode({
			'address' : address
		}, function(results, status) {
			document.getElementById("lat").value = results[0].geometry.location
					.lat().toFixed(4);

			document.getElementById("lng").value = results[0].geometry.location
					.lng().toFixed(4);
			initMap(results);
		});

	}

	function initMap(results) {
		map = new google.maps.Map(document.getElementById("map"), {
			center : {
				lat : results[0].geometry.location.lat(),
				lng : results[0].geometry.location.lng()
			},
			zoom : 15
		});

		marker = new google.maps.Marker({
			map : map,
			draggable : true,
			animation : google.maps.Animation.DROP,
			position : {
				lat : results[0].geometry.location.lat(),
				lng : results[0].geometry.location.lng()
			}
		});
		marker.addListener('click', toggleBounce);
		
		//var lat = marker.getPosition().lat();
		//var lng = marker.getPosition().lng();
		
		
		
	}
}