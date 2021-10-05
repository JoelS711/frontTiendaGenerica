<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="Ciclo3.front.vo.*"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/estiloscss.css" rel="stylesheet" type="text/css" />
<meta charset="ISO-8859-1">
<title>Tienda</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body style="background: url(./img/desk.jpg); background-size: cover">
	<div class="container col-lg-3">
		<div class="form-group text-center">
			<form action="/auth" method="POST">
				<div class="form-group text-center">
					<p style="color: white">
						<strong>Bienvenidos a la tienda generica</strong>
					</p>
					<img src="./img/Imagen2.png" height="180" width="240" />
				</div>
				<div class="form-group">
					<input class="form-control" type="text" name="usuario" id="usuario"
						value="${usuario.usuario}" placeholder="Ingrese usuario">
				</div>

				<div class="form-group">
					<input class="form-control" type="password" name="contrasena"
						id="contrasena" value="${usuario.contrasena}"
						placeholder="Ingrese contraseña">
				</div>
				<input class="btn btn-primary btn-block" type="submit" name="accion"
					value="Ingresar">
<%-- 				<c:choose> --%>
<%-- 					<c:when test="${usuario.contraseña != null}"> --%>
<%-- 						<label>Bienvenido, ${usuario.nombre}</label> --%>
<%-- 						<label>Su rol es: ${usuario.rol}</label> --%>
<%-- 					</c:when> --%>
<%-- 				</c:choose> --%>
				<div style="color: red">${error}</div>
				<%-- 						<div style="color: red">${error}</div> --%>

			</form>
		</div>
	</div>



	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>

<%-- 	<c:choose> --%>
<%-- 		<c:when test="${usuario.contraseña != null}"> --%>
<%-- 			<label>Bienvenido, ${usuario.nombre}</label> --%>
<%-- 			<label>Su rol es: ${usuario.rol}</label> --%>
<%-- 		</c:when> --%>
<%-- 	</c:choose> --%>
<%-- 	<div style="color: red">${error}</div> --%>
</body>
</html>