/// clase de dart que modela la pagina de login de una aplicacion de domicilios de prueba

/// importamos dart
import 'package:flutter/material.dart';

/// usamos el comando stful para crear un pequeño framework para este fichero

class LoginPage extends StatefulWidget {
  const LoginPage({super.key});

  @override
  State<LoginPage> createState() => _LoginPageState();
}

/// clase que modela la estructura de la ventana de login
class _LoginPageState extends State<LoginPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        width: double.infinity,
        child: Column(
          children: [
            Image.asset('assets/img/delivery.png',
            width: 200,
            height: 200,),
            TextField(
              decoration: InputDecoration(
                hintText: 'Correo Electronico'
              ),
            ),
            TextField(
              decoration: InputDecoration(
                  hintText: 'Contraseña'
              ),
            ),
            ElevatedButton(
              onPressed: (){},
              child: Text('Ingresar'),
            )
          ],
        ),
      )
    );
  }
}
