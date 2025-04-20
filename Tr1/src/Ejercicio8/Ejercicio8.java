package Ejercicio8;

import java.util.*;

public class Ejercicio8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el número de filas: ");
        int n = sc.nextInt();
        System.out.print("Ingrese el número de columnas: ");
        int m = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese la palabra a buscar (en mayúsculas): ");
        String palabra = sc.nextLine().toUpperCase();

        SopaDeLetras sopa = new SopaDeLetras(n, m);
        System.out.println("\nMatriz generada:");
        sopa.imprimir();
        //guardar tiempo de ejecución
        long startTime = System.nanoTime();
        List<List<Posicion>> encontrados = sopa.buscarPalabra(palabra);
        long endTime = System.nanoTime();
        System.out.println("Tiempo de ejecución: " + (endTime - startTime) + " ns");
        if (encontrados.isEmpty()) {
            System.out.println("La palabra no se encontró en la matriz.");
        } else {
            System.out.println("Posiciones donde se encontró la palabra:");
            for (List<Posicion> lista : encontrados) {
                System.out.println(lista);
            }
        }
    }
}