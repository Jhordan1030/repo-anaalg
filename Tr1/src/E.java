import java.util.Random;
import java.util.Scanner;

public class E {
    // Constantes
    private static final int VALOR_MAXIMO = 90;
    private static final int VALOR_MINIMO = 1;
    private static final int DECIMALES_INVERSA = 4;
    private static final int MICROSEGUNDOS_POR_NANOSEGUNDO = 1000;
    private static final int MILISEGUNDOS_POR_NANOSEGUNDO = 1_000_000;
    private static final double SEGUNDOS_POR_NANOSEGUNDO = 1_000_000_000.0;
    private static final int DECIMALES_MICROSEGUNDOS = 3;
    private static final int DECIMALES_MILISEGUNDOS = 3;
    private static final int DECIMALES_SEGUNDOS = 6;
    
    // Campos
    private final int[][] matriz;
    private final int dimension;

    public static void main(String[] args) {
        ejecutarPrograma();
    }

    private static void ejecutarPrograma() {
        try (Scanner scanner = new Scanner(System.in)) {
            int dimensionMatriz = solicitarDimensionMatriz(scanner);
            MatrizInversa matriz = new MatrizInversa(dimensionMatriz);
            
            matriz.imprimirMatriz();
            
            ResultadoCalculo resultado = calcularYMedirInversa(matriz);
            imprimirInversa(resultado.matrizInversa);
            
            mostrarTiemposEjecucion(resultado);
        }
    }

    public MatrizInversa(int dimension) {
        validarDimension(dimension);
        this.dimension = dimension;
        this.matriz = new int[dimension][dimension];
        generarMatrizAleatoria();
    }

    private void validarDimension(int dimension) {
        if (dimension <= 0) {
            throw new IllegalArgumentException("La dimensión debe ser mayor que cero");
        }
    }

    private void generarMatrizAleatoria() {
        Random generadorAleatorio = new Random();
        for (int fila = 0; fila < dimension; fila++) {
            for (int columna = 0; columna < dimension; columna++) {
                matriz[fila][columna] = generadorAleatorio.nextInt(VALOR_MAXIMO) + VALOR_MINIMO;
            }
        }
    }

    public void imprimirMatriz() {
        System.out.println("Matriz Generada:");
        for (int[] fila : matriz) {
            for (int valor : fila) {
                System.out.printf("%d\t", valor);
            }
            System.out.println();
        }
        System.out.println();
    }

    public double[][] calcularInversa() {
        if (calcularDeterminante(matriz) == 0) {
            System.out.println("La matriz no tiene inversa (determinante = 0).");
            return null;
        }

        double[][] matrizAumentada = crearMatrizAumentada();
        aplicarEliminacionGaussiana(matrizAumentada);
        return extraerMatrizInversa(matrizAumentada);
    }

    private double[][] crearMatrizAumentada() {
        double[][] matrizAumentada = new double[dimension][2 * dimension];
        
        for (int fila = 0; fila < dimension; fila++) {
            System.arraycopy(matriz[fila], 0, matrizAumentada[fila], 0, dimension);
            for (int columna = dimension; columna < 2 * dimension; columna++) {
                matrizAumentada[fila][columna] = (fila == columna - dimension) ? 1 : 0;
            }
        }
        return matrizAumentada;
    }

    private void aplicarEliminacionGaussiana(double[][] matrizAumentada) {
        for (int filaPivote = 0; filaPivote < dimension; filaPivote++) {
            realizarPivoteoParcial(matrizAumentada, filaPivote);
            normalizarFilaPivote(matrizAumentada, filaPivote);
            eliminarElementosRestantes(matrizAumentada, filaPivote);
        }
    }

    private double[][] extraerMatrizInversa(double[][] matrizAumentada) {
        double[][] matrizInversa = new double[dimension][dimension];
        for (int fila = 0; fila < dimension; fila++) {
            System.arraycopy(matrizAumentada[fila], dimension, matrizInversa[fila], 0, dimension);
        }
        return matrizInversa;
    }

    private static int calcularDeterminante(int[][] matriz) {
        int tamaño = matriz.length;
        if (tamaño == 1) return matriz[0][0];
        if (tamaño == 2) return matriz[0][0] * matriz[1][1] - matriz[0][1] * matriz[1][0];

        int determinante = 0;
        for (int columna = 0; columna < tamaño; columna++) {
            determinante += matriz[0][columna] * Math.pow(-1, columna) * calcularDeterminante(crearSubmatriz(matriz, columna));
        }
        return determinante;
    }

