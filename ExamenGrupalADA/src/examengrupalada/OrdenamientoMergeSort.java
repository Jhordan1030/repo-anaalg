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
    public static void ordenarFila(int[][] matriz, int fila) { //2
        int[] filaData = matriz[fila]; //1
        mergeSort(filaData, 0, filaData.length - 1); // (13n+21)(2^n-1)+4*2^n
        // (13n+21)(2^n-1)+4*2^n+3
    }

    // Método para ordenar una columna específica de una matriz
    public static void ordenarColumna(int[][] matriz, int columna) { //2
        int filas = matriz.length; //1
        int[] columnaData = new int[filas]; //1

        // Extraer la columna
        for (int fil = 0; fil < filas; fil++) { //3n+2
            columnaData[fil] = matriz[fil][columna];
        }

        // Ordenar columna
        mergeSort(columnaData, 0, filas - 1); //(13n+17)(2^n-1)+4*2^n

        // Reinsertar la columna ordenada
        for (int fil = 0; fil < filas; fil++) { //3n+2
            matriz[fil][columna] = columnaData[fil];
        }
        //total = 6n+8 + (13n+17)(2^n-1)+4*2^n
    }

    // Método para ordenar toda la matriz fila por fila (puedes modificar para columna por columna si deseas)
    public static void ordenarMatriz(int[][] matriz) { //1
        int filas = matriz.length; //1
        int columnas = matriz[0].length; //1
        int total = filas * columnas; //1

        int[] arreglo = new int[total]; // Crear arreglo temporal 1

        // Paso 1: Copiar elementos de la matriz al arreglo
        int index = 0; //1
        //inicio = 6
        for (int fil = 0; fil < filas; fil++) { //1 n+1 n 3n²+2n = 3n²+4n+2
            for (int col = 0; col < columnas; col++) { // 1 n+1 n n = 3n+2
                arreglo[index++] = matriz[fil][col];
            }
        }

        // Paso 2: Ordenar el arreglo con MergeSort personalizado
        mergeSort(arreglo, 0, arreglo.length - 1); //(13n+21)(2^n-1)+4*2^n

        // Paso 3: Volver a llenar la matriz con los valores ordenados
        index = 0; //1
        for (int fil = 0; fil < filas; fil++) { //1 n+1 n 3n²+2 = 3n²+4n+2
            for (int col = 0; col < columnas; col++) { //1 n+1 n n = 3n+2
                matriz[fil][col] = arreglo[index++];
            }
        }
        // total = 6n³+8n+11+(13n+21)(2^n-1)+4*2^n
    }

    // Método auxiliar de MergeSort
    private static void mergeSort(int[] arr, int left, int right) { //3
        if (left < right) { //1
            int mid = (left + right) / 2; //1
            mergeSort(arr, left, mid); // T(n-1)
            mergeSort(arr, mid + 1, right);// T(n-1)
            merge(arr, left, mid, right); //13n+16
        }
        //b= 13n+17 a=4
    } //13n+21+2T(n-1) = (13n+21)(2^n-1)+4*2^n

    private static void merge(int[] arr, int left, int mid, int right) { //4
        int[] leftArray = new int[mid - left + 1]; //1
        int[] rightArray = new int[right - mid]; //1

        for (int i = 0; i < leftArray.length; i++) //1 n+1 n = 3n+2
        {
            leftArray[i] = arr[left + i]; //n
        }
        for (int j = 0; j < rightArray.length; j++) //3n+2
        {
            rightArray[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left; //3

        while (i < leftArray.length && j < rightArray.length) { //n+1 = 3n+1
            if (leftArray[i] <= rightArray[j]) { //2n
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
            }
        }

        while (i < leftArray.length) { // n+1 = 2n+1
            arr[k++] = leftArray[i++]; //n
        }

        while (j < rightArray.length) { //2n+1
            arr[k++] = rightArray[j++];
        }
        //total = 6 + 6n+4 + 3 +3n+1 + 4n+2 = 13n+16
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
