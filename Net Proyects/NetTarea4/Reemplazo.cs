//Bryan Alexander Campuzano Giraldo
//GAES: 8 
//Programa: Analisis y Desarrollo de Software
//Código Fuente: autoría propianamespace 
namespace Ejercicio4
{
    class Reemplazo
    {
        public static void Reemplazar()
        {
            Console.WriteLine("Ingrese una oración:");
            string? oracion = Console.ReadLine();

            Console.WriteLine("Ingrese la palabra a reemplazar:");
            string? palabraAReemplazar = Console.ReadLine();

            Console.WriteLine("Ingrese la palabra de reemplazo:");
            string? palabraReemplazo = Console.ReadLine();

            if (oracion != null && palabraAReemplazar != null)
            {
                string nuevaOracion = oracion.Replace(palabraAReemplazar, palabraReemplazo);
                Console.WriteLine($"Oración con reemplazo: {nuevaOracion}");
            }
            else
            {
                Console.WriteLine("Ingrese una opcion valida");
            }

        }
    }
}