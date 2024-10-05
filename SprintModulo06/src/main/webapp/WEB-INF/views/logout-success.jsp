<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es" data-bs-theme="dark">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Sesión cerrada</title>
<!-- Redirección automática después de 5 segundos -->
<meta http-equiv="refresh" content="3;url=./">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="res/css/estilo.css">
<!-- Importar script.js -->
<script src="res/js/countdown.js"></script>
</head>
<body>
	<div class="logout-page bg-gradient">
		<div class="logout-card text-center">
			<h2>Has cerrado sesión correctamente.</h2>
			<p>Serás redirigido a la página principal en <span id="countdown">3</span> segundos...</p>
			<p>Si no ocurre automáticamente, <a href="./">haz clic aquí</a>.</p>
		</div>
	</div>
</body>
</html>
