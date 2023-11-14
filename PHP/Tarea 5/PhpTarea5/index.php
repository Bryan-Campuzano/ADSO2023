<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/Project/PHP/PHPProject.php to edit this template
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title>Actividad 5: Inicio de Sesión</title>
        <link href='https://fonts.googleapis.com/css?family=DM Serif Display' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet'>
        <style>
            .container1 {
                display: flex;
                justify-content: center;
                flex-direction: column;
                align-items: center;
                border: 1px solid #ccc;
                padding: 20px;
                height: auto; /* Esto centra verticalmente en la página */
                background-color: #e9e3bb;
                font-family: 'Montserrat';font-size: 22px;
                width: auto;
                border-radius: 20px;
                box-shadow: 0 20px 35px rgba(0, 0, 0, 0.444);
            }
           .divider{
                padding: 20px;
                height: 10vh; /* Esto centra verticalmente en la página */
                background-color: transparent;
            }
            .banner {
                display: flex;
                justify-content: space-between;
                align-items: center;
                background-color: #042212;
                padding: 10px;
            }
            .footer1{
                display: flex;
                justify-content: space-between;
                align-items: center;
                background-color: #042212;
                padding: 10px;
            }
            .titlefont {
                font-family: 'DM Serif Display';
                font-size: 72px;
                margin: 0;
                color: #a57512;
            }
        </style>
    </head>
    <body>
        <div class="banner">
        <a href="home.html" class="btn1"></a>
        <div class="center-text">
            <h1 class="titlefont">COLTEXT</h1>
        </div>
        <a href="404.html" class="btn2"></a>
        <a href="500.html" class="btn3"></a>
    </div>

    <div class="divider"></div>
    <div class="padre">
        <div class="container1">
            <h1 class="titlefont">Ingreso</h1>
            <p>Registra tus credenciales</p>
            <form action="validacion.php" method="post">
                <label for="username">Correo Electronico:</label>
                <input type="text" id="username" name="username" required>
                <br>
                <label for="password">Contraseña:</label>
                <input type="password" id="password" name="password" required>
                <br>
                <button type="submit">Ingresar</button>
            </form>
        </div>
    </div>
    <div class="divider"></div>
    <div class="footer1">
        <h1 class="titlefont">COLTEXT FOOTER</h1>
    </div>
    </body>
</html>

