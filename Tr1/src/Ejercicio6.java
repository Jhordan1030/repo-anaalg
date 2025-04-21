import java.util.Scanner;

public class Ejercicio6 {

    // Método principal
    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar la dimensión de la matriz
        System.out.print("Ingrese la dimensión de la matriz (n): ");
        int tamañoMatriz = scanner.nextInt();

        // Crear la matriz de tamaño n x n
        int[][] matriz = new int[tamañoMatriz][tamañoMatriz];

        // Llenar la matriz con el patrón específico
        llenarMatrizConPatron(matriz, tamañoMatriz);

        // Imprimir la matriz
        imprimirMatriz(matriz, tamañoMatriz);

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
