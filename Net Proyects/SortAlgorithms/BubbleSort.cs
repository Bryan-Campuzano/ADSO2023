//Bryan Alexander Campuzano Giraldo
//Grupo: 312
//Programa: Ingenieria de Sistemas
//Código Fuente: autoría propia

using System; // ejecutamos en el sistema

namespace SortAlgorithms
{
    public static class BubbleSort // clase que representa el metodo de ordenamiento burnuja
    {
        public static int[] Sort(int[] numbers) // metodo de ordenamiento segun estructura
        {
            int[] array = (int[])numbers.Clone();
            for (int i = 0; i < array.Length - 1; i++)
            {
                for (int j = 0; j < array.Length - 1 - i; j++)
                {
                    if (array[j] > array[j + 1])
                    {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
            return array;
        }
    }
}
