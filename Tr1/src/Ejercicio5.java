import java.util.Scanner;

/**
 *
 * @author Jhordan Huera
 */
public class Ejercicio5 {
    /**
     *
     * Crear un programa que genere secuencialmente una matriz de orden nxn
     *
     */
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

        llenarDiagonalCentral(contador);
        contador += tamano;  // Ajustar contador para diagonales inferiores

        llenarDiagonalesInferiores(contador);
        contador += tamano * (tamano - 1) / 2;  // Ajustar para diagonales superiores

        llenarDiagonalesSuperiores(contador);
    }

    private void llenarDiagonalCentral(int contador) {
        for (int fila = tamano - 1, columna = 0; fila >= 0 && columna < tamano; fila--, columna++) {
            matriz[fila][columna] = contador++;
        }
    }

    private void llenarDiagonalesInferiores(int contador) {
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
        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                System.out.printf("%4d", matriz[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        System.out.println("\nEjecutando Ejercicio 5\n");
        medirTiempoEjecucion(() -> {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.print("Ingrese el tamaño de la matriz (n): ");
                int n = scanner.nextInt();

                Ejercicio5 matrizDiagonal = new Ejercicio5(n);
                matrizDiagonal.generarDiagonales();
                matrizDiagonal.mostrarMatriz();

                scanner.close();
            }
        });

    }

    /**
     * Mide y muestra el tiempo de ejecución de una operación dada.
     * @param operacion La operación cuya duración se va a medir.
     */
    private static void medirTiempoEjecucion(Runnable operacion) {
        long tiempoInicio = System.nanoTime();

        operacion.run();

        long tiempoFin = System.nanoTime();
        long duracionNanosegundos = tiempoFin - tiempoInicio;

        System.out.println("Tiempo de ejecución: " + duracionNanosegundos + " nanosegundos");
    }
}
