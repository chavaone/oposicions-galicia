<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
		<link rel="stylesheet" href="css/bootstrap.min.css"/>
		<link rel="stylesheet" href="css/bootstrap-table.css"/>
		<link rel="stylesheet" href="css/oposiciones.css"/>
		<title>Oposiciones - Centros</title>
	</head>

	<body>
		<jsp:include page="header.jsp"/>

		<div class="container" id="mainContainer">
			<h1>Centros</h1>
			<table class="table table-striped table-condensed" data-toggle="table" id="tablaCentros">
				<thead>
					<tr>
						<th data-sortable="true" data-field="codigo" data-sort-name="_codigo_data" data-sorter="codigoSorter">Código</th>
						<th data-sortable="true" data-field="nombre" data-sort-name="_nombre_data" data-sorter="nombreSorter">Nombre</th>
						<th data-sortable="true" data-field="direccion" data-sort-name="_direccion_data" data-sorter="direccionSorter">Dirección</th>
						<th data-sortable="true" data-field="localidad" data-sort-name="_localidad_data" data-sorter="localidadSorter">Localidad</th>
						<th data-sortable="true" data-field="ayuntamiento" data-sort-name="_ayuntamiento_data" data-sorter="ayuntamientoSorter">Ayuntamiento</th>
						<th data-sortable="true" data-field="codigoPostal" data-sort-name="_codigoPostal_data" data-sorter="codigoPostalSorter">CP</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="centro" items="${centros}">
						<tr>
							<td class="col-xs-2" data-codigo="<c:out value="${centro.codigo}"/>"><c:out value="${centro.codigo}"/></td>
							<td class="col-xs-2" data-nombre="<c:out value="${centro.nombre}"/>"><c:out value="${centro.nombre}"/></td>
							<td class="col-xs-2" data-direccion="<c:out value="${centro.direccion}"/>"><c:out value="${centro.direccion}"/></td>
							<td class="col-xs-2" data-localidad="<c:out value="${centro.localidad.nombre}"/>"><c:out value="${centro.localidad.nombre}"/></td>
							<td class="col-xs-2" data-ayuntamiento="<c:out value="${centro.ayuntamiento.nombre}"/>"><c:out value="${centro.ayuntamiento.nombre}"/></td>
							<td class="col-xs-1" data-codigoPostal="<c:out value="${centro.codigoPostal}"/>"><c:out value="${centro.codigoPostal}"/></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<script type="text/javascript">
		function codigoSorter(a, b) {
			if (a.codigo < b.codigo) return -1;
			if (a.codigo > b.codigo) return 1;
			return 0;
		}
		function nombreSorter(a, b) {
			if (a.nombre.toUpperCase() < b.nombre.toUpperCase()) return -1;
			if (a.nombre.toUpperCase() > b.nombre.toUpperCase()) return 1;
			return 0;
		}
		function direccionSorter(a, b) {
			if (a.direccion.toUpperCase() < b.direccion.toUpperCase()) return -1;
			if (a.direccion.toUpperCase() > b.direccion.toUpperCase()) return 1;
			return 0;
		}
		function localidadSorter(a, b) {
			if (a.localidad.toUpperCase() < b.localidad.toUpperCase()) return -1;
			if (a.localidad.toUpperCase() > b.localidad.toUpperCase()) return 1;
			return 0;
		}
		function ayuntamientoSorter(a, b) {
			if (a.ayuntamiento.toUpperCase() < b.ayuntamiento.toUpperCase()) return -1;
			if (a.ayuntamiento.toUpperCase() > b.ayuntamiento.toUpperCase()) return 1;
			return 0;
		}
		function codigoPostalSorter(a, b) {
			if (a.codigopostal < b.codigopostal) return -1;
			if (a.codigopostal > b.codigopostal) return 1;
			return 0;
		}
		</script>
	</body>
</html>
