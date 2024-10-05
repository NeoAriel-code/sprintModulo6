<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crear Visita</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="res/css/estilo.css">
</head>
<body>
    <!-- Incluir el Navbar -->
    <jsp:include page="navbar.jsp" />

    <div class="container mt-4">
        <h1>Crear Nueva Visita a Terreno</h1>

        <!-- Mensajes de éxito y error -->
        <c:if test="${not empty mensaje}">
            <div class="alert alert-success">
                ${mensaje}
            </div>
        </c:if>
        <c:if test="${not empty error}">
            <div class="alert alert-danger">
                ${error}
            </div>
        </c:if>

        <!-- Formulario para crear visita -->
        <form action="${pageContext.request.contextPath}/crearVisita" method="post" class="needs-validation" novalidate>
            <!-- Seleccionar Cliente -->
            <div class="mb-3">
                <label for="idCliente" class="form-label">Cliente</label>
                <select name="idCliente" id="idCliente" class="form-select" required>
                    <option value="">-- Seleccione un Cliente --</option>
                    <c:forEach var="cliente" items="${clientes}">
                        <option value="${cliente.idCliente}" ${cliente.idCliente == visita.cliente.idCliente ? 'selected' : ''}>
                            ${cliente.rutEmpresa} - ${cliente.nombreEmpresa}
                        </option>
                    </c:forEach>
                </select>
                <c:if test="${not empty errores['idCliente']}">
                    <div class="text-danger">${errores['idCliente']}</div>
                </c:if>
            </div>

            <!-- Día de Visita -->
            <div class="mb-3">
                <label for="diaVisita" class="form-label">Día de Visita</label>
                <input type="date" class="form-control" id="diaVisita" name="diaVisita" value="${visita.diaVisita}" required>
                <c:if test="${not empty errores['diaVisita']}">
                    <div class="text-danger">${errores['diaVisita']}</div>
                </c:if>
            </div>

            <!-- Hora de Visita -->
            <div class="mb-3">
                <label for="horaVisita" class="form-label">Hora de Visita</label>
                <input type="time" class="form-control" id="horaVisita" name="horaVisita" value="${visita.horaVisita}" required>
                <c:if test="${not empty errores['horaVisita']}">
                    <div class="text-danger">${errores['horaVisita']}</div>
                </c:if>
            </div>

            <!-- Lugar -->
            <div class="mb-3">
                <label for="lugar" class="form-label">Lugar</label>
                <input type="text" class="form-control" id="lugar" name="lugar" value="${visita.lugar}" required>
                <c:if test="${not empty errores['lugar']}">
                    <div class="text-danger">${errores['lugar']}</div>
                </c:if>
            </div>

            <!-- Comentario -->
            <div class="mb-3">
                <label for="comentario" class="form-label">Comentario</label>
                <textarea class="form-control" id="comentario" name="comentario" rows="3" required>${visita.comentario}</textarea>
                <c:if test="${not empty errores['comentario']}">
                    <div class="text-danger">${errores['comentario']}</div>
                </c:if>
            </div>

            <!-- Botones -->
            <button type="submit" class="btn btn-outline-light">Guardar</button>
            <br>
            <a href="${pageContext.request.contextPath}/obtenerVisita" class="btn btn-secondary">Cancelar</a>
        </form>
    </div>

    <!-- Bootstrap JS y dependencias -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
