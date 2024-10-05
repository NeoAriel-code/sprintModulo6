    // Función de cuenta regresiva
    function startCountdown(duration, display) {
        var timer = duration, seconds;
        var countdownInterval = setInterval(function () {
            seconds = parseInt(timer);

            // Mostrar el tiempo restante
            display.textContent = seconds;

            // Cuando el contador llega a cero, redirigir al usuario
            if (--timer < 0) {
                clearInterval(countdownInterval); // Detener el intervalo
                window.location.href = './'; // Redirigir a la página principal
            }
        }, 1000);
    }

    // Iniciar la cuenta regresiva cuando la página esté completamente cargada
    window.onload = function () {
        var countdownTime = 2; // Tiempo de cuenta regresiva en segundos
        var display = document.querySelector('#countdown'); // Selector para mostrar la cuenta
        startCountdown(countdownTime, display);
    };