package Ejercicio9;

import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedir al usuario el tamaño de la matriz y la cantidad de números a ingresar
        System.out.print("Ingrese el número de filas: ");
        int filas = sc.nextInt();
        System.out.print("Ingrese el número de columnas: ");
        int columnas = sc.nextInt();
        System.out.print("¿Cuántos números aleatorios desea ingresar? ");
        int t = sc.nextInt();

        MatrizNumeros matriz = new MatrizNumeros(filas, columnas);
        matriz.llenarAleatorio(t);

        System.out.println("\nMatriz original:");
        matriz.imprimir();


        System.out.print("\n¿Qué fila desea ordenar? (empezando desde 0): ");
        int filaOrdenar = sc.nextInt();

        //calcular tiempo de ejecución
        long startTime = System.nanoTime();
        matriz.ordenarFilaPorInsercion(filaOrdenar);
        long endTime = System.nanoTime();
        System.out.println("Tiempo de ejecución: " + (endTime - startTime) + " ns");
        
        System.out.println("\nMatriz con la fila " + filaOrdenar + " ordenada:");
        matriz.imprimir();
    }
}