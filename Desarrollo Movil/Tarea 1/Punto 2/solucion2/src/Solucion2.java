
//------------------------IMPORTACIONES---------------------------
import java.util.Scanner;
//------------------------ZONA DE CÓDIGO------------------------

/**
 * Clase Principal de la Solución:
 * Punto 1: se desea saber cuantos meses han transcurrido entre enero de 1978 y enero de 2020
 */
public class Solucion2 {
    
    /**
     * Método que solicita al usuario la edad de Juan.
     *
     * @param scanner     El objeto Scanner para leer la entrada del usuario.
     * @param maxIntentos El número máximo de intentos para ingresar la edad.
     * @return La edad de Juan ingresada por el usuario.
     */
    public static int recibirEdad(Scanner scanner, int maxIntentos) {
        for (int intento = 0; intento < maxIntentos; intento++) {
            System.out.print("Por favor, ingresa la edad de Juan: ");
            String edadStr = scanner.nextLine();
    
            try {
                int edad = Integer.parseInt(edadStr);
                return edad;
            } catch (NumberFormatException e) {
                System.out.println("Error: Debes ingresar un número entero válido.");
            }
        }
    
        System.out.println("Has alcanzado el número máximo de intentos.");
        System.exit(1);
        return 0;
    }
    
    /**
     * Método que calcula la edad de la Mama de Juan.
     *
     * @param edadJuan La edad de Juan.
     * @param alberto  La proporción de la edad de Alberto con respecto a Juan.
     * @param ana      La proporción de la edad de Ana con respecto a Juan.
     * @return La edad de la Mama de Juan.
     */
    public static double calcularEdadMamaJuan(int edadJuan, double alberto, double ana) {
        return (alberto * edadJuan) + (ana * edadJuan) + edadJuan;
    }

        /**
     * Método principal del programa.
     * @param args Los argumentos de línea de comandos (no se utilizan en este programa).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxIntentos = 3; // Número máximo de intentos para ingresar la edad de Juan
        double alberto = 2.0 / 3.0; // Proporción de la edad de Alberto con respecto a Juan
        double ana = 4.0 / 3.0; // Proporción de la edad de Ana con respecto a Juan
    
        for (int contador = 0; contador < 5; contador++) {
            int edadJuan = recibirEdad(scanner, maxIntentos);
            double edadMamaJuan = calcularEdadMamaJuan(edadJuan, alberto, ana);
            double edadAlberto = alberto * edadJuan;
            double edadAna = ana * edadJuan;
    
            System.out.println("Las edades de la familia de Juan son:");
            System.out.println("Edad de Juan: " + edadJuan);
            System.out.println("Edad de Alberto: " + edadAlberto);
            System.out.println("Edad de Ana: " + edadAna);
            System.out.println("Edad de la Mama de Juan: " + edadMamaJuan);
        }
    }
}

//  appEnd
