//Bryan Alexander Campuzano Giraldo
//Grupo: 502
//Programa: Ingenieria de Sistemas
//Código Fuente: autoría propia
using Tarea4;

namespace Ejercicio4
{
    class Tarea4
    {
        static void Main(string[] args)
        {
            int opcion = 0;
            Console.WriteLine("Escoja el proyecto que quiere ejecutar: \n1: Ejercicio 4\n2: Ejercicio 5");
            opcion = Convert.ToInt32(Console.ReadLine());

            switch (opcion)
            {
                case 1:
                   Circulo.CalcularCirculo(); break;
                case 2:
                   Rectangulo.CalcularRectangulo(); break;
                default:
                    Console.WriteLine("Opcion no valida");
                    break;
            }
        }

    }
}
