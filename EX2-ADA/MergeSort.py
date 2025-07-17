import time

# Algoritmo Merge Sort (Recursivo)
def merge_sort(arr):
    if len(arr) <= 1:
        return arr  # Caso base: si la lista tiene 1 o menos elementos, está ordenada
    mid = len(arr) // 2  # Encuentra el punto medio
    left_half = arr[:mid]  # Divide la mitad izquierda
    right_half = arr[mid:]  # Divide la mitad derecha

    # Recursión: ordena la mitad izquierda y derecha
    left_half = merge_sort(left_half)
    right_half = merge_sort(right_half)

    # Fusiona las dos mitades ordenadas
    return merge(left_half, right_half)

# Función para fusionar dos listas ordenadas
def merge(left, right):
    result = []
    i = j = 0
    # Compara los elementos de left y right, y fusiona las listas
    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1
    # Si hay elementos restantes en left, se agregan al resultado
    result.extend(left[i:])
    # Si hay elementos restantes en right, se agregan al resultado
    result.extend(right[j:])
    return result

# Medir el tiempo de ejecución
def measure_time(func, arr):
    start_time = time.perf_counter_ns()
    func(arr)
    end_time = time.perf_counter_ns()
    return end_time - start_time

if __name__ == "__main__":
    # Leer los números del archivo
    archivo = 'numeros_aleatorios.txt'  # Asegúrate de que este archivo esté en el mismo directorio
    def leer_numeros_archivo(filename):
        with open(filename, 'r') as file:
            # Leer todas las líneas y convertirlas a una lista de enteros
            return [int(line.strip()) for line in file.readlines()]

    # Leer los números desde el archivo
    numeros = leer_numeros_archivo(archivo)

    # Solicitar al usuario el tamaño del arreglo
    size = int(input("Ingrese el tamaño del arreglo: "))

    # Verificar si hay suficientes números en el archivo
    if size <= len(numeros):
        data = numeros[:size]
    else:
        print(f"Advertencia: El archivo tiene solo {len(numeros)} números. Usando todos.")
        data = numeros

    # Mostrar el arreglo original
    print(f"Arreglo original: {data}")

    # Ordenar y medir el tiempo de ejecución
    data_ordenado = data.copy()  # Crear una copia del arreglo original para no modificar el original
    data_ordenado = merge_sort(data_ordenado)  # Aplicar Merge Sort

    # Medir el tiempo de ejecución
    merge_time = measure_time(merge_sort, data.copy())

    # Mostrar el arreglo ordenado
    print(f"Arreglo ordenado: {data_ordenado}")
    print(f"Tiempo de ejecución para Merge Sort: {merge_time} nanosegundos")
