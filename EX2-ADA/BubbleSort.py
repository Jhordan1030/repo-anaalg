import random
import time

# Algoritmo Bubble Sort
def bubble_sort(arr):
    n = len(arr)
    for i in range(n):
        for j in range(0, n - i - 1):
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
    return arr

# Medir el tiempo de ejecución
def measure_time(func, data):
    start_time = time.perf_counter_ns()
    if isinstance(data[0], list):  # Si es una matriz
        data_plana = [elem for row in data for elem in row]
        func(data_plana)
    else:  # Si es un arreglo
        func(data)
    end_time = time.perf_counter_ns()
    return end_time - end_time

# Convertir una lista plana en una matriz
def list_to_matrix(lst, rows, cols):
    matrix = []
    for i in range(rows):
        row = lst[i * cols:(i + 1) * cols]
        matrix.append(row)
    return matrix

def generar_numeros_aleatorios(cantidad):
    return [random.randint(1, 1000) for _ in range(cantidad)]

def main():
    print("Seleccione una opción:")
    print("1. Generar y ordenar una matriz")
    print("2. Generar y ordenar un arreglo")
    
    opcion = int(input("Ingrese su opción (1 o 2): "))
    
    if opcion == 1:
        # Opción para matriz
        filas = int(input("Ingrese el número de filas: "))
        columnas = int(input("Ingrese el número de columnas: "))
        total = filas * columnas
        
        # Generar matriz con números aleatorios
        numeros = generar_numeros_aleatorios(total)
        matriz = list_to_matrix(numeros, filas, columnas)
        
        print("\nMatriz original:")
        for fila in matriz:
            print(fila)
        
        # Ordenar la matriz
        start_time = time.perf_counter_ns()
        matriz_plana = [elem for row in matriz for elem in row]
        bubble_sort(matriz_plana)
        matriz_ordenada = list_to_matrix(matriz_plana, filas, columnas)
        end_time = time.perf_counter_ns()
        
        print("\nMatriz ordenada:")
        for fila in matriz_ordenada:
            print(fila)
        
        print(f"\nTiempo de ejecución: {end_time - start_time} nanosegundos")
    
    elif opcion == 2:
        # Opción para arreglo
        longitud = int(input("Ingrese la longitud del arreglo: "))
        
        # Generar arreglo con números aleatorios
        arreglo = generar_numeros_aleatorios(longitud)
        
        print("\nArreglo original:")
        print(arreglo)
        
        # Ordenar el arreglo
        start_time = time.perf_counter_ns()
        arreglo_ordenado = bubble_sort(arreglo.copy())
        end_time = time.perf_counter_ns()
        
        print("\nArreglo ordenado:")
        print(arreglo_ordenado)
        
        print(f"\nTiempo de ejecución: {end_time - start_time} nanosegundos")
    
    else:
        print("Opción no válida. Por favor ingrese 1 o 2.")

if __name__ == "__main__":
    main()