        <?php
            // Credenciales de usuario predefinidas 
            $usuarioValido = 'usuariocoltext';
            $contrasenaValida = 'coco';

            // Verifica si se enviaron datos mediante POST
            if ($_SERVER['REQUEST_METHOD'] === 'POST') {
            // Obtiene las credenciales ingresadas por el usuario
                $username = $_POST['username'];
                $password = $_POST['password'];

            // Verifica las credenciales
                if ($username === $usuarioValido && $password === $contrasenaValida) {
            // Credenciales válidas, redirecciona a otra página 
                    header('Location: ./successePage.php');
                    exit();
                } else {
            // Credenciales inválidas, muestra un mensaje de error 
                    echo '<div class = container1>Usuario y/o contraseña incorrectos. Inténtalo de nuevo.</div>';
                }
            }
        