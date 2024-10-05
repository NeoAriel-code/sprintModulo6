<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
       <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Visitas</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/estilo.css">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <!-- Incluir el Navbar -->
    <jsp:include page="navbar.jsp" />

    <div class="container mt-4">
        <h1>Lista de Visitas a Terreno</h1>

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
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th>ID Visita</th>
                    <th>RUT Empresa</th>
                    <th>Día de Visita</th>
                    <th>Hora de Visita</th>
                    <th>Lugar</th>
                    <th>Comentario</th>
                    <th>Revisiones</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="visita" items="${visitasLocales}">
                    <tr>
                        <td>${visita.idVisita}</td>
                        <td>${visita.cliente.rutEmpresa}</td> <!-- Corregido -->
                        <td>${visita.diaVisita}</td>
                        <td>${visita.horaVisita}</td>
                        <td>${visita.lugar}</td>
                        <td>${visita.comentario}</td>
                        <td>
                            <c:if test="${not empty visita.revisiones}">
                                <ul>
                                    <c:forEach var="revision" items="${visita.revisiones}">
                                        <li>${revision.nombreRevision} - ${revision.estadoRevision}</li>
                                    </c:forEach>
                                </ul>
                            </c:if>
                            <c:if test="${empty visita.revisiones}">
                                No hay revisiones.
                            </c:if>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/crearRevision?idVisita=${visita.idVisita}" class="btn btn-sm btn-success">Agregar Revisión</a>
                            <!-- Puedes agregar más acciones como editar o eliminar -->
                        </td>
                    </tr>
                    
                </c:forEach>
            </tbody>
            
        </table>
        		<div class="d-grid gap-2 d-md-flex justify-content m-3">
        <a href="${pageContext.request.contextPath}/crearVisita" class="btn btn-outline-light">Crear Nueva Visita</a>
        </div>
    </div>

    <!-- Bootstrap JS y dependencias -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
