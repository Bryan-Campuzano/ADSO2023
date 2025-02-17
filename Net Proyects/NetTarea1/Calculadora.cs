//Bryan Alexander Campuzano Giraldo
//GAES: 8 
//Programa: Analisis y Desarrollo de Software
//Código Fuente: autoría propia
namespace Ejercicio1
{
    class Calculadora
    {
        private static double Sumar(int parNum1, int parNum2)
        {
            int resultado = 0;
            resultado = parNum1 + parNum2;
            return resultado;
        }
        private static double Restar(int parNum1, int parNum2)
        {
            int resultado = 0;
            resultado = parNum1 - parNum2;
            return resultado;
        }
        private static double Multiplicar(int parNum1, int parNum2)
        {
            int resultado = 0;
            resultado = parNum1 * parNum2;
            return resultado;
        }
        private static double Dividir(int parNum1, int parNum2)
        {
            int resultado = 0;
            resultado = parNum1 / parNum2;
            return resultado;
        }

        public static void Calcular()
        {
            Console.WriteLine("Ingrese el primer numero: ");
            int num1 = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("Ingrese el segundo numero: ");
            int num2 = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("Ingrese la operacion a realizar (el operador): ");
            string? operacion = Console.ReadLine();
            switch (operacion)
                {
                    case "+":
                        Console.WriteLine("El resultado de la suma es: " + Sumar(num1, num2));
                        break;
                    case "-":
                        Console.WriteLine("El resultado de la resta es: " + Restar(num1, num2));
                        break;
                    case "*":
                        Console.WriteLine("El resultado de la multiplicacion es: " + Multiplicar(num1, num2)); 
                        break;
                    case "/":
                        if(num2!=0)
                        {
                            Console.WriteLine("El resultado de la division es: " + Dividir(num1, num2));
                            break;
                        }
                        else
                        { 
                            Console.WriteLine("No se puede dividir por 0");
                            break;
                        }
                    default:
                        Console.WriteLine("Operacion no valida");
                        break;
                }
  
        }
    }
}
