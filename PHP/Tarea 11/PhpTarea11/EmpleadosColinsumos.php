<html>
    <head>
        <title>Actividad 10: Actualizacion de registros</title>
        <link rel="stylesheet" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css"></link>
        <link rel="stylesheet" href="https://cdn.datatables.net/buttons/2.2.3/css/buttons.dataTables.min.css"></link>   
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
                <h1 class="titlefont">Lista de Empleados ColText</h1>
                <a href="crearempleado.php">Crear empleado</a>
                <?php
                /*
                 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
                 * Click nbfs://nbhost/SystemFileSystem/Templates/Scripting/EmptyPHP.php to edit this template
                 */
                include './BDconect.php';
                include './session.php';
                $sql = 'SELECT
                E.idUsuario,
                E.nombres,
                E.apellidos,
                E.correo,
                E.celular,
                E.direccion,
                R.Descripcion
                FROM coltext.usuario E INNER JOIN coltext.rol R ON E.Rol = R.idRol';
                $query = $connect->prepare($sql);
                $query->execute();
                $results = $query->fetchAll(PDO::FETCH_OBJ);
                //var_dump($results);
                if ($query->rowCount() > 0) {
                    echo '<table id="t-all" class="display nowrap" border = "2"><thead><tr>';
                    echo '<th>ID Usuario</th>';
                    echo '<th>Nombres</th>';
                    echo '<th>Apellidos</th>';
                    echo '<th>Correo</th>';
                    echo '<th>Celular</th>';
                    echo '<th>Direccion</th>';
                    echo '<th>Rol</th>';
                    foreach ($results as $result) {
                        echo '<tr>
                    <td>' . $result->idUsuario . '</td>
                    <td>' . $result->nombres . '</td>
                    <td>' . $result->apellidos . '</td>
                    <td>' . $result->correo . '</td>
                    <td>' . $result->celular . '</td>
                    <td>' . $result->direccion . '</td>
                    <td>' . $result->Descripcion . '</td> </tr>'
                        . '<td><form action="updateemp.php" method="POST">  
            <input type="hidden" name="id" id="id" value="' . $result->idUsuario . '">
            <button type="submit"> Actualizar </button>
        </form></td> </tr>';
                    }
                    echo '</tbody></table>';
                }
                ?>
                <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
                <script type="text/javascript" src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
                <script type="text/javascript" src="https://cdn.datatables.net/buttons/2.2.3/js/dataTables.buttons.min.js"></script>
                <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
                <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
                <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
                <script type="text/javascript" src="https://cdn.datatables.net/buttons/2.2.3/js/buttons.html5.min.js"></script>
                <script type="text/javascript" src="https://cdn.datatables.net/buttons/2.2.3/js/buttons.print.min.js"></script> 
                <script>
                    $(document).ready(function () {
                        $('#t-all').DataTable({
                            dom: 'Bfrtip',
                            buttons: [
                                'copy', 'csv', 'excel', 'pdf', 'print'
                            ]
                        });
                    });</script>
            </div>
        </div>
        <div class="divider"></div>
        <div class="footer1">
            <h1 class="titlefont">COLTEXT FOOTER</h1>
        </div>
    </body>
</html>