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
<link rel="stylesheet" href="css/cssCliente.css">
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
							<li><a href="/cliente/consultarCliente.jsp">Consultar</a></li>
							<li><a href="/cliente/crearCliente.jsp">Crear</a></li>
							<li><a href="/cliente/actualizarCliente.jsp">Actualizar</a></li>
							<li><a href="/cliente/eliminarCliente.jsp">Eliminar</a></li>
						</ul></li>
					<li><a href="#">Proveedores</a>
						<ul class="submenu">
							<li><a href="/proveedor/consultarProveedor.jsp">Consultar</a></li>
							<li><a href="/proveedor/crearProveedor.jsp">Crear</a></li>
							<li><a href="/proveedor/actualizarProveedor.jsp">Actualizar</a></li>
							<li><a href="/proveedor/eliminarProveedor.jsp">Eliminar</a></li>
						</ul></li>
					<li><a href="/producto/cargarProducto.jsp">Productos</a></li>
					<li><a href="/ventas/Ventas.jsp">Ventas</a></li>
					<li><a href="#">Reportes</a>
						<ul class="submenu">
							<li><a href="/reportes/listarUsuarios.jsp">Lista de Usuarios</a></li>
							<li><a href="/reportes/listarClientes.jsp">Lista de Clientes</a></li>
							<li><a href="/reportes/ventaCliente.jsp">Venta por Cliente</a></li>
						</ul></li>

				</ul>

			</nav>

		</div>
		<div class="container col-lg-2">
			<div class="form-group text-center">
				<form action="/cliente/crearCliente" method="POST">
					<div class="form-group text-center">
						<p style="color:white">
							<strong>CREAR CLIENTE</strong>
						</p>
						<img src="./img/usuario2.png" height="80" width="80" />
					</div>
					<div class="form-group">
						<input class="form-control" type="text" name="cedula"
							id="cedula" value="${cliente.cedula}"
							placeholder="Ingrese C�dula" style="text-align: center">
					</div>
					
					<div class="form-group">
						<input class="form-control" type="text" name="nombre"
							id="nombre" value="${cliente.nombre}"
							placeholder="Ingrese Nombre Completo" style="text-align: center">
					</div>
					
					<div class="form-group">
						<input class="form-control" type="text" name="direccion"
							id="direccion" value="${cliente.direccion}"
							placeholder="Ingrese Direcci�n" style="text-align: center">
					</div>
					
					<div class="form-group">
						<input class="form-control" type="text" name="telefono"
							id="telefono" value="${cliente.telefono}"
							placeholder="Ingrese N�mero de Tel�fono" style="text-align: center">
					</div>
					
					<div class="form-group">
						<input class="form-control" type="text" name="correo"
							id="correo" value="${cliente.correo}"
							placeholder="Ingrese Correo Electr�nico"
							style="text-align: center">
					</div>
					<br>
					<div>
					<input class="btn btn-primary btn-md" type="submit"
						name="btnActualizar" value="CREAR" >
					</div>
					<br/>
					<div style="color: white">${mensaje}</div>
					<div style="color: red"><b>${error}</b></div>
				</form>
			</div>
	</div>

	</header>
	</body>
</html>