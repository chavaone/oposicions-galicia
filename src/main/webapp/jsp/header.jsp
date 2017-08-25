<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-inverse">
	<div class="container" id="mainContainer">
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="calcular-distancias-centros">Calcular distancias</a></li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">Listas <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="listar-centros">Centros</a></li>
						<li><a href="listar-localidades">Localidades</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">Carto <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="carto-centros">Centros de Educación Secundaria</a></li>
						<li><a href="carto-plazas">Plazas adjudicadas CADP Matemáticas</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</nav>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-table.js"></script>
