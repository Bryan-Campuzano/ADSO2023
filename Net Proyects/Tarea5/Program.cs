//Bryan Alexander Campuzano Giraldo
//Grupo: 502
//Programa: Ingenieria de Sistemas
//Código Fuente: autoría propia

using System.Globalization;

namespace Ejercicio5
{
    class Tarea5
    {
        struct Empleado
            {
                public DateTime FechaNacimiento;
                public int Edad;

                public Empleado(DateTime fechaNacimiento, int edad)
                {
                    FechaNacimiento = fechaNacimiento;
                    Edad = edad;
                }
            }

        static int CalcularEdad(DateTime fechaNacimiento)
        {
            DateTime hoy = DateTime.Today;
            int edad = hoy.Year - fechaNacimiento.Year;
            return edad;
        }
         static void Main(string[] args)
        {
            int BONO = 150000;

            List<Empleado> empleados = new List<Empleado>();

            Console.WriteLine("Ingrese la cantidad de empleados:");
            if (!int.TryParse(Console.ReadLine(), out int cantidadEmpleados) || cantidadEmpleados <= 0)
                {
                    Console.WriteLine("Cantidad de empleados inválida.");
                    return;
                }

            for (int i = 0; i < cantidadEmpleados; i++)
            {
                Console.WriteLine($"Ingrese la fecha de nacimiento del empleado {i + 1} (formato: dd/MM/yyyy):");
                string? fecha = Console.ReadLine();

                if (string.IsNullOrWhiteSpace(fecha))
                {
                    Console.WriteLine("Fecha de nacimiento inválida, ingrese un valor con el formato solicitado");
                    i--; 
                    continue;
                }

                if (!DateTime.TryParseExact(fecha, "dd/MM/yyyy", CultureInfo.InvariantCulture, DateTimeStyles.None, out DateTime fechaNacimiento))
                {
                    Console.WriteLine("Formato de fecha incorrecto.");
                    i--; 
                    continue;
                }
                if (fechaNacimiento > DateTime.Today)
                {
                    Console.WriteLine("La fecha de nacimiento invalida, no puede ser mayor que la fecha actual.");
                    i--; 
                    continue;
                }

                int edad = CalcularEdad(fechaNacimiento);

                empleados.Add(new Empleado(fechaNacimiento, edad));
            }

            List<Empleado> empleadosConBono = empleados.Where(e => e.Edad >= 18 && e.Edad < 50).ToList();

            double promedioEdades = empleados.Average(e => e.Edad);
            Console.WriteLine($"El promedio de las edades es: {promedioEdades:F2}");

            var empleadosPorMes = new Dictionary<int, List<Empleado>>();

            foreach (Empleado emp in empleadosConBono)
            {
                int mes = emp.FechaNacimiento.Month;
                if (!empleadosPorMes.ContainsKey(mes))
                {
                    empleadosPorMes[mes] = new List<Empleado>();
                }
                empleadosPorMes[mes].Add(emp);
            }

            int totalBonos = 0;
            Console.WriteLine("Mes\tEmpleados TikTok\tDinero en Bonos");
            for (int mes = 1; mes <= 12; mes++)
            {
                if (empleadosPorMes.ContainsKey(mes))
                {
                    int cantidadEmpleadosMes = empleadosPorMes[mes].Count;
                    int dineroEnBonos = cantidadEmpleadosMes * BONO;
                    totalBonos += dineroEnBonos;
                    Console.WriteLine($"{CultureInfo.CurrentCulture.DateTimeFormat.GetMonthName(mes)}\t{cantidadEmpleadosMes} empleados\t\t${dineroEnBonos}");
                }
                else
                {
                    Console.WriteLine($"{CultureInfo.CurrentCulture.DateTimeFormat.GetMonthName(mes)}\t0 empleados\t\t$0");
                }
            }

            Console.WriteLine($"Total de dinero en bonificaciones: ${totalBonos}");
        }

    }
}
