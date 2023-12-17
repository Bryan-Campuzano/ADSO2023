<?php
session_start();
if(!isset($_SESSION['usuario'])){
     echo "<script> alert('Su sesion ha caducado'); "
    . "window.location.replace('home.php');</script>";    
}
/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Scripting/EmptyPHP.php to edit this template
 */

