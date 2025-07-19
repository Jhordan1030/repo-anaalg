import random
import time

# Algoritmo Quick Sort (Recursivo)
def quick_sort(arr):
    if len(arr) <= 1:
        return arr
    pivot = arr[len(arr) // 2]  # Seleccionamos el pivote como el elemento del medio
    left = [x for x in arr if x < pivot]  # Elementos menores que el pivote
    middle = [x for x in arr if x == pivot]  # Elementos iguales al pivote
    right = [x for x in arr if x > pivot]  # Elementos mayores que el pivote
    return quick_sort(left) + middle + quick_sort(right)  # Recursión para las sublistas

# Convertir lista a matriz
def list_to_matrix(lst, rows, cols):
    matrix = []
    for i in range(rows):
        row = lst[i * cols:(i + 1) * cols]
        matrix.append(row)
    return matrix

# Generar números aleatorios
def generate_random_numbers(count):
    return [random.randint(1, 1000) for _ in range(count)]

def main():
    print("Seleccione una opción:")
    print("1. Generar y ordenar una matriz")
    print("2. Generar y ordenar un arreglo")
    
    while True:
        try:
            opcion = int(input("Ingrese su opción (1 o 2): "))
            if opcion in [1, 2]:
                break
            else:
                print("Por favor ingrese 1 o 2.")
        except ValueError:
            print("Por favor ingrese un número válido.")
    
    if opcion == 1:
        # Opción para matriz
        while True:
            try:
                filas = int(input("Ingrese el número de filas: "))
                columnas = int(input("Ingrese el número de columnas: "))
                if filas > 0 and columnas > 0:
                    break
                else:
                    print("Las dimensiones deben ser números positivos.")
            except ValueError:
                print("Por favor ingrese números enteros válidos.")
        
        total = filas * columnas
        
        # Generar matriz con números aleatorios
        numeros = generate_random_numbers(total)
        matriz = list_to_matrix(numeros, filas, columnas)
        
        print("\nMatriz original:")
        for fila in matriz:
            print(fila)
        
        # Medir tiempo y ordenar
        start_time = time.perf_counter_ns()
        matriz_plana = [elem for row in matriz for elem in row]
        matriz_ordenada_plana = quick_sort(matriz_plana)
        matriz_ordenada = list_to_matrix(matriz_ordenada_plana, filas, columnas)
        end_time = time.perf_counter_ns()
        
        print("\nMatriz ordenada:")
        for fila in matriz_ordenada:
            print(fila)
        
        print(f"\nTiempo de ejecución: {end_time - start_time} nanosegundos")
    
    elif opcion == 2:
        # Opción para arreglo
        while True:
            try:
                longitud = int(input("Ingrese la longitud del arreglo: "))
                if longitud > 0:
                    break
                else:
                    print("La longitud debe ser un número positivo.")
            except ValueError:
                print("Por favor ingrese un número entero válido.")
        
        # Generar arreglo con números aleatorios
        arreglo = generate_random_numbers(longitud)
        
        print("\nArreglo original:")
        print(arreglo)
        
        # Medir tiempo y ordenar
        start_time = time.perf_counter_ns()
        arreglo_ordenado = quick_sort(arreglo.copy())
        end_time = time.perf_counter_ns()
        
        print("\nArreglo ordenado:")
        print(arreglo_ordenado)
        
        print(f"\nTiempo de ejecución: {end_time - start_time} nanosegundos")

if __name__ == "__main__":
    main()