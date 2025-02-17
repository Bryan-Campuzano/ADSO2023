/// clase principal que modela los elementos dentro de la galleria, cada elemento es una instancia de esta clase

/// importamos dart y las librerias necesarias
import 'package:flutter/material.dart';
import 'package:imagenes/src/utils/my_colors.dart';

/// clase principal del elemento
class galleryElement extends StatefulWidget {

  final String imagePath;
  final String description;

/// constructor del elemento
  const galleryElement({super.key, required this.imagePath, required this.description});

  @override
  State<galleryElement> createState() => _galleryElementState();
}

/// creamos un framework de trabajo pequeño donde
class _galleryElementState extends State<galleryElement> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
          title: Text('Informacion sobre el reino'),
          backgroundColor: MyColors.backgroundColor
      ),
      backgroundColor: MyColors.backgroundColor,
      body: Center(
        child: Padding(
          padding: const EdgeInsets.all(20.0),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Image.asset(widget.imagePath),
              SizedBox(height: 20),
              Text(widget.description),
            ],
          ),
        ),
      ),
    );
  }
}

