<html>
    <head>
        <title>Actividad 8: Lectura, filtrado multi criterio y exportación de registros</title>
        <link rel="stylesheet" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css"></link>
        <link rel="stylesheet" href="https://cdn.datatables.net/buttons/2.2.3/css/buttons.dataTables.min.css"></link>   
        <style>
            /* Aplica estilos de centrado al contenedor principal para centrar todo su contenido en la mitad de la pantalla*/
            .container {
                display: flex;
                flex-direction: column;
                align-items: center;
                justify-content: center;
                text-align: center; /* Esto centra horizontalmente el texto */
            }
            .body {
                background-color: #d9d9d9; /* Cambia #FF0000 a tu color hexadecimal deseado */
            }
        </style>
    </head>
    <body>
        <div class="container">
            <?php
            /*
             * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
             * Click nbfs://nbhost/SystemFileSystem/Templates/Scripting/EmptyPHP.php to edit this template
             */
            include './BDconect.php';
            $sql = 'SELECT
                E.idUsuario,
                E.nombres,
                E.apellidos,
                E.correo,
                E.celular,
                E.direccion,
                R.Descripcion,
                P.nombre
                FROM coltext.usuario E INNER JOIN coltext.rol R ON E.Rol = R.idRol
                INNER JOIN coltext.pyme P ON E.idUsuario = P.empleados';
            $query = $connect->prepare($sql);
            $query->execute();
            $results = $query->fetchAll(PDO::FETCH_OBJ);
            //var_dump($results);
            if ($query->rowCount() > 0) {
                echo '<table id="t-all" class="display nowrap" style="width: 100%"border = "2"><thead><tr>';
                echo '<th>ID Usuario</th>';
                echo '<th>Nombres</th>';
                echo '<th>Apellidos</th>';
                echo '<th>Correo</th>';
                echo '<th>Celular</th>';
                echo '<th>Direccion</th>';
                echo '<th>Rol</th>';
                echo '<th>Empresa</th></tr></thead></tbody>';
                foreach ($results as $result) {
                    echo '<tr>
                    <td>' . $result->idUsuario . '</td>
                    <td>' . $result->nombres . '</td>
                    <td>' . $result->apellidos . '</td>
                    <td>' . $result->correo . '</td>
                    <td>' . $result->celular . '</td>
                    <td>' . $result->direccion . '</td>
                    <td>' . $result->Descripcion . '</td>
                    <td>' . $result->nombre . '</td> </tr>';
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
    </body>
</html>