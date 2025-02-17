//Bryan Alexander Campuzano Giraldo
//GAES: 8 
//Programa: Analisis y Desarrollo de Software
//Código Fuente: autoría propianamespace 
namespace Ejercicio2
{
    public class Raiz
    {
        private static double Cuadrada(int t1)
        {
            double resultado = Math.Sqrt(t1);
            return resultado;
        }

        public static void ResultadoCuadrada()
        {
            Console.WriteLine("Calculadora de Raiz Cuadrada, Introduzca un numero para calcular: ");
            int r1 = Convert.ToInt32(Console.ReadLine());

            double res = Cuadrada(r1);

            Console.WriteLine($"El resultado es: {res}");

        }

    }
}