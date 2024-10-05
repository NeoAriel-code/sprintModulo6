<%@ page import="java.util.List"%>
<%@ page import="cl.grupo02.sprintFinal.model.entity.Capacitacion"%>
<%@ page import="cl.grupo02.sprintFinal.model.entity.Cliente"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="es" data-bs-theme="dark">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crear Nueva Capacitación</title>
    <!-- Bootstrap CSS -->
    <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/estilo.css">
     <script src="res/js/capacitacion.js"></script>
</head>
<body>

    <!-- Navbar o cualquier otra parte de tu página -->
    <%@ include file='navbar.jsp'%>

    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-lg-6 col-md-8">
                <h2 class="text-center mb-4">Crear Nueva Capacitación</h2>
                <p class="text-center">Utiliza el formulario a continuación para
                    registrar una capacitación para tu equipo. Asegúrate de completar
                    todos los campos requeridos.</p>

                <!-- Mostrar mensajes de error o éxito -->
                <c:if test="${not empty error}">
                    <div class="alert alert-danger">${error}</div>
                </c:if>
                <c:if test="${not empty mensaje}">
                    <div class="alert alert-success">${mensaje}</div>
                </c:if>

                <!-- Formulario para crear la capacitación -->
                <form action="${pageContext.request.contextPath}/capacitaciones" method="post">
                    <div class="mb-3">
                        <label for="nombreCapacitacion" class="form-label">Nombre de la Capacitación</label>
                        <input type="text" class="form-control" id="nombreCapacitacion" name="nombreCapacitacion" value="${capacitacion.nombreCapacitacion}" required>
                        <div class="invalid-feedback">Por favor, ingresa el nombre de la capacitación.</div>
                    </div>

                    <div class="mb-3">
                        <label for="detalleCapacitacion" class="form-label">Detalle de la Capacitación</label>
                        <textarea class="form-control" id="detalleCapacitacion" name="detalleCapacitacion" rows="3" required>${capacitacion.detalleCapacitacion}</textarea>
                        <div class="invalid-feedback">Por favor, ingresa el detalle de la capacitación.</div>
                    </div>

                    <div class="mb-3">
                     <label for="rutEmpresa" class="form-label">RUT de la Empresa</label>
                    <select class="form-select" id="rutEmpresa" name="rutEmpresa" required>
                        <option value="" disabled selected>Seleccione una empresa...</option>
                        <%
                        List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");
                        if (clientes != null) {
                            for (Cliente c : clientes) {
                        %>
                        <option value="<%= c.getRutEmpresa() %>"><%= c.getRutEmpresa() %> - <%= c.getNombreEmpresa() %></option>
                        <%
                            }
                        }
                        %>
						</select>
                    </div>

                    <!-- Botón de envío -->
                    <div class="text-center">
                        <button type="submit" class="btn btn-outline-light">Crear</button>
                        <br>
                        <a href="${pageContext.request.contextPath}/capacitaciones" class="btn btn-outline-light">Ver Todas las Capacitaciones</a>
                    </div>
                </form>
            </div>

        </div>
    </div>

    <!-- Footer o cualquier otra parte de tu página -->
    <%@ include file='footer.jsp'%>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
