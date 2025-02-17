//Bryan Alexander Campuzano Giraldo
//GAES: 8 
//Programa: Analisis y Desarrollo de Software
//Código Fuente: autoría propia
namespace Ejercicio4
{
    class Tarea4
    {
        static void Main(string[] args)
        {
            int opcion = 0;
            Console.WriteLine("Escoja el proyecto que quiere ejecutar: \n1: Reemplazar una palabra\n2: Contar Vocales\n3: Ordenar Alfabeticamente\n4: Buscar autos");
            opcion = Convert.ToInt32(Console.ReadLine());

            switch (opcion)
            {
                case 1:
                    Reemplazo.Reemplazar(); break;
                case 2:
                    Vocales.ContarVocales(); break;
                case 3:
                    OrdenarLista.Ordenar(); break;
                case 4:
                    ListaAutos.BuscarAuto(); break;
                default:
                    Console.WriteLine("Opcion no valida");
                    break;
            }
        }

    }
}