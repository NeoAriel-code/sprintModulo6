<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="es" data-bs-theme="dark">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crear Usuario - Prevención Segura</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="res/css/estilo.css">
</head>
<body>
    <!-- Navbar -->
    <%@ include file='navbar.jsp'%>

    <!-- Main content -->
    <div class="container my-5">
        <div class="row justify-content-center">
            <div class="col-md-6 text-center">
                <h1 class="mb-4">Crear Nuevo Usuario</h1>
                <br>
                <p class="lead">Asegúrate de completar todos los campos requeridos.</p>
            </div>
        </div>

        <!-- Mostrar mensajes de error o éxito -->
        <div class="row justify-content-center">
            <div class="col-md-6">
                <c:if test="${not empty error}">
                    <div class="alert alert-danger">${error}</div>
                </c:if>
                <c:if test="${not empty mensaje}">
                    <div class="alert alert-success">${mensaje}</div>
                </c:if>
            </div>
        </div>

        <div class="row justify-content-center">
            <div class="col-md-6">
                <form action="${pageContext.request.contextPath}/usuarios/crear" method="post" id="userForm" novalidate>
                    <!-- Nombre de usuario -->
                    <div class="form-group mb-3">
                        <label for="nombreUsuario">Nombre del Usuario:</label>
                        <input type="text" class="form-control" id="nombreUsuario" name="nombreUsuario" placeholder="Ingrese el nombre del usuario" required>
                        <div class="invalid-feedback">Por favor, ingrese el nombre del usuario.</div>

                        <label for="apellidoUsuario" style="margin-top: 15px">Apellido del Usuario:</label>
                        <input type="text" class="form-control" id="apellidoUsuario" name="apellidoUsuario" placeholder="Ingrese el apellido del usuario" required>
                        <div class="invalid-feedback">Por favor, ingrese el apellido del usuario.</div>

                        <label for="nickname" style="margin-top: 15px">Nombre de Usuario:</label>
                        <input type="text" class="form-control" id="nickname" name="nickname" readonly>

                        <label for="contrasena" style="margin-top: 15px">Contraseña:</label>
                        <input type="password" class="form-control" id="contrasena" name="contrasena" required>
                        <div class="invalid-feedback">Por favor, ingrese una contraseña.</div>

                        <label for="runUsuario" style="margin-top: 15px">RUN del Usuario:</label>
                        <input type="text" class="form-control" id="runUsuario" name="runUsuario" placeholder="Ingrese el RUN del usuario" required>
                        <div class="invalid-feedback">Por favor, ingrese el RUN del usuario.</div>

                        <label for="correoUsuario" style="margin-top: 15px">Correo del Usuario:</label>
                        <input type="email" class="form-control" id="correoUsuario" name="correoUsuario" placeholder="Ingrese el correo del usuario" required>
                        <div class="invalid-feedback">Por favor, ingrese el correo del usuario.</div>

                        <label for="telefonoUsuario" style="margin-top: 15px">Teléfono del Usuario:</label>
                        <input type="text" class="form-control" id="telefonoUsuario" name="telefonoUsuario" placeholder="Ingrese el teléfono del usuario" required>
                        <div class="invalid-feedback">Por favor, ingrese el teléfono del usuario.</div>
                    </div>

                    <!-- Tipo de usuario -->
                    <div class="form-group">
                        <label for="tipoUsuario">Tipo de Usuario:</label>
                        <select class="form-control" id="tipoUsuario" name="tipoUsuario" required>
                            <option value="" selected disabled>Seleccione el tipo de usuario</option>
                            <option value="cliente">Cliente</option>
                            <option value="administrativo">Administrativo</option>
                            <option value="profesional">Profesional</option>
                        </select>
                        <div class="invalid-feedback">Por favor, seleccione un tipo de usuario.</div>
                    </div>

                    <!-- Campos adicionales para Cliente -->
                    <div id="clienteFields" class="d-none">
                        <h3>Datos de Empresa</h3>
                        <label for="nombreEmpresa">Nombre Empresa:</label>
                        <input type="text" class="form-control" id="nombreEmpresa" name="nombreEmpresa">

                        <label for="rutEmpresa">RUT Empresa:</label>
                        <input type="text" class="form-control" id="rutEmpresa" name="rutEmpresa">

                        <label for="telefonoEmpresa">Teléfono Empresa:</label>
                        <input type="text" class="form-control" id="telefonoEmpresa" name="telefonoEmpresa">

                        <label for="correoEmpresa">Correo Empresa:</label>
                        <input type="email" class="form-control" id="correoEmpresa" name="correoEmpresa">

                        <label for="direccionEmpresa">Dirección Empresa:</label>
                        <input type="text" class="form-control" id="direccionEmpresa" name="direccionEmpresa">

                        <label for="comunaEmpresa">Comuna Empresa:</label>
                        <input type="text" class="form-control" id="comunaEmpresa" name="comunaEmpresa">
                    </div>

                    <!-- Campos adicionales para Administrativo -->
                    <div id="administrativoFields" class="d-none">
                        <h3>Datos Administrativos</h3>
                        <label for="areaAdministrativo">Área:</label>
                        <input type="text" class="form-control" id="areaAdministrativo" name="areaAdministrativo">

                        <label for="experienciaPrevia">Experiencia Previa:</label>
                        <input type="text" class="form-control" id="experienciaPrevia" name="experienciaPrevia">
                    </div>

                    <!-- Campos adicionales para Profesional -->
                    <div id="profesionalFields" class="d-none">
                        <h3>Datos Profesionales</h3>
                        <label for="tituloProfesional">Título Profesional:</label>
                        <input type="text" class="form-control" id="tituloProfesional" name="tituloProfesional">

                        <label for="fechaIngresoProfesional">Fecha de Ingreso:</label>
                        <input type="date" class="form-control" id="fechaIngresoProfesional" name="fechaIngresoProfesional">
                    </div>

                    <br>

                    <!-- Botón de envío -->
                    <button type="submit" class="btn btn-outline-light" style="margin-top: 15px">Crear Usuario</button>
                </form>
            </div>
        </div>
    </div>

    <!-- Footer -->
    <%@ include file='footer.jsp'%>

    <!-- Bootstrap JS y tus scripts -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>


