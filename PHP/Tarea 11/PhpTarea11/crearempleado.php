<html>
    <head>
        <meta charset="UTF-8">
        <title>Actividad 10: Actualizacion de registros</title>
        <link href='https://fonts.googleapis.com/css?family=DM Serif Display' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet'>
        <link href="resources/css/login.css" rel="stylesheet" type="text/css"/>
        <script src="resources/js/validaciones.js" type="text/javascript"></script>
    </head>
    <body>
        <?php
        include './session.php';
        include './BDconect.php';
        ?>
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
                <h1 class="titlefont">Crear Empleado</h1>
                <form method="post" action="logicacrearemp.php" >
                    <table>
                        <tr>
                            <td><label for="firstName">Nombres:</label></td>
                            <td><input type="text" id="firstName" name="firstName"></td>
                        </tr>
                        <tr>
                            <td><label for="lastName">Apellidos:</label></td>
                            <td><input type="text" id="lastName" name="lastName" required></td>
                        </tr>
                        <tr>
                            <td><label for="email">Correo:</label></td>
                            <td><input type="email" id="email" name="email" required oninput="validarEmail('email')" > </td>
                        </tr>
                        <tr>
                            <td><label for="phoneNumber">Celular:</label></td>
                            <td><input type="text" id="phoneNumber" name="phoneNumber"></td>
                        </tr>
                        <tr>
                            <td><label for="direccion">Dirección:</label></td>
                            <td><input type="text" id="direccion" name="direccion" required></td>
                        </tr>
                        <tr>
                            <td><label for="password">Contraseña:</label></td>
                            <td><input type="password" id="password" name="password" required></td>
                        </tr>
                        <tr>
                            <td><label for="idRol">Rol:</label></td>
                            <td>
                                <select id="idRol" name="idRol">
                                    <?php
                                    $sql = "SELECT rol.idRol,rol.Descripcion FROM coltext.rol";
                                    $query = $connect->prepare($sql);
                                    $query->execute();
                                    $resultsdep = $query->fetchAll(PDO::FETCH_OBJ);
                                    if ($query->rowCount() > 0) {
                                        foreach ($resultsdep as $dep) {
                                            ?> <option value="<?php echo $dep->idRol; ?>"><?php echo $dep->Descripcion; ?></option>                           
                                        <?php
                                        }
                                    }
                                    ?>
                                </select> 
                            </td>
                        </tr>
                    </table>
                    <button type="submit" > Crear empleado </button>
                </form>   
            </div>
        </div>
        <div class="divider"></div>
        <div class="footer1">
            <h1 class="titlefont">COLTEXT FOOTER</h1>
        </div>
    </body>
</html>

