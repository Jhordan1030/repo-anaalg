import java.util.Scanner;

public class Ejercicio6 {

    // Método principal
    public static void main(String[] args) {

        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar la dimensión de la matriz
        System.out.print("Ingrese la dimensión de la matriz (n): ");
        int tamañoMatriz = scanner.nextInt();

        // Medir el tiempo de ejecución total del programa
        long tiempoInicioPrograma = System.nanoTime();

        // Crear la matriz de tamaño n x n
        int[][] matriz = new int[tamañoMatriz][tamañoMatriz];

        // Medir el tiempo de ejecución de la parte de llenar la matriz
        long tiempoInicio = System.nanoTime();
        // Llenar la matriz con el patrón específico
        llenarMatrizConPatron(matriz, tamañoMatriz);

        // Medir el tiempo de ejecución para imprimir la matriz
        long tiempoFin = System.nanoTime();
        long duracionLlenado = tiempoFin - tiempoInicio;

        // Mostrar los tiempos en un solo mensaje
        System.out.println("Tiempo total de ejecución:");
        System.out.println("Tiempo para llenar la matriz: " + duracionLlenado + " nanosegundos");
        // Mostrar el tiempo en segundos
        double duracionSegundos = duracionLlenado / 1_000_000_000.0;
        System.out.printf("Tiempo para llenar la matriz: %.9f segundos\n", duracionSegundos);

        // Imprimir la matriz
        imprimirMatriz(matriz, tamañoMatriz);

        // Medir el tiempo total de ejecución del programa
        long tiempoFinPrograma = System.nanoTime();
        long duracionTotal = tiempoFinPrograma - tiempoInicioPrograma;

        // Mostrar el tiempo total de ejecución del programa
        System.out.println("\nTiempo total de ejecución del programa:");
        System.out.println("Tiempo total de ejecución: " + duracionTotal + " nanosegundos");
        System.out.printf("Tiempo total de ejecución: %.9f segundos\n", duracionTotal / 1_000_000_000.0);

        scanner.close();
    }

    // Método para llenar la matriz con el patrón solicitado
    public static void llenarMatrizConPatron(int[][] matriz, int tamañoMatriz) {
        // Variable para generar los números secuenciales
        int numero = 1;

        // Llenar la matriz con el patrón específico
        for (int fila = 0; fila < tamañoMatriz; fila++) {
            // Llenar la fila de acuerdo al patrón
            if (fila % 2 == 0) {  // Filas pares (0, 2, 4, ...) se llenan de manera ascendente
                for (int columna = 0; columna <= fila; columna++) {
                    matriz[fila][columna] = numero++;
                }
            } else {  // Filas impares (1, 3, 5, ...) se llenan de manera descendente
                for (int columna = fila; columna >= 0; columna--) {
                    matriz[fila][columna] = numero++;
                }
            }
        }
    }

    // Método para imprimir la matriz
    public static void imprimirMatriz(int[][] matriz, int tamañoMatriz) {
        System.out.println("Matriz " + tamañoMatriz + "x" + tamañoMatriz + ":");
        for (int fila = 0; fila < tamañoMatriz; fila++) {
            for (int columna = 0; columna <= fila; columna++) {
                System.out.print(matriz[fila][columna] + "\t");
            }
            System.out.println();
        }
    }
}
