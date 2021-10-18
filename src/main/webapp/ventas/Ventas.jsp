<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="Ciclo3.front.vo.*"%>
<%@ page import="java.util.*"%>
<%@ page import="Ciclo3.front.controller.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Menú</title>
<link rel="stylesheet" href="css/cssVentas.css">
</head>
<body>
	<header class="header">
		<div class="container2">
			<div class="logo">
				<div class="dropdown">
					<button class="btn btn-secondary btn-sm dropdown-toggle"
						type="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false" "
						id="dropdownMenuButton"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">mi
						nombre</button>
					<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						<a class="dropdown-item" href="#"> <img
							src="./img/usuario.png" height="60" width="70" />
						</a> <a class="dropdown-item" href="#">miusuario</a> <a
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
							<li><a href="/reportes/ventaClientes.jsp">Venta por Cliente</a></li>
						</ul></li>

				</ul>

			</nav>

		</div>
		<div class="neta">
			<br> <br> <br> <br> <br> <br>
			<div class="formulario-login">
				<div class="formulario1">
					<form action="/ventas/Ventas" method="POST">

						<h5>VENTAS</h5>
						<br /> <input class="controls" type="text" name="cedula"
							id="cedula" value="${cliente.cedula}"
							placeholder=" Cédula del cliente"> &nbsp; <input
							class="boton" type="submit" name="" value="CONSULTAR">
						&nbsp; <input class="controls1" type="text" name="nombre"
							value="${cliente.nombre}"
							placeholder="Aparecera el Nombre del Usuario">
						<p>
						<div style="color: red">${error}</div>
						</p>
						<br> <br>
					</form>

				</div>
				<br />
				<div class="formulario2">
					<form action="/ventas/VentasFinal" method="POST">
						
						<br />
						<div class="hijo">

							<input class="venta1" type="text" name="codProducto1"
								id="codProducto1" value="${producto.codigoProducto}"
								placeholder=" Codigo Producto">&nbsp; <input
								class="boton" type="submit" name="" value="CONSULTAR">&nbsp;
							<input class="venta2" type="text" name="nombreProducto1"
								value="${producto.nombreProducto}"
								placeholder="Nombre del producto">&nbsp; <input
								class="venta3" type="text" name="cantidad1"
								value="${producto.cantidad}" placeholder="Cant.">&nbsp;
							&nbsp; &nbsp; <input class="venta4" type="text"
								name="nombreProducto1" value="${producto.precioVenta}"
								placeholder="Precio"> <br> <input class="venta1"
								type="text" name="codProducto1" id="codProducto1"
								value="${producto.codigoProducto}"
								placeholder=" Codigo Producto">&nbsp; <input
								class="boton" type="submit" name="" value="CONSULTAR">&nbsp;
							<input class="venta2" type="text" name="nombreProducto1"
								value="${producto.nombreProducto}"
								placeholder="Nombre del producto">&nbsp; <input
								class="venta3" type="text" name="cantidad2"
								value="${producto.cantidad}" placeholder="Cant.">&nbsp;
							&nbsp; &nbsp; <input class="venta4" type="text"
								name="nombreProducto1" value="${producto.precioVenta}"
								placeholder="Precio"> <br> <input class="venta1"
								type="text" name="codProducto1" id="codProducto1"
								value="${producto.codigoProducto}"
								placeholder=" Codigo Producto">&nbsp; <input
								class="boton" type="submit" name="" value="CONSULTAR">&nbsp;
							<input class="venta2" type="text" name="nombreProducto1"
								value="${producto.nombreProducto}"
								placeholder="Nombre del producto">&nbsp; <input
								class="venta3" type="text" name="cantidad3"
								value="${producto.cantidad}" placeholder="Cant.">&nbsp;
							&nbsp; &nbsp; <input class="venta4" type="text"
								name="nombreProducto1" value="${producto.precioVenta}"
								placeholder="Precio"> <br> <br>
						</div>
						<div class="hijo2">
							<input class="venta5" type="text" name="nombreProducto1"
								value="${producto.precioVenta}" placeholder="Total Venta">
							<br> <input class="venta5" type="text"
								name="nombreProducto1" value="${producto.precioVenta}"
								placeholder="Total Iva"> <br> <input class="venta5"
								type="text" name="nombreProducto1"
								value="${producto.precioVenta}" placeholder="Total con IVA">
							<br>
						</div>
						<div class="bo">
						<input
							class="boton" type="submit" name="" value="CONFIRMAR">
						</div>

					</form>

				</div>
			</div>
		</div>
	
	</header>
</body>
</html>