<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/Project/PHP/PHPProject.php to edit this template
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title>Login</title>
        <link href="resources/css/login.css" rel="stylesheet" type="text/css"/>
        <script src="resources/js/validaciones.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="container">
            <form action="validacion.php" method="POST">
                <table border="1">                   
                    <tbody>
                        <tr>
                            <td><label for="email">Correo Electrónico:</label> </td>
                            <td><input type="email" id="email" name="email" required ></td>
                        </tr>
                        <tr>
                            <td><label for="contrasena">Contraseña:</label></td>
                            <td><input type="password" id="contrasena" name="contrasena" required oninput="validarTamano('contrasena',2,8)" ></td>
                        </tr>
                        <tr>
                            <td colspan="2" style="text-align: center;"> <button type="submit">Enviar</button> </td>
                            
                        </tr>
                    </tbody>
                </table>   
            </form>
        </div>
    </body>
</html>
