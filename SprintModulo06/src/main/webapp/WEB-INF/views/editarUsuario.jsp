<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="es" data-bs-theme="dark">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Usuario</title>
    <!-- Bootstrap CSS para mejorar el estilo -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="res/css/estilo.css">
    
</head>
<body>

<%@ include file='navbar.jsp'%>

<div class="container">
    <h2 class="my-4">Editar Usuario</h2>

    <!-- Mostrar mensajes de error si existen -->
    <c:if test="${not empty error}">
        <div class="alert alert-danger">${error}</div>
    </c:if>

    <form action="${pageContext.request.contextPath}/usuarios/${formularioUsuario.idUsuario}/editar" method="post">
    
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    

        <!-- Campos comunes para todos los tipos de usuario -->
        <div class="mb-3">
            <label for="nombreUsuario" class="form-label">Nombre:</label>
            <input type="text" id="nombreUsuario" name="nombreUsuario" class="form-control" value="${formularioUsuario.nombreUsuario}" required>
        </div>

        <div class="mb-3">
            <label for="apellidoUsuario" class="form-label">Apellido:</label>
            <input type="text" id="apellidoUsuario" name="apellidoUsuario" class="form-control" value="${formularioUsuario.apellidoUsuario}" required>
        </div>

        <div class="mb-3">
            <label for="nickname" class="form-label">Nombre de Usuario:</label>
            <input type="text" id="nickname" name="nickname" class="form-control" value="${formularioUsuario.nickname}">
        </div>
        
		<div class="mb-3">
		    <label for="contrasena" class="form-label">Contraseña (dejar en blanco si no desea cambiarla):</label>
		    <input type="password" id="contrasena" name="contrasena" class="form-control">
		</div>
        
        <div class="mb-3">
            <label for="runUsuario" class="form-label">RUN del Usuario:</label>
            <input type="text" id="runUsuario" name="runUsuario" class="form-control" value="${formularioUsuario.runUsuario}" required>
        </div>

        <div class="mb-3">
            <label for="correoUsuario" class="form-label">Correo del Usuario:</label>
            <input type="email" id="correoUsuario" name="correoUsuario" class="form-control" value="${formularioUsuario.correoUsuario}" required>
        </div>

        <div class="mb-3">
            <label for="telefonoUsuario" class="form-label">Teléfono:</label>
            <input type="text" id="telefonoUsuario" name="telefonoUsuario" class="form-control" value="${formularioUsuario.telefonoUsuario}" required>
        </div>

        <!-- Tipo de Usuario (oculto) -->
        <input type="hidden" name="tipoUsuario" value="${formularioUsuario.tipoUsuario}"/>

        <!-- Campos adicionales específicos según el tipo de usuario -->
        <c:choose>
            <c:when test="${formularioUsuario.tipoUsuario == 'cliente'}">
                <h3>Datos de Empresa</h3>
                <div class="mb-3">
                    <label for="nombreEmpresa" class="form-label">Nombre Empresa:</label>
                    <input type="text" id="nombreEmpresa" name="nombreEmpresa" class="form-control" value="${formularioUsuario.nombreEmpresa}">
                </div>

                <div class="mb-3">
                    <label for="rutEmpresa" class="form-label">RUT Empresa:</label>
                    <input type="text" id="rutEmpresa" name="rutEmpresa" class="form-control" value="${formularioUsuario.rutEmpresa}">
                </div>

                <div class="mb-3">
                    <label for="telefonoEmpresa" class="form-label">Teléfono Empresa:</label>
                    <input type="text" id="telefonoEmpresa" name="telefonoEmpresa" class="form-control" value="${formularioUsuario.telefonoEmpresa}">
                </div>

                <div class="mb-3">
                    <label for="correoEmpresa" class="form-label">Correo Empresa:</label>
                    <input type="email" id="correoEmpresa" name="correoEmpresa" class="form-control" value="${formularioUsuario.correoEmpresa}">
                </div>

                <div class="mb-3">
                    <label for="direccionEmpresa" class="form-label">Dirección Empresa:</label>
                    <input type="text" id="direccionEmpresa" name="direccionEmpresa" class="form-control" value="${formularioUsuario.direccionEmpresa}">
                </div>

                <div class="mb-3">
                    <label for="comunaEmpresa" class="form-label">Comuna Empresa:</label>
                    <input type="text" id="comunaEmpresa" name="comunaEmpresa" class="form-control" value="${formularioUsuario.comunaEmpresa}">
                </div>
            </c:when>
            <c:when test="${formularioUsuario.tipoUsuario == 'profesional'}">
                <h3>Datos Profesionales</h3>
                <div class="mb-3">
                    <label for="tituloProfesional" class="form-label">Título Profesional:</label>
                    <input type="text" id="tituloProfesional" name="tituloProfesional" class="form-control" value="${formularioUsuario.tituloProfesional}">
                </div>

                <div class="mb-3">
                    <label for="fechaIngresoProfesional" class="form-label">Fecha de Ingreso:</label>
                    <input type="date" id="fechaIngresoProfesional" name="fechaIngresoProfesional" class="form-control" value="${formularioUsuario.fechaIngresoProfesional}">
                </div>
            </c:when>
            <c:when test="${formularioUsuario.tipoUsuario == 'administrativo'}">
                <h3>Datos Administrativos</h3>
                <div class="mb-3">
                    <label for="areaAdministrativo" class="form-label">Área:</label>
                    <input type="text" id="areaAdministrativo" name="areaAdministrativo" class="form-control" value="${formularioUsuario.areaAdministrativo}">
                </div>

                <div class="mb-3">
                    <label for="experienciaPrevia" class="form-label">Experiencia Previa:</label>
                    <input type="text" id="experienciaPrevia" name="experienciaPrevia" class="form-control" value="${formularioUsuario.experienciaPrevia}">
                </div>
            </c:when>
        </c:choose>
          <!-- Botón para actualizar el usuario -->
<div class="d-grid gap-2 d-md-flex justify-content">
    <input type="submit" value="Actualizar Usuario" class="btn btn-outline-light"/>
</div>



    </form>
</div>

<!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>



</body>
</html>
