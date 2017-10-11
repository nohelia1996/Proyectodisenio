<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import= "java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ver Salas</title>
</head>
	<LINK REL="StyleSheet" HREF="assets/css/main.css" TYPE="text/css" MEDIA=screen>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, shrink-to-fit=no, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Bootstrap Core CSS -->
    <link href="bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="simple-sidebar.css" rel="stylesheet">
    <script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>
<body>

		<div id="wrapper">
		<header id="header">
			<h1>Temas</h1>
				<form action="CargarSalas" method="get">
					<ul class="actions">
						<li><input type="submit" value="Cargar Información Salas" class="special"/></li>
					</ul>
				</form>
		</header>
		<tr>
 			<th>Id Sala</th>
 			<th>Nombre de la sala</th> 
 			<th>Capacidad</th> 
 			<th>Descripción</th>
 			</tr>
		<form action="CargarSalas" method = "get">
			 
			<%
				ArrayList<String> listaSala = (ArrayList<String>) request.getAttribute("listaSala");
			%>
			
			<select id="listaSalas" name="listaSalas">
				<%
					for(int i=0; i<listaSala.size();i++){ 
						String sala = listaSala.get(i);
						%>
						
						<option value="<%=sala%>"><%=sala%></option>
						<%	
					}
				%>
			</select>
			
		</form>
		
	</div>

</body>
</html>