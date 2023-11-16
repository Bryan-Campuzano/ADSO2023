<?php

include './BDconect.php';

$user = $_POST['user'];
$pass = $_POST['contrasena'];

$sql = "SELECT * FROM user WHERE username = :user AND password = :pass";
$query = $connect->prepare($sql);
$query->bindParam(':user',$user,PDO::PARAM_STR);
$query->bindParam(':pass',$pass,PDO::PARAM_STR);
$query->execute();

if($query->rowCount() > 0 ){
    session_start();
    $_SESSION['usuario'] = $user;
    echo "<script>window.location.replace('pagina2.php');</script>"; 
}else{
      echo "<script> alert('Nombre de usuario y/o contraseña incorrectos'); "
    . "window.location.replace('index.php');</script>";    
}

/*
if (strcasecmp($_POST['email'],"pruebas@gmail.com")==0 && strcmp($_POST['contrasena'],"admin")==0){
    session_start();
    $_SESSION['usuario'] = $_POST['email'];
    echo "<script>window.location.replace('pagina2.php');</script>";
}else{   
    echo "<script> alert('Nombre de usuario y/o contraseña incorrectos'); "
    . "window.location.replace('index.php');</script>";
}
*/