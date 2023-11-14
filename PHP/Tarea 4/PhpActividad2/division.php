<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/Project/PHP/PHPProject.php to edit this template
-->
<?php
function dividir($a, $b) {
    if ($b != 0) {
        return $a / $b;
    } else {
        return "No se puede dividir por cero.";
    }
}
