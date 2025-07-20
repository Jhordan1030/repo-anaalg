import time
from concurrent.futures import ThreadPoolExecutor

# Algoritmo Merge Sort paralelo
def merge_sort_parallel(arr):
    if len(arr) <= 1:
        return arr
    mid = len(arr) // 2
    left = arr[:mid]
    right = arr[mid:]
    
    # Ordenar las mitades en paralelo
    with ThreadPoolExecutor(max_workers=2) as executor:
        left_future = executor.submit(merge_sort_parallel, left)
        right_future = executor.submit(merge_sort_parallel, right)
        left_sorted = left_future.result()
        right_sorted = right_future.result()
    
    return merge(left_sorted, right_sorted)

def merge(left, right):
    result = []
    i = j = 0
    while i < len(left) and j < len(right):
        if left[i] <= right[j]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1
    result.extend(left[i:])
    result.extend(right[j:])
    return result

# Convertir lista a matriz
def list_to_matrix(lst, rows, cols):
    return [lst[i * cols:(i + 1) * cols] for i in range(rows)]

# Leer números desde el archivo
def leer_numeros_archivo(filename):
    with open(filename, 'r') as file:
        # Leer todas las líneas y convertirlas a una lista de enteros
        return [int(line.strip()) for line in file.readlines()]

def main():
    print("Seleccione una opción:")
    print("1. Generar y ordenar una matriz (Merge Sort Paralelo)")
    print("2. Generar y ordenar un arreglo (Merge Sort Paralelo)")
    
    while True:
        try:
            opcion = int(input("Ingrese su opción (1 o 2): "))
            if opcion in [1, 2]:
                break
            print("Por favor ingrese 1 o 2.")
        except ValueError:
            print("Entrada inválida. Ingrese un número.")
    
    if opcion == 1:
        # Opción para matriz
        while True:
            try:
                filas = int(input("Ingrese número de filas: "))
                columnas = int(input("Ingrese número de columnas: "))
                if filas > 0 and columnas > 0:
                    break
                print("Las dimensiones deben ser positivas.")
            except ValueError:
                print("Ingrese números enteros válidos.")
        
        total = filas * columnas
        
        # Leer los números desde el archivo
        numeros = leer_numeros_archivo('numeros_aleatorios.txt')
        
        # Verificar si hay suficientes números en el archivo
        if total <= len(numeros):
            matriz = list_to_matrix(numeros[:total], filas, columnas)
        else:
            print(f"Advertencia: El archivo tiene solo {len(numeros)} números. Usando todos.")
            matriz = list_to_matrix(numeros, filas, columnas)
        
        print("\nMatriz original:")
        for fila in matriz:
            print(fila)
        
        # Medir tiempo y ordenar
        start_time = time.perf_counter_ns()
        matriz_plana = [num for fila in matriz for num in fila]
        matriz_ordenada_plana = merge_sort_parallel(matriz_plana)
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
                longitud = int(input("Ingrese longitud del arreglo: "))
                if longitud > 0:
                    break
                print("La longitud debe ser positiva.")
            except ValueError:
                print("Ingrese un número entero válido.")
        
        # Leer los números desde el archivo
        numeros = leer_numeros_archivo('numeros_aleatorios.txt')
        
        # Verificar si hay suficientes números en el archivo
        if longitud <= len(numeros):
            arreglo = numeros[:longitud]
        else:
            print(f"Advertencia: El archivo tiene solo {len(numeros)} números. Usando todos.")
            arreglo = numeros
        
        print("\nArreglo original:")
        print(arreglo)
        
        # Medir tiempo y ordenar
        start_time = time.perf_counter_ns()
        arreglo_ordenado = merge_sort_parallel(arreglo.copy())
        end_time = time.perf_counter_ns()
        
        print("\nArreglo ordenado:")
        print(arreglo_ordenado)
        
        print(f"\nTiempo de ejecución: {end_time - start_time} nanosegundos")

if __name__ == "__main__":
    main()
