import time

# Algoritmo Bubble Sort con impresiones
def bubble_sort(arr):
    n = len(arr)
    for i in range(n):
        for j in range(0, n-i-1):
            # Compara los elementos adyacentes
            if arr[j] > arr[j+1]:
                arr[j], arr[j+1] = arr[j+1], arr[j]  # Intercambia si están en el orden incorrecto
    return arr

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
    bubble_time = measure_time(bubble_sort, data_ordenado)

    # Mostrar el arreglo ordenado
    print(f"Arreglo ordenado: {data_ordenado}")
    print(f"Tiempo de ejecución para Bubble Sort: {bubble_time} nanosegundos")
