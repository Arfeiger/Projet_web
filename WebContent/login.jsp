
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<title>Log in</title>
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
			Auction </a>
</nav>

	<form method="post" action="LoginServlet">

		<fieldset>

			<div class="form-group">
				<label for="inputEmail1">Adresse mail</label> <input type="email"
					class="form-control" id="inputEmail1" aria-describedby="emailHelp"
					placeholder="adresse mail" name="adresse">
				<%--  <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>--%>
			</div>

			<div class="form-group">
				<label for="inputPassword1">Mot de passe </label> <input
					type="password" class="form-control" id="inputPassword1"
					placeholder="mot de passe " name="password">
			</div>

			<div class="form-group form-check">
				<input type="checkbox" class="form-check-input" id="exampleCheck1">
				<label class="form-check-label" for="exampleCheck1">Souvenir de moi
					</label>
			</div>

			<button type="submit" class="btn btn-primary">Connexion</button>

			<button type="submit" class="btn btn-primary" style="float: right"
				name="Creer">Créer un compte</button>

			<br></br>


			<c:if test="${not empty loginVide}">

				<div class="alert alert-danger" role="alert"
					style="float: inline-start">${loginVide}</div>

			</c:if>

			<c:if test="${not empty loginError}">

				<div class="alert alert-danger" role="alert"
				
					style="float: inline-start">${loginError}</div>
			</c:if>
			
			<c:if test="${ not empty panierLogin }">

				<div class="alert alert-success" role="alert">
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<strong>sorry!</strong>  veuillez connecter pour ajouter au panier
				</div>
			</c:if>

		</fieldset>

	</form>
	
	

</body>
</html>