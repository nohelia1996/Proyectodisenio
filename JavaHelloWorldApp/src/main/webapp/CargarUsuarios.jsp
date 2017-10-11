<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cargar Usuarios</title>
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
			<h1>Usuarios</h1>
				<form action="CargarUsuarios" method="get">
					<ul class="actions">
						<label for="demo-name">Nombre de la entidad</label>
						<li><input type="text" name="nombreEntidad" value="" class="special"/></li>
					</ul>
					<ul class="actions">
						<li><input type="submit" value="Cargar Usuarios" class="special"/></li>
					</ul>
				</form>
		</header>
		
		</div>
</body>
</html>