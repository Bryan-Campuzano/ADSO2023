<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="../resources/css/stylesheet.css" rel="stylesheet" type="text/css"/>
        <link href='https://fonts.googleapis.com/css?family=DM Serif Display' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet'>
        <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css'rel='stylesheet'>
        <title>DashBoard COLTEXT</title>
    </head>
    <body>
        <div class="banner">
            <a href="home.php" class="btn1"></a>
            <div class="center-text">
                <h1 class="titlefont">COLTEXT</h1>
            </div>
            <a href="404.php" class="btn2"></a>
            <a href="500.php" class="btn5"></a>
        </div>
        <div class="container2">
            <section class="main">
                <div class="main-top">
                    <h1 class="titlefont">Dashboard</h1>
                </div>
                <h2 class="subrayado"> Panel de Control de la Gestión Administrativa</h2>
                <div class="main-skills">
                    <div class="card">
                        <h3>Gestión Inventario</h3>
                        <p>Area encargada de Gestionar el inventario actual</p>
                        <button>Acceso Area</button>
                    </div>
                    <div class="card">
                        <h3>Gestión Ventas</h3>
                        <p>Area encargada del capital entrante</p>
                        <button>Acceso Area</button>
                    </div>
                    <div class="card">
                        <h3>Gestión Fidelizacion</h3>
                        <p>Area encargada del Bienestar de cliente</p>
                        <button>Acceso Area</button>
                    </div>
                    <div class="card">
                        <h3>Empleados</h3>
                        <p>Area con los empleados</p>
                        <button>
                            <a href="../back/empleado/EmpleadosColtext.php">Acceso Area</a>
                        </button>
                    </div>
                </div>

                <section class="main-course">
                    <h1 class="subrayado">Resumen</h1>
                    <div class="course-box">
                        <ul>
                            <li>Cuenta</li>
                            <li class="active">Estado Bodega</li>
                            <li>Estado Ventas</li>
                            <li>Estado Domicilios</li>
                            <li>PQRS</li>
                        </ul>
                        <div class="course">
                            <div class="box">
                                <h3>Ingresos Generales</h3>
                                <p>Datos de las ventas a tiempo real</p>
                                <div class="banner2">
                                    <img src="../resources/css/multimedia/barras.png" alt="" width="100" height="100"/>
                                    <button>Ampliar</button>
                                </div>
                            </div>
                            <div class="box">
                                <h3>Capacidad de Bodega</h3>
                                <p>Estado de la Bodega a tiempo real</p>
                                <div class="banner2">
                                    <img src="../resources/css/multimedia/inventario.png" alt="" width="100" height="100"/>
                                    <button>Ampliar</button>
                                </div>
                            </div>
                            <div class="box">
                                <h3>Popularidad</h3>
                                <p>Satisfacción General de nuestros clientes</p>
                                <div class="banner2">
                                    <img src="../resources/css/multimedia/popularidad.png" alt="" width="100" height="100"/>
                                    <button>Ampliar</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </section>
        </div>
        <div class="divider"></div>
        <div class="footer1">
            <a href="home.php" class="btn1"></a>
            <img src="../resources/css/multimedia/coltext-reservado.PNG" alt="COLTEXT R" width="120" height="50"/>
        </div>
    </body>
</html>