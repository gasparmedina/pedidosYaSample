<!DOCTYPE html>
<html>
<head>
<title>Bienvenido a PedidosYa</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="generator" content="Bootply" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<!-- COMIENZO ESTILOS CSS-->
<link rel='stylesheet prefetch'
	href='${request.contextPath}/pedidosYa/css/bootstrap.min.css'>
<link href="${request.contextPath}/pedidosYa/css/stylesContent.css"
	rel="stylesheet">
<!-- FIN ESTILOS CSS-->
</head>
<body>
	<!-- COMIENZO NAVBAR-->
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">

		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>

		<div class="collapse navbar-collapse">
			<g:if test="${session.userAccountResponse}">
				<div class="navbar-text">
					Bienvenido
					${session.userAccountResponse.name}
					${session.userAccountResponse.lastName}
				</div>
			</g:if>
			<div class="col-sm-3 col-md-3 pull-right">
				<div class="navbar-text  pull-right">
					<g:link style="color:blank;" controller="pedidosYa" action="logout">Cerrar Sesion</g:link>
				</div>
			</div>
		</div>
	</div>
	<!-- FIN NAVBAR-->
	<!-- COMIENZO CONTENT CONTAINER-->
	<div class="container">

		<div class="text-center">
			<h1>Restaurantes</h1>

			<g:form controller="user" action="content" name="formUserLogin"
				class="form-signin">

				<div class="col-xs-3"></div>

				<div class="col-xs-2">
					<g:field type="text" name="latitud" class="form-control"
						placeholder="Latitud" required="" autofocus="" />
				</div>
				<div class="col-xs-2">
					<g:field type="text" name="Longitud" class="form-control"
						placeholder="Latitud" required="" autofocus="" />

				</div>
				<div class="col-xs-2">
					<button class="btn  btn-primary btn-block" type="submit">Buscar</button>
				</div>

			</g:form>

			<br> <br> <br>


			<g:if test="${params.restaurantsNotFound == 'true'}">
				<div class="col-lg-3"></div>
				<div class="col-lg-6">
					<div class="alert alert-danger alert-error">
						<strong> No se han encontrado restaurantes para mostrar.
							Intentelo con otra ubicaci&oacute;n.</strong>
					</div>
				</div>
			</g:if>



			<g:each in="${restaurants}" var="restaurant" status="i">
				<div class="container">
					<div class="row">
						<div class="col-lg-2"></div>
						<div class="col-lg-3" style="background-color: blank;">
							<img src="${restaurant.logo}" alt="" />
						</div>
						<div class="col-lg-4" style="background-color: blank;">
							<label>Nombre: ${restaurant.name}</label> <br> <label>Categoria:
								${restaurant.topCategories}
							</label> <br> <label>Rating: ${restaurant.ratingScore}</label> <br>
							<g:if test="${restaurant.deliveryTimeMaxMinutes < 60}">
								<label>Tiempo de entrega: ${restaurant.deliveryTimeMaxMinutes}
									minutos
								</label>
							</g:if>
							<g:if
								test="${restaurant.deliveryTimeMaxHours == 1 && restaurant.deliveryTimeMaxHoursMinutes == 0 }">
								<label>Tiempo de entrega: ${restaurant.deliveryTimeMaxHours}
									hora
								</label>
							</g:if>
							<g:if
								test="${restaurant.deliveryTimeMaxHours == 1 && restaurant.deliveryTimeMaxHoursMinutes > 0 }">
								<label>Tiempo de entrega: ${restaurant.deliveryTimeMaxHours}
									hora y ${restaurant.deliveryTimeMaxHoursMinutes} minutos
								</label>
							</g:if>
							<g:if
								test="${restaurant.deliveryTimeMaxHours > 1 && restaurant.deliveryTimeMaxHoursMinutes > 0 }">
								<label>Tiempo de entrega: ${restaurant.deliveryTimeMaxHours}
									horas y ${restaurant.deliveryTimeMaxHoursMinutes} minutos
								</label>
							</g:if>
							<g:if
								test="${restaurant.deliveryTimeMaxHours > 1 && restaurant.deliveryTimeMaxHoursMinutes == 0 }">
								<label>Tiempo de entrega: ${restaurant.deliveryTimeMaxHours}
									horas
								</label>
							</g:if>
							<br> <a href="${restaurant.link}">Hacer un pedido</a>
						</div>
						<div class="col-lg-4"></div>
					</div>
				</div>
				<br>
				<br>
				<br>
			</g:each>
		</div>

	</div>
	<!-- FIN NAVBAR-->

	<script src="${request.contextPath}/pedidosYa/js/bootstrap.min.js"></script>
	<script src="${request.contextPath}/pedidosYa/js/jquery.min.js"></script>

</body>
</html>