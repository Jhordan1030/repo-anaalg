import Ejercicio1,Ejercicio2,Ejercicio3, Ejercicio7, Ejercicio8, Ejercicio9, Ejercicio10
def main():
    while True:
        print("\nBienvenido al programa de Trabajo 3")
        print("Menú de opciones:")
        print("1. Ejercicio 1")
        print("2. Ejercicio 2")
        print("3. Ejercicio 3")
        print("4. Ejercicio 4")
        print("5. Ejercicio 5")
        print("6. Ejercicio 6")
        print("7. Ejercicio 7")
        print("8. Ejercicio 8")
        print("9. Contar hojas (recursivo)")
        print("10. Camino a nodo (recursivo)")
        print("11. Salir")
        opcion = input("Seleccione una opción: ")

        if opcion == "1":
            Ejercicio1.main()  # Llamada al ejercicio 1
            pass
        elif opcion == "2":
            Ejercicio2.main()  # Llamada al ejercicio 2
            pass
        elif opcion == "3":
            Ejercicio3.main()  # Llamada al ejercicio 3
        elif opcion == "4":
            # Ejercicio 4
            pass
        elif opcion == "5":
            # Ejercicio 5
            pass
        elif opcion == "6":
            # Ejercicio 6
            pass
        elif opcion == "7":
            Ejercicio7.main()  # Llamada al ejercicio 7
        elif opcion == "8":
            Ejercicio8.main()  # Llamada al ejercicio 8
        elif opcion == "9":
            Ejercicio9.main()
        elif opcion == "10":
            Ejercicio10.main()
        elif opcion == "11":
            print("Saliendo del programa.")
            break
        else:
            print("Opción no válida. Intente de nuevo.")

if __name__ == "__main__":
    main()