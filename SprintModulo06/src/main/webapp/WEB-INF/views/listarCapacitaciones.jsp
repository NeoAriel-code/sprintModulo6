<%@ page import="java.util.List"%>
<%@ page import="cl.grupo02.sprintFinal.model.entity.Capacitacion"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es" data-bs-theme="dark">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
<head>
    <meta charset="UTF-8">
    <title>Listado de Capacitaciones</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap Icons (Opcional) -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <!-- Tu archivo de estilos personalizado -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/estilo.css">
</head>
<body>

    <!-- Navbar -->
    <%@ include file='navbar.jsp'%>

    <div class="container mt-5">
        <h2 class="mb-4 text-center">Listado de Capacitaciones</h2>

        <!-- Mostrar mensajes de error o éxito -->
        <c:if test="${not empty error}">
            <div class="alert alert-danger text-center">${error}</div>
        </c:if>
        <c:if test="${not empty mensaje}">
            <div class="alert alert-success text-center">${mensaje}</div>
        </c:if>

        <c:if test="${not empty capacitaciones}">
            <div class="table-responsive">
                <table class="table table-bordered table-striped align-middle">
                    <thead class="table-dark">
                        <tr>
                            <th>ID</th>
                            <th>RUT Empresa</th>
                            <th>Nombre de la Capacitación</th>
                            <th>Detalle</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="capacitacion" items="${capacitaciones}">
                            <tr>
                                <td>${capacitacion.idCapacitacion}</td>
                                <td>${capacitacion.rutEmpresa}</td>
                                <td>${capacitacion.nombreCapacitacion}</td>
                                <td>${capacitacion.detalleCapacitacion}</td>
                                <td>
                                    <!-- Contenedor Flex para Alinear Botones -->
                                    <div class="d-flex justify-content-center gap-2">

                                        <!-- Botón para editar -->
                                        <a href="${pageContext.request.contextPath}/capacitaciones/${capacitacion.idCapacitacion}/editar" class="btn btn-primary2">
                                            Editar
                                        </a>

                                        <!-- Botón para eliminar -->
                                        <a href="${pageContext.request.contextPath}/capacitaciones/${capacitacion.idCapacitacion}/eliminar" class="btn btn-primary2" onclick="return confirm('¿Estás seguro de que deseas eliminar esta capacitación?');">
                                            Eliminar
                                        </a>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                        <div class="d-grid gap-2 d-md-flex justify-content m-3">
            <a href="${pageContext.request.contextPath}/capacitaciones/nueva" class="btn btn-outline-light">
                Crear Nueva Capacitación
            </a>
        </div>
            </div>
        </c:if>
        <c:if test="${empty capacitaciones}">
            <div class="alert alert-warning text-center">No hay capacitaciones disponibles para mostrar.</div>
        </c:if>
    </div>

    <!-- Footer -->
    <%@ include file='footer.jsp'%>

    <!-- Bootstrap JS Bundle (incluye Popper) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
