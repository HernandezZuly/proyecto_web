<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/estilo.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="shotcut icon" href="img/logo.png" type="image/x-icon">
    <title>Página Inicial</title>
</head>
<body>
    <header>
        <a class="logo">Página Inicial</a>
        <input type="checkbox" id="menu-bar">
        <label for="menu-bar" class="fa fa-bars"></label>
            <nav class="navbar">
                <a href="daviplata?accion=loginDaviplata">Volver</a>
            </nav>
    </header>
    <section class="especificaciones" id="especificaciones">
        <div class="caja-contenedor">
            <div class="caja">
                <img src="img/consultarSaldo.png" alt="imagen de consultar saldo">
                <h3>Consultar saldo</h3>
                <p>Aquí puede verificar cuanto saldo tiene disponible en su número de cuenta para realizar retiros, entre otras cosas</p>
                <a href="#" class="btn">Consultar</a>
            </div>
            <div class="caja">
                <img src="img/recargarCuenta.png" alt="imagen de recargar cuenta">
                <h3>Recargar cuenta</h3>
                <p>Aquí puede recargar la cantidad de dinero que quiera a su cuenta</p>
                <a href="#" class="btn">Recargar</a>
            </div>
            <div class="caja">
                <img src="img/sacarDinero.png" alt="imagen de sacar saldo">
                <h3>Retirar dinero</h3>
                <p>Aquí puede sacar la cantidad de dinero que desee de su cuenta</p>
                <a href="#" class="btn">Retirar</a>
            </div>
        </div>
    </section>
    <div class="footer">
        <div class="caja-contenedor">
            <div class="caja">
                <h3>Correo Electronico</h3>
                <i class="fas fa.envelope"></i>
                <p>BolsilloDigital@gmail.com </p>
            </div>
            <div class="caja">
                <h3>Redes Sociales</h3>
                <a href="#">Facebook</a>
                <a href="#">Instagram</a>
            </div>
            <div class="caja">
                <h3>Números telefónicos</h3>
                <div class="info">
                    <i class="fa fa-phone" aria-hidden="true"></i>
                    <p>(+57) 321 1234567<br> 098-765-5</p>
                </div>
            </div>
        </div>
    </div>
</body>
</html>