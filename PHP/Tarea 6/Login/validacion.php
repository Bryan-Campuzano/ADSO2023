<?php

/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Scripting/EmptyPHP.php to edit this template
 */

if (strcasecmp($_POST['email'],"pruebas@gmail.com")==0 && strcmp($_POST['contrasena'],"admin")==0){
    session_start();
    $_SESSION['usuario'] = $_POST['email'];
    echo "<script>window.location.replace('pagina2.php');</script>";
}else{   
    echo "<script> alert('Nombre de usuario y/o contraseña incorrectos'); "
    . "window.location.replace('index.php');</script>";
}