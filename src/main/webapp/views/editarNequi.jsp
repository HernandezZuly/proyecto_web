<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/estilo.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="shotcut icon" href="assets/img/logo.png" type="image/x-icon">
    <title>Formulario nequi</title>
</head>
<body>
    <header>
        <a class="logo">Formulario nequi</a>
         <input type="checkbox" id="menu-bar">
        <label for="menu-bar" class="fa fa-bars"></label>
            <nav class="navbar">
                <a href="nequi?accion=listar">Volver</a>
            </nav>
    </header>
    <section class="formulario" id="formulario">
        <div class="image">
            <img src="assets/img/registro.png" alt="imagen del login">
        </div>
    <c:forEach var="nequi" items="${nequi}">
        <form action="nequi" method="post">
            <h1 class="heading">Actualizar</h1>
                <div class="inputcaja">
                    <input type="hidden" name="idNequi" id="idNequi" required value="${nequi.getIdNequi()}">
                    <p>${nequi.getIdNequi()}</p></BR>
                </div>
                <div class="inputcaja">
                    <input type="number" name="idUsuario" id="idUsuario" required value="${nequi.getIdUsuario()}">
                    <label for="idUsuario">Id Usuario</label>
                </div>
                <div class="inputcaja">
                    <input type="number" name="retiro" id="retiro" required value="${nequi.getRetiro()}">
                    <label for="valorRetiro">Valor del retiro</label>
                </div>
                <div class="inputcaja">
                    <input type="number" name="valorRetiro" id="valorRetiro" required value="${nequi.getValorRecarga()}">
                    <label for="valorRetiro">Valor de la Recarga</label>
                </div>
                <div class="inputcaja">
                    <input type="number" name="saldoActual" id="saldoActual" required value="${nequi.getSaldoActual()}">
                    <label for="saldoActual">Saldo Actual</label>
                </div>
                <div class="inputcaja">
                    <input type="checkbox" name="estadoNequi" id="estadoNequi" value="${nequi.getEstadoNequi()}">
                    <label for="estadoNequi">Estado</label>
                </div>
                <button type="submit" class="btn" name="accion" value="editar">GUARDAR</button>
        </form>
    </c:forEach>
    </section>
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