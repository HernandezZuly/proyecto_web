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
    <title>Formulario usuario</title>
</head>
<body>
    <header>
        <a class="logo">Formulario usuario</a>
         <input type="checkbox" id="menu-bar">
        <label for="menu-bar" class="fa fa-bars"></label>
            <nav class="navbar">
                <a href="usuario?accion=listar">Volver</a>
            </nav>
    </header>
    <section class="formulario" id="formulario">
        <div class="image">
            <img src="assets/img/registro.png" alt="imagen del login">
        </div>
    <c:forEach var="usuarios" items="${usuarios}">
        <form action="usuario" method="post">
            <h1 class="heading">Actualizar</h1>
                <div class="inputcaja">
                    <input type="hidden" name="idUsuario" id="idUsuario" required value="${usuarios.getIdUsuario()}">
                    <p>${usuarios.getIdUsuario()}</p></BR>
                </div>
                <div class="inputcaja">
                    <input type="text" name="nombre" id="nombre" required value="${usuarios.getNombre()}">
                    <label for="nombre">Nombre</label>
                </div>
                <div class="inputcaja">
                    <input type="text" name="apellido" id="apellido" required value="${usuarios.getApellido()}">
                    <label for="apellido">Apellido</label>
                </div>
                <div class="inputcaja">
                    <input type="text" name="tipoDocumento" id="tipoDocumento" required value="${usuarios.getTipoDocumento()}">
                    <label for="tipoDocumento">Tipo de documento</label>
                </div>
                <div class="inputcaja">
                    <input type="number" name="numeroDocumento" id="numeroDocumento" required value="${usuarios.getNumeroDocumento()}">
                    <label for="numeroDocumento">Número de documento</label>
                </div>
                <div class="inputcaja">
                    <input type="number" name="numeroCelular" id="numeroCelular" required value="${usuarios.getNumeroCelular()}">
                    <label for="numeroCelular">Número de celular</label>
                </div>
                <div class="inputcaja">
                    <input type="email" name="correo" id="correo" required value="${usuarios.getCorreo()}">
                    <label for="correo">Correo</label>
                </div>
                <div class="inputcaja">
                    <input type="number" name="numeroCuenta" id="numeroCuenta" required value="${usuarios.getNumeroCuenta()}">
                    <label for="clave">Numero De Cuenta</label>
                </div>
                <div class="inputcaja">
                    <input type="password" name="clave" id="clave" required value="${usuarios.getClave()}">
                    <label for="clave">Contraseña</label>
                </div>
                <div class="inputcaja">
                    <input type="checkbox" name="estadoUsuario" id="estadoUsuario" value="${usuarios.getEstadoUsuario()}">
                    <label for="estadoUsuario">Estado</label>
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