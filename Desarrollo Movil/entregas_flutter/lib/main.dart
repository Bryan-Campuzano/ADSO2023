/// clase principal de dart que modela una aplicacion de domicilios

/// importamos dart
import 'package:entregas_flutter/src/login/login_page.dart';
import 'package:entregas_flutter/src/utils/my_colors.dart';
import 'package:flutter/material.dart';

/// metodo main de la aplicación
void main() {
  runApp(const MyApp());
}
/// usamos el comando stful para crear un pequeño framework de trabajo
class MyApp extends StatefulWidget {

  const MyApp ({super.key});

  @override
  State<MyApp> createState() => _State();
}

/// clase que modela la estructura de la ventana principal
class _State extends State<MyApp> {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Aplicacion de Domicilios',
      debugShowCheckedModeBanner: false,
      initialRoute: 'login',
      routes: {
        'login':(BuildContext context) => LoginPage()
      },

      // tema de la aplicacion
      theme: ThemeData(
        primaryColor: MyColors.primaryColor,
      ),
    );
  }
}

