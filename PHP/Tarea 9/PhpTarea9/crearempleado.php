<html>
    <head>
        <meta charset="UTF-8">
        <title>Actividad 9: Construccion de select dinamicos</title>
        <script src="resources/js/validaciones.js" type="text/javascript"></script>
    </head>
    <body>
        <?php 
        include './session.php';
        include './BDconect.php'; ?>
        <h2>Crear Empleado</h2>
        <form method="post" action="logicacrearemp.php" >
            <table>
                <tr>
                    <td><label for="firstName">FirstName:</label></td>
                    <td><input type="text" id="firstName" name="firstName"></td>
                </tr>
                <tr>
                    <td><label for="lastName">LastName:</label></td>
                    <td><input type="text" id="lastName" name="lastName" required></td>
                </tr>
                <tr>
                    <td><label for="email">Email:</label></td>
                    <td><input type="email" id="email" name="email" required oninput="validarEmail('email')" > </td>
                </tr>
                <tr>
                    <td><label for="phoneNumber">PhoneNumber:</label></td>
                    <td><input type="text" id="phoneNumber" name="phoneNumber"></td>
                </tr>
                <tr>
                    <td><label for="hireDate">HireDate:</label></td>
                    <td><input type="date" id="hireDate" name="hireDate" required></td>
                </tr>
                <tr>
                    <td><label for="salary">Salary:</label></td>
                    <td><input type="text" id="salary" name="salary" required></td>
                </tr>
                <tr>
                    <td><label for="departmentId">DepartmentId:</label></td>
                    <td>
                        <select id="departmentId" name="departmentId">
                           <?php 
                           $sql = "SELECT department_id,department_name FROM hr.departments";
                           $query = $connect->prepare($sql);
                           $query->execute();
                           $resultsdep = $query->fetchAll(PDO::FETCH_OBJ);
                           if($query->rowCount()>0){
                               foreach ($resultsdep as $dep) {
                           ?> <option value="<?php echo $dep->department_id; ?>"><?php echo $dep->department_name; ?></option>                           
                           <?php } }?>
                        </select> 
                    </td>
                </tr>
                <tr>
                    <td><label for="managerId">ManagerId:</label></td>
                    <td>
                        <select id="managerId" name="managerId">                      
                            <option value="100">Manager 1</option>
                            <option value="2">Manager 2</option>                   
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><label for="jobId">JobId:</label></td>
                    <td>
                        <select id="jobId" name="jobId" required>                      
                            <option value="9">Job 1</option>
                            <option value="2">Job 2</option>                     
                        </select>
                    </td>
                </tr>
            </table>
            <button type="submit" > Crear empleado </button>
        </form>        
    </body>
</html>

