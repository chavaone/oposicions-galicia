<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
		<link rel="stylesheet" href="css/bootstrap.min.css"/>
		<link rel="stylesheet" href="css/bootstrap-table.css"/>
		<link rel="stylesheet" href="css/oposiciones.css"/>
		<title>Oposiciones - Seleccionar ubicación</title>
		<meta name="viewport" content="initial-scale=1.0">
		<style>
			/* Always set the map height explicitly to define the size of the div
			 * element that contains the map. */
			#map {
				width: 100%;
				height: 100%;
				text-align: center;
			}
		</style>
	</head>
	<body>
		<jsp:include page="header.jsp"/>

		<div class="container" id="mainContainer">
			<c:if test="${not empty error}">
				<div class="alert alert-danger alert-dismissible fade in">
					<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<span class="glyphicon glyphicon-exclamation-sign"></span> <c:out value="${error}"/>
				</div>
			</c:if>
			<h1>Seleccionar ubicación</h1>
			<h3>Seleccione la ubicación desde la que calcular las distancias a los centros</h3>
			<h3>Puede geolocalizarla, escribir la dirección, las coordenadas o ubicarla en el mapa</h3>
			<form class="form-horizontal" action="calcular-distancias-centros" method="post" id="calcularDistanciasCentrosForm">
				<input type="hidden" id="latitud" name="latitud" value="${latitud}"/>
				<input type="hidden" id="longitud" name="longitud" value="${longitud}"/>
				<div class="radio">
					<input type="radio" name="tipoBusqueda" id="tipoBusquedaGeolocalizacion" value="geolocalizacion" checked>
					<label for="tipoBusquedaGeolocalizacion">Geolocalización (debe permitirla en el navegador)</label>
					<input type="text" name="geolocalizacion" class="form-control" id="geolocalizacion" placeholder="Realizando geolocalización..." readonly>
				</div>
				<div class="radio">
					<input type="radio" name="tipoBusqueda" id="tipoBusquedaDireccion" value="direccion">
					<label for="tipoBusquedaDireccion">Escriba la dirección</label>
					<input type="text" name="escribirDireccion" class="form-control" id="escribirDireccion" placeholder="Rúa Real, 2, A Coruña">
				</div>
				<div class="radio">
					<input type="radio" name="tipoBusqueda" id="tipoBusquedaCoordenadas" value="coordenadas">
					<label for="tipoBusquedaCoordenadas">Escriba las coordenadas</label>
					<input type="text" name="escribirCoordenadaY" class="form-control" id="escribirCoordenadaY" placeholder="43.370506">
					<input type="text" name="escribirCoordenadaX" class="form-control" id="escribirCoordenadaX" placeholder="-8.4013279">
				</div>
				<div class="radio">
					<input type="radio" name="tipoBusqueda" id="tipoBusquedaMapa" value="mapa">
					<label for="tipoBusquedaMapa">Selecione la ubicación en el mapa</label>
					<input type="text" name="mapa" class="form-control" id="mapa" placeholder="Esperando a que seleccione ubicación..." readonly>
					<div id="map"></div>
				</div>
				<div class="form-group">
					<div class="text-center">
						<button type="submit" class="btn btn-primary btn-lg">Calcular distancias</button>
					</div>
				</div>
			</form>
		</div>
		<script>
			var map;
			function initMap() {
				map = new google.maps.Map(document.getElementById('map'), {
					center: {lat: 42.8, lng: -8},
					zoom: 8
				});
				google.maps.event.addListener(map, 'click', function(event) {
					document.getElementById("mapa").value = Math.round(event.latLng.lat() * 1000000) / 1000000 + ", " +
							Math.round(event.latLng.lng() * 1000000) / 1000000;
				});
			}
			$(document).ready(function() {
				$("#geolocalizacion").click(function () {
					$('input:radio[name=tipoBusqueda]')[0].checked = true;
				});
				$("#escribirDireccion").click(function () {
					$('input:radio[name=tipoBusqueda]')[1].checked = true;
				});
				$("#escribirCoordenadaY").click(function () {
					$('input:radio[name=tipoBusqueda]')[2].checked = true;
				});
				$("#escribirCoordenadaX").click(function () {
					$('input:radio[name=tipoBusqueda]')[2].checked = true;
				});
				$("#mapa").click(function () {
					$('input:radio[name=tipoBusqueda]')[3].checked = true;
				});
			});
		</script>
		<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyADWRQl_gJg9z7reVzaj8A7btykoJCrxfk&callback=initMap" async defer></script>
		<script>
			window.onload = function getLocation() {
				if (navigator.geolocation) {
					navigator.geolocation.getCurrentPosition(showPosition);
				} else {
					document.getElementById("geolocalizacion").value = "Geolocalización no permitida";
				}
			}
			function showPosition(position) {
				document.getElementById("geolocalizacion").value = Math.round(position.coords.latitude * 1000000) / 1000000 + ", " +
						Math.round(position.coords.longitude * 1000000) / 1000000;
			}
		</script>
	</body>
</html>
