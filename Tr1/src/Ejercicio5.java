import java.util.Scanner;

/**
 * Ejercicio para generar una matriz de tamaño nxn con un patrón en diagonal.
 * Las diagonales se llenan comenzando desde la central, luego las inferiores y superiores.
 */
public class Ejercicio5 {

    private int[][] matriz;
    private int tamano;

    /**
     * Constructor para inicializar la matriz con el tamaño especificado.
     * @param tamano El tamaño de la matriz cuadrada.
     */
    public Ejercicio5(int tamano) {
        this.tamano = tamano;
        this.matriz = new int[tamano][tamano];
    }

    /**
     * Genera un patrón en diagonal comenzando desde la diagonal central.
     * Llena primero la diagonal central, luego las diagonales inferiores y superiores.
     */
    public void generarDiagonales() {
        int contador = 1;

        // Llenar la diagonal central
        llenarDiagonalCentral(contador);
        contador += tamano;  // Ajustar contador para diagonales inferiores

        // Llenar las diagonales inferiores
        llenarDiagonalesInferiores(contador);
        contador += tamano * (tamano - 1) / 2;  // Ajustar para diagonales superiores

        // Llenar las diagonales superiores
        llenarDiagonalesSuperiores(contador);
    }

    private void llenarDiagonalCentral(int contador) {
        // Llenar la diagonal central comenzando desde la esquina inferior izquierda
        for (int fila = tamano - 1, columna = 0; fila >= 0 && columna < tamano; fila--, columna++) {
            matriz[fila][columna] = contador++;
        }
    }

    private void llenarDiagonalesInferiores(int contador) {
        // Llenar las diagonales inferiores comenzando desde el lado izquierdo
        for (int inicio = 1; inicio < tamano; inicio++) {
            int fila = tamano - 1;
            int columna = inicio;
            while (fila >= inicio && columna < tamano) {
                matriz[fila][columna] = contador++;
                fila--;
                columna++;
            }
        }
    }

    private void llenarDiagonalesSuperiores(int contador) {
        // Llenar las diagonales superiores comenzando desde el lado superior
        for (int inicio = 1; inicio < tamano; inicio++) {
            int fila = tamano - 1 - inicio;
            int columna = 0;
            while (fila >= 0 && columna < tamano - inicio) {
                matriz[fila][columna] = contador++;
                fila--;
                columna++;
            }
        }
    }

    /**
     * Muestra la matriz en formato tabular.
     */
    public void mostrarMatriz() {
        for (int fila = 0; fila < tamano; fila++) {
            for (int columna = 0; columna < tamano; columna++) {
                System.out.printf("%4d", matriz[fila][columna]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("\nEjecutando Ejercicio 5\n");
        
        // Medir el tiempo de ejecución de la operación
        medirTiempoEjecucion(() -> {
            try (Scanner scanner = new Scanner(System.in)) {
                // Solicitar al usuario el tamaño de la matriz
                System.out.print("Ingrese el tamaño de la matriz (n): ");
                int n = scanner.nextInt();

                // Crear el objeto Ejercicio5 para la matriz de tamaño n x n
                Ejercicio5 matrizDiagonal = new Ejercicio5(n);

                // Generar el patrón de diagonales en la matriz
                matrizDiagonal.generarDiagonales();

                // Mostrar la matriz generada
                matrizDiagonal.mostrarMatriz();

            }
        });
    }

    /**
     * Mide y muestra el tiempo de ejecución de una operación dada.
     * @param operacion La operación cuya duración se va a medir.
     */
    private static void medirTiempoEjecucion(Runnable operacion) {
        long tiempoInicio = System.nanoTime();  // Tiempo inicial en nanosegundos

        operacion.run();  // Ejecutar la operación

        long tiempoFin = System.nanoTime();  // Tiempo final en nanosegundos
        long duracionNanosegundos = tiempoFin - tiempoInicio;

        // Mostrar el tiempo de ejecución en nanosegundos
        System.out.println("Tiempo de ejecución: " + duracionNanosegundos + " nanosegundos");

        // Convertir nanosegundos a segundos
        double duracionSegundos = duracionNanosegundos / 1_000_000_000.0;
        // Mostrar el tiempo de ejecución en segundos
        System.out.println("Tiempo de ejecución: " + duracionSegundos + " segundos");
    }
}
