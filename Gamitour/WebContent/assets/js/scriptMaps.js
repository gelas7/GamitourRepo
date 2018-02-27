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

		});

	}
}