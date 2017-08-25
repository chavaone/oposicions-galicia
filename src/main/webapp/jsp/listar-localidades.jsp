<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
		<link rel="stylesheet" href="css/bootstrap.min.css"/>
		<link rel="stylesheet" href="css/bootstrap-table.css"/>
		<link rel="stylesheet" href="css/oposiciones.css"/>
		<title>Oposiciones - Localidades</title>
	</head>

	<body>
		<jsp:include page="header.jsp"/>

		<div class="container" id="mainContainer">
			<h1>Localidades</h1>
			<table class="table table-striped table-condensed" data-toggle="table" id="tablaCentros">
				<thead>
					<tr>
						<th data-sortable="true" data-field="codigo" data-sort-name="_codigo_data" data-sorter="codigoSorter">Código</th>
						<th data-sortable="true" data-field="nombre" data-sort-name="_nombre_data" data-sorter="nombreSorter">Nombre</th>
						<th data-sortable="true" data-field="ayuntamiento" data-sort-name="_ayuntamiento_data" data-sorter="ayuntamientoSorter">Ayuntamiento</th>
						<th data-sortable="true" data-field="provincia" data-sort-name="_provincia_data" data-sorter="provinciaSorter">Provincia</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="localidad" items="${localidades}">
						<tr>
							<td class="col-xs-2" data-codigo="<c:out value="${localidad.codigo}"/>"><c:out value="${localidad.codigo}"/></td>
							<td class="col-xs-4" data-nombre="<c:out value="${localidad.nombre}"/>"><c:out value="${localidad.nombre}"/></td>
							<td class="col-xs-4" data-ayuntamiento="<c:out value="${localidad.ayuntamiento.nombre}"/>"><c:out value="${localidad.ayuntamiento.nombre}"/></td>
							<td class="col-xs-2" data-provincia="<c:out value="${localidad.ayuntamiento.provincia.nombre}"/>"><c:out value="${localidad.ayuntamiento.provincia.nombre}"/></td>
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
		</script>
	</body>
</html>
