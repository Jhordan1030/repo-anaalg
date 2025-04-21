import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar el tamaño de los arreglos
        System.out.print("Ingrese el tamaño de los arreglos (n): ");
        int tamañoArreglos = scanner.nextInt();
        
        // Generar arreglos aleatorios
        int[] arregloA = generarArregloAleatorio(tamañoArreglos, 1, 100);
        int[] arregloB = generarArregloAleatorio(tamañoArreglos, 1, 100);
        
        // Mostrar los arreglos generados
        System.out.println("\nArreglo A:");
        imprimirArreglo(arregloA);
        
        System.out.println("\nArreglo B:");
        imprimirArreglo(arregloB);
        
        // Determinar elementos comunes
        int[] elementosAenB = encontrarElementosComunes(arregloA, arregloB);
        int[] elementosBenA = encontrarElementosComunes(arregloB, arregloA);
        
        // Mostrar resultados
        mostrarResultados("A", "B", elementosAenB);
        mostrarResultados("B", "A", elementosBenA);
        
        // Realizar mediciones de tiempo
        realizarEvaluacionTiempos(tamañoArreglos);
        
        scanner.close();
    }
    
    /**
     * Genera un arreglo de números aleatorios dentro de un rango especificado
     * @param tamaño Tamaño del arreglo a generar
     * @param minimo Valor mínimo posible para los elementos
     * @param maximo Valor máximo posible para los elementos
     * @return Arreglo de enteros con valores aleatorios
     */
    public static int[] generarArregloAleatorio(int tamaño, int minimo, int maximo) {
        if (tamaño <= 0 || minimo <= 0) {
            return new int[0];
        }
        
        Random generadorAleatorio = new Random();
        int[] arreglo = new int[tamaño];
        
        for (int indice = 0; indice < tamaño; indice++) {
            arreglo[indice] = generadorAleatorio.nextInt(maximo - minimo + 1) + minimo;
        }
        
        return arreglo;
    }
    
    /**
     * Encuentra los elementos comunes entre dos arreglos
     * @param arreglo1 Primer arreglo a comparar
     * @param arreglo2 Segundo arreglo a comparar
     * @return Arreglo con los elementos comunes (sin duplicados)
     */
    public static int[] encontrarElementosComunes(int[] arreglo1, int[] arreglo2) {
        Set<Integer> conjuntoArreglo2 = new HashSet<>();
        for (int valor : arreglo2) {
            conjuntoArreglo2.add(valor);
        }
        
        Set<Integer> elementosComunes = new HashSet<>();
        for (int valor : arreglo1) {
            if (conjuntoArreglo2.contains(valor)) {
                elementosComunes.add(valor);
            }
        }
        
        return convertirSetAArreglo(elementosComunes);
    }
    
    /**
     * Convierte un Set de enteros a un arreglo de enteros
     * @param conjunto Set a convertir
     * @return Arreglo con los elementos del Set
     */
    private static int[] convertirSetAArreglo(Set<Integer> conjunto) {
        int[] arregloResultado = new int[conjunto.size()];
        int posicion = 0;
        
        for (Integer valor : conjunto) {
            arregloResultado[posicion++] = valor;
        }
        
        return arregloResultado;
    }
    
    /**
     * Imprime un arreglo en formato [elemento1, elemento2, ..., elementoN]
     * @param arreglo Arreglo a imprimir
     */
    public static void imprimirArreglo(int[] arreglo) {
        System.out.print("[");
        for (int indice = 0; indice < arreglo.length; indice++) {
            System.out.print(arreglo[indice]);
            if (indice < arreglo.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    /**
     * Muestra los resultados de la comparación entre dos arreglos
     * @param nombreArreglo1 Nombre del primer arreglo
     * @param nombreArreglo2 Nombre del segundo arreglo
     * @param elementosComunes Arreglo con los elementos comunes
     */
    private static void mostrarResultados(String nombreArreglo1, String nombreArreglo2, int[] elementosComunes) {
        System.out.printf("\nElementos de %s que se encuentran en %s:\n", nombreArreglo1, nombreArreglo2);
        if (elementosComunes.length > 0) {
            imprimirArreglo(elementosComunes);
        } else {
            System.out.println("No hay elementos comunes.");
        }
    }
    
    /**
     * Realiza una evaluación de tiempos para diferentes tamaños de arreglos
     * @param tamañoBase Tamaño base para las evaluaciones
     */
    private static void realizarEvaluacionTiempos(int tamañoBase) {
        System.out.println("\nEvaluación de tiempos:");
        
        for (int evaluacion = 1; evaluacion <= 10; evaluacion++) {
            int tamañoEvaluacion = tamañoBase * evaluacion;
            int[] arregloA = generarArregloAleatorio(tamañoEvaluacion, 1, tamañoEvaluacion * 2);
            int[] arregloB = generarArregloAleatorio(tamañoEvaluacion, 1, tamañoEvaluacion * 2);
            
            long inicio = System.nanoTime();
            encontrarElementosComunes(arregloA, arregloB);
            long fin = System.nanoTime();
            
            System.out.printf("Evaluación %d: Tamaño=%d, Tiempo=%d ns\n", 
                    evaluacion, tamañoEvaluacion, (fin - inicio));
        }
    }
}