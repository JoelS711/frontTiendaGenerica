<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="Ciclo3.front.vo.*"%>
<%@ page import="Ciclo3.front.controller.*"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
	crossorigin="anonymous"></script>

<title>Lista de Usuarios</title>
</head>
<body>
	<label>Lista de Usuarios</label>
	<%
	UsuariosController controller = new UsuariosController();
	controller.listarUsuario();
	ArrayList<UsuariosVO> lista = controller.getListarUsuarios();
	%>

	<table class="table table-striped">
		<th>
		<td scope="col">Cedula</td>
		<td scope="col">Nombre</td>
		<td scope="col">Correo</td>
		<td scope="col">Usuario</td>
		<td scope="col">Contrasena</td>
		</th>
		<%
		for (UsuariosVO dto : lista) {
		%>
		<tr>
			<td></td>
			<td><%=dto.getCedula()%></td>
			<td><%=dto.getNombre()%></td>
			<td><%=dto.getCorreo()%></td>
			<td><%=dto.getUsuario()%></td>
			<td><%=dto.getContrasena()%></td>
		</tr>
		<%
		}
		%>
	</table>

</body>
</html>