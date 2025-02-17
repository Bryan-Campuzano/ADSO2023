//Bryan Alexander Campuzano Giraldo
//Grupo: 502
//Programa: Ingenieria de Sistemas
//Código Fuente: autoría propia
namespace Tarea4
{
    class Circulo
    {

        // metodo que calcula el Diametro
        private static float Diametro(float parRadio)
        {
            float parResultado = parRadio * 2;
            return parResultado;
        }

        // metodo que calcula el Perimetro
        private static float Perimetro(float parDiametro)
        {
            float parResultado = (float)(parDiametro * Math.PI);
            return parResultado;
        }

        // metodo que calcula el Area
        private static float Area(float parDiametro)
        {
            float parResultado = (float)(Math.PI*parDiametro*parDiametro)/4;
            return parResultado;
        }

        // metodo que genera el mensaje con los calculos buscados
        public static void CalcularCirculo()
        {
            Console.WriteLine("Introduzca el radio del Círculo: ");
            float radioC = Convert.ToSingle(Console.ReadLine());

            float diametroC = Diametro(radioC);

            float areaC = Area(diametroC);

            float perimetroC = Perimetro(diametroC);

            Console.WriteLine($"El area del Circulo es: {areaC} y su perimetro es: {perimetroC}");

        }
    }
}