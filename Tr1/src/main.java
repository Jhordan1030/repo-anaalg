import java.util.InputMismatchException;
import java.util.Scanner;
public class main {
private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayMenu();
        int option = getOption();

        handleOption(option);

        scanner.close();
        System.out.println("Programa terminado.");
    }

    private static void displayMenu() {
        System.out.println("\n=========================");
        System.out.println("    Elija un ejercicio:    ");
        System.out.println("=========================");
        System.out.println("1. Ejercicio 1");
        System.out.println("2. Ejercicio 2");
        System.out.println("3. Ejercicio 3");
        System.out.println("4. Ejercicio 4");
        System.out.println("5. Ejercicio 5");
        System.out.println("6. Ejercicio 6");
        System.out.println("7. Ejercicio 7");
        System.out.println("8. Ejercicio 8");
        System.out.println("9. Ejercicio 9");
        System.out.println("10. Ejercicio 10");
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
                Ejercicio1.main(null);
                break;
            case 2:
                Ejercicio2.main(null);
                break;
            case 3:
                Ejercicio3.main(null);
                break;
            case 4:
                Ejercicio4.main(null);
                break;
            case 5:
                Ejercicio5.main(null);
                break;
            case 6:
                Ejercicio6.main(null);
                break;
            case 7:
                Ejercicio7.main(null);
                break;
            case 8:
                Ejercicio8.main(null);
                break;
            case 9:
                Ejercicio9.main(null);
                break;
            case 10:
                Ejercicio10.main(null);
                break;
            case 0:
                System.out.println("Saliendo del programa.");
                break;
            default:
                System.out.println("Opción no válida. Intenta de nuevo.");
        }
    }
}
