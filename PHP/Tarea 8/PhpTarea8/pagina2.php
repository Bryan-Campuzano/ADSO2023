<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/Project/PHP/PHPProject.php to edit this template
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title>Actividad 8: Lectura, filtrado multi criterio y exportación de registros</title>
        <link href='https://fonts.googleapis.com/css?family=DM Serif Display' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet'>
        <link href="resources/css/login.css" rel="stylesheet" type="text/css"/>
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
                <p>EL LOGIN COLTEXT FUNCIONA</p>
            </div>
        </div>
        <div class="divider"></div>
        <div class="footer1">
            <h1 class="titlefont">COLTEXT FOOTER</h1>
        </div>
        <?php
        session_start();
        if (isset($_SESSION['usuario'])) {
            echo '<div class="container1">Bienvenido usuario: ' . $_SESSION['usuario'] . '</div>';
        } else {
            echo "<script> alert('Su sesion ha caducado'); "
            . "window.location.replace('index.php');</script>";
        }
        ?>
    </body>
</html>
