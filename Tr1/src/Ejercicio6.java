import java.util.Scanner;

public class Ejercicio6 {
    // Constantes
    private static final int VALOR_VACIO = -1;
    private static final int NANOSEGUNDOS_POR_MICROSEGUNDO = 1000;
    private static final int NANOSEGUNDOS_POR_MILISEGUNDO = 1_000_000;
    private static final int NANOSEGUNDOS_POR_SEGUNDO = 1_000_000_000;
    
    // Campos
    private final int[][] matriz;
    private final int tamaño;

    /**
     * Constructor que inicializa la matriz con valores vacíos
     * @param tamaño Tamaño de la matriz cuadrada
     */
    public Ejercicio6(int tamaño) {
        validarTamañoMatriz(tamaño);
        this.tamaño = tamaño;
        this.matriz = new int[tamaño][tamaño];
        inicializarMatrizConValoresVacios();
    }

    private void validarTamañoMatriz(int tamaño) {
        if (tamaño <= 0) {
            throw new IllegalArgumentException("El tamaño de la matriz debe ser mayor que cero");
        }
    }

    private void inicializarMatrizConValoresVacios() {
        for (int fila = 0; fila < tamaño; fila++) {
            for (int columna = 0; columna < tamaño; columna++) {
                matriz[fila][columna] = VALOR_VACIO;
            }
        }
    }

    /**
     * Genera la matriz especial llenando la diagonal y la parte inferior
     */
    public void generarMatriz() {
        int numeroActual = 1;
        llenarDiagonalPrincipal(numeroActual);
        llenarParteInferior(numeroActual + tamaño);
    }

    private void llenarDiagonalPrincipal(int numeroInicial) {
        for (int posicionDiagonal = 0; posicionDiagonal < tamaño; posicionDiagonal++) {
            matriz[posicionDiagonal][posicionDiagonal] = numeroInicial + posicionDiagonal;
        }
    }

    private void llenarParteInferior(int numeroInicial) {
        int numeroActual = numeroInicial;
        
        for (int columnaActual = 0; columnaActual < tamaño; columnaActual++) {
            for (int filaDebajoDiagonal = columnaActual + 1; filaDebajoDiagonal < tamaño; filaDebajoDiagonal++) {
                matriz[filaDebajoDiagonal][columnaActual] = numeroActual++;
            }
        }
    }

    /**
     * Imprime la matriz formateada, mostrando espacios para valores vacíos
     */
    public void imprimirMatriz() {
        System.out.println("Matriz generada:");
        
        for (int[] fila : matriz) {
            imprimirFila(fila);
            System.out.println();
        }
    }

    private void imprimirFila(int[] fila) {
        for (int valorCelda : fila) {
            if (valorCelda == VALOR_VACIO) {
                System.out.print("    ");
            } else {
                System.out.printf("%4d", valorCelda);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            int tamañoMatriz = solicitarTamañoMatriz(scanner);
            Ejercicio6 matriz = new Ejercicio6(tamañoMatriz);
            
            long tiempoEjecucionNs = medirTiempoGeneracionMatriz(matriz);
            
            matriz.imprimirMatriz();
            mostrarResultadosTiempo(tiempoEjecucionNs);
        } finally {
            scanner.close();
        }
    }

    private static int solicitarTamañoMatriz(Scanner scanner) {
        System.out.print("Ingrese el tamaño de la matriz (n x n): ");
        return scanner.nextInt();
    }

    private static long medirTiempoGeneracionMatriz(Ejercicio6 matriz) {
        long inicio = System.nanoTime();
        matriz.generarMatriz();
        return System.nanoTime() - inicio;
    }

    private static void mostrarResultadosTiempo(long tiempoNanosegundos) {
        System.out.println("\nTiempo de ejecución:");
        System.out.println("Nanosegundos: " + tiempoNanosegundos + " ns");
        
        System.out.printf("Microsegundos: %.3f µs%n", convertirNanosegundos(tiempoNanosegundos, NANOSEGUNDOS_POR_MICROSEGUNDO));
        System.out.printf("Milisegundos: %.3f ms%n", convertirNanosegundos(tiempoNanosegundos, NANOSEGUNDOS_POR_MILISEGUNDO));
        System.out.printf("Segundos: %.6f s%n", convertirNanosegundos(tiempoNanosegundos, NANOSEGUNDOS_POR_SEGUNDO));
    }

    private static double convertirNanosegundos(long tiempoNs, int factorConversion) {
        return (double) tiempoNs / factorConversion;
    }
}