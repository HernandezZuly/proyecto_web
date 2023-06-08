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
    <title>Registros Daviplata</title>
</head>
<body>
    <header>
        <a class="logo">Registros Daviplata</a>
        <input type="checkbox" id="menu-bar">
        <label for="menu-bar" class="fa fa-bars"></label>
            <nav class="navbar">
                <a href="daviplata?accion=loginDaviplata">Ingrese</a>
                <a href="daviplata?accion=abrirForm">Regístrese</a>
                <a href="daviplata?accion=volver">Atrás</a>
            </nav>
    </header>
    <section class="formulario" id="formulario">
        <h1 class="heading">Registros Daviplata</h1><BR>
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

                    <c:forEach var="daviplata" items="${aviplata}">

                    <tr>
                        <td>${daviplata.getIdDaviplata()}</td>
                        <td>${daviplata.getIdUsuario()}</td>
                        <td>${daviplata.getRetiro()}</td>
                        <td>${daviplata.getValorRecarga()}</td>
                        <td>${daviplata.getSaldoActual()}</td>
                        <td>${daviplata.getEstadoDaviplata()}</td>
                        <td>
                            <a class="btn" href="daviplata?accion=editarForm&getIdDaviplata=${daviplata.getIdDaviplata()}">Editar</a>
                        </td>
                        <td>
                            <a class="btn" href="daviplata?accion=eliminarForm&getIdDaviplata=${daviplata.getIdDaviplata()}">Eliminar</a>
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