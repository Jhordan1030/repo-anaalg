/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examengrupalada;
import java.util.Scanner;

/**
 *
 * @author Giuliana Espinoza
 */
public class OrdenamientoSeleccion {
    
     // Método para ordenar una fila específica por selección
    public void ordenarFilaPorSeleccion(int[][] matriz, int fila) {
        if (fila < 0 || fila >= matriz.length) {
            System.out.println("Fila inválida");
            return;
        }
        
        int[] filaACopiar = matriz[fila];
        ordenarPorSeleccion(filaACopiar);
        
        // No es necesario devolver nada porque trabajamos con la referencia
    }

    // Método para ordenar una columna específica por selección
    public void ordenarColumnaPorSeleccion(int[][] matriz, int columna) {
        if (matriz.length == 0 || columna < 0 || columna >= matriz[0].length) {
            System.out.println("Columna inválida");
            return;
        }
        
        // Extraer columna a un arreglo
        int[] columnaArr = new int[matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            columnaArr[i] = matriz[i][columna];
        }
        
        // Ordenar el arreglo
        ordenarPorSeleccion(columnaArr);
        
        // Devolver los valores ordenados a la columna
        for (int i = 0; i < matriz.length; i++) {
            matriz[i][columna] = columnaArr[i];
        }
    }

    // Método para ordenar toda la matriz por selección
    public void ordenarMatrizCompletaPorSeleccion(int[][] matriz) {
        if (matriz.length == 0) return;
        
        // Convertir matriz a arreglo unidimensional
        int totalElementos = matriz.length * matriz[0].length;
        int[] elementos = new int[totalElementos];
        
        int index = 0;
        for (int[] fila : matriz) {
            for (int valor : fila) {
                elementos[index++] = valor;
            }
        }
        
        // Ordenar el arreglo
        ordenarPorSeleccion(elementos);
        
        // Volver a llenar la matriz
        index = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = elementos[index++];
            }
        }
    }

    // Método auxiliar: ordenamiento por selección
    private void ordenarPorSeleccion(int[] arreglo) {
        for (int i = 0; i < arreglo.length - 1; i++) {
            int minIndex = i;
            
            for (int j = i + 1; j < arreglo.length; j++) {
                if (arreglo[j] < arreglo[minIndex]) {
                    minIndex = j;
                }
            }
            
            if (minIndex != i) {
                int temp = arreglo[i];
                arreglo[i] = arreglo[minIndex];
                arreglo[minIndex] = temp;
            }
        }
    }
    
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
        
        // Menú de opciones de ordenamiento
        System.out.println("\nOpciones de ordenamiento:");
        System.out.println("f - Ordenar una fila");
        System.out.println("c - Ordenar una columna");
        System.out.println("e - Ordenar matriz completa");
        System.out.print("Seleccione una opción: ");
        
        String opcion = scanner.next().toLowerCase();
        OrdenamientoSeleccion ordenador = new OrdenamientoSeleccion();
        
        switch(opcion) {
            case "f":
                System.out.print("Ingrese el número de fila a ordenar (0-" + (filas-1) + "): ");
                int fila = scanner.nextInt();
                ordenador.ordenarFilaPorSeleccion(miMatriz.getMatriz(), fila);
                System.out.println("\nMatriz con fila " + fila + " ordenada:");
                break;
                
            case "c":
                System.out.print("Ingrese el número de columna a ordenar (0-" + (columnas-1) + "): ");
                int columna = scanner.nextInt();
                ordenador.ordenarColumnaPorSeleccion(miMatriz.getMatriz(), columna);
                System.out.println("\nMatriz con columna " + columna + " ordenada:");
                break;
                
            case "e":
                ordenador.ordenarMatrizCompletaPorSeleccion(miMatriz.getMatriz());
                System.out.println("\nMatriz completamente ordenada:");
                break;
                
            default:
                System.out.println("Opción no válida");
                break;
        }
        
        // Mostrar matriz después del ordenamiento
        miMatriz.imprimirMatriz();
        scanner.close();
    }
    
}

