/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examengrupalada;

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
        for (int i = 0; i < filas; i++) { //3n+2
            columnaData[i] = matriz[i][columna];
        }

        // Ordenar columna
        mergeSort(columnaData, 0, filas - 1); //(13n+17)(2^n-1)+4*2^n

        // Reinsertar la columna ordenada
        for (int i = 0; i < filas; i++) { //3n+2
            matriz[i][columna] = columnaData[i];
        }
        //total = 6n+8 + (13n+17)(2^n-1)+4*2^n
    }

    // Método para ordenar toda la matriz fila por fila (puedes modificar para columna por columna si deseas)
    public static void ordenarMatriz(int[][] matriz) { //1
        for (int i = 0; i < matriz.length; i++) { //1 n+1 n 
            ordenarFila(matriz, i);// n*((13n+21)(2^n-1)+4*2^n+3)
        }
        //total = 2n+3+ n*((13n+21)(2^n-1)+4*2^n+3)
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
            leftArray[i] = arr[left + i]; //n
        for (int j = 0; j < rightArray.length; j++) //3n+2
            rightArray[j] = arr[mid + 1 + j];

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
        Matriz m2;
        //Evaluar tiempos
        for (int size = 10; size <= 100; size += 10) {
            m2 = new Matriz(size, size); // matriz cuadrada size x size
            int numeroABuscar = (int)(Math.random() * (size - 1));

            long inicio = System.nanoTime();
            ordenarColumna(m2.getMatriz(), numeroABuscar);
            ordenarFila(m2.getMatriz(), numeroABuscar);
            ordenarMatriz(m2.getMatriz());
            long fin = System.nanoTime();

            long tiempo = fin - inicio;
            System.out.println("Tamaño: " + size + "x" + size + " | Tiempo: " + tiempo + " ns\n");
        }
    }
}
