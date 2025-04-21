import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio3 {

    // Método para generar un arreglo de números aleatorios
    public static int[] generarArregloAleatorio(int tamaño, int minimo, int maximo) {
        if (tamaño <= 0) {
            return new int[0];
        }

        Random random = new Random();
        int[] arreglo = new int[tamaño];

        for (int i = 0; i < tamaño; i++) {
            // Genera un número entre minimo y maximo
            arreglo[i] = random.nextInt(maximo - minimo + 1) + minimo;
        }

        return arreglo;
    }

    // Método para realizar la búsqueda binaria (aunque en este caso no será necesario)
    public static int busquedaBinaria(int[] arreglo, int elemento) {
        int izquierda = 0;
        int derecha = arreglo.length - 1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;

            // Verificar si el elemento está en el medio
            if (arreglo[medio] == elemento) {
                return medio;
            }

            // Si el elemento es mayor, ignorar la mitad izquierda
            if (arreglo[medio] < elemento) {
                izquierda = medio + 1;
            }
            // Si el elemento es menor, ignorar la mitad derecha
            else {
                derecha = medio - 1;
            }
        }

        // El elemento no está presente
        return -1;
    }

    // Método para buscar todas las posiciones de un elemento en el arreglo sin ordenarlo
    public static ArrayList<Integer> buscarTodasLasPosiciones(int[] arreglo, int elemento) {
        ArrayList<Integer> posiciones = new ArrayList<>();

        // Buscamos en el arreglo sin ordenarlo
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == elemento) {
                posiciones.add(i);
            }
        }

        return posiciones;
    }

    // Método para imprimir el arreglo
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

        // Solicitar el tamaño del arreglo y el número a buscar
        System.out.print("Ingrese el tamaño del arreglo (n): ");
        int n = scanner.nextInt();

        

        // Crear el arreglo aleatorio
        int[] arreglo = generarArregloAleatorio(n, 1, 100);
        // Arreglo desordenado
        System.out.println("\nArreglo desordenado:");
        imprimirArreglo(arreglo);

        // Solicitar el elemento a buscar
        System.out.print("Ingrese el elemento a buscar: ");
        int elementoBuscado = scanner.nextInt();
        // Medir el tiempo de ejecución total del programa
        long tiempoInicioPrograma = System.nanoTime();
        // Buscar todas las posiciones del elemento
        ArrayList<Integer> posiciones = buscarTodasLasPosiciones(arreglo, elementoBuscado);

        // Mostrar resultados de la búsqueda
        if (posiciones.isEmpty()) {
            System.out.println("\nEl elemento " + elementoBuscado + " no se encuentra en el arreglo.");
        } else {
            System.out.println("\nEl elemento " + elementoBuscado + " se encuentra en las siguientes posiciones:");
            for (int pos : posiciones) {
                System.out.println("Posición: " + pos);
            }
        }

        // Medir el tiempo de ejecución total del programa
        long tiempoFinPrograma = System.nanoTime();
        long duracionTotal = tiempoFinPrograma - tiempoInicioPrograma;

        // Mostrar el tiempo total de ejecución del programa
        System.out.println("\nTiempo total de ejecución del programa:");
        System.out.println("Tiempo total de ejecución: " + duracionTotal + " nanosegundos");
        System.out.printf("Tiempo total de ejecución: %.9f segundos\n", duracionTotal / 1_000_000_000.0);

        scanner.close();
    }
}
