package Ejercicio9;

import java.util.Random;

public class MatrizNumeros {
    private int[][] matriz;
    private int filas;
    private int columnas;

    public MatrizNumeros(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        matriz = new int[filas][columnas];
    }

    public void llenarAleatorio(int t) {
        Random rand = new Random();
        int total = filas * columnas;

        if (t > total) t = total;

        int insertados = 0;
        while (insertados < t) {
            int i = rand.nextInt(filas);
            int j = rand.nextInt(columnas);
            if (matriz[i][j] == 0) {
                matriz[i][j] = rand.nextInt(100) + 1; // Números entre 1 y 100
                insertados++;
            }
        }
    }

    public void imprimir() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public void ordenarFilaPorInsercion(int fila) {
        for (int i = 1; i < columnas; i++) {
            int valor = matriz[fila][i];
            int j = i - 1;
            while (j >= 0 && matriz[fila][j] > valor) {
                matriz[fila][j + 1] = matriz[fila][j];
                j--;
            }
            matriz[fila][j + 1] = valor;
        }
    }
}