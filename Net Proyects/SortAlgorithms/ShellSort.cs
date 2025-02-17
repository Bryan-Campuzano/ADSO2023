//Bryan Alexander Campuzano Giraldo
//Grupo: 312
//Programa: Ingenieria de Sistemas
//Código Fuente: autoría propia

using System; // ejecutamos en el sistema

namespace SortAlgorithms
{
    public static class ShellSort // clase que representa el metodo de ordenamiento concha
    {
        public static int[] Sort(int[] numbers) // metodo de ordenamiento segun estructura
        {
            int[] array = (int[])numbers.Clone();
            int gap = array.Length / 2;

            while (gap > 0)
            {
                for (int i = gap; i < array.Length; i++)
                {
                    int temp = array[i];
                    int j;
                    for (j = i; j >= gap && array[j - gap] > temp; j -= gap)
                    {
                        array[j] = array[j - gap];
                    }
                    array[j] = temp;
                }
                gap /= 2;
            }

            return array;
        }
    }
}
