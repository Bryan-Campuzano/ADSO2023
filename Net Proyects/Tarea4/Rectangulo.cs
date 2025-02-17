//Bryan Alexander Campuzano Giraldo
//Grupo: 502
//Programa: Ingenieria de Sistemas
//Código Fuente: autoría propia
namespace Tarea4
{
    class Rectangulo
    {
        // metodo que calcula el Area
        private static float Area(float parBase, float parAltura)
        {
            float parResultado = (float)(parBase * parAltura);
            return parResultado;
        }
        // metodo que calcula el Area
        private static float Perimetro(float parBase, float parAltura)
        {
            float parResultado = (float)(parBase * 2) + (float)(parAltura * 2);
            return parResultado;
        }
        public static void CalcularRectangulo()
        {
            Console.WriteLine("Introduzca la base del Rectangulo: ");
            float baseR = Convert.ToSingle(Console.ReadLine());

            Console.WriteLine("Introduzca la altura del Rectangulo: ");
            float alturaR = Convert.ToSingle(Console.ReadLine());

            float areaR = Area(baseR,alturaR);

            float perimetroR = Perimetro(baseR,alturaR);

            Console.WriteLine($"El area del Rectangulo es: {areaR} y el Perimetro del Rectangulo es; {perimetroR}");

        }
    }
}