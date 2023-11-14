<?php

/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Scripting/EmptyPHP.php to edit this template
 */

session_start();
if(isset($_SESSION['usuario'])){
echo 'Pagina de inicio';
}else{
     echo "<script> alert('Su sesion ha caducado'); "
    . "window.location.replace('index.php');</script>";    
}
