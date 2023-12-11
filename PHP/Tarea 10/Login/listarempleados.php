<html>
    <head>
        <title>Empleados</title>
        <link rel="stylesheet" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css"></link>
        <link rel="stylesheet" href="https://cdn.datatables.net/buttons/2.2.3/css/buttons.dataTables.min.css"></link>        
    </head>
    <body>    
        <a href="crearempleado.php">Crear empleado</a>
        <?php
        include './session.php';   
        include './BDconect.php';
        $sql = "SELECT 
E.employee_id,
E.first_name,
E.last_name,
E.email,
E.phone_number,
E.hire_date,
D.department_name,
J.job_title,
E.salary
FROM employees E INNER JOIN departments D ON E.department_id=D.department_id
INNER JOIN jobs J ON E.job_id=J.job_id;";
        $query = $connect->prepare($sql);
        $query->execute();
        $results = $query->fetchAll(PDO::FETCH_OBJ);
//var_dump($results);
        if ($query->rowCount() > 0) {
            echo '<table id="t-all" class="display nowrap" style="width: 80%" border="1"> <thead>';
            echo '<th>CÓDIGO</th>';
            echo '<th>NOMBRES</th>';
            echo '<th>APELLIDOS</th>';
            echo '<th>CORREO</th>';
            echo '<th>TELEFONO</th>';
            echo '<th>FECHA CONTRATO</th>';
            echo '<th>DEPARTAMENTO</th>';
            echo '<th>CARGO</th>';
            echo '<th>SALARIO</th>';
            echo '<th>ACCIONES</th>';
            echo '</thead><tbody>';
            foreach ($results as $result) {
                echo '<tr>
        <td>' . $result->employee_id . '</td>
        <td>' . $result->first_name . '</td>
        <td>' . $result->last_name . '</td>
        <td>' . $result->email . '</td>
        <td>' . $result->phone_number . '</td>
        <td>' . $result->hire_date . '</td>
        <td>' . $result->department_name . '</td>
        <td>' . $result->job_title . '</td>
        <td>' . $result->salary . '</td> '
              . '<td><form action="updateemp.php" method="POST">  
            <input type="hidden" name="id" id="id" value="' . $result->employee_id. '">
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
    </body>
</html>