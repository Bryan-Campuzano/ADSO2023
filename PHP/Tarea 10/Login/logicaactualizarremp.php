<?php
include './BDconect.php';
if($_SERVER["REQUEST_METHOD"] == "POST"){
    $firstName = $_POST["firstName"];
    $lastName = $_POST["lastName"];
    $email = $_POST["email"];
    $phoneNumber = $_POST["phoneNumber"];
    $hireDate = $_POST["hireDate"];
    $salary = $_POST["salary"];
    $departmentId= $_POST["departmentId"];
    $managerId= $_POST["managerId"];
    $jobId= $_POST["jobId"];
    $id=$_POST["id"];
    
    $sql = "UPDATE EMPLOYEES SET first_name=:firstName,last_name=:lastName,email=:email,phone_number=:phoneNumber,hire_date=:hireDate,salary=:salary,department_id=:departmentId,manager_id=:managerId,job_id=:jobId "
            . " WHERE employee_id=:id";

    $query = $connect->prepare($sql);    
    $query->bindParam(':firstName',$firstName);
    $query->bindParam(':lastName',$lastName);
    $query->bindParam(':email',$email);
    $query->bindParam(':phoneNumber',$phoneNumber);
    $query->bindParam(':hireDate',$hireDate);
    $query->bindParam(':salary',$salary);
    $query->bindParam(':departmentId',$departmentId);
    $query->bindParam(':managerId',$managerId);
    $query->bindParam(':jobId',$jobId);
    $query->bindParam(':id',$id);
    
    
    if($query->execute()){
        echo "<script>alert('El registro se ha actualizado correctamente'); window.location='listarempleados.php';</script>";        
    }else{
        echo "<script>alert('Error actualizando registro'); window.location='listarempleados.php';</script>";
    }    
    $connect=null;   
}


?>
