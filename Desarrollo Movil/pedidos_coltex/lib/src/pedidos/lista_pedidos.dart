/// clase de dart que modela la pagina de login de una aplicacion de domicilios de prueba

/// importamos dart
import 'package:flutter/material.dart';
import 'package:pedidos_coltex/src/utils/my_colors.dart';
import 'detalle_pedido.dart'; // Importa la vista de detalle del pedido

class ListaPedidos extends StatefulWidget {
  const ListaPedidos({Key? key}) : super(key: key);

  @override
  State<ListaPedidos> createState() => _ListaPedidosState();
}

class _ListaPedidosState extends State<ListaPedidos> {
  // Datos de ejemplo para los pedidos
  final List<Map<String, dynamic>> _pedidos = [
    {
      'imagen': 'assets/img/1 sin fondo.png',
      'nombre': 'Camisa de algodón',
      'cantidad': 2,
      'precio_unitario': 15.99,
    },
    {
      'imagen': 'assets/img/1 sin fondo.png',
      'nombre': 'Pantalón vaquero',
      'cantidad': 1,
      'precio_unitario': 29.99,
    },
    {
      'imagen': 'assets/img/1 sin fondo.png',
      'nombre': 'Bufanda de lana',
      'cantidad': 3,
      'precio_unitario': 9.99,
    },
    {
      'imagen': 'assets/img/1 sin fondo.png',
      'nombre': 'Calcetines deportivos',
      'cantidad': 4,
      'precio_unitario': 5.99,
    },
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: MyColors.backgroundColor,
      appBar: AppBar(
        backgroundColor: MyColors.backgroundColor,
        title: const Text('Lista de Pedidos'),
      ),
      body: ListView.builder(
        itemCount: _pedidos.length,
        itemBuilder: (context, index) {
          final pedido = _pedidos[index];
          return GestureDetector(
            onTap: () {
              // Navegar a la página de detalle del pedido pasando los datos del pedido
              Navigator.push(
                context,
                MaterialPageRoute(
                  builder: (context) => DetallePedido(pedido: pedido),
                ),
              );
            },
            child: ListTile(
              contentPadding: const EdgeInsets.symmetric(
                  horizontal: 16, vertical: 8), // Ajusta el padding
              leading: Image.asset(
                pedido['imagen'],
                width: 50,
                height: 50,
                fit: BoxFit.cover,
              ),
              title: Text(pedido['nombre']),
              subtitle: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  const SizedBox(
                      height:
                          4), // Agrega un espacio entre el título y el subtítulo
                  Text('Cantidad: ${pedido['cantidad']}'),
                  Text('Precio unitario: \$${pedido['precio_unitario']}'),
                  Text(
                      'Total: \$${pedido['cantidad'] * pedido['precio_unitario']}'),
                ],
              ),
            ),
          );
        },
      ),
    );
  }
}
