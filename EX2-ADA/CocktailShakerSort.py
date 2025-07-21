import random
import time

# Algoritmo Cocktail Shaker Sort
def cocktail_shaker_sort(arreglo):
    num_elementos = len(arreglo)  # Número de elementos en el arreglo
    intercambiado = True
    indice_inicio = 0
    indice_final = num_elementos - 1
    while intercambiado:
        intercambiado = False
        # Recorrer de izquierda a derecha
        for indice_actual in range(indice_inicio, indice_final):
            if arreglo[indice_actual] > arreglo[indice_actual + 1]:
                arreglo[indice_actual], arreglo[indice_actual + 1] = arreglo[indice_actual + 1], arreglo[indice_actual]
                intercambiado = True
        if not intercambiado:
            break
        intercambiado = False
        indice_final -= 1
        # Recorrer de derecha a izquierda
        for indice_actual in range(indice_final - 1, indice_inicio - 1, -1):
            if arreglo[indice_actual] > arreglo[indice_actual + 1]:
                arreglo[indice_actual], arreglo[indice_actual + 1] = arreglo[indice_actual + 1], arreglo[indice_actual]
                intercambiado = True
        indice_inicio += 1
    return arreglo

# Convertir lista plana a matriz
def convertir_lista_a_matriz(lista_plana, num_filas, num_columnas):
    matriz = []
    for indice_fila in range(num_filas):
        fila = lista_plana[indice_fila * num_columnas:(indice_fila + 1) * num_columnas]
        matriz.append(fila)
    return matriz

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
                num_filas = int(input("Ingrese número de filas: "))
                num_columnas = int(input("Ingrese número de columnas: "))
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
        matriz_ordenada_plana = cocktail_shaker_sort(matriz_plana)
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
        arreglo_ordenado = cocktail_shaker_sort(arreglo_aleatorio.copy())
        tiempo_fin = time.perf_counter_ns()
        
        print("\nArreglo ordenado:")
        print(arreglo_ordenado)
        
        print(f"\nTiempo de ejecución: {tiempo_fin - tiempo_inicio} nanosegundos")

if __name__ == "__main__":
    main()