<!-- 	Se intentó importar el script desde un .js pero no funcionaba
	Script para rellenar y ligar campos a valores predeterminados por la DB -->
    <script>
    document.addEventListener('DOMContentLoaded', function() {
        function generarNickname() {
            var nombre = document.getElementById('nombreUsuario').value;
            var apellido = document.getElementById('apellidoUsuario').value;

            if (nombre && apellido) {
                var nombreUsuario = nombre.charAt(0).toLowerCase() + "_" + apellido.toLowerCase();
                document.getElementById('nickname').value = nombreUsuario;
            }
        }

        // Escucha cambios en los campos de nombre y apellido
        document.getElementById('nombreUsuario').addEventListener('input', generarNickname);
        document.getElementById('apellidoUsuario').addEventListener('input', generarNickname);

        // Mostrar campos adicionales según el tipo de usuario seleccionado
        document.getElementById('tipoUsuario').addEventListener('change', function() {
            var clienteFields = document.getElementById('clienteFields');
            var administrativoFields = document.getElementById('administrativoFields');
            var profesionalFields = document.getElementById('profesionalFields');

            // Ocultar todos los campos adicionales
            clienteFields.classList.add('d-none');
            administrativoFields.classList.add('d-none');
            profesionalFields.classList.add('d-none');

            // Limpiar atributos de required
            clearRequiredFields();

            // Mostrar los campos adicionales correspondientes
            if (this.value === 'cliente') {
                clienteFields.classList.remove('d-none');
                setRequiredFields(clienteFields);
            } else if (this.value === 'administrativo') {
                administrativoFields.classList.remove('d-none');
                setRequiredFields(administrativoFields);
            } else if (this.value === 'profesional') {
                profesionalFields.classList.remove('d-none');
                setRequiredFields(profesionalFields);
            }
        });

        // Limpiar los campos requeridos
        function clearRequiredFields() {
            var fields = document.querySelectorAll('#clienteFields input, #administrativoFields input, #profesionalFields input');
            fields.forEach(function(field) {
                field.removeAttribute('required');
                field.classList.remove('is-invalid'); // Quitar clase de error
            });
        }

        // Establecer los campos requeridos
        function setRequiredFields(container) {
            var fields = container.querySelectorAll('input');
            fields.forEach(function(field) {
                field.setAttribute('required', 'true');
            });
        }

        // Validar el formulario al enviarlo
        document.getElementById('userForm').addEventListener('submit', function(event) {
            var form = this;
            var isValid = true;

            // Validar todos los campos visibles
            var requiredFields = form.querySelectorAll('input[required]');
            requiredFields.forEach(function(field) {
                if (!field.value) {
                    field.classList.add('is-invalid');
                    isValid = false;
                } else {
                    field.classList.remove('is-invalid');
                }
            });

            if (!isValid) {
                event.preventDefault();
                event.stopPropagation();
                alert('Por favor, complete todos los campos requeridos.');
            }
        });
    });
    </script>
</body>
</html>
