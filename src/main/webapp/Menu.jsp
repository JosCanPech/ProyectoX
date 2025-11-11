<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        // Verificar si hay sesión activa
       /*
        String usuario = (String) session.getAttribute("usuario");
        if (usuario == null) {
            response.sendRedirect("InicioSesion.jsp");
            return;
        }*/
    %>

    <div class="container">
        <h1>Menú Principal</h1>
        <p class="welcome">Bienvenido</p>

        <div class="menu-options">
            <form action="" method="GET">
                <button type="submit" class="menu-btn">Ingresar</button>
            </form>
            
            <form action="" method="GET">
                <button type="submit" class="menu-btn">Transferir</button>
            </form>
            
            <form action="" method="GET">
                <button type="submit" class="menu-btn">Retirar</button>
            </form>
        </div>

        <form action="" method="POST">
            <button type="submit" name="cerrarSesion" class="menu-btn logout-btn">Cerrar Sesión</button>
        </form>
    </div>
</body>
</html>