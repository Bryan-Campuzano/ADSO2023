//Bryan Alexander Campuzano Giraldo
//GAES: 8 
//Programa: Analisis y Desarrollo de Software
//Código Fuente: autoría propianamespace 
namespace Ejercicio4
{
    class OrdenarLista
    {
        public static void Ordenar()
        {
            Console.WriteLine("Ingrese la cantidad de nombres de carros que desea ingresar:");
            int cantidadCarros = Convert.ToInt32(Console.ReadLine());

            string[] nombresCarros = new string[cantidadCarros];

            for (int i = 0; i < cantidadCarros; i++)
            {
                Console.Write($"Ingrese el nombre del carro {i + 1}: ");
                string? temp = Console.ReadLine();
                if(temp != null)
                {
                    nombresCarros[i] = temp;
                }
            }

            Array.Sort(nombresCarros);

            Console.WriteLine("Nombres de carros en orden alfabético:");
            foreach (string nombreCarro in nombresCarros)
            {
                Console.WriteLine(nombreCarro);
            }
        }
    }
}