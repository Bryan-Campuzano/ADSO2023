/// clase de dart que modela la pagina que muestra la descripcion de un producto y opciones sobre este

/// importamos dart
import 'package:flutter/material.dart';
import 'package:pedidos_coltex/src/utils/my_colors.dart';

class DetallePedido extends StatelessWidget {
  final Map<String, dynamic> pedido;

  const DetallePedido({Key? key, required this.pedido}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: MyColors.backgroundColor,
      appBar: AppBar(
        backgroundColor: MyColors.backgroundColor,
        title: Text(pedido['nombre']),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: [
            Image.asset(
              pedido['imagen'],
              width: 200,
              height: 200,
              fit: BoxFit.cover,
            ),
            Text('Cantidad: ${pedido['cantidad']}'),
            Text('Precio unitario: \$${pedido['precio_unitario']}'),
            Text('Total: \$${pedido['cantidad'] * pedido['precio_unitario']}'),
            const SizedBox(
              height: 20,
            ), // Agrega un espacio entre la imagen y los botones
            GridView.count(
              crossAxisCount: 2, // 2 columnas
              shrinkWrap: true, // Ajusta el tamaño del grid al contenido
              children: [
                TextButton(
                  onPressed: () {},
                  style: TextButton.styleFrom(
                      backgroundColor: MyColors
                          .backgroundColor, // Cambia el color de fondo aquí
                      side: const BorderSide(color: Colors.black, width: 2)),
                  child: const Text(
                    'Botón 1',
                    style: TextStyle(
                        color: Colors.white), // Cambia el color del texto
                  ),
                ),
                TextButton(
                  onPressed: () {},
                  style: TextButton.styleFrom(
                      backgroundColor: MyColors
                          .backgroundColor, // Cambia el color de fondo aquí
                      side: const BorderSide(color: Colors.black, width: 2)),
                  child: const Text(
                    'Botón 2',
                    style: TextStyle(
                        color: Colors.white), // Cambia el color del texto
                  ),
                ),
                TextButton(
                  onPressed: () {},
                  style: TextButton.styleFrom(
                      backgroundColor: MyColors
                          .backgroundColor, // Cambia el color de fondo aquí
                      side: const BorderSide(color: Colors.black, width: 2)),
                  child: const Text(
                    'Botón 3',
                    style: TextStyle(
                        color: Colors.white), // Cambia el color del texto
                  ),
                ),
                TextButton(
                  onPressed: () {},
                  style: TextButton.styleFrom(
                      backgroundColor: MyColors
                          .backgroundColor, // Cambia el color de fondo aquí
                      side: const BorderSide(color: Colors.black, width: 2)),
                  child: const Text(
                    'Botón 4',
                    style: TextStyle(
                        color: Colors.white), // Cambia el color del texto
                  ),
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }
}
