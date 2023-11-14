<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/Project/PHP/PHPProject.php to edit this template
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title>Actividad 2: Calculadora</title>
        <link href='https://fonts.googleapis.com/css?family=DM Serif Display' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet'>
        <style>
            .container1 {
                display: flex;
                justify-content: center;
                flex-direction: column;
                align-items: center;
                border: 1px solid #ccc;
                padding: 20px;
                height: auto; /* Esto centra verticalmente en la página */
                background-color: #e9e3bb;
                font-family: 'Montserrat';font-size: 22px;
                width: auto;
                border-radius: 20px;
                box-shadow: 0 20px 35px rgba(0, 0, 0, 0.444);
            }
           .divider{
                padding: 20px;
                height: 10vh; /* Esto centra verticalmente en la página */
                background-color: transparent;
            }
        </style>
    </head>
    <body>
        <div class = "divider"></div>
        <div class = "container1"> 
            <h2>Calculadora Basica</h2>
            <form method="post">
                <div class="form-group">
                    <label for="valor1">Valor 1:</label>
                    <input type="number" name="valor1" id="valor1" value="<?php echo $valor1; ?>"><br>
                </div>
                <div class="form-group">
                    <label for="valor2">Valor 2:</label>
                    <input type="number" name="valor2" id="valor2" value="<?php echo $valor2; ?>"><br>
                </div>
                <div class="form-group">
                    <input type="submit" name="calcular" value="Calcular" class="submit-btn">
                </div>
            </form>
        </div>
        <div class = "divider"></div>
        <?php
            // Incluye los archivos con las funciones
            include 'suma.php';
            include 'resta.php';
            include 'multiplicacion.php';
            include 'division.php';

            // Declara las variables
            $valor1 = '';
            $valor2 = '';
            $resultado_suma = '';
            $resultado_resta = '';
            $resultado_multiplicacion = '';
            $resultado_division = '';

            // Verifica el formulario e imprime los resultados
            if (isset($_POST['calcular'])) {
                
            // Obtén los valores ingresados en el formulario
            $valor1 = $_POST['valor1'];
            $valor2 = $_POST['valor2'];

            // Realiza las operaciones llamando a las funciones
            $resultado_suma = sumar($valor1, $valor2);
            $resultado_resta = restar($valor1, $valor2);
            $resultado_multiplicacion = multiplicar($valor1, $valor2);
            $resultado_division = dividir($valor1, $valor2);    
            
            echo "<div class = container1>Valor 1: $valor1<br> Valor 2: $valor2<br>Resultado de la suma: $resultado_suma<br> Resultado de la resta: $resultado_resta<br> Resultado de la multiplicación: $resultado_multiplicacion<br> Resultado de la división: $resultado_division<br></div>";
            }
        ?>

    </body>
</html>
