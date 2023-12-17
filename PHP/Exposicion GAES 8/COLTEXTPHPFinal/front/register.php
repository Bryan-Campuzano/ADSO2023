<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Registro COLTEXT</title>
        <link href='https://fonts.googleapis.com/css?family=DM Serif Display' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet'>
        <link href="../resources/css/stylesheet.css" rel="stylesheet" type="text/css"/>
        <script src="resources/js/validaciones.js" type="text/javascript"></script>
    </head>
    <body>
        <?php
        include '../back/session.php';
        include '../back/BDconect.php';
        ?>
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
                <h1 class="titlefont">Registro Usuario</h1>
                <form method="post" action="../back/empleado/logicacrearemp.php" >
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
                    <button type="submit" > Crear Usuario </button>
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

