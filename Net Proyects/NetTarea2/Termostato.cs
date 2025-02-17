//Bryan Alexander Campuzano Giraldo
//GAES: 8 
//Programa: Analisis y Desarrollo de Software
//Código Fuente: autoría propianamespace 
namespace Ejercicio2
{
    class Termostato
    {
        private static double CalcularDiferenciaTemperaturas(double temperaturaActual, double temperaturaDeseada)
        {
            double diferencia = Math.Abs(temperaturaActual - temperaturaDeseada);
            return diferencia;
        }

        public static void AjusteTermostato()
        {
            Console.WriteLine("Bienvenido al sistema de análisis de temperaturas.");
            
            double temperaturaActual;
            do
            {
                Console.WriteLine("Por favor, ingrese la temperatura actual en grados Celsius:");
            } while (!double.TryParse(Console.ReadLine(), out temperaturaActual));

            double temperaturaDeseada;
            do
            {
                Console.WriteLine("Ahora, ingrese la temperatura deseada en grados Celsius:");
            } while (!double.TryParse(Console.ReadLine(), out temperaturaDeseada));

            double diferencia = CalcularDiferenciaTemperaturas(temperaturaActual, temperaturaDeseada);

            Console.WriteLine($"La diferencia entre la temperatura actual ({temperaturaActual} °C) y la temperatura deseada ({temperaturaDeseada} °C) es de {diferencia} grados Celsius.");
        }
    }
}
