//Bryan Alexander Campuzano Giraldo
//GAES: 8 
//Programa: Analisis y Desarrollo de Software
//Código Fuente: autoría propia
namespace Ejercicio1
{
    class Captura
    {
        public static void Formular()
        {
            Console.WriteLine("Introduzca su nombre: ");
            string? nombreUsu = Console.ReadLine();

            Console.WriteLine("Introduzca el año en el que naciste: ");
            int anioNacimiento = Convert.ToInt32(Console.ReadLine());

            int edad = 2024 - anioNacimiento;

            Console.WriteLine($"Su nombre es: {nombreUsu} y tiene: {edad} años de edad");

        }

    }

}