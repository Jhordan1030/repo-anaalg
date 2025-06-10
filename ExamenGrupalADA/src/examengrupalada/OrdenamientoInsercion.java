/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examengrupalada;

/**
 *
 * @author Giuliana Espinoza
 */
import java.util.Scanner;

public class OrdenamientoInsercion extends Matriz {

    public OrdenamientoInsercion(int filas, int columnas) {
        super(filas, columnas);
    }

    public int[][] ordenarPorFilas() {
        int[][] matrizOrdenada = new int[this.filas][this.columnas];

        for (int fila = 0; fila < this.filas; fila++) {
            int[] filaTemporal = this.matriz[fila].clone();
            matrizOrdenada[fila] = aplicarOrdenamientoPorInsercion(filaTemporal);
        }

        return matrizOrdenada;
    }

    public int[][] ordenarPorColumnas() {
        int[][] matrizOrdenada = new int[this.filas][this.columnas];

        for (int columna = 0; columna < this.columnas; columna++) {
            int[] columnaTemporal = new int[this.filas];

            for (int fila = 0; fila < this.filas; fila++) {
                columnaTemporal[fila] = this.matriz[fila][columna];
            }

            int[] columnaOrdenada = aplicarOrdenamientoPorInsercion(columnaTemporal);

            for (int fila = 0; fila < this.filas; fila++) {
                matrizOrdenada[fila][columna] = columnaOrdenada[fila];
            }
        }

        return matrizOrdenada;
    }

    public int[][] ordenarMatrizCompleta() {
        int[][] matrizOrdenada = new int[this.filas][this.columnas];
        int totalElementos = this.filas * this.columnas;
        int[] elementosLineales = new int[totalElementos];

        // Convertir la matriz en un arreglo unidimensional
        int indice = 0;
        for (int fila = 0; fila < this.filas; fila++) {
            for (int columna = 0; columna < this.columnas; columna++) {
                elementosLineales[indice++] = this.matriz[fila][columna];
            }
        }

        elementosLineales = aplicarOrdenamientoPorInsercion(elementosLineales);

        // Reconstruir la matriz a partir del arreglo ordenado
        indice = 0;
        for (int fila = 0; fila < this.filas; fila++) {
            for (int columna = 0; columna < this.columnas; columna++) {
                matrizOrdenada[fila][columna] = elementosLineales[indice++];
            }
        }

        return matrizOrdenada;
    }

    private int[] aplicarOrdenamientoPorInsercion(int[] arregloDesordenado) {
        for (int indiceActual = 1; indiceActual < arregloDesordenado.length; indiceActual++) {
            int elementoAInsertar = arregloDesordenado[indiceActual];
            int posicionComparacion;

            for (posicionComparacion = indiceActual - 1; posicionComparacion >= 0; posicionComparacion--) {
                if (arregloDesordenado[posicionComparacion] > elementoAInsertar) {
                    arregloDesordenado[posicionComparacion + 1] = arregloDesordenado[posicionComparacion];
                } else {
                    break; // Se detiene cuando ya no se cumple la condición de ordenamiento
                }
            }

            arregloDesordenado[posicionComparacion + 1] = elementoAInsertar;
        }

        return arregloDesordenado;
    }

    public void imprimirOrdenamiento(int[][] matrizOrdenada) {
        for (int fila = 0; fila < matrizOrdenada.length; fila++) {
            for (int columna = 0; columna < matrizOrdenada[fila].length; columna++) {
                System.out.print(matrizOrdenada[fila][columna] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese el número de filas de la matriz:");
        int filas = entrada.nextInt();

        System.out.println("Ingrese el número de columnas de la matriz:");
        int columnas = entrada.nextInt();

        OrdenamientoInsercion matrizConOrdenamiento = new OrdenamientoInsercion(filas, columnas);

        System.out.println("\nMatriz original:");
        matrizConOrdenamiento.imprimirMatriz();

        System.out.println("\nMatriz ordenada por filas:");
        matrizConOrdenamiento.imprimirOrdenamiento(matrizConOrdenamiento.ordenarPorFilas());

        System.out.println("\nMatriz ordenada por columnas:");
        matrizConOrdenamiento.imprimirOrdenamiento(matrizConOrdenamiento.ordenarPorColumnas());

        System.out.println("\nMatriz completamente ordenada:");
        matrizConOrdenamiento.imprimirOrdenamiento(matrizConOrdenamiento.ordenarMatrizCompleta());

        entrada.close();
    }
}
