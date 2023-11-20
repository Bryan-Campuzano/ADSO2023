<?php

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Scripting/EmptyPHP.php to edit this template
 */

include './BDconect.php';

$user = $_POST['email'];
$pass = $_POST['password'];
$sql = "SELECT * FROM coltext.usuario WHERE correo = :user AND password = :pass";
$query = $connect->prepare($sql);
$query->bindParam(':user', $user, PDO::PARAM_STR);
$query->bindParam(':pass', $pass, PDO::PARAM_STR);
$query->execute();

if ($query->rowCount() > 0) {
    session_start();
    $_SESSION['usuario'] = $user;
    echo "<script>window.location.replace('pagina2.php');</script>";
} else {
    echo "<script> alert('Nombre de usuario y/o contraseña incorrectos'); "
    . "window.location.replace('index.php');</script>";
}

/*
if (strcasecmp($_POST['email'],"usuario@coltext.com")==0 && strcmp($_POST['password'],"COCOcoco1234@")==0){
    session_start();
    $_SESSION['usuario'] = $_POST['email'];
    echo "<script>window.location.replace('pagina2.php');</script>";
}else{   
    echo "<script> alert('Nombre de usuario y/o contraseña incorrectos'); "
    . "window.location.replace('index.php');</script>";
}
*/