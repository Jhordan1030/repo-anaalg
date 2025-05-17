/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examengrupalada;

/**
 *
 * @author Giuliana Espinoza
 */
public class OrdenamientoShellSort {
    private Matriz matriz;

    public OrdenamientoShellSort(Matriz matriz) {
        this.matriz = matriz;
    }

    public void ordenarPorFilas() {
        int[][] matrizActual = matriz.getMatriz();
        for (int i = 0; i < matriz.getFilas(); i++) {
            int[] fila = matrizActual[i].clone();
            aplicarShellSort(fila);
            matrizActual[i] = fila;
        }
    }

    public void ordenarPorColumnas() {
        int[][] matrizActual = matriz.getMatriz();
        for (int j = 0; j < matriz.getColumnas(); j++) {
            int[] columna = extraerColumna(j);
            aplicarShellSort(columna);
            insertarColumna(columna, j);
        }
    }

    public void ordenarMatrizCompleta() {
        int totalElementos = matriz.getFilas() * matriz.getColumnas();
        int[] elementos = new int[totalElementos];
        int[][] matrizActual = matriz.getMatriz();
        
        // Convertir matriz a array unidimensional
        int k = 0;
        for (int i = 0; i < matriz.getFilas(); i++) {
            for (int j = 0; j < matriz.getColumnas(); j++) {
                elementos[k++] = matrizActual[i][j];
            }
        }
        
        aplicarShellSort(elementos);
        
        // Reconvertir array ordenado a matriz
        k = 0;
        for (int i = 0; i < matriz.getFilas(); i++) {
            for (int j = 0; j < matriz.getColumnas(); j++) {
                matrizActual[i][j] = elementos[k++];
            }
        }
    }

    private void aplicarShellSort(int[] elementos) {
        int totalElementos = elementos.length;
        
        for (int brecha = totalElementos / 2; brecha > 0; brecha /= 2) {
            for (int indiceActual = brecha; indiceActual < totalElementos; indiceActual++) {
                int valorActual = elementos[indiceActual];
                int indiceAnterior;
                
                for (indiceAnterior = indiceActual; 
                     indiceAnterior >= brecha && elementos[indiceAnterior - brecha] > valorActual; 
                     indiceAnterior -= brecha) {
                    elementos[indiceAnterior] = elementos[indiceAnterior - brecha];
                }
                
                elementos[indiceAnterior] = valorActual;
            }
        }
    }

    private int[] extraerColumna(int columna) {
        int[][] matrizActual = matriz.getMatriz();
        int[] columnaArray = new int[matriz.getFilas()];
        for (int i = 0; i < matriz.getFilas(); i++) {
            columnaArray[i] = matrizActual[i][columna];
        }
        return columnaArray;
    }

    private void insertarColumna(int[] columna, int numColumna) {
        int[][] matrizActual = matriz.getMatriz();
        for (int i = 0; i < matriz.getFilas(); i++) {
            matrizActual[i][numColumna] = columna[i];
        }
    }
}
