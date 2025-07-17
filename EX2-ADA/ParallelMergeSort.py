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

def measure_time(func, arr):
    start_time = time.perf_counter_ns()
    result = func(arr)
    end_time = time.perf_counter_ns()
    return result, end_time - start_time

if __name__ == "__main__":
    archivo = 'numeros_aleatorios.txt'
    def leer_numeros_archivo(filename):
        with open(filename, 'r') as file:
            return [int(line.strip()) for line in file.readlines()]

    numeros = leer_numeros_archivo(archivo)
    size = int(input("Ingrese el tamaño del arreglo: "))
    if size <= len(numeros):
        data = numeros[:size]
    else:
        print(f"Advertencia: El archivo tiene solo {len(numeros)} números. Usando todos.")
        data = numeros

    print(f"Arreglo original: {data}")
    data_ordenado, parallel_time = measure_time(merge_sort_parallel, data.copy())
    print(f"Arreglo ordenado: {data_ordenado}")
    print(f"Tiempo de ejecución para Parallel Merge Sort: {parallel_time} nanosegundos") 