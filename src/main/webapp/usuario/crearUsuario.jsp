<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="Ciclo3.front.vo.*"%>
<%@ page import="Ciclo3.front.controller.*"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Men�</title>
<link rel="stylesheet" href="css/cssUsuario.css">
</head>
<body>
	<header class="header">
		<div class="container2">
			<div class="logo">
				<div class="dropdown">
					<button class="btn btn-secondary btn-sm dropdown-toggle"
						type="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false" 
						id="dropdownMenuButton"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">minombre</button>
					<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						<a class="dropdown-item" href="#"> <img
							src="./img/usuario.png" height="60" width="70" />
						</a> <a class="dropdown-item" href="#">mi uusuario</a> <a
							class="dropdown-item" href="#">mi correo</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#">Cerrar Sesion</a>

					</div>
				</div>
			</div>
			<nav class="menu">
				<ul>
					<li><a href="#">Usuarios</a>
						<ul class="submenu">
							<li><a href="/usuario/consultarUsuario.jsp">Consultar</a></li>
							<li><a href="/usuario/crearUsuario.jsp">Crear</a></li>
							<li><a href="/usuario/actualizarUsuario.jsp">Actualizar</a></li>
							<li><a href="/usuario/eliminarUsuario.jsp">Eliminar</a></li>
						</ul></li>
					<li><a href="#">Clientes</a>
						<ul class="submenu">
							<li><a href="#">Consultar</a></li>
							<li><a href="#">Crear</a></li>
							<li><a href="#">Actualizar</a></li>
							<li><a href="#">Eliminar</a></li>
						</ul></li>
					<li><a href="#">Proveedores</a>
						<ul class="submenu">
							<li><a href="#">Consultar</a></li>
							<li><a href="#">Crear</a></li>
							<li><a href="#">Actualizar</a></li>
							<li><a href="#">Eliminar</a></li>
						</ul></li>
					<li><a href="#">Productos</a></li>
					<li><a href="#">Ventas</a></li>
					<li><a href="#">Reportes</a>
						<ul class="submenu">
							<li><a href="#">Lista de Usuarios</a></li>
							<li><a href="#">Lista de Clientes</a></li>
							<li><a href="#">Venta por Cliente</a></li>
						</ul></li>

				</ul>

			</nav>

		</div>
		<div class="container col-lg-2">
			<div class="form-group text-center">
				<form action="/usuario/crearUsuario" method="POST">
					<div class="form-group text-center">
						<p style="color: white">
							<strong>CREAR USUARIO</strong>
						</p>
						<img src="./img/usuario2.png" height="120" width="120" />
					</div>
					<div class="form-group">
						<input class="form-control" type="text" name="cedula"
							id="cedula" value="${usuario.cedula}"
							placeholder="Ingrese Cedula" style="text-align: center">
					</div>

					<div class="form-group">
						<input class="form-control" type="text" name="nombre"
							id="nombre" value="${usuario.nombre}"
							placeholder="Ingrese Nombre Completo" style="text-align: center">
					</div>
					<div class="form-group">
						<input class="form-control" type="text" name="correo"
							id="correo" value="${usuario.correo}"
							placeholder="Ingrese Correo Electr�nico"
							style="text-align: center">
					</div>
					<div class="form-group">
						<input class="form-control" type="text" name="usuario"
							id="usuario" value="${usuario.usuario}"
							placeholder="Ingrese Usuario" style="text-align: center">
					</div>

					<div class="form-group">
						<input class="form-control" type="password" name="contrasena"
							id="contrasena" value="${usuario.contrasena}"
							placeholder="Ingrese Contrasena" style="text-align: center">
					</div>
					<br> <input class="btn btn-primary btn-md" type="submit"
						name="btnCrear" value="CREAR">
					<div style="color: red">${error}</div>
					<div style="color: white">${mensaje}</div>

				</form>
			</div>
		</div>

	</header>


	<div class="portada"></div>
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
</body>
</html>