<%-- 
    Document   : InicioSesion
    Created on : 11 nov 2025, 8:12:03 a.m.
    Author     : josue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=h1, initial-scale=1.0">
        <link rel="stylesheet" href="CSS/LoginC.css">
        <meta http-equiv="X-UA-Compatible" content="IE-edge">
        <title>Iniciar Sesion</title>
    </head>
    <body>
        <form action="Svinicio" method="POST">
        <h1 class ="title"> Login </h1>
        <label>
            <input placeholder="Usuario/Cuenta" type="text" name="Usua">
        </label>
        <label>
            <input placeholder="Contraseña" type="password" name="Contra">
        </label>
        <a href="" class="link">¿Olvidaste tu contraseña?</a>

        <button type="submit">Iniciar Sesion</button>

    </body>
</html>
