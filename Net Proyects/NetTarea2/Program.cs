//Bryan Alexander Campuzano Giraldo
//GAES: 8 
//Programa: Analisis y Desarrollo de Software
//Código Fuente: autoría propia
namespace Ejercicio2
{
    class Tarea2
    {
        static void Main(string[] args)
        {
            int opcion = 0;
            Console.WriteLine("Escoja el proyecto que quiere ejecutar: \n1: Simulador de Carrera\n2: Raiz Cuadrada\n3: Calculadora Nivel Ph\n4: Termostato");
            opcion = Convert.ToInt32(Console.ReadLine());

            switch (opcion)
            {
                case 1:
                    Carrera.ResultadoCarrera(); break;
                case 2:
                    Raiz.ResultadoCuadrada(); break;
                case 3:
                    Alcalinidad.CalcularPh(); break;
                case 4:
                    Termostato.AjusteTermostato(); break;
                default:
                    Console.WriteLine("Opcion no valida");
                    break;
            }
        }

    }
}
