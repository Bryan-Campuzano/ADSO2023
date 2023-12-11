<?php
include './BDconect.php';
if($_SERVER["REQUEST_METHOD"] == "POST"){
    $firstName = $_POST["firstName"];
    $lastName = $_POST["lastName"];
    $email = $_POST["email"];
    $phoneNumber = $_POST["phoneNumber"];
    $direccion = $_POST["direccion"];
    $password = $_POST["password"];
    $rol= $_POST["idRol"];
    
    $sql = "INSERT INTO usuario (nombres, apellidos, correo, celular, direccion, Rol, password) "
            . "VALUES (:firstName,:lastName,:email,:phoneNumber,:direccion,:idRol,:password) ";

    $query = $connect->prepare($sql);
    
    $query->bindParam(':firstName',$firstName);
    $query->bindParam(':lastName',$lastName);
    $query->bindParam(':email',$email);
    $query->bindParam(':phoneNumber',$phoneNumber);
    $query->bindParam(':direccion',$direccion);
    $query->bindParam(':idRol',$rol);
    $query->bindParam(':password',$password);

    if($query->execute()){
        echo "<script>alert('El registro se inserto correctamente'); window.location='listarempleados.php';</script>";        
    }else{
        echo "<script>alert('Error insertando registro'); window.location='listarempleados.php';</script>";
    }
    
    $connect=null;
    
}


?>
