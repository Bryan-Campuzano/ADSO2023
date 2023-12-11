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
    
    $sql = "UPDATE usuario SET nombres=:firstName,apellidos=:lastName,correo=:email,celular=:phoneNumber,direccion=:direccion,Rol=:idRol, password=:password "
            . " WHERE idUsuario=:id";

    $query = $connect->prepare($sql);    
    $query->bindParam(':firstName',$firstName);
    $query->bindParam(':lastName',$lastName);
    $query->bindParam(':email',$email);
    $query->bindParam(':phoneNumber',$phoneNumber);
    $query->bindParam(':direccion',$direccion);
    $query->bindParam(':idRol',$rol);
    $query->bindParam(':password',$password);
    
    
    if($query->execute()){
        echo "<script>alert('El registro se ha actualizado correctamente'); window.location='listarempleados.php';</script>";        
    }else{
        echo "<script>alert('Error actualizando registro'); window.location='listarempleados.php';</script>";
    }    
    $connect=null;   
}


?>
