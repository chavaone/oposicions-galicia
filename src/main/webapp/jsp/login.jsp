<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
		<link rel="stylesheet" href="css/bootstrap.min.css"/>
		<link rel="stylesheet" href="css/bootstrap-table.css"/>
		<link rel="stylesheet" href="css/capitales.css"/>
		<title>Capitales - Login</title>
	</head>

	<body>
		<jsp:include page="header.jsp"/>

		<div class="container" id="mainContainer">
			<c:if test="${not empty error}">
				<div class="alert alert-danger"><span class="glyphicon glyphicon-exclamation-sign"></span> <c:out value="${error}"/></div>
			</c:if>
			<h1>Login</h1>
			<h2>Login con Facebook</h2>
			<div class="text-center">
				<!-- TODO PRO -->
 				<a href="https://www.facebook.com/dialog/oauth?client_id=409113142785407&redirect_uri=https://capitales-perseofic.rhcloud.com/login" class="btn btn-primary btn-lg">Login con Facebook</a>
				<!--<a href="https://www.facebook.com/dialog/oauth?client_id=409113142785407&redirect_uri=http://localhost:8080/Capitales/login" class="btn btn-primary btn-lg">Login con Facebook</a>-->
			</div>
		</div>
	</body>
</html>
