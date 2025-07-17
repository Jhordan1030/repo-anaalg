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

    numeros = leer_numeros_archivo(archivo)

    # Solicitar al usuario el tamaño del arreglo con manejo de errores
    while True:
        try:
            size = int(input("Ingrese el tamaño del arreglo: "))
            break
        except ValueError:
            print("Por favor, ingrese un número entero válido.")

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
    data_ordenado = quick_sort(data_ordenado)  # Aplicar Quick Sort

    # Medir el tiempo de ejecución
    quick_time = measure_time(quick_sort, data.copy())

    # Mostrar el arreglo ordenado
    print(f"Arreglo ordenado: {data_ordenado}")
    print(f"Tiempo de ejecución para Quick Sort: {quick_time} nanosegundos")
