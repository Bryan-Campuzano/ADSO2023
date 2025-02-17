/// clase de dart que modela la pagina de login de una aplicacion de gestion de pedidos COLTEXT

/// importamos dart
import 'package:flutter/material.dart';
import 'package:pedidos_coltex/src/utils/my_colors.dart';

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
        backgroundColor: MyColors.backgroundColor,
        body: SizedBox(
          width: double.infinity,
          child: Column(
            children: [
              Image.asset(
                'assets/img/1 sin fondo.png',
                width: 200,
                height: 200,
              ),
              const TextField(
                decoration: InputDecoration(hintText: 'Correo Electronico'),
              ),
              const TextField(
                decoration: InputDecoration(hintText: 'Contraseña'),
              ),
              ElevatedButton(
                onPressed: () {
                  Navigator.pushNamed(context, 'lista');
                },
                child: const Text('Ingresar'),
              )
            ],
          ),
        ));
  }
}
