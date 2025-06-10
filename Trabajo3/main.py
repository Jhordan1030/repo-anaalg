import Ejercicio1, Ejercicio2, Ejercicio3, Ejercicio4, Ejercicio5, Ejercicio6, Ejercicio7, Ejercicio8, Ejercicio9, Ejercicio10
def main():
    while True:
        print("\nBienvenido al programa de Trabajo 3")
        print("Menú de opciones:")
        print("1. Sumar los elementos de un arreglo de n datos.")
        print("2. Obtener el número mayor de los elementos de un arreglo de n datos.")
        print("3. Sumar los dígitos múltiplos de un número de cada elemento del arreglo A, guardar la suma en un arreglo B.")
        print("4. Verificar si una matriz es simétrica o no.")
        print("5. Calcular la suma de los elementos de las filas impares de una matriz.")
        print("6. Generar una matriz de orden nxn")
        print("7. Generar una matriz de orden nxm")
        print("8. Recorrer en profundidad (preorden, inorden, o postorden) en un árbol binario.")
        print("9. Contar hojas en un árbol binario.")
        print("10. Camino a nodo específico en un árbol binario.")
        print("11. Salir")
        opcion = input("Seleccione una opción: ")

        if opcion == "1":
            Ejercicio1.main()  # Llamada al ejercicio 1
        elif opcion == "2":
            Ejercicio2.main()  # Llamada al ejercicio 2
        elif opcion == "3":
            Ejercicio3.main()  # Llamada al ejercicio 3
        elif opcion == "4":
            Ejercicio4.main()  # Llamada al ejercicio 4
        elif opcion == "5":
            Ejercicio5.main()  # Llamada al ejercicio 5
        elif opcion == "6":
            Ejercicio6.main()  # Llamada al ejercicio 6
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