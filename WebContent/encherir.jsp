<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enchérir</title>
</head>
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
fieldset {
	padding-top: 5em;
	width: 500px;
	margin: auto;
}

td {
	text-align: center;
	color: red;
}

h6 {
	padding-top: 10em;
	justify-content: center;
	text-align: center;
}
</style>

<body>
<c:if test="${not empty sessionScope.userSession }">

		<nav class="navbar navbar-light" style="background-color: #e3f2fd;">
			<a class="navbar-brand" href="mainServlet"> <img src="auction.svg"
				width="30" height="30" class="d-inline-block align-top" alt="">
				Auction
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



	<form method="post" action="EncherirServlet">
		<fieldset>

			<c:forEach items="${sessionScope.descProduit}" var="item">

			
						
							${item.nom}
							
							<hr />

				<font style="color: #808080">offre de jour : </font>
				<td><font color="red">${item.price} € </font></td>
				<br>

				<font style="color: #808080">Économisez : </font>
				<td><font color="red" span=" ">10% </font>Tous les prix
					incluent la TVA.</td>
				<br>

				<hr />

				<div class="form-row" style="float: center">
					<div class="form-group col-md-6">
						<label for="inputNom"> </label>
						 <input type="text"
							class="form-control" id="inputNom"
							placeholder="Saisir votre enchére maximum" name="montant">
					</div>

				</div>

				<button type="submit" class="btn btn-danger" name="encherirbutton" value="${item.price}">Enchérir</button>


				<hr />

				<c:if test="${not empty montantVide }">

					<div class="alert alert-danger" role="alert">
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>

						<strong span=" ">sorry!</strong> ${ montantVide }
					</div>
				</c:if>

				<c:if test="${not empty chiffre }">

					<div class="alert alert-danger" role="alert">
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>

						<strong span=" ">sorry!</strong> ${ chiffre }
					</div>
				</c:if>


			</c:forEach>


			<c:if test="${not empty loose }">

				<div class="alert alert-danger" role="alert">
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>

					<strong span=" ">sorry!</strong> ${ loose }
				</div>
			</c:if>

			<c:if test="${not empty  winner }">
				<div class="alert alert-success" role="alert">
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>

					<strong span=" ">Félicitation!</strong> ${ winner }
				</div>
				<a class="btn btn-danger" href="acheter.jsp" role="button">passer la commande</a>
			</c:if>

		</fieldset>

	</form>



</body>
</html>