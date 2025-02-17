//Bryan Alexander Campuzano Giraldo
//GAES: 8 
//Programa: Analisis y Desarrollo de Software
//Código Fuente: autoría propia
namespace Ejercicio3
{
    class Program
    {
        // menu principal, escoger el primer tipo de cliente
        static void Main(string[] args)
        {
            Console.WriteLine("Bienvenido a la tienda de Doña Segunda.");
            Console.WriteLine("Por favor, seleccione el tipo de cliente:");
            Console.WriteLine("1. Cliente Frecuente");
            Console.WriteLine("2. Cliente Corporativo");
            Console.WriteLine("3. Cliente Subsidiado");

            int opcionCliente = Convert.ToInt32(Console.ReadLine());

            switch (opcionCliente)
            {
                case 1:
                    ClienteFrecuente();
                    break;
                case 2:
                    ClienteCorporativo();
                    break;
                case 3:
                    ClienteSubsidiado();
                    break;
                default:
                    Console.WriteLine("Opción inválida. Saliendo del programa.");
                    break;
            }
        }

        // modelamos el comportamiento del cliente frecuente
        static void ClienteFrecuente()
        {
            Console.WriteLine("Ingrese la cantidad de productos comprados:");
            int cantidadProductos = Convert.ToInt32(Console.ReadLine());

            double totalPagar;
            do
            {
                Console.WriteLine("Ingrese el total a pagar:");
            } while (!double.TryParse(Console.ReadLine(), out totalPagar));


            if (cantidadProductos >= 10)
            {
                double subtotal = totalPagar * 100; // Precio por producto
                double descuento = subtotal * 0.1; // 10% de descuento
                double resultado = subtotal - descuento;

                Console.WriteLine($"Subtotal: {subtotal:C}");
                Console.WriteLine($"Descuento: {descuento:C}");
                Console.WriteLine($"Total a pagar: {resultado:C}");
            }
            else
            {
                Console.WriteLine("Debe comprar al menos 10 productos para ser cliente frecuente.");
            }
        }

        // modelamos el comportamiento del cliente corporativo
        static void ClienteCorporativo()
        {
            double totalPagar;
            do
            {
                Console.WriteLine("Ingrese el total a pagar:");
            } while (!double.TryParse(Console.ReadLine(), out totalPagar));

            double iva = totalPagar * 0.19; // 19% de IVA

            Console.WriteLine($"IVA: {iva:C}");
            Console.WriteLine($"Total a pagar (con IVA): {totalPagar + iva:C}");
        }

        // modelamos el comportamiento del cliente subsidiado y sus diferentes tipos 
        static void ClienteSubsidiado()
        {
            Console.WriteLine("Ingrese el tipo de cliente subsidiado:");
            Console.WriteLine("1. Madre gestante");
            Console.WriteLine("2. Adulto mayor");
            Console.WriteLine("3. Primera infancia");

            int tipoCliente = Convert.ToInt32(Console.ReadLine());

            switch (tipoCliente)
            {
                case 1:
                    ClienteMadreGestante();
                    break;
                case 2:
                    ClienteAdultoMayor();
                    break;
                case 3:
                    ClientePrimeraInfancia();
                    break;
                default:
                    Console.WriteLine("Opción inválida. Saliendo del programa.");
                    break;
            }
        }

