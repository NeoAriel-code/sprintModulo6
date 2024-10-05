<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crear Revisión</title>
    <!-- Tu archivo de estilos personalizado -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/estilo.css">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="res/js/revision.js"></script>
</head>
<body>
    <!-- Incluir el Navbar -->
    <jsp:include page="navbar.jsp" />

    <div class="container mt-4">
        <h1>Crear Nueva Revisión</h1>
        
        <!-- Mensajes de éxito y error -->
        <c:if test="${not empty mensaje}">
            <div class="alert alert-success">${mensaje}</div>
        </c:if>
        <c:if test="${not empty error}">
            <div class="alert alert-danger">${error}</div>
        </c:if>
        
        <!-- Formulario para crear revisión -->
        <form action="${pageContext.request.contextPath}/crearRevision" method="post" class="needs-validation" novalidate>
            <!-- ID Visita (Solo lectura) -->
            <div class="mb-3">
                <label for="idVisita" class="form-label">ID Visita</label>
                <!-- Campo de texto solo lectura -->
                <input type="text" class="form-control" id="idVisita" name="visita.idVisita" value="${revision.visita.idVisita}" readonly>
                <!-- Campo oculto para enviar el ID Visita -->
                <input type="hidden" name="visita.idVisita" value="${revision.visita.idVisita}">
                <!-- Manejo de errores para visita.idVisita -->
                <c:if test="${not empty errores['visita.idVisita']}">
                    <div class="text-danger">${errores['visita.idVisita']}</div>
                </c:if>
            </div>
            
            <!-- Nombre de Revisión -->
            <div class="mb-3">
                <label for="nombreRevision" class="form-label">Nombre de Revisión</label>
                <input type="text" class="form-control ${errores['nombreRevision'] != null ? 'is-invalid' : ''}" id="nombreRevision" name="nombreRevision" value="${revision.nombreRevision}" required>
                <div class="invalid-feedback">
                    Por favor, ingresa el nombre de la revisión.
                </div>
                <!-- Manejo de errores para nombreRevision -->
                <c:if test="${not empty errores['nombreRevision']}">
                    <div class="text-danger">${errores['nombreRevision']}</div>
                </c:if>
            </div>
            
            <!-- Detalle de Revisión -->
            <div class="mb-3">
                <label for="detalleRevision" class="form-label">Detalle de Revisión</label>
                <textarea class="form-control ${errores['detalleRevision'] != null ? 'is-invalid' : ''}" id="detalleRevision" name="detalleRevision" rows="3" required>${revision.detalleRevision}</textarea>
                <div class="invalid-feedback">
                    Por favor, ingresa el detalle de la revisión.
                </div>
                <!-- Manejo de errores para detalleRevision -->
                <c:if test="${not empty errores['detalleRevision']}">
                    <div class="text-danger">${errores['detalleRevision']}</div>
                </c:if>
            </div>
            
            <!-- Estado de Revisión -->
            <div class="mb-3">
                <label for="estadoRevision" class="form-label">Estado de Revisión</label>
                <select class="form-select ${errores['estadoRevision'] != null ? 'is-invalid' : ''}" id="estadoRevision" name="estadoRevision" required>
                    <option value="">Seleccione un estado</option>
                    <option value="PENDIENTE" ${revision.estadoRevision == 'PENDIENTE' ? 'selected' : ''}>Pendiente</option>
                    <option value="APROBADA" ${revision.estadoRevision == 'APROBADA' ? 'selected' : ''}>Aprobada</option>
                    <option value="REPROBADA" ${revision.estadoRevision == 'REPROBADA' ? 'selected' : ''}>Reprobada</option>
                </select>
                <div class="invalid-feedback">
                    Por favor, selecciona el estado de la revisión.
                </div>
                <!-- Manejo de errores para estadoRevision -->
                <c:if test="${not empty errores['estadoRevision']}">
                    <div class="text-danger">${errores['estadoRevision']}</div>
                </c:if>
            </div>
            
            <!-- Botones -->
            <button type="submit" class="btn btn-primary">Guardar</button>
            <a href="${pageContext.request.contextPath}/listarRevisiones" class="btn btn-secondary">Cancelar</a>
        </form>
    </div>

    <!-- Bootstrap JS y dependencias -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
