/// clase principal de dart que modela el fichero principal de la aplicacion
/// en este caso modela la pagina de inicio de la aplicacion de gestion de pedidos para COLTEXT

/// importamos dart y las clases necesarias
import 'package:flutter/material.dart';
import 'package:flutter/services.dart' show rootBundle;
import 'dart:convert';
import 'package:firebase_core/firebase_core.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:pedidos_coltex/src/login/login_page.dart';
import 'package:pedidos_coltex/src/pedidos/lista_pedidos.dart';
import 'package:pedidos_coltex/src/utils/my_colors.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp(); // Inicializa Firebase
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Pedidos Coltext',
      debugShowCheckedModeBanner: false,
      initialRoute: '/',
      routes: {
        '/': (BuildContext context) => const HomePage(),
        'login': (BuildContext context) => const LoginPage(),
        'lista': (BuildContext context) => const ListaPedidos()
      },
      theme: ThemeData(
        primaryColor: MyColors.backgroundColor,
      ),
    );
  }
}

class HomePage extends StatelessWidget {
  const HomePage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: MyColors.backgroundColor,
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Image.asset(
              'assets/img/1 sin fondo.png',
              width: 200,
              height: 200,
              fit: BoxFit.contain,
            ),
            const SizedBox(height: 20),
            const Text(
              '¿Eres domiciliario asociado con COLTEXT? INGRESA AQUI',
              textAlign: TextAlign.center,
              style: TextStyle(fontSize: 18),
            ),
            const SizedBox(height: 20),
            ElevatedButton(
              onPressed: () {
                Navigator.pushNamed(context, 'login');
              },
              child: const Text('INGRESAR'),
            ),
            const SizedBox(height: 20),
            TextButton(
              onPressed: () {
                importDataToFirestore(context);
              },
              child: const Text('Importar Datos a Firestore'),
            ),
          ],
        ),
      ),
    );
  }

  Future<void> importDataToFirestore(BuildContext context) async {
    try {
      String jsonString = await rootBundle.loadString('assets/db/base de datos.json');
      Map<String, dynamic> data = json.decode(jsonString);
      FirebaseFirestore firestore = FirebaseFirestore.instance;

      data.forEach((collectionName, collectionData) {
        collectionData.forEach((documentId, documentData) async {
          await firestore
              .collection(collectionName)
              .doc(documentId)
              .set(documentData);
        });
      });

      showSuccessDialog(context);
    } catch (e) {
      showErrorDialog(context, e.toString());
    }
  }

  void showSuccessDialog(BuildContext context) {
    showDialog(
      context: context,
      builder: (BuildContext context) {
        return AlertDialog(
          title: Text('Datos Importados'),
          content: Text('Los datos se han importado correctamente a Firestore.'),
          actions: <Widget>[
            TextButton(
              onPressed: () {
                Navigator.of(context).pop();
              },
              child: Text('Aceptar'),
            ),
          ],
        );
      },
    );
  }

  void showErrorDialog(BuildContext context, String error) {
    showDialog(
      context: context,
      builder: (BuildContext context) {
        return AlertDialog(
          title: Text('Error'),
          content: Text('Hubo un error al importar los datos a Firestore: $error'),
          actions: <Widget>[
            TextButton(
              onPressed: () {
                Navigator.of(context).pop();
              },
              child: Text('Aceptar'),
            ),
          ],
        );
      },
    );
  }
}



