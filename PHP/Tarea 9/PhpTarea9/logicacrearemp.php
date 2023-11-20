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
    
    $sql = "INSERT INTO employees (first_name,last_name,email,phone_number,hire_date,salary,department_id,manager_id,job_id) "
            . "VALUES (:firstName,:lastName,:email,:phoneNumber,:hireDate,:salary,:departmentId,:managerId,:jobId) ";

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
    
    if($query->execute()){
        echo "<script>alert('El registro se inserto correctamente'); window.location='listarempleados.php';</script>";        
    }else{
        echo "<script>alert('Error insertndo registro'); window.location='listarempleados.php';</script>";
    }
    
    $connect=null;
    
}


?>
