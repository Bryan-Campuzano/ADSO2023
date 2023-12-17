<?php
include '../BDconect.php';

if (isset($_POST['eliminar'])) {
    $idUsuario = $_POST['id'];

    // Agregar código para eliminar el registro de la base de datos
    $sqlDelete = 'DELETE FROM coltext.usuario WHERE idUsuario = :idUsuario';
    $queryDelete = $connect->prepare($sqlDelete);
    $queryDelete->bindParam(':idUsuario', $idUsuario, PDO::PARAM_INT);

    if ($queryDelete->execute()) {
        // Redirigir al archivo principal después de la eliminación
            echo "<script>alert('El usuario se ha actualizado correctamente'); window.location='EmpleadosColtext.php';</script>";
    } else {
            echo "<script>alert('Error actualizando registro'); window.location='EmpleadosColtext.php';</script>";
    }
        $connect = null;
}
?>
