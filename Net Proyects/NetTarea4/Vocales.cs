//Bryan Alexander Campuzano Giraldo
//GAES: 8 
//Programa: Analisis y Desarrollo de Software
//Código Fuente: autoría propianamespace 
namespace Ejercicio4
{
    class Vocales
    {
        public static void ContarVocales()
        {
            Console.WriteLine("Ingrese una frase:");
            string? frase = Console.ReadLine();

            if (frase != null)
            {
                int contadorVocales = frase.Count(c => "aeiouAEIOU".Contains(c));
                Console.WriteLine($"Cantidad de vocales: {contadorVocales}");
            }
            else
            {
                Console.WriteLine("Ingrese una opcion valida");
            }
        }
    }
}