import time

# Algoritmo Cocktail Shaker Sort
def cocktail_shaker_sort(arr):
    n = len(arr)
    swapped = True
    start = 0
    end = n - 1
    while swapped:
        swapped = False
        # Recorrer de izquierda a derecha
        for i in range(start, end):
            if arr[i] > arr[i+1]:
                arr[i], arr[i+1] = arr[i+1], arr[i]
                swapped = True
        if not swapped:
            break
        swapped = False
        end -= 1
        # Recorrer de derecha a izquierda
        for i in range(end-1, start-1, -1):
            if arr[i] > arr[i+1]:
                arr[i], arr[i+1] = arr[i+1], arr[i]
                swapped = True
        start += 1
    return arr

# Convertir lista a matriz
def list_to_matrix(lst, rows, cols):
    matrix = []
    for i in range(rows):
        row = lst[i * cols:(i + 1) * cols]
        matrix.append(row)
    return matrix

# Leer números del archivo
def leer_numeros_archivo(filename):
    with open(filename, 'r') as file:
        # Leer todas las líneas y convertirlas a una lista de enteros
        return [int(line.strip()) for line in file.readlines()]

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
        matriz_plana = [elem for row in matriz for elem in row]
        cocktail_shaker_sort(matriz_plana)
        matriz_ordenada = list_to_matrix(matriz_plana, filas, columnas)
        end_time = time.perf_counter_ns()
        
        print("\nMatriz ordenada:")
        for fila in matriz_ordenada:
            print(fila)
        
        print(f"\nTiempo de ejecución: {end_time - start_time} nanosegundos")
    
    elif opcion == 2:
        # Opción para arreglo
        longitud = int(input("Ingrese la longitud del arreglo: "))
        
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
        arreglo_ordenado = arreglo.copy()
        cocktail_shaker_sort(arreglo_ordenado)
        end_time = time.perf_counter_ns()
        
        print("\nArreglo ordenado:")
        print(arreglo_ordenado)
        
        print(f"\nTiempo de ejecución: {end_time - start_time} nanosegundos")
    
    else:
        print("Opción no válida. Por favor ingrese 1 o 2.")

if __name__ == "__main__":
    main()
