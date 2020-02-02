<%--
  Created by IntelliJ IDEA.
  User: khalef
  Date: 17/03/19
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Create account</title>

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

<body>


	<style>
fieldset {
	padding-top: 10em;
	width: 400px;
	margin: auto;
}
</style>

	<nav class="navbar navbar-light" style="background-color: #e3f2fd;">
		<a class="navbar-brand" href="mainServlet"> <img src="auction.svg"
			width="30" height="30" class="d-inline-block align-top" alt="">
			Auction
		</a>
	</nav>


	<form method="post" action="CreateServlet">

		<fieldset>


			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="inputNom">Nom</label> <input type="text"
						class="form-control" id="inputNom" placeholder="nom" name="nom">
				</div>
				<div class="form-group col-md-6">
					<label for="inputPrenom">Prénom</label> <input type="text"
						class="form-control" id="inputPrenom" placeholder="prénom"
						name="prenom">
				</div>
			</div>


			<div class="form-group">
				<label for="inputEmail">Adresse mail</label> <input type="email"
					class="form-control" id="inputEmail" aria-describedby="emailHelp"
					placeholder="adresse mail " name="adresse">
				<%--  <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>--%>
			</div>

			<div class="form-group">
				<label for="inputPassword">Mot de passe </label> <input
					type="password" class="form-control" id="inputPassword"
					placeholder="mot de passe " name="password"> <small
					id="emailHelp" class="form-text text-muted">Utilisez au
					moins huit caractères avec des lettres, des chiffres et des
					symboles.</small>

			</div>


			<button type="submit" class="btn btn-primary" name="valider">Valider</button>
			<button type="submit" class="btn btn-link" style="float: right" name="compteExist">Se connecter à un compte existant</button>

			<br></br>

			<c:if test="${not empty loginVide}">

				<div class="alert alert-danger" role="alert"
					style="float: inline-start">${loginVide}</div>

			</c:if>

			<c:if test="${not empty succes}">

				<div class="alert alert-success" role="alert">
					Félicitations ! Votre nouveau compte a été créé avec succès ! <span aria-hidden="true">&times;</span>
				</div>

			</c:if>

		</fieldset>

	</form>

</body>
</html>