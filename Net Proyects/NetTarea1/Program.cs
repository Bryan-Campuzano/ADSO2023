//Bryan Alexander Campuzano Giraldo
//GAES: 8 
//Programa: Analisis y Desarrollo de Software
//Código Fuente: autoría propia

namespace Ejercicio1
{
    class Tarea1
    {
        static void Main(string[] args)
        {
            int opcion = 0;
            Console.WriteLine("Escoja el proyecto que quiere ejecutar: \n1: Formulario de Captura\n2: Calculadora\n3: Area de Triangulo");
            opcion = Convert.ToInt32(Console.ReadLine());

            switch (opcion)
            {
                case 1:
                    Captura.Formular();
                    break;
                case 2:
                    Calculadora.Calcular();
                    break;
                case 3:
                    Triangulo.CalcularArea();
                    break;
                default:
                    Console.WriteLine("Opcion no valida");
                    break;
            }

        }
    }
}