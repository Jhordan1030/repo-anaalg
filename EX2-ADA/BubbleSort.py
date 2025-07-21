import random
import time

# Algoritmo Bubble Sort
def bubble_sort(arr):
    num_elements = len(arr)  # Número de elementos en el arreglo
    for pass_num in range(num_elements):  # Para cada paso del algoritmo
        for current_index in range(0, num_elements - pass_num - 1):  # Iteración sobre el arreglo
            if arr[current_index] > arr[current_index + 1]:
                arr[current_index], arr[current_index + 1] = arr[current_index + 1], arr[current_index]
    return arr

# Medir el tiempo de ejecución
def measure_time(func, data):
    start_time = time.perf_counter_ns()
    if isinstance(data[0], list):  # Si es una matriz
        flattened_data = [element for row in data for element in row]
        func(flattened_data)
    else:  # Si es un arreglo
        func(data)
    end_time = time.perf_counter_ns()
    return end_time - start_time  # Tiempo en nanosegundos

# Convertir una lista plana en una matriz
def list_to_matrix(flat_list, rows, columns):
    matrix = []
    for row_index in range(rows):
        row = flat_list[row_index * columns:(row_index + 1) * columns]
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
            option = int(input("Ingrese su opción (1 o 2): "))
            if option in [1, 2]:
                break
            print("Por favor ingrese 1 o 2.")
        except ValueError:
            print("Entrada inválida. Ingrese un número.")
    
    if option == 1:
        # Opción para matriz
        while True:
            try:
                num_rows = int(input("Ingrese número de filas: "))
                num_columns = int(input("Ingrese número de columnas: "))
                if num_rows > 0 and num_columns > 0:
                    break
                print("Las dimensiones deben ser positivas.")
            except ValueError:
                print("Ingrese números enteros válidos.")
        
        total_elements = num_rows * num_columns
        
        # Generar matriz con números aleatorios
        numbers = generate_random_numbers(total_elements)
        matrix = list_to_matrix(numbers, num_rows, num_columns)
        
        print("\nMatriz original:")
        for row in matrix:
            print(row)
        
        # Medir tiempo y ordenar
        start_time = time.perf_counter_ns()
        flattened_matrix = [element for row in matrix for element in row]
        sorted_flattened_matrix = bubble_sort(flattened_matrix)
        sorted_matrix = list_to_matrix(sorted_flattened_matrix, num_rows, num_columns)
        end_time = time.perf_counter_ns()
        
        print("\nMatriz ordenada:")
        for row in sorted_matrix:
            print(row)
        
        print(f"\nTiempo de ejecución: {(end_time - start_time)} nanosegundos")
    
    elif option == 2:
        # Opción para arreglo
        while True:
            try:
                array_length = int(input("Ingrese longitud del arreglo: "))
                if array_length > 0:
                    break
                print("La longitud debe ser positiva.")
            except ValueError:
                print("Ingrese un número entero válido.")
        
        # Generar arreglo con números aleatorios
        array = generate_random_numbers(array_length)
        
        print("\nArreglo original:")
        print(array)
        
        # Medir tiempo y ordenar
        start_time = time.perf_counter_ns()
        sorted_array = bubble_sort(array.copy())
        end_time = time.perf_counter_ns()
        
        print("\nArreglo ordenado:")
        print(sorted_array)
        
        print(f"\nTiempo de ejecución: {(end_time - start_time)} nanosegundos")

if __name__ == "__main__":
    main()
