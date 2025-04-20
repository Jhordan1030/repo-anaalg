import java.util.Scanner;
import Ejercicio8.Ejercicio8;
import Ejercicio9.Ejercicio9;

public class main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("=== MENÚ DE EJERCICIOS ===");
            System.out.println("1. Ejercicio 8 (Sopa de Letras)");
            System.out.println("2. Ejercicio 9 (Matriz y Ordenamiento)");
            System.out.println("0. Salir");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    Ejercicio8.main(new String[0]);
                    break;
                case 2:
                    Ejercicio9.main(new String[0]);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
            System.out.println();
        } while (opcion != 0);
        sc.close();
    }
}
