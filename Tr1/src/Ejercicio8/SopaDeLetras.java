package Ejercicio8;

import java.util.*;

public class SopaDeLetras {
    private final char[][] matriz;
    private final int filas;
    private final int columnas;
    private static final String ALFABETO = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public SopaDeLetras(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.matriz = new char[filas][columnas];
        llenarAleatorio();
    }

    private void llenarAleatorio() {
        Random rand = new Random();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = ALFABETO.charAt(rand.nextInt(ALFABETO.length()));
            }
        }
    }

    public void imprimir() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public List<List<Posicion>> buscarPalabra(String palabra) {
        List<List<Posicion>> resultados = new ArrayList<>();
        int[][] direcciones = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1},  {1, 0},  {1, 1}
        };

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                for (int[] dir : direcciones) {
                    List<Posicion> pos = buscarDesde(i, j, palabra, dir[0], dir[1]);
                    if (pos != null) {
                        resultados.add(pos);
                    }
                }
            }
        }
        return resultados;
    }

    private List<Posicion> buscarDesde(int fila, int col, String palabra, int df, int dc) {
        List<Posicion> posiciones = new ArrayList<>();
        int f = fila, c = col;
        for (int k = 0; k < palabra.length(); k++) {
            if (f < 0 || f >= filas || c < 0 || c >= columnas || matriz[f][c] != palabra.charAt(k)) {
                return null;
            }
            posiciones.add(new Posicion(f, c));
            f += df;
            c += dc;
        }
        return posiciones;
    }
}