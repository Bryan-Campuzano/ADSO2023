// Bryan Alexander Campuzano Giraldo
// Grupo: 312
// Programa: Ingeniería de Sistemas
// Código Fuente: autoría propia

using System; // ejecutamos en el sistema

namespace SortAlgorithms // seteamos el mismo workspace para todos los ficheros para que podamos impotar metodos de las otras clases
{
    class Program
    {
        static void Main(string[] args) // metodo principal de la aplicacion
        {
            Console.WriteLine("Welcome to the Sorting Application!"); // bienvenida
            Console.WriteLine("Please enter 10 different numbers separated by spaces:");

            int[] numbers; // recoleccion de datos
            while (true)
            {
                try
                {
                    numbers = Array.ConvertAll(Console.ReadLine().Split(), int.Parse);
                    if (numbers.Length != 10 || numbers.Length != numbers.Distinct().Count())
                    {
                        throw new Exception("You must enter 10 unique numbers.");
                    }
                    break;
                }
                catch (Exception ex)
                {
                    Console.WriteLine($"Error: {ex.Message}. Please try again.");
                }
            }

            Console.WriteLine("\nChoose the sorting algorithm:"); // menu de seleccion de algoritmo
            Console.WriteLine("1: Bubble Sort");
            Console.WriteLine("2: Shell Sort");
            Console.WriteLine("3: Selection Sort");
            Console.WriteLine("4: Insertion Sort");
            Console.Write("Your choice: ");
            
            int choice = Convert.ToInt32(Console.ReadLine());
            int[] sortedNumbers = null;

            switch (choice)
            {
                case 1:
                    sortedNumbers = BubbleSort.Sort(numbers);
                    break;
                case 2:
                    sortedNumbers = ShellSort.Sort(numbers);
                    break;
                case 3:
                    sortedNumbers = SelectionSort.Sort(numbers);
                    break;
                case 4:
                    sortedNumbers = InsertionSort.Sort(numbers);
                    break;
                default:
                    Console.WriteLine("Invalid choice.");
                    return;
            }

            Console.WriteLine("\nSorted Numbers:"); // muestra del resultado
            Console.WriteLine(string.Join(" ", sortedNumbers));

            string fileName = "sorted_numbers.txt"; // almacenamiendo de la lista en un fichero (persistencia)
            File.WriteAllText(fileName, string.Join(" ", sortedNumbers));
            Console.WriteLine($"The sorted numbers have been saved to {fileName}.");
        }
    }
}
