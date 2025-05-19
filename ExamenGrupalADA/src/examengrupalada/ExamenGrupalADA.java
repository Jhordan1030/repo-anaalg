package examengrupalada;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.InputMismatchException;


/**
 *
 * @author Giuliana Espinoza
 */
public class ExamenGrupalADA {
    private static final Scanner scanner = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        displayMenu();
        int option = getOption();

        handleOption(option);

        scanner.close();
        System.out.println("Programa terminado.");
        System.out.println("Valores agregados:" + "\n" + "1. Ordenamiento de MergeShort" + "\n" + "2. Ordenar filas"
                            +"\n" + "3. Ordenar columnas" + "\n" + "4. Codigo limpio" + "\n" + "5. POO");

    }
    private static void displayMenu() {
        System.out.println("\n=========================");
        System.out.println("    Elija un ejercicio:    ");
        System.out.println("=========================");
        System.out.println("1. Busqueda lineal");
        System.out.println("2. Ordenamiento de Burbuja");
        System.out.println("3. Ordenamiento de Inserción");
        System.out.println("4. Ordeanamiento de MergeShort");
        System.out.println("5. Ordenamiento de Selección");
        System.out.println("6. Ordenamiento de ShellSort");
        System.out.println("0. Salir");
        System.out.println("=========================");
        System.out.print("Elige una opción: ");
    }
    private static int getOption() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Entrada no válida. Por favor, ingresa un número.");
            scanner.next(); // Limpiar el buffer
            return -1; // Indicar que la entrada fue inválida
        }
    }
    private static void handleOption(int option) {
        switch (option) {
            case 1:
                Busqueda.main(null);
                break;
            case 2:
                OrdenamientoBurbuja.main(null);
                break;
            case 3:
                OrdenamientoInsercion.main(null);
                break;
            case 4:
                OrdenamientoMergeSort.main(null);
                break;
            case 5:
                OrdenamientoSeleccion.main(null);
                break;
            case 6:
                OrdenamientoShellSort.main(null);
                break;
            case 0:
                System.out.println("Saliendo del programa.");
                break;
            default:
                System.out.println("Opción no válida. Intenta de nuevo.");
        }
    }
}
