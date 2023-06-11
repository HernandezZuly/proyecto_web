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
    <title>Registros Nequi</title>
</head>
<body>
    <header>
        <a class="logo">Registros Nequi</a>
        <input type="checkbox" id="menu-bar">
        <label for="menu-bar" class="fa fa-bars"></label>
            <nav class="navbar">
                <a href="nequi?accion=loginNequi">Ingrese</a>
                <a href="nequi?accion=abrirForm">Regístrese</a>
                <a href="nequi?accion=volver">Atrás</a>
            </nav>
    </header>
    <section class="tabla" id="tabla">
        <h1 class="heading">Registros Nequi</h1>
        <div>
            <table>
                    <tr>
                        <th>Id</th>
                        <th>Id Usuario</th>
                        <th>Valor Retiro</th>
                        <th>Valor Recarga</th>
                        <th>Saldo Actual</th>
                        <th>Estado</th>
                        <th>Acciones</th>
                    </tr>

                    <c:forEach var="nequi" items="${nequi}">

                    <tr>
                        <td>${nequi.getIdNequi()}</td>
                        <td>${nequi.getIdUsuario()}</td>
                        <td>${nequi.getRetiro()}</td>
                        <td>${nequi.getValorRecarga()}</td>
                        <td>${nequi.getSaldoActual()}</td>
                        <td>${nequi.getEstadoNequi()}</td>
                        <td>
                            <a class="btn" href="nequi?accion=editarForm&getIdNequi=${nequi.getIdNequi()}">Editar</a>
                        </td>
                        <td>
                            <a class="btn" href="nequi?accion=eliminarForm&getIdNequi=${nequi.getIdNequi()}">Eliminar</a>
                        </td>
                    </tr>

                    </c:forEach>
            </table>
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