
//------------------------IMPORTACIONES---------------------------
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;
//------------------------ZONA DE CÓDIGO------------------------

/**
 * Clase Principal de la Solución:
 * Punto 1: se desea saber cuantos meses han transcurrido entre enero de 1978 y enero de 2020
 */
public class Solucion1 {

    /**
     * Solicita al usuario que ingrese un año y valida la entrada.
     * @param scanner Scanner para leer la entrada del usuario.
     * @param mensaje Mensaje que indica al usuario qué ingresar.
     * @return El año ingresado por el usuario.
     */
    public static int solicitarAnio(Scanner scanner, String mensaje) {
        while (true)
        {
            System.out.print(mensaje);
            String input = scanner.nextLine();

        try {
                return Integer.parseInt(input);
            } 
            catch (NumberFormatException e) 
            {
                System.out.println("Error: Debes ingresar un número entero válido.");
            }
        }
    }

    /**
     * Calcula la diferencia en meses entre dos años.
     * @param anio1 Año de inicio.
     * @param anio2 Año de fin.
     * @return Un mensaje con los meses transcurridos.
     */
    public static String calcularDiferenciaEnMeses(int anio1, int anio2) {
        LocalDate fecha1 = LocalDate.of(anio1, 1, 1);
        LocalDate fecha2 = LocalDate.of(anio2, 1, 1);
        Period periodo = Period.between(fecha1, fecha2);
        int meses_transcurridos = periodo.getYears() * 12 + periodo.getMonths(); // tomamos los años completos en el periodo, los multiplicamos por los meses que tiene un año, si el periodo es inexacto (no completa 12 meses) añadimos los periodos menores a un año
        return String.format("Los meses transcurridos entre %d y %d son:\n%d meses", anio1, anio2, meses_transcurridos);
    }
//-------------------------ZONA DE TEST 1-----------------------
    /**
     * Función de test que permite probar el cálculo de meses transcurridos.
     */
    public static void repTest() {
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario que ingrese los años y calcular la diferencia en meses
        for (int i = 0; i < 5; i++) 
        {
            System.out.println("Test " + (i + 1));
            int anio1 = solicitarAnio(scanner, "Por favor, ingresa el primer año: ");
            int anio2 = solicitarAnio(scanner, "Por favor, ingresa el segundo año: ");

            String resultado = calcularDiferenciaEnMeses(anio1, anio2);
            System.out.println(resultado);
        }
    }

    /**
    * Método Constructor de la Aplicacion
    */
    public static void main(String[] args) throws Exception {
        repTest();  // Realizar el test
    }

}

//  appEnd
