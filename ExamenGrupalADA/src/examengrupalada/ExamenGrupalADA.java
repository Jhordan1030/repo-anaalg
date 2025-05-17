/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examengrupalada;

import java.util.Scanner;

/**
 *
 * @author Giuliana Espinoza
 */
public class ExamenGrupalADA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el número de filas para la matriz:");
        int filas = scanner.nextInt();

        System.out.println("Ingrese el número de columnas para la matriz:");
        int columnas = scanner.nextInt();

        OrdenamientoShellSort shellSort = new OrdenamientoShellSort(filas, columnas);

        System.out.println("\nMatriz original:");
        shellSort.imprimirMatriz();

        // Ordenar por filas

        System.out.println("\nMatriz ordenada por filas:");
        shellSort.imprimirOrdenamiento(shellSort.ordenarPorFilas());
        
        // Ordenar por columnas
        System.out.println("\nMatriz ordenada por columnas:");
        shellSort.imprimirOrdenamiento(shellSort.ordenarPorColumnas());
        
        // Ordenar matriz completa
        System.out.println("\nMatriz completamente ordenada:");
        shellSort.imprimirOrdenamiento(shellSort.ordenarMatrizCompleta());
        
        scanner.close();
    }
}
