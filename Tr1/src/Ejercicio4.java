import java.util.*;

/**
 * Ejercicio para generar una matriz con n filas y m columnas, con números aleatorios,
 * y realizar una búsqueda binaria de un número ingresado por el usuario. 
 * El tiempo de ejecución de la búsqueda se mide en nanosegundos y segundos.
 */
public class Ejercicio4 {

    private int[][] matriz;
    private int filas, columnas;

    // Constructor
    public Ejercicio4(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        matriz = new int[filas][columnas];
    }

    // Método para generar la matriz con números aleatorios
    public void generarNumerosAleatorios() {
        Random random = new Random();
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                matriz[fila][columna] = random.nextInt(100) + 1; // Números aleatorios entre 1 y 100
            }
        }
    }

    // Método para imprimir la matriz
    public void imprimirMatriz() {
        System.out.println("\nMatriz generada:");
        for (int[] fila : matriz) {
            for (int numero : fila) {
                System.out.print(numero + "\t");
            }
            System.out.println();
        }
    }

    // Método para realizar la búsqueda binaria del número ingresado
    public void buscarElemento(int numeroBuscado) {
        List<int[]> posicionesEncontradas = new ArrayList<>();
        int[] arregloPlano = new int[filas * columnas];
        Map<Integer, List<int[]>> mapaPosiciones = new HashMap<>();

        int indice = 0;
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                arregloPlano[indice] = matriz[fila][columna];

                // Guardar las posiciones donde se encuentra el número
                mapaPosiciones
                    .computeIfAbsent(matriz[fila][columna], k -> new ArrayList<>())
                    .add(new int[]{fila, columna});
                indice++;
            }
        }

        // Ordenar el arreglo plano para aplicar búsqueda binaria
        Arrays.sort(arregloPlano);

        // Búsqueda binaria
        int resultadoBusqueda = Arrays.binarySearch(arregloPlano, numeroBuscado);

        if (resultadoBusqueda >= 0) {
            System.out.println("\nEl número " + numeroBuscado + " fue encontrado en las posiciones:");
            for (int[] posicion : mapaPosiciones.get(numeroBuscado)) {
                System.out.println("Fila: " + posicion[0] + ", Columna: " + posicion[1]);
            }
        } else {
            System.out.println("\nEl número " + numeroBuscado + " no fue encontrado en la matriz.");
        }
    }

    // Método para medir el tiempo de ejecución de una operación específica
    private static void medirTiempoEjecucion(String operacion, Runnable operacionRunnable) {
        long tiempoInicio = System.nanoTime();  

        operacionRunnable.run();  // Ejecutar la operación

        long tiempoFin = System.nanoTime();  
        long duracionNanosegundos = tiempoFin - tiempoInicio;  

        double duracionSegundos = duracionNanosegundos / 1_000_000_000.0;  

        System.out.println(operacion + " - Tiempo de ejecución: " + duracionNanosegundos + " nanosegundos");
        System.out.println(operacion + " - Tiempo de ejecución: " + duracionSegundos + " segundos");
    }

    public static void main(String[] args) {
        System.out.println("\nEjecutando Ejercicio 4\n");

        Scanner scanner = new Scanner(System.in);

        // Entradas del usuario
        System.out.print("Ingrese el número de filas (n): ");
        int filas = scanner.nextInt();
        System.out.print("Ingrese el número de columnas (m): ");
        int columnas = scanner.nextInt();

        // Crear objeto de la clase Ejercicio
        Ejercicio4 ejercicio = new Ejercicio4(filas, columnas);

        // Generar la matriz, pero sin medir el tiempo de generación
        ejercicio.generarNumerosAleatorios();
        ejercicio.imprimirMatriz();

        // Solicitar el número a buscar
        System.out.print("Ingrese el número a buscar: ");
        int numeroBuscado = scanner.nextInt();

        // Medir solo el tiempo de búsqueda
        medirTiempoEjecucion("Búsqueda del elemento", () -> ejercicio.buscarElemento(numeroBuscado));
    }
}
