import random
import time

# Algoritmo Quick Sort (Recursivo)
def ordenamiento_quick(arreglo):
    if len(arreglo) <= 1:
        return arreglo
    pivote = arreglo[len(arreglo) // 2]  # Seleccionamos el pivote como el elemento del medio
    izquierda = [x for x in arreglo if x < pivote]  # Elementos menores que el pivote
    medio = [x for x in arreglo if x == pivote]  # Elementos iguales al pivote
    derecha = [x for x in arreglo if x > pivote]  # Elementos mayores que el pivote
    return ordenamiento_quick(izquierda) + medio + ordenamiento_quick(derecha)  # Recursión para las sublistas

# Convertir lista a matriz
def convertir_lista_a_matriz(lista_plana, filas, columnas):
    return [lista_plana[i * columnas:(i + 1) * columnas] for i in range(filas)]

# Generar números aleatorios
def generar_numeros_aleatorios(cantidad):
    return [random.randint(1, 1000) for _ in range(cantidad)]

def main():
    print("Seleccione una opción:")
    print("1. Generar y ordenar una matriz")
    print("2. Generar y ordenar un arreglo")
    
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
                num_filas = int(input("Ingrese el número de filas: "))
                num_columnas = int(input("Ingrese el número de columnas: "))
                if num_filas > 0 and num_columnas > 0:
                    break
                print("Las dimensiones deben ser positivas.")
            except ValueError:
                print("Ingrese números enteros válidos.")
        
        total_elementos = num_filas * num_columnas
        
        # Generar números aleatorios
        numeros_aleatorios = generar_numeros_aleatorios(total_elementos)
        matriz = convertir_lista_a_matriz(numeros_aleatorios, num_filas, num_columnas)
        
        print("\nMatriz original:")
        for fila in matriz:
            print(fila)
        
        # Medir tiempo y ordenar
        tiempo_inicio = time.perf_counter_ns()
        matriz_plana = [elemento for fila in matriz for elemento in fila]
        matriz_ordenada_plana = ordenamiento_quick(matriz_plana)
        matriz_ordenada = convertir_lista_a_matriz(matriz_ordenada_plana, num_filas, num_columnas)
        tiempo_fin = time.perf_counter_ns()
        
        print("\nMatriz ordenada:")
        for fila in matriz_ordenada:
            print(fila)
        
        print(f"\nTiempo de ejecución: {tiempo_fin - tiempo_inicio} nanosegundos")
    
    elif opcion == 2:
        # Opción para arreglo
        while True:
            try:
                longitud_arreglo = int(input("Ingrese longitud del arreglo: "))
                if longitud_arreglo > 0:
                    break
                print("La longitud debe ser positiva.")
            except ValueError:
                print("Ingrese un número entero válido.")
        
        # Generar arreglo con números aleatorios
        arreglo_aleatorio = generar_numeros_aleatorios(longitud_arreglo)
        
        print("\nArreglo original:")
        print(arreglo_aleatorio)
        
        # Medir tiempo y ordenar
        tiempo_inicio = time.perf_counter_ns()
        arreglo_ordenado = ordenamiento_quick(arreglo_aleatorio.copy())
        tiempo_fin = time.perf_counter_ns()
        
        print("\nArreglo ordenado:")
        print(arreglo_ordenado)
        
        print(f"\nTiempo de ejecución: {tiempo_fin - tiempo_inicio} nanosegundos")

if __name__ == "__main__":
    main()
