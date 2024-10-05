<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Prevención de Riesgos PDR</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="res/css/estilo.css">
</head>

<body data-bs-theme="dark">

    <!-- Se agrega el navbar creado en otro archivo jsp para poder trabajar de forma modular -->
    <%@ include file='navbar.jsp'%>

    <!-- Container con estilo m (margin) y (arriba y abajo) de tamaño 5.  -->
    <div class="container my-5">

        <div class="row">
            <!-- Ajuste para PC, Tablet y Celular usando Bootstrap -->
            <div class="col-lg-6 col-md-12 mb-4 mb-lg-0">
                <h1 class="display-3" >Bienvenido a Prevención Segura</h1>
                <p class="lead" style="text-align: justify;">En Prevención Segura, nos especializamos en identificar y mitigar los riesgos laborales para garantizar la seguridad y bienestar de su equipo.</p>
                <p style="text-align: justify;">Nuestra misión es ofrecer soluciones efectivas que protejan a su organización, cumpliendo con todas las normativas vigentes y promoviendo un ambiente de trabajo seguro.</p>
                
                <!-- Centrado del botón -->
                <div class="d-grid gap-2 d-md-flex justify-content-md-center">
                    <a href="#" class="btn btn-outline-light">Conoce más</a>
                </div>
            </div>
            <div class="col-lg-6 col-md-12">
                <img src="res/img/Prevencionistas.png" alt="Prevención Segura" class="img-fluid w-100">
            </div>
        </div>
    </div>

    <!-- Footer -->
    <%@ include file='footer.jsp'%>
    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
