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
    data_ordenado = data.copy()
    cocktail_time = measure_time(cocktail_shaker_sort, data_ordenado)
    
    # Mostrar el arreglo final
    print(f"Arreglo ordenado: {data_ordenado}")
    print(f"Tiempo de ejecución para Cocktail Shaker Sort: {cocktail_time} nanosegundos")
