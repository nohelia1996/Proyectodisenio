<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inicio Sesion Usuario</title>
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

</head>
<body>

<div id="wrapper">
		<header id="header">
			<h1>Inicio Sesion</h1>
			<form action="ControladorValidarUsuario" method="get">
				<div class="half">
					<input type="email" id="correo" name= "correo" placeholder="Correo"/>
				</div>
				<nav>
					<ul>
						<li> <!-- <a href="ControladorValidarUsuario">Entrar</a> --> <input type="submit" value= "Entrar" class="special"/> </li>
						<li><a href="MenuInicio.jsp">Regresar</a> <!-- <input type="submit" value= "Entrar" class="special"/> --></li>
						</ul>
				</nav>
			</form>
		</header>



</div>
</body>
