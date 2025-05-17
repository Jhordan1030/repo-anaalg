/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examengrupalada;

/**
 *
 * @author Giuliana Espinoza
 */
public class OrdenamientoShellSort extends Matriz {

    public OrdenamientoShellSort(int filas, int columnas) {
        super(filas, columnas);
    }

    public int[][] ordenarPorFilas() {
        int[][] resultado = new int[this.filas][this.columnas];
        for (int fila = 0; fila < this.filas; fila++) {
            int[] filaTemporal = this.matriz[fila].clone();
            resultado[fila] = aplicarShellSort(filaTemporal);
        }
        return resultado;
    }

    public int[][] ordenarPorColumnas() {
        int[][] resultado = new int[this.filas][this.columnas];
        for (int columna = 0; columna < this.columnas; columna++) {
            int[] columnaTemporal = new int[this.filas];
            for (int fila = 0; fila < this.filas; fila++) {
                columnaTemporal[fila] = this.matriz[fila][columna];
            }
            int[] columnaOrdenada = aplicarShellSort(columnaTemporal);
            for (int fila = 0; fila < this.filas; fila++) {
                resultado[fila][columna] = columnaOrdenada[fila];
            }
        }
        return resultado;
    }

    public int[][] ordenarMatrizCompleta() {
        int[][] resultado = new int[this.filas][this.columnas];
        int totalElementos = this.filas * this.columnas;
        int[] elementos = new int[totalElementos];
        
        // Convertir matriz a array unidimensional
        int indiceElemento = 0;
        for (int fila = 0; fila < this.filas; fila++) {
            for (int columna = 0; columna < this.columnas; columna++) {
                elementos[indiceElemento++] = this.matriz[fila][columna];
            }
        }
        
        elementos = aplicarShellSort(elementos);
        
        // Reconvertir array ordenado a matriz
        indiceElemento = 0;
        for (int fila = 0; fila < this.filas; fila++) {
            for (int columna = 0; columna < this.columnas; columna++) {
                resultado[fila][columna] = elementos[indiceElemento++];
            }
        }
        return resultado;
    }

    private int[] aplicarShellSort(int[] elementos) {
        int longitudArreglo = elementos.length;

        for (int distancia = longitudArreglo / 2; distancia > 0; distancia /= 2) {
            for (int posicionActual = distancia; posicionActual < longitudArreglo; posicionActual++) {
                int elementoAInsertar = elementos[posicionActual];
                int posicionComparacion;
                for (posicionComparacion = posicionActual; posicionComparacion >= distancia; posicionComparacion -= distancia) {
                    if (elementos[posicionComparacion - distancia] > elementoAInsertar) {
                        elementos[posicionComparacion] = elementos[posicionComparacion - distancia];                        
                    } else {
                        break;
                    }
                }
                
                elementos[posicionComparacion] = elementoAInsertar;
            }
        }
        
        return elementos;
    }

    public void imprimirOrdenamiento(int[][] matrizOrdenada) {
        for (int fila = 0; fila < matrizOrdenada.length; fila++) {
            for (int columna = 0; columna < matrizOrdenada[fila].length; columna++) {
                System.out.print(matrizOrdenada[fila][columna] + "\t");
            }
            System.out.println();
        }
    }
}