        static void ClienteMadreGestante()
        {
            Console.WriteLine("Ingrese el nombre de la señora:");
            string? nombre = Console.ReadLine();

            Console.WriteLine("Ingrese el teléfono:");
            string? telefono = Console.ReadLine();

            Console.WriteLine("Ingrese el equipo de fútbol del cual es hincha:");
            string? equipo = Console.ReadLine();

            Console.WriteLine("Ingrese la edad de la señora:");
            int edad = Convert.ToInt32(Console.ReadLine());

            bool tieneHijoMenor = false;
            string respuesta;
            do
            {
                Console.WriteLine("¿Tiene un hijo menor de 24 meses? (S/N)");
                respuesta = Console.ReadLine()?.Trim().ToUpper() ?? "";
                if (respuesta == "S")
                {
                    tieneHijoMenor = true;
                    break;
                }
                else if (respuesta == "N")
                {
                    tieneHijoMenor = false;
                    break;
                }
                else
                {
                    Console.WriteLine("Respuesta inválida. Por favor, ingrese S para sí o N para no.");
                }
            } while (true);


            double totalPagar;
            do
            {
                Console.WriteLine("Ingrese el total a pagar:");
            } while (!double.TryParse(Console.ReadLine(), out totalPagar));

            double descuento = 0;
            if (edad < 40 && tieneHijoMenor)
            {
                descuento = totalPagar * 0.15; // 15% de descuento
            }

            Console.WriteLine($"Nombre: {nombre}");
            Console.WriteLine($"Teléfono: {telefono}");
            Console.WriteLine($"Equipo de fútbol: {equipo}");
            Console.WriteLine($"Descuento: {descuento:C}");
            Console.WriteLine($"Total a pagar: {totalPagar - descuento:C}");
        }


        static void ClienteAdultoMayor()
        {
            Console.WriteLine("Ingrese el nombre del adulto:");
            string? nombre = Console.ReadLine();

            Console.WriteLine("Ingrese la edad:");
            int edad = Convert.ToInt32(Console.ReadLine());

            Console.WriteLine("Ingrese la dirección:");
            string? direccion = Console.ReadLine();

            double totalPagar;
            do
            {
                Console.WriteLine("Ingrese el total a pagar:");
            } while (!double.TryParse(Console.ReadLine(), out totalPagar));

            double descuento = totalPagar * 0.4; // 40% de descuento

            Console.WriteLine($"Nombre: {nombre}");
            Console.WriteLine($"Edad: {edad}");
            Console.WriteLine($"Dirección: {direccion}");
            Console.WriteLine($"Descuento: {descuento:C}");
            Console.WriteLine($"Total a pagar: {totalPagar - descuento:C}");
        }

        static void ClientePrimeraInfancia()
        {
            Console.WriteLine("Ingrese el nombre del acudiente:");
            string? nombreAcudiente = Console.ReadLine();

            Console.WriteLine("Ingrese el teléfono del acudiente:");
            string? telefonoAcudiente = Console.ReadLine();

            Console.WriteLine("Ingrese el nombre del niño:");
            string? nombreNino = Console.ReadLine();

            Console.WriteLine("Ingrese el nombre del personaje favorito del niño:");
            string? personaje = Console.ReadLine();

            bool llevaProductosAzucarados;
            do
            {
                Console.WriteLine("¿Lleva productos azucarados? (S/N)");
                string respuesta = Console.ReadLine()?.Trim().ToUpper() ?? "";
                if (respuesta == "S")
                {
                    llevaProductosAzucarados = true;
                    break;
                }
                else if (respuesta == "N")
                {
                    llevaProductosAzucarados = false;
                    break;
                }
                else
                {
                    Console.WriteLine("Respuesta inválida. Por favor, ingrese S para sí o N para no.");
                }
            } while (true);

            double totalPagar;
            do
            {
                Console.WriteLine("Ingrese el total a pagar:");
            } while (!double.TryParse(Console.ReadLine(), out totalPagar));

            double descuento = 0;
            if (!llevaProductosAzucarados)
            {
                descuento = totalPagar * 0.2; // 20% de descuento
            }

            // resultado del proceso
            Console.WriteLine($"Nombre del acudiente: {nombreAcudiente}");
            Console.WriteLine($"Teléfono del acudiente: {telefonoAcudiente}");
            Console.WriteLine($"Nombre del niño: {nombreNino}");
            Console.WriteLine($"Personaje favorito: {personaje}");
            Console.WriteLine($"Descuento: {descuento:C}");
            Console.WriteLine($"Total a pagar: {totalPagar - descuento:C}");
        }

    }

}
