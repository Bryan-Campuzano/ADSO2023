//Bryan Alexander Campuzano Giraldo
//GAES: 8 
//Programa: Analisis y Desarrollo de Software
//Código Fuente: autoría propianamespace 
namespace Ejercicio4
{
    class ListaAutos
    {
        public static void BuscarAuto()
        {
            bool existe = false;
            string[] carros = { "Volvo", "BMW", "Ford", "Mazda" };

            Console.WriteLine("Por favor digite el nombre de una marca de Automobiles: ");
            string? carro = Console.ReadLine();

            for (int i = 0; i < carros.Length; i++)
            {
                if (carro == carros[i])
                {
                    existe = true;
                }
            }

            if (existe == true)
            {
                Console.WriteLine("La marca se encuentra registrada en la lista");

            }
            else
            {
                Console.WriteLine("La marca NO se encuentra registrada en la lista");
            }
        }
    }
}