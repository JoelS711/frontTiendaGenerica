<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Menú</title>
<link rel="stylesheet" href="css/InicioEstilo.css">
</head>
<body>
	<header class="header">
		<div class="container2">
			<div class="logo">
				<div class="dropdown">
					<button class="btn btn-secondary btn-sm dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false""
						id="dropdownMenuButton" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">${usuario.nombre}</button>
					<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						<a class="dropdown-item" href="#"> <img
							src="./img/usuario.png" height="60" width="70" />
						</a> <a class="dropdown-item" href="#">${usuario.usuario}</a> <a
							class="dropdown-item" href="#">${usuario.correo}</a>
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
							<li><a href="/cliente/actualizarCliente.jsp">Actualizar</a></li>
							<li><a href="#">Eliminar</a></li>
						</ul></li>
					<li><a href="#">Proveedores</a>
						<ul class="submenu">
							<li><a href="#">Consultar</a></li>
							<li><a href="#">Crear</a></li>
							<li><a href="#">Actualizar</a></li>
							<li><a href="#">Eliminar</a></li>
						</ul></li>
					<li><a href="/producto/cargarProducto.jsp">Productos</a></li>
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
		<div></div>

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