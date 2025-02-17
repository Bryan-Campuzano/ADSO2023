//Bryan Alexander Campuzano Giraldo
//Grupo: 312
//Programa: Ingenieria de Sistemas
//Código Fuente: autoría propia

using System;

class Program
{
    static void Main(string[] args)
    {
        Sistema sistema = new Sistema();

        Console.WriteLine("Ingrese su correo:");
        string correo = Console.ReadLine();
        Console.WriteLine("Ingrese su contraseña:");
        string contraseña = Console.ReadLine();

        if (sistema.Login(correo, contraseña))
        {
            Console.WriteLine("¡Bienvenido!");
            bool continuar = true;

            while (continuar)
            {
                Console.WriteLine("\nSeleccione una opción:");
                Console.WriteLine("1. Ver Catálogo");
                Console.WriteLine("2. Agregar Producto");
                Console.WriteLine("3. Eliminar Producto");
                Console.WriteLine("4. Registrar Compra");
                Console.WriteLine("5. Ver Historial de Compras");
                Console.WriteLine("6. Salir");

                switch (Console.ReadLine())
                {
                    case "1":
                        sistema.VerCatalogo();
                        break;
                    case "2":
                        Console.WriteLine("Ingrese ID del producto:");
                        int id = int.Parse(Console.ReadLine());
                        Console.WriteLine("Ingrese nombre del producto:");
                        string nombre = Console.ReadLine();
                        Console.WriteLine("Ingrese precio del producto:");
                        decimal precio = decimal.Parse(Console.ReadLine());
                        sistema.AgregarProducto(new Producto(id, nombre, precio));
                        break;
                    case "3":
                        Console.WriteLine("Ingrese ID del producto a eliminar:");
                        int idEliminar = int.Parse(Console.ReadLine());
                        sistema.EliminarProducto(idEliminar);
                        break;
                    case "4":
                        Console.WriteLine("Ingrese ID de la compra:");
                        int idCompra = int.Parse(Console.ReadLine());
                        var compra = new Compra(idCompra);
                        sistema.RegistrarCompra(compra);
                        break;
                    case "5":
                        sistema.VerHistorial();
                        break;
                    case "6":
                        continuar = false;
                        break;
                    default:
                        Console.WriteLine("Opción no válida.");
                        break;
                }
            }
        }
        else
        {
            Console.WriteLine("Credenciales incorrectas.");
        }
    }
}
