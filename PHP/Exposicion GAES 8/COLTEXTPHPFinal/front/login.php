<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Inicio Sesion COLTEXT</title>
        <link href='https://fonts.googleapis.com/css?family=DM Serif Display' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet'>
        <link href="../resources/css/stylesheet.css" rel="stylesheet" type="text/css"/>
        <script src="resources/js/validaciones.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="banner">
            <a href="home.php" class="btn1"></a>
            <div class="center-text">
                <h1 class="titlefont">COLTEXT</h1>
            </div>
            <a href="404.php" class="btn2"></a>
            <a href="500.php" class="btn5"></a>
        </div>

        <div class="divider"></div>
        <div class="padre">
            <div class="container1">
                <h1 class="titlefont">Ingreso</h1>
                <p>Registra tus credenciales</p>
                <form action="../back/validacion.php" method="post" onsubmit="return validarFormulario();">
                    <label for="email">Correo Electronico:</label>
                    <input type="email" id="email" name="email" required>
                    <br>
                    <label for="password">Contraseña:</label>
                    <input type="password" id="password" name="password" required oninput="validarTamano('password', 6, 12);">
                    <br>
                    <button type="submit">Ingresar</button>
                </form>
            </div>
        </div>
        <div class="divider"></div>
        <div class="footer1">
            <a href="home.php" class="btn1"></a>
            <img src="../resources/css/multimedia/coltext-reservado.PNG" alt="COLTEXT R" width="120" height="50"/>
        </div>
    </body>
</html>
