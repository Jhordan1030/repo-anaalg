/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examengrupalada;

import java.util.Scanner;

/**
 *
 * @author Pablo Jiménez
 */
public class OrdenamientoMergeSort {

    // Método para ordenar una fila específica de una matriz
    public static void ordenarFila(int[][] matriz, int fila) {
        int[] filaData = matriz[fila]; //1
        mergeSort(filaData, 0, filaData.length - 1);

    }

    // Método para ordenar una columna específica de una matriz
    public static void ordenarColumna(int[][] matriz, int columna) {
        int filas = matriz.length;
        int[] columnaData = new int[filas];

        // Extraer la columna
        for (int fil = 0; fil < filas; fil++) {
            columnaData[fil] = matriz[fil][columna];
        }

        // Ordenar columna
        mergeSort(columnaData, 0, filas - 1);

        // Reinsertar la columna ordenada
        for (int fil = 0; fil < filas; fil++) {
            matriz[fil][columna] = columnaData[fil];
        }

    }

    // Método para ordenar toda la matriz fila por fila (puedes modificar para columna por columna si deseas)
    public static void ordenarMatriz(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        int total = filas * columnas;

        int[] arreglo = new int[total];

        // Paso 1: Copiar elementos de la matriz al arreglo
        int index = 0; //1
        //inicio = 6
        for (int fil = 0; fil < filas; fil++) {
            for (int col = 0; col < columnas; col++) {
                arreglo[index++] = matriz[fil][col];
            }
        }

        // Paso 2: Ordenar el arreglo con MergeSort personalizado
        mergeSort(arreglo, 0, arreglo.length - 1);

        // Paso 3: Volver a llenar la matriz con los valores ordenados
        index = 0;
        for (int fil = 0; fil < filas; fil++) {
            for (int col = 0; col < columnas; col++) {
                matriz[fil][col] = arreglo[index++];
            }
        }

    }

    // Método auxiliar de MergeSort
    private static void mergeSort(int[] arr, int left, int right) { //3
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }

    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] leftArray = new int[mid - left + 1];
        int[] rightArray = new int[right - mid];

        for (int i = 0; i < leftArray.length; i++)
        {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < rightArray.length; j++)
        {
            rightArray[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
            }
        }

        while (i < leftArray.length) {
            arr[k++] = leftArray[i++];
        }

        while (j < rightArray.length) {
            arr[k++] = rightArray[j++];
        }

    }

    public static void main(String[] args) {
        Matriz matriz;
        Scanner user;

        user = new Scanner(System.in);

        System.out.print("Ingrese num de filas: ");
        int filas = user.nextInt();
        System.out.print("Ingrese num de columnas: ");
        int columnas = user.nextInt();
        matriz = new Matriz(filas, columnas);
        System.out.println("\nMatriz generada aleatoriamente:");
        matriz.imprimirMatriz();

        System.out.println("\nOpciones de ordenamiento:");
        System.out.println("f - Ordenar una fila");
        System.out.println("c - Ordenar una columna");
        System.out.println("e - Ordenar matriz completa");
        System.out.print("Seleccione una opción: ");

        String opcion = user.next().toLowerCase();

        switch (opcion) {
            case "f":
                System.out.print("Ingrese el número de fila a ordenar (0-" + (filas - 1) + "): ");
                int fila = user.nextInt();
                ordenarFila(matriz.getMatriz(), fila);
                System.out.println("\nMatriz con fila " + fila + " ordenada:");
                break;

            case "c":
                System.out.print("Ingrese el número de columna a ordenar (0-" + (columnas - 1) + "): ");
                int columna = user.nextInt();
                ordenarColumna(matriz.getMatriz(), columna);
                System.out.println("\nMatriz con columna " + columna + " ordenada:");
                break;

            case "e":
                ordenarMatriz(matriz.getMatriz());
                System.out.println("\nMatriz completamente ordenada:");
                break;

            default:
                System.out.println("Opción no válida");
                break;
        }

        matriz.imprimirMatriz();
        user.close();
    }
}
