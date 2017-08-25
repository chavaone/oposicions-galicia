<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
		<link rel="stylesheet" href="css/bootstrap.min.css"/>
		<link rel="stylesheet" href="css/bootstrap-table.css"/>
		<link rel="stylesheet" href="css/oposiciones.css"/>
		<title>Oposiciones - Distancias a los centros</title>
	</head>

	<body>
		<jsp:include page="header.jsp"/>

		<div class="container" id="mainContainer">
			<h1>Distancias a los Centros</h1>
			<h3>El tiempo se calcula como tiempo de conducción, sin tener en cuenta el tráfico</h3>
			<h3>La distancia se mide en kilómetros en línea recta</h3>
			<table class="table table-striped table-condensed" data-toggle="table" id="tablaDistancias">
				<thead>
					<tr>
						<th data-sortable="true" data-field="codigo" data-sort-name="_codigo_data" data-sorter="codigoSorter">Código</th>
						<th data-sortable="true" data-field="nombre" data-sort-name="_nombre_data" data-sorter="nombreSorter">Nombre</th>
						<th data-sortable="true" data-field="ayuntamiento" data-sort-name="_ayuntamiento_data" data-sorter="ayuntamientoSorter">Ayuntamiento</th>
						<th data-sortable="true" data-field="provincia" data-sort-name="_provincia_data" data-sorter="provinciaSorter">Provincia</th>
						<th data-sortable="true" data-field="tiempo" data-sort-name="_tiempo_data" data-sorter="tiempoSorter">Tiempo</th>
						<th data-sortable="true" data-field="kms" data-sort-name="_kms_data" data-sorter="kmsSorter">Distancia</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="distancia" items="${distancias}">
						<tr>
							<td class="col-xs-2" data-codigo="<c:out value="${distancia.centro.codigo}"/>"><c:out value="${distancia.centro.codigo}"/></td>
							<td class="col-xs-3" data-nombre="<c:out value="${distancia.centro.nombre}"/>"><c:out value="${distancia.centro.nombre}"/></td>
							<td class="col-xs-3" data-ayuntamiento="<c:out value="${distancia.centro.ayuntamiento.nombre}"/>"><c:out value="${distancia.centro.ayuntamiento.nombre}"/></td>
							<td class="col-xs-2" data-provincia="<c:out value="${distancia.centro.ayuntamiento.provincia.nombre}"/>"><c:out value="${distancia.centro.ayuntamiento.provincia.nombre}"/></td>
							<td class="col-xs-1" data-tiempo="<c:out value="${distancia.tiempo}"/>"><c:out value="${distancia.tiempoTexto}"/></td>
							<td class="col-xs-1" data-kms="<c:out value="${distancia.kms}"/>"><c:out value="${distancia.kms}"/> kms</td>
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
		function ayuntamientoSorter(a, b) {
			if (a.ayuntamiento.toUpperCase() < b.ayuntamiento.toUpperCase()) return -1;
			if (a.ayuntamiento.toUpperCase() > b.ayuntamiento.toUpperCase()) return 1;
			return 0;
		}
		function provinciaSorter(a, b) {
			if (a.provincia.toUpperCase() < b.provincia.toUpperCase()) return -1;
			if (a.provincia.toUpperCase() > b.provincia.toUpperCase()) return 1;
			return 0;
		}
		function tiempoSorter(a, b) {
			if (a.tiempo < b.tiempo) return -1;
			if (a.tiempo > b.tiempo) return 1;
			return 0;
		}
		function kmsSorter(a, b) {
			if (a.kms < b.kms) return -1;
			if (a.kms > b.kms) return 1;
			return 0;
		}
		</script>
	</body>
</html>
