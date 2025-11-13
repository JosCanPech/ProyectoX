<%-- 
    Document   : Menu
    Created on : 11 nov 2025, 8:42:00 p.m.
    Author     : josue y equipo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Movimientos.DatosSesion" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/Menu.css">
    <meta http-equiv="X-UA-Compatible" content="IE-edge">
    <title>Menú Principal</title>
</head>
<body>
    <%
        DatosSesion datos = (DatosSesion) session.getAttribute("datosUsuario");
        if (datos != null) {
    %>
    
    <div class="container">
        <div class="header">
            <h1>Bienvenido, <%=datos.getNombre()%></h1>
            <h1>Saldo, <%=datos.getSaldo()%></h1>
        </div>

        <div class="menu-options">
            <form action="Transferencia.jsp" method="GET">
                <button type="submit" class="menu-btn">Transferir</button>
            </form>
            
            <form action="Retiro.jsp" method="GET">
                <button type="submit" class="menu-btn">Retirar</button>
            </form>
        </div>

        <form action="InicioSesion.jsp" method="GET">
            <button type="submit" class="menu-btn logout-btn">Cerrar Sesión</button>
        </form>
    </div>
    
    <%
        } else {
    %>
    
    <div class="container">
        <h1>No hay usuario en sesión</h1>
        <form action="InicioSesion.jsp" method="GET">
            <button type="submit" class="menu-btn">Ir a Inicio de Sesión</button>
        </form>
    </div>
    
    <%
        }
    %>
</body>
</html>