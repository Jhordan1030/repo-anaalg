import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Ejercicio1 {
    // Métodos

    public static int[] generarArregloAleatorio(int tamaño, int minimo, int maximo) {
        Random random = new Random();
        int[] arreglo = new int[tamaño];

        for (int i = 0; i < tamaño; i++) {
            arreglo[i] = random.nextInt(maximo - minimo + 1) + minimo;
        }

        return arreglo;
    }

    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        if (numero <= 3) {
            return true;
        }
        if (numero % 2 == 0 || numero % 3 == 0) {
            return false;
        }

        int i = 5;
        while (i * i <= numero) {
            if (numero % i == 0 || numero % (i + 2) == 0) {
                return false;
            }
            i += 6;
        }

        return true;
    }

    public static ArrayList<Integer> encontrarPrimos(int[] arreglo) {
        ArrayList<Integer> primos = new ArrayList<>();
        for (int numero : arreglo) {
            if (esPrimo(numero)) {
                primos.add(numero);
            }
        }
        return primos;
    }

    public static void imprimirArreglo(int[] arreglo) {
        System.out.print("[");
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i]);
            if (i < arreglo.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el tamaño del arreglo (n): ");
        int n = scanner.nextInt();

        // Medir el tiempo de ejecución de la generación del arreglo
        long tiempoInicioGeneracion = System.nanoTime();
        int[] arreglo = generarArregloAleatorio(n, 1, 1000);
        long tiempoFinGeneracion = System.nanoTime();
        long duracionGeneracion = tiempoFinGeneracion - tiempoInicioGeneracion;
        System.out.println("Tiempo de generación del arreglo: " + duracionGeneracion + " nanosegundos");

        System.out.println("\nArreglo generado:");
        imprimirArreglo(arreglo);

        // Medir el tiempo de ejecución para encontrar los primos
        long tiempoInicioBusqueda = System.nanoTime();
        ArrayList<Integer> primos = encontrarPrimos(arreglo);
        long tiempoFinBusqueda = System.nanoTime();
        long duracionBusqueda = tiempoFinBusqueda - tiempoInicioBusqueda;

        // Mostrar los números primos encontrados
        System.out.println("\nNúmeros primos encontrados en el arreglo:");
        for (int primo : primos) {
            System.out.print(primo + " ");
        }
        System.out.println(); // Para dar salto de línea

        // Mostrar la cantidad de números primos encontrados
        System.out.println("\nCantidad de números primos encontrados: " + primos.size());

        // Mostrar el tiempo de ejecución de la búsqueda de primos
        System.out.println("Tiempo de ejecución para encontrar los primos: " + duracionBusqueda + " nanosegundos");
        System.out.printf("Tiempo de ejecución para encontrar los primos: %.9f segundos\n", duracionBusqueda / 1_000_000_000.0);

        scanner.close();
    }
}
