<!DOCTYPE html>
<html>
<head>
<title>PedidosYa | Iniciar Sesion</title>
<!-- COMIENZO ESTILOS CSS-->
<link rel='stylesheet prefetch'
	href='${request.contextPath}/pedidosYa/css/bootstrap.min.css'>
<link href="${request.contextPath}/pedidosYa/css/loginIndexStyle.css"
	rel="stylesheet">
<!-- FIN ESTILOS CSS-->
</head>
<body>

	<div class="wrapper">
		<g:form controller="login" action="login" name="formUserLogin"
			class="form-signin">

			<h2 class="form-signin-heading">PedidosYa</h2>

			<g:field type="text" id="email" name="email" class="form-control"
				placeholder="Email" required="" autofocus="" />

			<g:passwordField name="password" class="form-control"
				placeholder="Contraseña" required="" />

			<button class="btn btn-lg btn-primary btn-block" type="submit">Iniciar
				Sesion</button>

		</g:form>
		<g:if test="${params.appAuthenticateFailed == 'true'}">

			<div class="alert alert-danger alert-error">
				<strong> Ha ocurrido un error al intentar acceder al sitio.</strong>
			</div>

		</g:if>
	</div>

</body>
</html>