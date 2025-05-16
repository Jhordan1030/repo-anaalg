import java.util.Random;
import java.util.Scanner;

<<<<<<< HEAD
public class Ej {
    // Constantes
    private static final int VALOR_MAXIMO = 90;
    private static final int VALOR_MINIMO = 1;
    private static final int DECIMALES_INVERSA = 4;
    private static final int MICROSEGUNDOS_POR_NANOSEGUNDO = 1000;
=======
public class Ejercicio7 {

  private static final int MICROSEGUNDOS_POR_NANOSEGUNDO = 1000;
>>>>>>> 03431219ff3cb7c2211d5b4228d97fd1b1c728ef
    private static final int MILISEGUNDOS_POR_NANOSEGUNDO = 1_000_000;
    private static final double SEGUNDOS_POR_NANOSEGUNDO = 1_000_000_000.0;
    private static final int DECIMALES_MICROSEGUNDOS = 3;
    private static final int DECIMALES_MILISEGUNDOS = 3;
    private static final int DECIMALES_SEGUNDOS = 6;
<<<<<<< HEAD
    
    // Campos
    private final int[][] matriz;
    private final int dimension;

    public static void main(String[] args) {
        ejecutarPrograma();
=======

  
  //Metodos 
   private static final int VALOR_MAXIMO = 90;
    private static final int VALOR_MINIMO = 1;
    private static final int DECIMALES_INVERSA = 4;
    
    private final int[][] matriz;
    private final int dimension;

    public Ejercicio7(int dimension) {
        this.dimension = dimension;
        this.matriz = new int[dimension][dimension];
        generarMatrizAleatoria();
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
        double[][] matrizInversa = new double[dimension][dimension];
        double[][] matrizAumentada = crearMatrizAumentada();

        int determinante = calcularDeterminante(matriz);
        if (determinante == 0) {
            System.out.println("La matriz no tiene inversa (determinante = 0).");
            return null;
        }

        aplicarEliminacionGaussiana(matrizAumentada);
        extraerMatrizInversa(matrizAumentada, matrizInversa);

        return matrizInversa;
    }

    private double[][] crearMatrizAumentada() {
        double[][] matrizAumentada = new double[dimension][2 * dimension];
        
        for (int fila = 0; fila < dimension; fila++) {
            for (int columna = 0; columna < dimension; columna++) {
                matrizAumentada[fila][columna] = matriz[fila][columna];
                matrizAumentada[fila][columna + dimension] = (fila == columna) ? 1 : 0;
            }
        }
        return matrizAumentada;
    }

    private void aplicarEliminacionGaussiana(double[][] matrizAumentada) {
        for (int filaPivote = 0; filaPivote < dimension; filaPivote++) {
            realizarPivoteoParcial(matrizAumentada, filaPivote);
            normalizarFilaPivote(matrizAumentada, filaPivote);
            eliminarElementosDebajoPivote(matrizAumentada, filaPivote);
        }
    }

    private void realizarPivoteoParcial(double[][] matrizAumentada, int filaPivote) {
        if (matrizAumentada[filaPivote][filaPivote] == 0) {
            for (int filaBusqueda = filaPivote + 1; filaBusqueda < dimension; filaBusqueda++) {
                if (matrizAumentada[filaBusqueda][filaPivote] != 0) {
                    intercambiarFilas(matrizAumentada, filaPivote, filaBusqueda);
                    break;
                }
            }
        }
    }

    private void normalizarFilaPivote(double[][] matrizAumentada, int filaPivote) {
        double pivote = matrizAumentada[filaPivote][filaPivote];
        for (int columna = 0; columna < 2 * dimension; columna++) {
            matrizAumentada[filaPivote][columna] /= pivote;
        }
    }

    private void eliminarElementosDebajoPivote(double[][] matrizAumentada, int filaPivote) {
        for (int filaActual = 0; filaActual < dimension; filaActual++) {
            if (filaActual != filaPivote && matrizAumentada[filaActual][filaPivote] != 0) {
                double factor = matrizAumentada[filaActual][filaPivote];
                for (int columna = 0; columna < 2 * dimension; columna++) {
                    matrizAumentada[filaActual][columna] -= factor * matrizAumentada[filaPivote][columna];
                }
            }
        }
    }

    private void extraerMatrizInversa(double[][] matrizAumentada, double[][] matrizInversa) {
        for (int fila = 0; fila < dimension; fila++) {
            for (int columna = 0; columna < dimension; columna++) {
                matrizInversa[fila][columna] = matrizAumentada[fila][columna + dimension];
            }
        }
    }

    private static void intercambiarFilas(double[][] matriz, int fila1, int fila2) {
        double[] filaTemporal = matriz[fila1];
        matriz[fila1] = matriz[fila2];
        matriz[fila2] = filaTemporal;
    }

    private static int calcularDeterminante(int[][] matriz) {
        int tamaño = matriz.length;
        if (tamaño == 1) return matriz[0][0];
        if (tamaño == 2) {
            return matriz[0][0] * matriz[1][1] - matriz[0][1] * matriz[1][0];
        }

        int determinante = 0;
        for (int columna = 0; columna < tamaño; columna++) {
            int[][] submatriz = crearSubmatriz(matriz, columna);
            int signo = (int) Math.pow(-1, columna);
            determinante += matriz[0][columna] * signo * calcularDeterminante(submatriz);
        }
        return determinante;
    }

    private static int[][] crearSubmatriz(int[][] matriz, int columnaExcluida) {
        int tamaño = matriz.length;
        int[][] submatriz = new int[tamaño - 1][tamaño - 1];
        
        for (int fila = 1; fila < tamaño; fila++) {
            for (int columna = 0, columnaSubmatriz = 0; columna < tamaño; columna++) {
                if (columna == columnaExcluida) continue;
                submatriz[fila - 1][columnaSubmatriz++] = matriz[fila][columna];
            }
        }
        return submatriz;
    }

    public static void imprimirInversa(double[][] inversa) {
        if (inversa == null) {
            System.out.println("No se puede imprimir la inversa (matriz no invertible).");
            return;
        }

        System.out.println("Matriz Inversa:");
        for (double[] fila : inversa) {
            for (double valor : fila) {
                System.out.printf("%." + DECIMALES_INVERSA + "f\t", valor);
            }
            System.out.println();
        }
    }
  
   public static void main(String[] args) {
     //Main
    

     Scanner scanner = new Scanner(System.in);
        
     int dimensionMatriz = solicitarDimensionMatriz(scanner);
     Ejercicio7 matriz = new Ejercicio7(dimensionMatriz);
     
     matriz.imprimirMatriz();
     
     ResultadoCalculo resultado = calcularYMedirInversa(matriz);
     Ejercicio7.imprimirInversa(resultado.matrizInversa);
     
     mostrarTiemposEjecucion(resultado);
     
     scanner.close();

   }

    private static int solicitarDimensionMatriz(Scanner scanner) {
        System.out.print("Ingrese la dimensión de la matriz cuadrada: ");
        return scanner.nextInt();
    }

    private static ResultadoCalculo calcularYMedirInversa(Ejercicio7 matriz) {
        long inicioTiempo = System.nanoTime();
        double[][] inversa = matriz.calcularInversa();
        long finTiempo = System.nanoTime();
        
        return new ResultadoCalculo(inversa, inicioTiempo, finTiempo);
    }

    private static void mostrarTiemposEjecucion(ResultadoCalculo resultado) {
        if (resultado.matrizInversa == null) {
            System.out.println("\nNo se midió el tiempo de ejecución (matriz no invertible)");
            return;
        }

        long tiempoEjecucionNs = resultado.finTiempo - resultado.inicioTiempo;
        System.out.println("\nTiempo de ejecución para calcular la inversa:");
        
        System.out.println("Nanosegundos: " + tiempoEjecucionNs + " ns");
        imprimirTiempoConvertido(tiempoEjecucionNs, MICROSEGUNDOS_POR_NANOSEGUNDO, "Microsegundos", DECIMALES_MICROSEGUNDOS);
        imprimirTiempoConvertido(tiempoEjecucionNs, MILISEGUNDOS_POR_NANOSEGUNDO, "Milisegundos", DECIMALES_MILISEGUNDOS);
        imprimirTiempoConvertido(tiempoEjecucionNs, SEGUNDOS_POR_NANOSEGUNDO, "Segundos", DECIMALES_SEGUNDOS);
    }

    private static void imprimirTiempoConvertido(long tiempoNs, double factorConversion, String unidad, int decimales) {
        double tiempoConvertido = tiempoNs / factorConversion;
        System.out.printf("%s: %." + decimales + "f %s%n", unidad, tiempoConvertido, getSimboloUnidad(unidad));
    }

    private static String getSimboloUnidad(String unidad) {
        switch (unidad) {
            case "Microsegundos": return "µs";
            case "Milisegundos": return "ms";
            case "Segundos": return "s";
            default: return "";
        }
    }

    private static class ResultadoCalculo {
        public final double[][] matrizInversa;
        public final long inicioTiempo;
        public final long finTiempo;

        public ResultadoCalculo(double[][] matrizInversa, long inicioTiempo, long finTiempo) {
            this.matrizInversa = matrizInversa;
            this.inicioTiempo = inicioTiempo;
            this.finTiempo = finTiempo;
        }
>>>>>>> 03431219ff3cb7c2211d5b4228d97fd1b1c728ef
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