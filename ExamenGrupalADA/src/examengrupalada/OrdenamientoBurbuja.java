/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examengrupalada;

import java.util.Scanner;

/**
 *
 * @author Jhordan Huera
 */
public class OrdenamientoBurbuja {

    // Ordena una fila específica con burbuja
    public static void ordenarFila(int[][] matriz, int fila) {
        int columnas = matriz[0].length;
        for (int pasada = 0; pasada < columnas - 1; pasada++) {
            for (int indiceColumna = 0; indiceColumna < columnas - 1 - pasada; indiceColumna++) {
                if (matriz[fila][indiceColumna] > matriz[fila][indiceColumna + 1]) {
                    int temp = matriz[fila][indiceColumna];
                    matriz[fila][indiceColumna] = matriz[fila][indiceColumna + 1];                  //T(n)= 6n^2-8n+7
                    matriz[fila][indiceColumna + 1] = temp;
                }
            }
        }
    }

    // Ordena una columna específica con burbuja
    public static void ordenarColumna(int[][] matriz, int columna) {
        int filas = matriz.length;
        for (int pasada = 0; pasada < filas - 1; pasada++) {
            for (int indiceFila = 0; indiceFila < filas - 1 - pasada; indiceFila++) {
                if (matriz[indiceFila][columna] > matriz[indiceFila + 1][columna]) {
                    int temp = matriz[indiceFila][columna];
                    matriz[indiceFila][columna] = matriz[indiceFila + 1][columna];
                    matriz[indiceFila + 1][columna] = temp;
                }                                                                       //T(n)=6n^2-8n+7
            }
        }
    }
    // Ordena la matriz completa  con burbuja
    public static void ordenarMatrizCompleta(int[][] matriz) {
        int numFilas = matriz.length;
        int numColumnas = matriz[0].length;
        int totalElementos = numFilas * numColumnas;

        // Aplanar la matriz en un arreglo unidimensional
        int[] arregloPlano = new int[totalElementos];
        int posicion = 0;
        for (int fila = 0; fila < numFilas; fila++) {
            for (int columna = 0; columna < numColumnas; columna++) {
                arregloPlano[posicion++] = matriz[fila][columna];           //T = 3n^2+4n+2
            }
        }

        // Ordenamiento burbuja en arreglo plano
        for (int pasada = 0; pasada < totalElementos - 1; pasada++) {
            for (int indice = 0; indice < totalElementos - 1 - pasada; indice++) {      //T(n) = 12n^2+14
                if (arregloPlano[indice] > arregloPlano[indice + 1]) {
                    int temp = arregloPlano[indice];
                    arregloPlano[indice] = arregloPlano[indice + 1];
                    arregloPlano[indice + 1] = temp;                    //T=6n^2-8n+4
                }
            }
        }

        // Volver a llenar la matriz con los valores ordenados
        posicion = 0;
        for (int fila = 0; fila < numFilas; fila++) {
            for (int columna = 0; columna < numColumnas; columna++) {
                matriz[fila][columna] = arregloPlano[posicion++];       //T=3n^2+4n+2
            }
        }
    }

    // Método main para manejar entrada y probar ordenamiento
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ordenamiento por Burbuja");

        System.out.println("Ingrese el número de filas para la matriz:");
        int filas = scanner.nextInt();

        System.out.println("Ingrese el número de columnas para la matriz:");
        int columnas = scanner.nextInt();

        Matriz miMatriz = new Matriz(filas, columnas);

        System.out.println("\nMatriz generada aleatoriamente:");
        miMatriz.imprimirMatriz();

        System.out.println("\nOpciones de ordenamiento:");
        System.out.println("f - Ordenar una fila");
        System.out.println("c - Ordenar una columna");
        System.out.println("t - Ordenar matriz completa");
        System.out.print("Seleccione una opción: ");
        String opcion = scanner.next();

        switch (opcion.toLowerCase()) {
            case "f":
                System.out.println("Ingrese el índice de la fila a ordenar (0 a " + (filas - 1) + "):");
                int fila = scanner.nextInt();
                if (fila >= 0 && fila < filas) {
                    OrdenamientoBurbuja.ordenarFila(miMatriz.getMatriz(), fila);
                    System.out.println("Matriz después de ordenar la fila " + fila + ":");
                    miMatriz.imprimirMatriz();
                } else {
                    System.out.println("Índice de fila inválido.");
                }
                break;

            case "c":
                System.out.println("Ingrese el índice de la columna a ordenar (0 a " + (columnas - 1) + "):");
                int columna = scanner.nextInt();
                if (columna >= 0 && columna < columnas) {
                    OrdenamientoBurbuja.ordenarColumna(miMatriz.getMatriz(), columna);
                    System.out.println("Matriz después de ordenar la columna " + columna + ":");
                    miMatriz.imprimirMatriz();
                } else {
                    System.out.println("Índice de columna inválido.");
                }
                break;

            case "t":
                OrdenamientoBurbuja.ordenarMatrizCompleta(miMatriz.getMatriz());
                System.out.println("Matriz después de ordenar toda la matriz:");
                miMatriz.imprimirMatriz();
                break;

            default:
                System.out.println("Opción inválida. No se realizó ninguna ordenación.");
        }

        scanner.close();
    }

}

