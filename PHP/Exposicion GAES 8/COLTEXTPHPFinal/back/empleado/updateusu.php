<html>
    <head>
        <meta charset="UTF-8">
        <title>Actividad 10: Actualizacion de registros</title>
        <link href='https://fonts.googleapis.com/css?family=DM Serif Display' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet'>
        <link href="../../resources/css/stylesheet.css" rel="stylesheet" type="text/css"/>
        <script src="../../resources/js/validaciones.js" type="text/javascript"></script>
    </head>
    <body>
        <?php
        include '../session.php';
        include '../BDconect.php';
        $id = $_POST['id'];
        $sql = "SELECT * FROM usuario WHERE idUsuario = :id";
        $stmt = $connect->prepare($sql);
        $stmt->bindParam(':id', $id, PDO::PARAM_INT);
        $stmt->execute();
        $obj = $stmt->fetchObject();
        ?>
        <div class="banner">
            <a href="../../front/home.php" class="btn1"></a>
            <div class="center-text">
                <h1 class="titlefont">COLTEXT</h1>
            </div>
            <a href="../../front/404.php" class="btn2"></a>
            <a href="../../front/500.php" class="btn3"></a>
        </div>
        <div class="divider"></div>
        <div class="padre">
            <div class="container1"> 
                <h2 class="titlefont">Actualizar Empleado</h2>
                <form method="post" action="logicaactualizarremp.php" >
                    <table>
                        <tr>
                            <td><label for="firstName">Nombres:</label></td>
                            <td><input type="text" id="firstName" name="firstName" value= <?php echo $obj->nombres; ?> ></td>
                        </tr>
                        <tr>
                            <td><label for="lastName">Apellidos:</label></td>
                            <td><input type="text" id="lastName" name="lastName" required value="<?php echo $obj->apellidos; ?>" ></td>
                        </tr>
                        <tr>
                            <td><label for="email">Correo:</label></td>
                            <td><input type="email" id="email" name="email" required oninput="validarEmail('email')" value="<?php echo $obj->correo; ?>" ></td>
                        </tr>
                        <tr>
                            <td><label for="phoneNumber">Celular:</label></td>
                            <td><input type="text" id="phoneNumber" name="phoneNumber" value="<?php echo $obj->celular; ?>" ></td>
                        </tr>
                        <tr>
                            <td><label for="direccion">Dirección:</label></td>
                            <td><input type="text" id="direccion" name="direccion" required value="<?php echo $obj->direccion; ?>" ></td>
                        </tr>
                        <tr>
                            <td><label for="password">Contraseña:</label></td>
                            <td><input type="password" id="password" name="password" required value="<?php echo $obj->password; ?>" ></td>
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
                           if($query->rowCount()>0){
                               foreach ($resultsdep as $dep) {
                           ?> <option value="<?php echo $dep->idRol; ?>" <?php if($dep->idRol==$obj->Rol ){echo 'selected';} ?> ><?php echo $dep->Descripcion; ?>   </option>                           
                           <?php } }?>
                                </select> 
                            </td>
                        </tr>
                    </table>
                    <input type="hidden "name="id" id="id" value="<?php echo $id; ?>" />
                    <button type="submit" > Actualizar empleado </button>
                </form>  
            </div>
        </div>
        <div class="divider"></div>
        <div class="footer1">
            <a class="btn1"></a>
            <img src="../../resources/css/multimedia/coltext-reservado.PNG" alt="COLTEXT R" width="120" height="50"/>
        </div>
    </body>
</html>