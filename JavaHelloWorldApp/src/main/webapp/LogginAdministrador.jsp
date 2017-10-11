<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modulo Administrativo</title>
<LINK REL="StyleSheet" HREF="assets/css/main.css" TYPE="text/css"
	MEDIA=screen>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, shrink-to-fit=no, initial-scale=1">
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
			<form action="ControladorValidarAdministrador" method="get">
				<div class="field half first">
					<input type="email" name="correo" />
				</div>
				<div class="field half first">
					<input type="password" name="password" />
				</div>
				<nav>
					<ul>
						<li>
							<!-- <a href="ControladorValidarAdministrador">Entrar</a> --> <input
							type="submit" value="Entrar" class="special" />
						</li>
						<li><a href="VentanaPrincipal.jsp">Regresar</a> <!-- <input type="submit" value= "Entrar" class="special"/> --></li>
					</ul>
				</nav>
			</form>
		</header>
	</div>
</body>


<style>
/* reset css */
div, span, applet, object, iframe, blockquote, pre, a, abbr, acronym,
	address, big, cite, code, del, dfn, em, img, ins, kbd, q, s, samp,
	small, strike, strong, sub, sup, tt, var, b, u, i, center, dl, dt, dd,
	ol, ul, li, fieldset, form, label, legend, table, caption, tbody, tfoot,
	thead, tr, th, td, article, aside, canvas, details, embed, figure,
	figcaption, footer, header, hgroup, menu, nav, output, ruby, section,
	summary, time, mark, audio, video {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	font: inherit;
	vertical-align: baseline
}

article, aside, details, figcaption, figure, footer, header, hgroup,
	menu, nav, section {
	display: block
}

body {
	line-height: 1
}

ol, ul {
	list-style: none
}

blockquote, q {
	quotes: none
}

blockquote:before, blockquote:after, q:before, q:after {
	content: '';
	content: none
}

table {
	border-collapse: collapse;
	border-spacing: 0
}

a {
	text-decoration: none;
}

/**
 * Hidden fallback
 */

/**
 * Styling navigation
 */
header {
	margin-right: auto;
	margin-left: auto;
	max-width: 22.5rem;
	margin-top: 150px;
	box-shadow: 0 3px 12px rgba(0, 0, 0, 0.25);
}

/**
 * Styling top level items
 */
.nav a, .nav label {
	display: block;
	padding: .85rem;
	color: #fff;
	background-color: #151515;
	box-shadow: inset 0 -1px #1d1d1d;
	-webkit-transition: all .25s ease-in;
	transition: all .25s ease-in;
}

.nav a:focus, .nav a:hover, .nav label:focus, .nav label:hover {
	color: rgba(255, 255, 255, 0.5);
	background: #030303;
}

.nav label {
	cursor: pointer;
}

/**
 * Styling first level lists items
 */
.group-list a, .group-list label {
	padding-left: 2rem;
	background: #252525;
	box-shadow: inset 0 -1px #373737;
}

.group-list a:focus, .group-list a:hover, .group-list label:focus,
	.group-list label:hover {
	background: #131313;
}

/**
 * Styling second level list items
 */
.sub-group-list a, .sub-group-list label {
	padding-left: 4rem;
	background: #353535;
	box-shadow: inset 0 -1px #474747;
}

.sub-group-list a:focus, .sub-group-list a:hover, .sub-group-list label:focus,
	.sub-group-list label:hover {
	background: #232323;
}

/**
 * Styling third level list items
 */
.sub-sub-group-list a, .sub-sub-group-list label {
	padding-left: 6rem;
	background: #454545;
	box-shadow: inset 0 -1px #575757;
}

.sub-sub-group-list a:focus, .sub-sub-group-list a:hover,
	.sub-sub-group-list label:focus, .sub-sub-group-list label:hover {
	background: #333333;
}

/**
 * Hide nested lists
 */
.group-list, .sub-group-list, .sub-sub-group-list {
	height: 100%;
	max-height: 0;
	overflow: hidden;
	-webkit-transition: max-height .5s ease-in-out;
	transition: max-height .5s ease-in-out;
}

.nav__list input[type=checkbox]:checked+label+ul {
	/* reset the height when checkbox is checked */
	max-height: 1000px;
}

/**
 * Rotating chevron icon
 */
label>span {
	float: right;
	-webkit-transition: -webkit-transform .65s ease;
	transition: transform .65s ease;
}

.nav__list input[type=checkbox]:checked+label>span {
	-webkit-transform: rotate(90deg);
	-ms-transform: rotate(90deg);
	transform: rotate(90deg);
}
</style>



</html>