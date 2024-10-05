<%@ page import="java.util.List"%>
<%@ page import="cl.grupo02.sprintFinal.model.entity.Capacitacion"%>

<!DOCTYPE html>
<html lang="es" data-bs-theme="dark">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Obtener Capacitaciones</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="res/css/estilo.css">
</head>

<body>

    <jsp:include page="navbar.jsp" />
    <!-- Incluir el navbar -->

    <div class="container mt-5">
        <div class="row">
            <div class="col-md-8 offset-md-2">
                <h1 class="text-center mb-4">Capacitaciones Creadas</h1>

                <div class="card shadow-sm p-4">
                    <div class="table-responsive">
                        <table class="table table-hover table-bordered">
                            <thead class="table-dark">
                                <tr>
                                    <th scope="col">Id</th>
                                    <th scope="col">Rut Empresa</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Detalle</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                // Cambia la variable para usar 'capacitacionesApi'
                                List<Capacitacion> capacitaciones = (List<Capacitacion>) request.getAttribute("capacitacionesApi");
                                if (capacitaciones != null && !capacitaciones.isEmpty()) {
                                    for (Capacitacion c : capacitaciones) {
                                %>
                                <tr>
                                    <td><%=c.getIdCapacitacion()%></td>
                                    <td><%=c.getRutEmpresa()%></td>
                                    <td><%=c.getNombreCapacitacion()%></td>
                                    <td><%=c.getDetalleCapacitacion()%></td>
                                </tr>
                                <%
                                    }
                                } else {
                                %>
                                <tr>
                                    <td colspan="4" class="text-center">No hay capacitaciones registradas.</td>
                                </tr>
                                <%
                                }
                                %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
