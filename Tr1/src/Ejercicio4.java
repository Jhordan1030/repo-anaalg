import java.util.*;
/**
 *
 * @author Jhordan Huera
 */

public class Ejercicio4 {
    /**
     *
     * Crear un programa que genere n números aleatorios para un arreglo de enteros. Buscar de
     * manera binaria un elemento e indicar las posiciones donde se encuentra. Imprimir el arreglo
     *
     */
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

    // Método para realizar la búsqueda binaria del número e
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
    private static void medirTiempoEjecucion(Runnable operacion) {
        long tiempoInicio = System.nanoTime();

        operacion.run();

        long tiempoFin = System.nanoTime();
        long duracionNanosegundos = tiempoFin - tiempoInicio;

        System.out.println("Tiempo de ejecución: " + duracionNanosegundos + " nanosegundos");
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

            // Generar la matriz y mostrarla
            ejercicio.generarNumerosAleatorios();
            ejercicio.imprimirMatriz();

            System.out.print("Ingrese el número a buscar: ");
        medirTiempoEjecucion(() -> {
            int numeroBuscado = scanner.nextInt();
            // Buscar el número en la matriz
            ejercicio.buscarElemento(numeroBuscado);
        });

    }
}
