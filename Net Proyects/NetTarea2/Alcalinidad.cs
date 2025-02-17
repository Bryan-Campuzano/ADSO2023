//Bryan Alexander Campuzano Giraldo
//GAES: 8 
//Programa: Analisis y Desarrollo de Software
//Código Fuente: autoría propianamespace 
namespace Ejercicio2
{
    class Alcalinidad
    {

        private static string CalcularNivel(int ph)
        {
            if (ph < 7)
            {
                return "acidez";
            }
            else if (ph > 7)
            {
                return "alcalinidad";
            }
            else
            {
                return "neutralidad";
            }
        }
        public static void CalcularPh()
        {
            Console.WriteLine("Bienvenido al laboratorio químico.");
            Console.WriteLine("Por favor, ingrese el pH de la sustancia a evaluar:");

            string? input = Console.ReadLine();
            if (!string.IsNullOrEmpty(input))
            {
                if (double.TryParse(input, out double ph))
                {
                    int level = Convert.ToInt32(ph);
                    string nivel = CalcularNivel(level);
                    Console.WriteLine($"El pH de la sustancia es {ph}, lo que indica un nivel de {nivel}.");
                }
                else
                {
                    Console.WriteLine("El valor ingresado no es válido. Por favor, ingrese un número decimal válido.");
                }
            }
            else
            {
                Console.WriteLine("No se ha ingresado ningún valor. Por favor, ingrese un número decimal válido.");
            }
        }


    }

}