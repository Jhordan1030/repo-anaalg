/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examengrupalada;

import java.util.Scanner;

/**
 *
 * @author Pablo
 */
public class Busqueda {

    public static boolean buscarUnElemento(int[][] matriz, int element) {
        for (int fil = 0; fil < matriz.length; fil++) {
            for (int col = 0; col < matriz[0].length; col++) {
                if (matriz[fil][col] == element) {
                    System.out.println("Elemento encontrado en posición: [" + fil + "][" + col + "]");
                    return true;
                }
            }
        }
        System.out.println("Elemento no encontrado.");
        return false;
    }

    public static boolean buscarUnElemento(Matriz matriz, int element) {
        return buscarUnElemento(matriz.getMatriz(), element);
    }

    public static boolean buscarUnElementoEnVariasPosiciones(int[][] matriz, int element) { //2
        boolean encontrado = false; //1

        for (int fil = 0; fil < matriz.length; fil++) { //1 n+1 n
            // n*(2n+5) = 2n² + 5n
            for (int col = 0; col < matriz[0].length; col++) { //1 n+1 n
                if (matriz[fil][col] == element) { //1
                    System.out.println("Elemento encontrado en posición: [" + fil + "][" + col + "]"); //1
                    encontrado = true; //1
                }
                //total col = 2n+5
            }
            //total fil = 2n² + 7n + 2
        }

        if (!encontrado) { //1
            System.out.println("Elemento no encontrado."); //1
        }

        return encontrado; //1
    }
    //total metodo = 2n² + 7n + 8

    public static boolean buscarUnElementoEnVariasPosiciones(Matriz matriz, int element) {
        return buscarUnElementoEnVariasPosiciones(matriz.getMatriz(), element);
    }

    public static void main(String[] args) {
        Matriz m1, m2;
        Scanner user;

        user = new Scanner(System.in);

        System.out.print("Ingrese num de filas: ");
        int filas = user.nextInt();
        System.out.print("Ingrese num de columnas: ");
        int columnas = user.nextInt();
        m1 = new Matriz(filas, columnas);
        m1.imprimirMatriz();

        System.out.print("Buscar un elemento, ingrese un numero: ");
        int num = user.nextInt();

        buscarUnElementoEnVariasPosiciones(m1, num);

        //Evaluar tiempos
        for (int size = 10; size <= 100; size += 10) {
            m2 = new Matriz(size, size); // matriz cuadrada size x size
            int numeroABuscar = (int) (Math.random() * 100); // número aleatorio a buscar

            long inicio = System.nanoTime();
            buscarUnElementoEnVariasPosiciones(m2.getMatriz(), numeroABuscar);
            long fin = System.nanoTime();

            long tiempo = fin - inicio;
            System.out.println("Tamaño: " + size + "x" + size + " | Tiempo: " + tiempo + " ns\n");
        }
    }
}
