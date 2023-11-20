<?php
session_start();
if(!isset($_SESSION['usuario'])){
     echo "<script> alert('Su sesion ha caducado'); "
    . "window.location.replace('index.php');</script>";    
}
