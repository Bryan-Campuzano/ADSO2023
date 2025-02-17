import 'package:flutter/material.dart';
import 'package:imagenes/src/utils/my_colors.dart';
import 'package:imagenes/src/galleryElement/galleryElement.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Avatar: Los Cuatro Reinos',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        primaryColor: MyColors.backgroundColor,
      ),
      home: GalleryScreen(),
    );
  }
}

class GalleryScreen extends StatelessWidget {
  final List<String> imagePaths = [
    'assets/img/air.png',
    'assets/img/fire.png',
    'assets/img/water.png',
    'assets/img/earth.png',
  ];

  final List<String> descriptions = [
    'Los maestros del aire son pacíficos y espirituales, capaces de manipular el aire y el viento para su ventaja. Son conocidos por su movilidad y agilidad en el campo de batalla, así como por su capacidad para esquivar ataques y desplazarse rápidamente. Los monjes de la Nación del Templo del Aire son los maestros del aire más prominentes, y entre ellos se encuentra Aang, el Avatar y protagonista de la serie.',
    'Los maestros del fuego son poderosos usuarios del elemento más destructivo y apasionado. Son expertos en generar y controlar el fuego, así como en manipular la energía interna conocida como "chi". La Nación del Fuego es el hogar de la mayoría de los maestros del fuego, y entre ellos se encuentra el príncipe Zuko y su hermana, la princesa Azula. Los maestros del fuego tienen un estilo de lucha agresivo y directo.',
    'Los maestros del agua son habilidosos manipuladores de su elemento, capaces de controlar el agua en sus diversas formas, ya sea líquida, sólida (hielo) o gaseosa (vapor). Son conocidos por su fluidez en combate y su conexión con la luna y los océanos. Los maestros del agua se dividen en dos tribus principales: la Tribu Agua del Norte y la Tribu Agua del Sur. Entre los personajes notables de esta tribu se encuentran Katara y Sokka.',
    'Los maestros de la tierra son expertos en controlar y manipular la tierra, la roca y los minerales. Son conocidos por su resistencia y fuerza física, así como por su capacidad para crear defensas sólidas y poderosos ataques. La Nación del Reino Tierra es hogar de la mayoría de los maestros de la tierra, y entre los personajes notables se encuentra Toph Beifong, quien es considerada una de las mejores maestras de la tierra en la serie.',
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Avatar: Los Cuatro Reinos'),
        backgroundColor: MyColors.backgroundColor,
        bottom: PreferredSize(
          preferredSize: const Size.fromHeight(40),
          child: Row(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: [
              _buildMenuButton(context, 'Aire', imagePaths[0], descriptions[0]),
              _buildMenuButton(context, 'Fuego', imagePaths[1], descriptions[1]),
              _buildMenuButton(context, 'Agua', imagePaths[2], descriptions[2]),
              _buildMenuButton(context, 'Tierra', imagePaths[3], descriptions[3]),
            ],
          ),
        ),
      ),
      backgroundColor: MyColors.backgroundColor,
      body: Padding(
        padding: const EdgeInsets.all(20.0),
        child: Center(
          child: GridView.builder(
            shrinkWrap: true,
            itemCount: imagePaths.length,
            gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(
              crossAxisCount: 2,
              crossAxisSpacing: 10,
              mainAxisSpacing: 10,
            ),
            itemBuilder: (context, index) {
              return GestureDetector(
                onTap: () {
                  Navigator.push(
                    context,
                    MaterialPageRoute(
                      builder: (context) => galleryElement(
                        imagePath: imagePaths[index],
                        description: descriptions[index],
                      ),
                    ),
                  );
                },
                child: Image.asset(imagePaths[index]),
              );
            },
          ),
        ),
      ),
    );
  }

  Widget _buildMenuButton(BuildContext context, String title, String imagePath, String description) {
    return IconButton(
      onPressed: () {
        Navigator.push(
          context,
          MaterialPageRoute(
            builder: (context) => galleryElement(
              imagePath: imagePath,
              description: description,
            ),
          ),
        );
      },
      icon: Text(title),
    );
  }
}
