/**
 * Resolución Punto 1:
 * Jose David, se encuentra ahorrando para comprar una maleta que vale 105.000$.
 * En la casa le han dado para sus gastos 24.000$ pesos durante 4 semanas.
 * Por atender la tienda recibió 36.000$.
 * Su hermano Juan Antonio ganó 23.000$ por limpiar la piscina y cuidar la tienda.
 * ¿Jose David tiene el dinero suficiente para comprar la maleta o aun le falta?
 *
 * Resolvemos el problema con pseudo-código:
 *
 * INICIO
 *     Total_Ahorros = 0
 *     Maleta_Precio = 105000
 *     Dinero_Semanal = 24000
 *     Semanas = 4
 *     Dinero_Por_Atender_Tienda = 36000
 *
 *     Total_Ahorros = (Dinero_Semanal * Semanas) + Dinero_Por_Atender_Tienda
 *
 *     SI Total_Ahorros >= Maleta_Precio ENTONCES
 *         ESCRIBIR "Jose David tiene suficiente dinero para comprar la maleta."
 *     SINO
 *         ESCRIBIR "Jose David no tiene suficiente dinero para comprar la maleta. Le falta dinero."
 *     FIN SI
 * FIN
 */
public class Solucion1 {
//----------------------DECLARACIÓN DE PARÁMETROS---------------------
    static double Total_Ahorros = 0;           // dinero ahorrado total
    static double Maleta_Precio = 105000;      // precio de la maleta a comprar
    static double Dinero_Semanal = 24000;      // dinero que recibe Jose cada semana para sus gastos
    //static int Semanas = 4;                   // semanas que lleva ahorrando Jose
    static double Dinero_Por_Atender_Tienda = 36000;   // dinero extra ganado por tareas concretas
    static double Dinero_Hermano = 23000;      // dinero del hermano (dato no computable porque no dice en el problema que se lo de)
//------------------------ZONA DE CÓDIGO------------------------
    /**
     * Este método indica si Jose tiene el dinero suficiente para la maleta o no, dependiendo de una cantidad de semanas ahorradas.
     * @param Semanas: semanas que lleva ahorrando Jose
     * @return mensaje con el resultado.
     */
    public static String calcularAhorros(int Semanas) {
        Total_Ahorros = (Dinero_Semanal * Semanas) + Dinero_Por_Atender_Tienda;

        if (Total_Ahorros >= Maleta_Precio) {
            return "Jose David tiene suficiente dinero para comprar la maleta.";
        } else {
            return "Jose David no tiene suficiente dinero para comprar la maleta. Le falta dinero.";
        }
    }

    /**
     * Función encargada de repetir el algoritmo para hacer varios tests para ver el comportamiento del ahorro al correr de las semanas.
     */
    public static void repTest() {
        boolean estado = true;
        int contador = 0;
        int Semanas = 0;
        while (estado) {
            System.out.println(calcularAhorros(Semanas));
            contador++;
            Semanas++;
            if (contador == 5) {
                estado = false;
            }
        }
    }

    public static void main(String[] args) {
        repTest();
    }
}
