//Bryan Alexander Campuzano Giraldo
//Grupo: 312
//Programa: Ingenieria de Sistemas
//Código Fuente: autoría propia

using System; // ejecutamos en el sistema

namespace SortAlgorithms
{
    public static class SelectionSort // clase que representa el metodo de ordenamiento seleccion
    {
        public static int[] Sort(int[] numbers) // metodo de ordenamiento segun estructura
        {
            int[] array = (int[])numbers.Clone();
            for (int i = 0; i < array.Length - 1; i++)
            {
                int minIndex = i;
                for (int j = i + 1; j < array.Length; j++)
                {
                    if (array[j] < array[minIndex])
                    {
                        minIndex = j;
                    }
                }

                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
            return array;
        }
    }
}
