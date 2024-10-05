<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html data-bs-theme="dark">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="res/css/estilo.css">
</head>
<body>

	<!-- Navbar o cualquier otra parte de tu página -->
	<%@ include file='navbar.jsp'%>

	<div class="contenedorLogin">
		<section class="vh-99 gradient-custom bg-gradient">
			<div class="container py-5">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-12 col-md-8 col-lg-6 col-xl-5">
						<div class="card bg-dark text-white" style="border-radius: 1rem;">
							<div class="card-body p-5 text-center">

								<div class="mb-md-5 mt-md-4 pb-5">

									<h2 class="fw-bold mb-2 text-uppercase">Inicio de sesión</h2>
									<p class="text-white-50 mb-5">Por favor ingresa tu nombre
										de usuario y tu contraseña</p>

									<!-- Formulario de inicio de sesión -->
									<form action="/sprintFinal/login" method="post">

										<div data-mdb-input-init class="form-outline form-white mb-4">
											<input type="text" id="nickname" name="nickname"
												class="form-control form-control-lg" required /> <label
												class="form-label" id="nickname">Nombre de usuario</label>

										</div>

										<div data-mdb-input-init class="form-outline form-white mb-4">
											<input type="password" id="contrasena" name="contrasena"
												class="form-control form-control-lg" required /> <label
												class="form-label" for="contrasena">Contraseña</label>
										</div>

										<p class="small mb-5 pb-lg-2">
											<a class="text-white-50" href="#!">Olvidaste tu
												contraseña?</a>
										</p>

										<button data-mdb-button-init data-mdb-ripple-init
											class="btn btn-outline-light" type="submit">Ingresar</button>
									</form>
									<br>
									<%
									String error = (String) request.getAttribute("error");
									if (error != null && error.equals("true")) {
									%>
									<div class="error-message">
										<strong>Error:</strong>
										<p>Error de autenticación.</p>
									</div>
									<%
									}
									%>

									<%-- 									<form class="form-signin" method="post"
										action="/grupal071/login"
										style="width: 300px; margin-top: 20px;">
										<%
										String error = (String) request.getAttribute("error");
										if (error != null && error.equals("true")) {
											out.println("<h2 class='alert alert-danger'>Error de Autenticacion</h2>");

										}
										%>
										<h2 class="form-signin-heading">Bienvenido</h2>
										<p>
											<input type="text" id="nickname" name="nickname"
												class="form-control" placeholder="Usuario" required=""
												autofocus="">
										</p>
										<p>
											<input type="contrasena" id="contrasena" name="contrasena"
												class="form-control" placeholder="Contraseña" required="">
										</p>
										<input name="_csrf" type="hidden"
											value="ca6e67f7-f585-4240-bb67-87fd4f13c651">
										<button class="btn btn-lg btn-primary btn-block" type="submit"
											style="width: 100%;">Ingresar</button>
									</form> --%>

								</div>

								<div>
									<p class="mb-0">
										No tienes una cuenta? <a href="#!"
											class="text-white-50 fw-bold">Regístrate</a>
									</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
		<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
