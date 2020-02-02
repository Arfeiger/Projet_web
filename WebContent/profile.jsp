<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>profile</title>
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
<body>
	<style>
fieldset {
	padding-top: 5em;
	width: 900px;
	margin: auto;
}

h6 {
	padding-top: 10em;
	justify-content: center;
	text-align: center;
}
</style>


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
	

	<ul class="nav justify-content-center">
		<li class="nav-item"><a class="nav-link active"
			href="InformatiqueServlet">High-Tech, Informatique, Bureau</a></li>
		<li class="nav-item"><a class="nav-link" href="VetementServlet">Vêtements,
				Chaussures, Bijoux</a></li>
		<li class="nav-item"><a class="nav-link" href="MusiqueServlet">Musique,
				Films et Jeux vidéo</a></li>

	</ul>
	


	<form method="get" action="profileServlet">

		<fieldset>

			<table class="table table-hover">

				<tbody>
					<tr>
						<th scope="row">Nom</th>
						<td colspan="2">${sessionScope.userSession}</td>

						<td><input class="form-control form-control-sm" type="text"
							placeholder="nouveau nom " name="nom"></td>
						<td><button type="submit" class="btn btn-primary"
								name="nomMod">Modifier</button></td>
					</tr>
					<tr>
						<th scope="row">E-mail</th>
						<td colspan="2">${sessionScope.mail}</td>
						<td><input class="form-control form-control-sm" type="text"
							placeholder="nouveau E-mail" name="mail"></td>


						<td>
							<button type="submit" class="btn btn-primary" name="mailMod">Modifier</button>
						</td>
					</tr>
					<tr>
						<th scope="row">Mot de passe</th>
						<td colspan="2">****************</td>
						<td><input class="form-control form-control-sm" type="text"
							placeholder="nouveau mot de passe " name="pass"></td>

						<td><button type="submit" class="btn btn-primary"
								name="motMod">Modifier</button></td>
					</tr>
				</tbody>
			</table>

			<c:if test="${not empty changesuc }">

				<div class="alert alert-success" role="alert">
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<strong>Success!</strong> le changement sera pris en compte lors de
					votre prochaine connexion!
				</div>
			</c:if>


			

		</fieldset>
	</form>

</body>
</html>