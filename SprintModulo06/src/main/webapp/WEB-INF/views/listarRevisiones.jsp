<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
       <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Revisiones</title>
    <link rel="stylesheet" href="<c:url value='/res/css/estilo.css'/>">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="res/css/estilo.css">
</head>
<body>
    <!-- Incluir el Navbar -->
    <jsp:include page="navbar.jsp" />

    <div class="container mt-4">
        <h1>Lista de Revisiones de Check List</h1>
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th>ID Revisión</th>
                    <th>ID Visita</th>
                    <th>Nombre de Revisión</th>
                    <th>Detalle</th>
                    <th>Estado</th>
                    <!-- <th>Acciones</th> -->
                </tr>
            </thead>
            <tbody>
                <c:forEach var="revision" items="${revisiones}">
                    <tr>
                        <td>${revision.idRevision}</td>
                        <td>${revision.visita.idVisita}</td>
                        <td>${revision.nombreRevision}</td>
                        <td>${revision.detalleRevision}</td>
                        <td>${revision.estadoRevision}</td>
 <!--                        <td>
                            Agrega acciones como editar o eliminar si es necesario
                        </td> -->
                    </tr>
                </c:forEach>
            </tbody>
        </table>
                <div class="d-grid gap-2 d-md-flex justify-content m-3">
        <a href="<c:url value='/crearRevision?idVisita=1'/>" class="btn btn-outline-light m-3 justify-content">Crear Nueva Revisión</a> <!-- Ajusta el idVisita según corresponda -->
        </div>
    </div>

    <!-- Bootstrap JS y dependencias -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
