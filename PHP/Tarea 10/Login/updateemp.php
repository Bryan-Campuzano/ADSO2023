<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
        <script src="resources/js/validaciones.js" type="text/javascript"></script>
    </head>
    <body>
        <?php 
        include './session.php';
        include './BDconect.php'; 
        $id = $_POST['id'];
        $sql= "SELECT * FROM employees WHERE employee_id = :id"; 
        $stmt = $connect->prepare($sql);
        $stmt->bindParam(':id', $id, PDO::PARAM_INT); 
        $stmt->execute();
        $obj = $stmt->fetchObject();
        ?>
        <h2>Actualizar Empleado</h2>
        <form method="post" action="logicaactualizarremp.php" >
            <table>
                <tr>
                    <td><label for="firstName">FirstName:</label></td>
                    <td><input type="text" id="firstName" name="firstName" value="<?php echo $obj->first_name;?>" ></td>
                </tr>
                <tr>
                    <td><label for="lastName">LastName:</label></td>
                    <td><input type="text" id="lastName" name="lastName" required value="<?php echo $obj->last_name;?>" ></td>
                </tr>
                <tr>
                    <td><label for="email">Email:</label></td>
                    <td><input type="email" id="email" name="email" required value="<?php echo $obj->email;?>" oninput="validarEmail('email')" > </td>
                </tr>
                <tr>
                    <td><label for="phoneNumber">PhoneNumber:</label></td>
                    <td><input type="text" id="phoneNumber" name="phoneNumber" value="<?php echo $obj->phone_number;?>" ></td>
                </tr>
                <tr>
                    <td><label for="hireDate">HireDate:</label></td>
                    <td><input type="date" id="hireDate" name="hireDate" required value="<?php echo $obj->hire_date;?>"></td>
                </tr>
                <tr>
                    <td><label for="salary">Salary:</label></td>
                    <td><input type="text" id="salary" name="salary" required value="<?php echo $obj->salary;?>"></td>
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
                           ?> <option value="<?php echo $dep->department_id; ?>" <?php if($dep->department_id==$obj->department_id ){echo 'selected';} ?> ><?php echo $dep->department_name; ?>   </option>                           
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
            <input type="hidden "name="id" id="id" value="<?php echo $id; ?>" />
            <button type="submit" > Actualizar empleado </button>
        </form>        
    </body>
</html>