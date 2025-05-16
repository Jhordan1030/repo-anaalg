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

        // Solicitar dimensiones de la matriz al usuario
        System.out.println("Ingrese el número de filas para la matriz:");
        int filas = scanner.nextInt();

        System.out.println("Ingrese el número de columnas para la matriz:");
        int columnas = scanner.nextInt();

        // Crear la matriz con las dimensiones ingresadas
        Matriz miMatriz = new Matriz(filas, columnas);

        // Imprimir la matriz
        System.out.println("\nMatriz generada aleatoriamente:");
        miMatriz.imprimirMatriz();
        
        scanner.close();
    }
}
