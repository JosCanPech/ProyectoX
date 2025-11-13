<%@page import="Movimientos.DatosSesion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=h1, initial-scale=1.0">
        <link rel="stylesheet" href="CSS/LoginA.css">
        <meta http-equiv="X-UA-Compatible" content="IE-edge">
        <title>Registro</title>
    </head>
    <body>
        <%
        DatosSesion datos = (DatosSesion) session.getAttribute("datosUsuario");
        if (datos != null) {
        %>
        
        <form action="Menu.jsp" method="">
        <h1 class ="title"> Saldo Actual </h1>
        <br>
        <label>Tu saldo disponible es: <%=datos.getSaldo()%>
          <!--  <input placeholder="Tu saldo disposile es: " type="text" name="nombr">-->
        </label>
     
       <!-- <a href="" class="link">No tienes una cuenta</a>-->

        <button type="submit">Regresar al menu</button>

    </body>
</html>
