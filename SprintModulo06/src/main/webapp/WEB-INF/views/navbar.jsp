<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="org.springframework.security.core.Authentication"%>
<%@ page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page import="org.springframework.security.core.GrantedAuthority"%>
<!DOCTYPE html>
<html lang="es" data-bs-theme="dark">
<head>
<meta charset="UTF-8">
<title>Navbar</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Tu archivo de estilos personalizado -->
<link rel="stylesheet" type="text/css" href="<c:url value='/res/css/estilo.css'/>">
</head>

<%
Authentication auth = SecurityContextHolder.getContext().getAuthentication();
boolean isCliente = false;
boolean isAdministrativo = false;
boolean isProfesional = false;

if (auth != null && auth.isAuthenticated()) {
	for (GrantedAuthority authority : auth.getAuthorities()) {
		if (authority.getAuthority().equals("CLIENTE")) {
	isCliente = true;
		}
		if (authority.getAuthority().equals("ADMINISTRATIVO")) {
	isAdministrativo = true;
		}
		if (authority.getAuthority().equals("PROFESIONAL")) {
	isProfesional = true;
		}
	}
}
%>

<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<!-- Marca de la aplicación -->
			<a class="navbar-brand" href="<c:url value='/'/>">Prevención
				Segura</a>
			<!-- Botón para dispositivos móviles -->
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<!-- Enlaces de navegación -->
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ms-auto">
					<!-- Enlace siempre visible -->
					<li class="nav-item"><a class="nav-link" aria-current="page"
						href="<c:url value='/'/>">Inicio</a></li>
					<%
					if (isCliente) {
					%>
					<!-- Enlace directo a Contacto -->
					<li class="nav-item"><a class="nav-link"
						href="<c:url value='/contacto'/>">Contacto</a></li>

					<!-- Capacitaciones Dropdown -->
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false">
							Capacitaciones </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item"
								href="<c:url value='/capacitaciones'/>">Listar
									Capacitaciones</a></li>
							<li><a class="dropdown-item"
								href="<c:url value='/capacitaciones/nueva'/>">Crear
									Capacitación</a></li>
						</ul></li>
					<%
					}
					%>


					<%
					if (isAdministrativo) {
					%>
					<!-- Usuarios Dropdown -->
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Usuarios </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item"
								href="<c:url value='/usuarios'/>">Listar Usuarios</a></li>
							<li><a class="dropdown-item"
								href="<c:url value='/usuarios/crear'/>">Crear Usuario</a></li>
						</ul></li>

					<!-- Pagos Dropdown -->
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Pagos </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="/sprintFinal/crearPago">Crear
									Pagos</a></li>
							<li><a class="dropdown-item" href="/sprintFinal/listarPagos">Listar
									Pagos</a></li>
						</ul></li>
						<li class="nav-item invisible-item"> <a class="nav-link" href="#"></a></li>

					<%
					}
					%>


					<%
					if (isProfesional) {
					%>
					<!-- Visitas a Terreno Dropdown -->
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Visitas a
							Terreno </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item"
								href="<c:url value='/obtenerVisita'/>">Listar Visitas</a></li>
							<li><a class="dropdown-item"
								href="<c:url value='/crearVisita'/>">Crear Visita</a></li>
						</ul></li>

					<!-- Revisiones de Check List Dropdown -->
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Revisiones de
							Check List </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item"
								href="<c:url value='/listarRevisiones'/>">Listar Revisiones</a></li>
							<%--                          <li><a class="dropdown-item" href="<c:url value='/crearRevision?idVisita=1'/>">Crear Revisión</a></li> <!-- Ajusta idVisita dinámicamente si es posible --> --%>
						</ul></li>
					<%
					}
					%>


					<%
					if (session.getAttribute("SPRING_SECURITY_CONTEXT") != null) {
					%>
					<!-- Botón de Logout -->
					<li class="nav-item"><a class="nav-link"
						href="<c:url value='/logout'/>">Logout</a></li>
					<%
					} else {
					%>
					<!-- Botón de Login -->
					<li class="nav-item"><a class="nav-link"
						href="<c:url value='/login'/>">Login</a></li>
					<%
					}
					%>
				</ul>
			</div>
		</div>
	</nav>
</body>
</html>
