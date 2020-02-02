<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@  page import="java.util.*"%>

<%@  page import="beans.*"%>

<%@  page import="Dao.*"%>

<%@  page import="java.sql.ResultSet"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Musique</title>
</head>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>


<style>
* {
	box-sizing: border-box;
	-moz-box-sizing: border-box;
}

body {
	background: #E8E8E8;
	font-family: Calluna, Arial, sans-serif;
	min-height: 1000px;
}

#wrap {
	width: 90%;
	max-width: 1100px;
	margin: 50px auto;
}

.columns_2 figure {
	width: 49%;
	margin-right: 1%;
}

.columns_2 figure:nth-child(2) {
	margin-right: 0;
}

.columns_3 figure {
	width: 32%;
	margin-right: 1%;
}

.columns_3 figure:nth-child(3) {
	margin-right: 0;
}

.columns_4 figure {
	width: 24%;
	margin-right: 1%;
}

.columns_4 figure:nth-child(4) {
	margin-right: 0;
}

.columns_5 figure {
	width: 19%;
	margin-right: 1%;
}

.columns_5 figure:nth-child(5) {
	margin-right: 0;
}

#columns figure:hover {
	-webkit-transform: scale(1.1);
	-moz-transform: scale(1.1);
	transform: scale(1.1);
}

#columns








:hover





 





figure










:not





 





(
:hover





 





)
{
opacity










:





 





0
.4










;
}
div#columns figure {
	display: inline-block;
	background: #FEFEFE;
	border: 2px solid #FAFAFA;
	box-shadow: 0 1px 2px rgba(34, 25, 25, 0.4);
	margin: 0 0px 15px;
	-webkit-column-break-inside: avoid;
	-moz-column-break-inside: avoid;
	column-break-inside: avoid;
	padding: 15px;
	padding-bottom: 5px;
	background: -webkit-linear-gradient(45deg, #FFF, #F9F9F9);
	opacity: 1;
	-webkit-transition: all .3s ease;
	-moz-transition: all .3s ease;
	-o-transition: all .3s ease;
	transition: all .3s ease;
}

div#columns figure img {
	width: 100%;
	border-bottom: 1px solid #ccc;
	padding-bottom: 15px;
	margin-bottom: 5px;
}

div#columns figure figcaption {
	font-size: .9rem;
	color: #444;
	line-height: 1.5;
	height: 60px;
	font-weight: 600;
	text-overflow: ellipsis;
}

a.button {
	padding: 10px;
	background: salmon;
	margin: 10px;
	display: block;
	text-align: center;
	color: #fff;
	transition: all 1s linear;
	text-decoration: none;
	text-shadow: 1px 1px 3px rgba(0, 0, 0, 0.3);
	border-radius: 3px;
	border-bottom: 3px solid #ff6536;
	box-shadow: 1px 1px 3px rgba(0, 0, 0, 0.3);
}

a.button:hover {
	background: #ff6536;
	border-bottom: 3px solid salmon;
	color: #f1f2f3;
}

@media screen and (max-width: 960px) {
	#columns figure {
		width: 24%;
	}
}

@media screen and (max-width: 767px) {
	#columns figure {
		width: 32%;
	}
}

@media screen and (max-width: 600px) {
	#columns figure {
		width: 49%;
	}
}

@media screen and (max-width: 500px) {
	#columns figure {
		width: 100%;
	}
}
</style>

<body>

	<c:if test="${empty sessionScope.userSession }">

		<nav class="navbar navbar-light" style="background-color: #e3f2fd;">
			<a class="navbar-brand" href="mainServlet"> <img
				src="auction.svg" width="30" height="30"
				class="d-inline-block align-top" alt=""> Auction
			</a>

			<ul class="nav justify-content-end">
				<li class="nav-item"><a class="nav-link active"
					href="login.jsp"><img src="icons8-user-50.png" width="20"
						height="20" class="d-inline-block align-top" alt=" "> Me
						connecter </a></li>
			</ul>
		</nav>
	</c:if>
	<c:if test="${not empty sessionScope.userSession }">

		<nav class="navbar navbar-light" style="background-color: #e3f2fd;">
			<a class="navbar-brand" href="mainServlet"> <img
				src="auction.svg" width="30" height="30"
				class="d-inline-block align-top" alt=""> Auction
			</a>
			<ul class="nav justify-content-end">
				<li class="nav-item"><a class="nav-link active"
					href="profile.jsp"><img src="icons8-user-50.png" width="20"
						height="20" class="d-inline-block align-top" alt=" ">
						${sessionScope.userSession } </a></li>
				<li class="nav-item"><a class="nav-link" href="PanierServlet">Panier</a></li>
				<li class="nav-item"><a class="nav-link" href="LogoutServlet">Déconnecter</a></li>

			</ul>

		</nav>
	</c:if>

	<ul class="nav justify-content-center">
		<li class="nav-item"><a class="nav-link active"
			href="InformatiqueServlet">High-Tech, Informatique, Bureau</a></li>
		<li class="nav-item"><a class="nav-link" href="VetementServlet">Vêtements,
				Chaussures, Bijoux</a></li>
		<li class="nav-item"><a class="nav-link" href="MusiqueServlet">Musique,
				Films et Jeux vidéo</a></li>

	</ul>

	<br>
	<c:if test="${not empty sessionScope.panierSucc }">

				<div class="alert alert-success" role="alert">
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<strong>Success!</strong> le produit a été ajouter au panier
				</div>
			</c:if>

	<form method="post" action="MusiqueServlet">
	
	<div id="wrap">
		<div id="columns" class="columns_4">
			<c:forEach items="${list}" var="item">

				<figure>
					<img src="${item.path}" height="250" width="150">
					<figcaption>${item.nom}</figcaption>
					<span class="price">${item.price}</span>
					<button type="submit"  class="btn btn-primary btn-lg btn-block"
						name="panier" value="${item.id}">Ajouter au Panier</button>

				</figure>
			</c:forEach>
		</div>
	</div>

</form>

</body>
</html>