    private static int[][] crearSubmatriz(int[][] matriz, int columnaExcluida) {
        int tamaño = matriz.length;
        int[][] submatriz = new int[tamaño - 1][tamaño - 1];
        
        for (int fila = 1; fila < tamaño; fila++) {
            for (int columna = 0, columnaSubmatriz = 0; columna < tamaño; columna++) {
                if (columna != columnaExcluida) {
                    submatriz[fila - 1][columnaSubmatriz++] = matriz[fila][columna];
                }
            }
        }
        return submatriz;
    }

    private static void imprimirInversa(double[][] inversa) {
        if (inversa == null) return;

        System.out.println("Matriz Inversa:");
        for (double[] fila : inversa) {
            for (double valor : fila) {
                System.out.printf("%." + DECIMALES_INVERSA + "f\t", valor);
            }
            System.out.println();
        }
    }

    private static int solicitarDimensionMatriz(Scanner scanner) {
        System.out.print("Ingrese la dimensión de la matriz cuadrada: ");
        return scanner.nextInt();
    }

    private static ResultadoCalculo calcularYMedirInversa(MatrizInversa matriz) {
        long inicioTiempo = System.nanoTime();
        double[][] inversa = matriz.calcularInversa();
        long finTiempo = System.nanoTime();
        
        return new ResultadoCalculo(inversa, inicioTiempo, finTiempo);
    }

    private static void mostrarTiemposEjecucion(ResultadoCalculo resultado) {
        if (resultado.matrizInversa == null) return;

        long tiempoEjecucionNs = resultado.finTiempo - resultado.inicioTiempo;
        System.out.println("\nTiempo de ejecución para calcular la inversa:");
        
        imprimirTiempo("Nanosegundos", tiempoEjecucionNs, 1, "ns");
        imprimirTiempo("Microsegundos", tiempoEjecucionNs, MICROSEGUNDOS_POR_NANOSEGUNDO, "µs");
        imprimirTiempo("Milisegundos", tiempoEjecucionNs, MILISEGUNDOS_POR_NANOSEGUNDO, "ms");
        imprimirTiempo("Segundos", tiempoEjecucionNs, SEGUNDOS_POR_NANOSEGUNDO, "s");
    }

    private static void imprimirTiempo(String etiqueta, long tiempoNs, double factorConversion, String unidad) {
        double tiempoConvertido = tiempoNs / factorConversion;
        int decimales = obtenerDecimalesParaUnidad(unidad);
        System.out.printf("%s: %." + decimales + "f %s%n", etiqueta, tiempoConvertido, unidad);
    }

    private static int obtenerDecimalesParaUnidad(String unidad) {
        return switch (unidad) {
            case "µs" -> DECIMALES_MICROSEGUNDOS;
            case "ms" -> DECIMALES_MILISEGUNDOS;
            case "s" -> DECIMALES_SEGUNDOS;
            default -> 0;
        };
    }

    private static class ResultadoCalculo {
        final double[][] matrizInversa;
        final long inicioTiempo;
        final long finTiempo;

        ResultadoCalculo(double[][] matrizInversa, long inicioTiempo, long finTiempo) {
            this.matrizInversa = matrizInversa;
            this.inicioTiempo = inicioTiempo;
            this.finTiempo = finTiempo;
        }
    }

    private static void realizarPivoteoParcial(double[][] matriz, int filaPivote) {
        if (matriz[filaPivote][filaPivote] != 0) return;

        for (int fila = filaPivote + 1; fila < matriz.length; fila++) {
            if (matriz[fila][filaPivote] != 0) {
                intercambiarFilas(matriz, filaPivote, fila);
                break;
            }
        }
    }

    private static void normalizarFilaPivote(double[][] matriz, int filaPivote) {
        double pivote = matriz[filaPivote][filaPivote];
        for (int columna = 0; columna < matriz[filaPivote].length; columna++) {
            matriz[filaPivote][columna] /= pivote;
        }
    }

    private static void eliminarElementosRestantes(double[][] matriz, int filaPivote) {
        for (int fila = 0; fila < matriz.length; fila++) {
            if (fila != filaPivote) {
                double factor = matriz[fila][filaPivote];
                for (int columna = 0; columna < matriz[fila].length; columna++) {
                    matriz[fila][columna] -= factor * matriz[filaPivote][columna];
                }
            }
        }
    }

    private static void intercambiarFilas(double[][] matriz, int fila1, int fila2) {
        double[] temp = matriz[fila1];
        matriz[fila1] = matriz[fila2];
        matriz[fila2] = temp;
    }
}