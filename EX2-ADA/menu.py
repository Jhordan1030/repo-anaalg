import os
import subprocess # Necesitamos este módulo para ejecutar otros scripts

def ejecutar_algoritmo(nombre_script):
    """
    Ejecuta un script Python dado como un subproceso.
    """
    print(f"\n--- Ejecutando {nombre_script} ---")
    try:
        # Usa subprocess.run para ejecutar el script.
        # capture_output=False permite que la salida del script se muestre directamente en la consola.
        # text=True para manejar la entrada/salida como texto.
        # check=True para lanzar una excepción si el script sale con un código de error.
        # cwd=os.path.dirname(os.path.abspath(__file__)) asegura que el subproceso se ejecute
        # en el mismo directorio del script del menú, lo cual es útil si 'numeros_aleatorios.txt'
        # está en la misma carpeta.
        subprocess.run(['python', nombre_script], check=True, text=True, cwd=os.path.dirname(os.path.abspath(__file__)))
    except subprocess.CalledProcessError as e:
        print(f"Error al ejecutar {nombre_script}: El script terminó con un error: {e}")
    except FileNotFoundError:
        print(f"Error: No se encontró el intérprete de Python o el script '{nombre_script}'.")
        print("Asegúrate de que 'python' esté en tu PATH y que los archivos .py estén en el mismo directorio que 'menu.py'.")
    print(f"--- Finalizado {nombre_script} ---\n")

def mostrar_menu():
    """
    Muestra las opciones del menú al usuario.
    """
    print("\n--- Menú de Algoritmos de Ordenamiento ---")
    print("1. Bubble Sort (BubbleSort.py)")
    print("2. Cocktail Shaker Sort (CocktailShakerSort.py)")
    print("3. Merge Sort (MergeSort.py)")
    print("4. Parallel Merge Sort (ParallelMergeSort.py)")
    print("5. Quick Sort (QuickSort.py)")
    print("0. Salir")
    print("------------------------------------------")

def main():
    while True:
        mostrar_menu()
        eleccion = input("Ingrese su elección (0-5): ")

        if eleccion == '1':
            ejecutar_algoritmo("BubbleSort.py")
        elif eleccion == '2':
            ejecutar_algoritmo("CocktailShakerSort.py")
        elif eleccion == '3':
            ejecutar_algoritmo("MergeSort.py")
        elif eleccion == '4':
            ejecutar_algoritmo("ParallelMergeSort.py")
        elif eleccion == '5':
            ejecutar_algoritmo("QuickSort.py")
        elif eleccion == '0':
            print("Saliendo del programa. ¡Hasta luego!")
            break
        else:
            print("Opción inválida. Por favor, ingrese un número entre 0 y 5.")

        # Pausar para que el usuario vea la salida antes de que reaparezca el menú
        input("\nPresione Enter para continuar...")
        # Limpia la consola. 'cls' para Windows, 'clear' para Unix/macOS
        os.system('cls' if os.name == 'nt' else 'clear')

if __name__ == "__main__":
    main()
    