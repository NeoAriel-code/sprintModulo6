<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es" data-bs-theme="dark">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Listado de Pagos</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="res/css/estilo.css">
</head>
<body>
	<%@ include file='navbar.jsp'%>
	
	<div class="container">
		<br> <br>
		<h2 class="mb-4">Listado de Pagos</h2>

		<!-- Verifica si la lista de pagos no está vacía -->
		<c:choose>
			<c:when test="${not empty pagos}">
				<table class="table table-bordered table-striped">
					<thead class="table-dark">
						<tr>
							<th>ID Pago</th>
							<th>RUT Empresa</th>
							<th>Monto</th>
							<th>Fecha</th>
							<th>Detalle Pago</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="pago" items="${pagos}">
							<tr>
								<td>${pago.idPago}</td>
								<td>${pago.rutEmpresa}</td>
								<td>$${pago.monto}</td>
								<td>${pago.fecha}</td>
								<td>${pago.detallePago}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
			<c:otherwise>
				<div class="alert alert-warning" role="alert">No hay pagos
					registrados.</div>
			</c:otherwise>
		</c:choose>
	</div>

	<%@ include file='footer.jsp'%>

	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
