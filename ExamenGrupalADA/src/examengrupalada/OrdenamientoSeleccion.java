package examengrupalada;

import java.util.Scanner;

/**
 * Clase que implementa el ordenamiento por selección (Selection Sort)
 * para filas, columnas o matriz completa.
 * 
 * Autor: Giuliana Espinoza
 */
public class OrdenamientoSeleccion {

    /**
     * Ordena una fila específica de la matriz usando ordenamiento por selección.
     * 
     * @param matriz matriz de enteros a ordenar
     * @param fila índice de la fila a ordenar
     */
    public void ordenarFila(int[][] matriz, int fila) {
        if (fila < 0 || fila >= matriz.length) {
            System.out.println("Fila inválida");
            return;
        }
        ordenarPorSeleccion(matriz[fila]);
    }

    /**
     * Ordena una columna específica de la matriz usando ordenamiento por selección.
     * 
     * @param matriz matriz de enteros a ordenar
     * @param columna índice de la columna a ordenar
     */
    public void ordenarColumna(int[][] matriz, int columna) {
        if (matriz.length == 0 || columna < 0 || columna >= matriz[0].length) {
            System.out.println("Columna inválida");
            return;
        }                                                               

        int[] columnaTemporal = new int[matriz.length];
        for (int filaIndex = 0; filaIndex < matriz.length; filaIndex++) {
            columnaTemporal[filaIndex] = matriz[filaIndex][columna];   //T(FILAINDEX)= 3n+2
        }

        ordenarPorSeleccion(columnaTemporal); // t(ordenarporseleccion)= 4^2+n-2

        for (int filaIndex = 0; filaIndex < matriz.length; filaIndex++) {
            matriz[filaIndex][columna] = columnaTemporal[filaIndex];//t(filaindex)=3n+2
        }
    }

    /**
     * Ordena toda la matriz usando ordenamiento por selección.
     * 
     * @param matriz matriz de enteros a ordenar
     */
   public void ordenarMatrizCompleta(int[][] matriz) {
    if (matriz.length == 0) return;

    int totalElementos = matriz.length * matriz[0].length;
    int[] elementos = new int[totalElementos];

    int indiceElemento = 0;
    for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz[i].length; j++) {
            elementos[indiceElemento++] = matriz[i][j];
        }
    }

    ordenarPorSeleccion(elementos);

    indiceElemento = 0;
    for (int filaIndex = 0; filaIndex < matriz.length; filaIndex++) {
        for (int columnaIndex = 0; columnaIndex < matriz[filaIndex].length; columnaIndex++) {
            matriz[filaIndex][columnaIndex] = elementos[indiceElemento++];
        }
    }
    
       System.out.println("");
}


    /**
     * Implementación del algoritmo de ordenamiento por selección para un arreglo.
     * 
     * @param arreglo arreglo de enteros a ordenar
     */
    private void ordenarPorSeleccion(int[] arreglo) {
        for (int posicionActual = 0; posicionActual < arreglo.length - 1; posicionActual++) {
            int indiceMinimo = posicionActual;
            for (int comparacion = posicionActual + 1; comparacion < arreglo.length; comparacion++) {
                if (arreglo[comparacion] < arreglo[indiceMinimo]) {
                    indiceMinimo = comparacion;
                }
            }
            if (indiceMinimo != posicionActual) {
                int temp = arreglo[posicionActual];
                arreglo[posicionActual] = arreglo[indiceMinimo];
                arreglo[indiceMinimo] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de filas para la matriz: ");
        int filas = scanner.nextInt();

        System.out.print("Ingrese el número de columnas para la matriz: ");
        int columnas = scanner.nextInt();

        Matriz miMatriz = new Matriz(filas, columnas);

        System.out.println("\nMatriz generada aleatoriamente:");
        miMatriz.imprimirMatriz();

        System.out.println("\nOpciones de ordenamiento:");
        System.out.println("f - Ordenar una fila");
        System.out.println("c - Ordenar una columna");
        System.out.println("e - Ordenar matriz completa");
        System.out.print("Seleccione una opción: ");

        String opcion = scanner.next().toLowerCase();
        OrdenamientoSeleccion ordenador = new OrdenamientoSeleccion();

        switch (opcion) {
            case "f":
                System.out.print("Ingrese el número de fila a ordenar (0-" + (filas - 1) + "): ");
                int fila = scanner.nextInt();
                ordenador.ordenarFila(miMatriz.getMatriz(), fila);
                System.out.println("\nMatriz con fila " + fila + " ordenada:");
                break;

            case "c":
                System.out.print("Ingrese el número de columna a ordenar (0-" + (columnas - 1) + "): ");
                int columna = scanner.nextInt();
                ordenador.ordenarColumna(miMatriz.getMatriz(), columna);
                System.out.println("\nMatriz con columna " + columna + " ordenada:");
                break;

            case "e":
                ordenador.ordenarMatrizCompleta(miMatriz.getMatriz());
                System.out.println("\nMatriz completamente ordenada:");
                break;

            default:
                System.out.println("Opción no válida");
                break;
        }

        miMatriz.imprimirMatriz();
        scanner.close();
    }
}
