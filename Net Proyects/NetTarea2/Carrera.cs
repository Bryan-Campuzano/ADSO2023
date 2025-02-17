//Bryan Alexander Campuzano Giraldo
//GAES: 8 
//Programa: Analisis y Desarrollo de Software
//Código Fuente: autoría propianamespace 
namespace Ejercicio2
{
    public class Carrera
    {
        private static int MenorTiempo(int t1, int t2, int t3)
        {
            int menor = Math.Min(t1, Math.Min(t2, t3)); return menor;
        }
        private static int MayorTiempo(int t1, int t2, int t3)
        {
            int mayor = Math.Max(t1, Math.Max(t2, t3)); return mayor;
        }

        public static void ResultadoCarrera()
        {
            Console.WriteLine("Evaluador de resultados, se evaluaran los 3 corredores: \n introduzca el primer resultado en minutos: ");
            int r1 = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("Introduzca el segundo resultado en minutos: ");
            int r2 = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("Introduzca el tercer resultado en minutos: ");
            int r3 = Convert.ToInt32(Console.ReadLine());

            int ganador = MenorTiempo(r1, r2, r3);
            int perdedor = MayorTiempo(r1, r2, r3);

            if (ganador == r1)
            {
                Console.WriteLine($"el mejor tiempo fue del corredor el primero");
            }
            else if (ganador == r2)
            {
                Console.WriteLine($"el mejor tiempo fue del corredor el segundo");
            }
            else
            {
                Console.WriteLine($"el mejor tiempo fue del corredor el tercero");
            }

            if (perdedor== r1)
            {
                Console.WriteLine($"el peor tiempo fue del corredor el primero");
            }
            else if (perdedor == r2)
            {
                Console.WriteLine($"el peor tiempo fue del corredor el segundo");
            }
            else
            {
                Console.WriteLine($"el peor tiempo fue del corredor el tercero");
            }

        }

    }
}