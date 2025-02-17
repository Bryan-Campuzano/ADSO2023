//Bryan Alexander Campuzano Giraldo
//GAES: 8 
//Programa: Analisis y Desarrollo de Software
//Código Fuente: autoría propia
namespace Ejercicio1
{
    class Triangulo
    {
        private static double Area(int parBase, int parAltura)
        {
            double parResultado = (parBase * parAltura) / 2;
            return parResultado;
        }
        public static void CalcularArea()
        {
            Console.WriteLine("Introduzca la base del triangulo: ");
            int baseT = Convert.ToInt32(Console.ReadLine());

            Console.WriteLine("Introduzca la altura del triangulo: ");
            int alturaT = Convert.ToInt32(Console.ReadLine());

            double resultadoT = Area(baseT,alturaT);

            Console.WriteLine($"El area del triangulo es: {resultadoT}");

        }
    }
}