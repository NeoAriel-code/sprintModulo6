<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="es" data-bs-theme="dark">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listado de Usuarios</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="res/css/estilo.css">
</head>
<body>
    <%@ include file='navbar.jsp'%>
    <div class="container-fluid">
        <br><br>
        <h2 class="mb-4">Listado de Usuarios</h2>

        <!-- Filtro para seleccionar el tipo de usuario -->
        <form method="get" class="mb-4">
            <label for="tipoUsuario" class="form-label">Filtrar por tipo de usuario:</label>
            <select id="tipoUsuario" name="tipoUsuario" class="form-select" onchange="this.form.submit()">
                <option value="" ${empty tipoUsuario ? 'selected' : ''}>Seleccionar...</option>
                <option value="cliente" ${tipoUsuario == 'cliente' ? 'selected' : ''}>Cliente</option>
                <option value="profesional" ${tipoUsuario == 'profesional' ? 'selected' : ''}>Profesional</option>
                <option value="administrativo" ${tipoUsuario == 'administrativo' ? 'selected' : ''}>Administrativo</option>
            </select>
        </form>

        <!-- Mostrar mensaje si no se selecciona un tipo de usuario -->
        <c:choose>
            <c:when test="${empty tipoUsuario}">
                <div class="alert alert-info">Debe seleccionar un tipo de usuario primero.</div>
            </c:when>
            <c:otherwise>
                <c:if test="${not empty usuarios}">
                    <!-- Tabla con los usuarios -->
                    <table class="table table-bordered table-striped">
                        <thead class="table-dark">
                            <tr>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>RUN</th>
                                <th>Correo</th>
                                <th>Teléfono</th>
                                <!-- Mostrar encabezados adicionales según el tipo de usuario -->
                                <c:choose>
                                    <c:when test="${tipoUsuario == 'cliente'}">
                                        <th>Nombre Empresa</th>
                                        <th>RUT Empresa</th>
                                        <th>Teléfono Empresa</th>
                                        <th>Correo Empresa</th>
                                        <th>Dirección Empresa</th>
                                        <th>Comuna Empresa</th>
                                    </c:when>
                                    <c:when test="${tipoUsuario == 'profesional'}">
                                        <th>Título Profesional</th>
                                        <th>Fecha Ingreso</th>
                                    </c:when>
                                    <c:when test="${tipoUsuario == 'administrativo'}">
                                        <th>Área Administrativo</th>
                                        <th>Experiencia Previa</th>
                                    </c:when>
                                </c:choose>
                                <th>Acciones</th> <!-- Nueva columna para las acciones -->
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="u" items="${usuarios}">
                                <tr style="font-size: 80%;">
                                    <td>${u.nombreUsuario}</td>
                                    <td>${u.apellidoUsuario}</td>
                                    <td>${u.runUsuario}</td>
                                    <td>${u.correoUsuario}</td>
                                    <td>${u.telefonoUsuario}</td>

                                    <!-- Mostrar datos adicionales según tipo de usuario -->
                                    <c:choose>
                                        <c:when test="${tipoUsuario == 'cliente'}">
                                            <td>${u.cliente.nombreEmpresa}</td>
                                            <td>${u.cliente.rutEmpresa}</td>
                                            <td>${u.cliente.telefonoEmpresa}</td>
                                            <td>${u.cliente.correoEmpresa}</td>
                                            <td>${u.cliente.direccionEmpresa}</td>
                                            <td>${u.cliente.comunaEmpresa}</td>
                                        </c:when>
                                        <c:when test="${tipoUsuario == 'profesional'}">
                                            <td>${u.profesional.tituloProfesional}</td>
                                            <td>${u.profesional.fechaIngresoProfesional}</td>
                                        </c:when>
                                        <c:when test="${tipoUsuario == 'administrativo'}">
                                            <td>${u.administrativo.areaAdministrativo}</td>
                                            <td>${u.administrativo.experienciaPrevia}</td>
                                        </c:when>
                                    </c:choose>

                                    <!-- Columna de acciones -->
                                    <td>
                                        <!-- Enlace para modificar -->
                                        <a href="${pageContext.request.contextPath}/usuarios/${u.idUsuario}/editar" class="btn btn-warning btn-sm">Modificar</a>

                                        <!-- Formulario para eliminar -->

                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>
                <c:if test="${empty usuarios}">
                    <div class="alert alert-warning">No hay usuarios disponibles para mostrar.</div>
                </c:if>
            </c:otherwise>
        </c:choose>
    </div>

    <%@ include file='footer.jsp'%>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
