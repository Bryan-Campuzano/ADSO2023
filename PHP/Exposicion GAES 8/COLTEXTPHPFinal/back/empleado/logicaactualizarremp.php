<?php
include '../BDconect.php';

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $id = $_POST["id"];
    $firstName = $_POST["firstName"];
    $lastName = $_POST["lastName"];
    $email = $_POST["email"];
    $phoneNumber = $_POST["phoneNumber"];
    $direccion = $_POST["direccion"];
    $password = $_POST["password"];
    $rol = $_POST["idRol"];

    // Consulta SQL para obtener los datos actuales del usuario
    $sql = "SELECT idUsuario, nombres, apellidos, correo, celular, direccion, password, Rol FROM usuario WHERE idUsuario = :id";
    $query = $connect->prepare($sql);
    $query->bindParam(':id', $id, PDO::PARAM_INT);
    $query->execute();
    $obj = $query->fetchObject();

    // Verifica si se encontró el registro antes de intentar acceder a sus propiedades
    if ($obj) {
        // Actualiza los campos necesarios
        $obj->nombres = $firstName;
        $obj->apellidos = $lastName;
        $obj->correo = $email;
        $obj->celular = $phoneNumber;
        $obj->direccion = $direccion;
        $obj->Rol = $rol;
        $obj->password = $password;

        // Consulta SQL para actualizar el usuario
        $sqlUpdate = "UPDATE usuario SET nombres=:nombres, apellidos=:apellidos, correo=:correo, celular=:celular, direccion=:direccion, Rol=:Rol, password=:password WHERE idUsuario=:id";

        $queryUpdate = $connect->prepare($sqlUpdate);
        $queryUpdate->bindParam(':nombres', $obj->nombres);
        $queryUpdate->bindParam(':apellidos', $obj->apellidos);
        $queryUpdate->bindParam(':correo', $obj->correo);
        $queryUpdate->bindParam(':celular', $obj->celular);
        $queryUpdate->bindParam(':direccion', $obj->direccion);
        $queryUpdate->bindParam(':Rol', $obj->Rol);
        $queryUpdate->bindParam(':password', $obj->password);
        $queryUpdate->bindParam(':id', $obj->idUsuario, PDO::PARAM_INT);

        if ($queryUpdate->execute()) {
            echo "<script>alert('El usuario se ha actualizado correctamente'); window.location='EmpleadosColtext.php';</script>";
        } else {
            echo "<script>alert('Error actualizando registro'); window.location='EmpleadosColtext.php';</script>";
        }
    } else {
        echo "<script>alert('No se encontró el registro.'); window.location='EmpleadosColtext.php';</script>";
    }

    $connect = null;
}
