<%@ page import="cl.grupo02.sprintFinal.model.entity.Capacitacion"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es" data-bs-theme="dark">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Capacitación</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Tu archivo de estilos personalizado -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/estilo.css">
    <!-- Validación personalizada con Bootstrap -->
    <script src="res/js/capacitacion.js"></script>
</head>
<body>

    <!-- Navbar -->
    <%@ include file='navbar.jsp'%>

    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-lg-6 col-md-8">
                <h2 class="text-center mb-4">Editar Capacitación</h2>
                <p class="text-center">Modifica los detalles de la capacitación utilizando el formulario a continuación.</p>

                <!-- Mostrar mensajes de error o éxito -->
                <c:if test="${not empty error}">
                    <div class="alert alert-danger">${error}</div>
                </c:if>
                <c:if test="${not empty mensaje}">
                    <div class="alert alert-success">${mensaje}</div>
                </c:if>

                <!-- Formulario para editar la capacitación -->
                <form action="${pageContext.request.contextPath}/capacitaciones/${capacitacion.idCapacitacion}/editar" method="post" novalidate>
                    <div class="mb-3">
                        <label for="rutEmpresa" class="form-label">RUT de la Empresa</label>
                        <input type="text" class="form-control" id="rutEmpresa" name="rutEmpresa" value="${capacitacion.rutEmpresa}" required pattern="\d{7,8}-[kK\d]">
                        <div class="invalid-feedback">
                            Por favor, ingresa un RUT válido (ejemplo: 12345678-9).
                        </div>
                    </div>

                    <div class="mb-3">
                        <label for="nombreCapacitacion" class="form-label">Nombre de la Capacitación</label>
                        <input type="text" class="form-control" id="nombreCapacitacion" name="nombreCapacitacion" value="${capacitacion.nombreCapacitacion}" required>
                        <div class="invalid-feedback">
                            Por favor, ingresa el nombre de la capacitación.
                        </div>
                    </div>

                    <div class="mb-3">
                        <label for="detalleCapacitacion" class="form-label">Detalle de la Capacitación</label>
                        <textarea class="form-control" id="detalleCapacitacion" name="detalleCapacitacion" rows="3" required>${capacitacion.detalleCapacitacion}</textarea>
                        <div class="invalid-feedback">
                            Por favor, ingresa el detalle de la capacitación.
                        </div>
                    </div>

                    <!-- Botón de envío -->
                    <div class="text-center">
                        <button type="submit" class="btn btn-outline-light">Actualizar</button>
                        <a href="${pageContext.request.contextPath}/capacitaciones" class="btn btn-outline-light">Cancelar</a>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <!-- Footer -->
    <%@ include file='footer.jsp'%>

    <!-- Bootstrap JS Bundle (incluye Popper) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>



</body>
</html>
