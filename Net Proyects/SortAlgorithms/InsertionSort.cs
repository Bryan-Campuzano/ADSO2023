//Bryan Alexander Campuzano Giraldo
//Grupo: 312
//Programa: Ingenieria de Sistemas
//Código Fuente: autoría propia

using System; // ejecutamos en el sistema

namespace SortAlgorithms
{
    public static class InsertionSort // clase que representa el metodo de ordenamiento insercion
    {
        public static int[] Sort(int[] numbers) // metodo de ordenamiento segun estructura
        {
            int[] array = (int[])numbers.Clone();
            for (int i = 1; i < array.Length; i++)
            {
                int key = array[i];
                int j = i - 1;

                while (j >= 0 && array[j] > key)
                {
                    array[j + 1] = array[j];
                    j--;
                }
                array[j + 1] = key;
            }
            return array;
        }
    }
}
