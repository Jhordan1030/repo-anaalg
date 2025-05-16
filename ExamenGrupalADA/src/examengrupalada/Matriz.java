/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examengrupalada;
import java.util.Random;

public class Matriz {
    private int[][] matriz;
    private int filas;
    private int columnas;
    private Random random;

    // Constructor que recibe filas y columnas
    public Matriz(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.matriz = new int[filas][columnas];
        this.random = new Random();
        llenarMatrizAleatoria();
    }

    // Método para llenar la matriz con números aleatorios
    private void llenarMatrizAleatoria() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = random.nextInt(100); // Números entre 0 y 99
            }
        }
    }

    // Método para imprimir la matriz
    public void imprimirMatriz() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Getters
    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }
        // Método getter necesario para acceder a la matriz
    public int[][] getMatriz() {
        return this.matriz;
    }
}