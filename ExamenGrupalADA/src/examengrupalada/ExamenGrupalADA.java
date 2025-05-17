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

        Matriz miMatriz = new Matriz(filas, columnas);
        OrdenamientoShellSort shellSort = new OrdenamientoShellSort(miMatriz);

        System.out.println("\nMatriz original:");
        miMatriz.imprimirMatriz();

        // Ordenar por filas
        shellSort.ordenarPorFilas();
        System.out.println("\nMatriz ordenada por filas:");
        miMatriz.imprimirMatriz();

        // Crear nueva matriz para ordenar por columnas
        miMatriz = new Matriz(filas, columnas);
        shellSort = new OrdenamientoShellSort(miMatriz);
        System.out.println("\nNueva matriz original:");
        miMatriz.imprimirMatriz();
        
        shellSort.ordenarPorColumnas();
        System.out.println("\nMatriz ordenada por columnas:");
        miMatriz.imprimirMatriz();

        // Crear nueva matriz para ordenamiento completo
        miMatriz = new Matriz(filas, columnas);
        shellSort = new OrdenamientoShellSort(miMatriz);
        System.out.println("\nNueva matriz original:");
        miMatriz.imprimirMatriz();
        
        shellSort.ordenarMatrizCompleta();
        System.out.println("\nMatriz completamente ordenada:");
        miMatriz.imprimirMatriz();
        
        scanner.close();
    }
}
