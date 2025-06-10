import random

# Método Secuencial para verificar si una matriz es simétrica
def es_simetrica_secuencial(matriz):
    # Obtener el tamaño de la matriz (suponemos que es cuadrada)
    n = len(matriz)

    # Recorremos la matriz de forma secuencial
    for i in range(n):
        for j in range(n):
            if matriz[i][j] != matriz[j][i]:  # Si no es igual a la transpuesta
                return False
    return True  # Si todo es igual, es simétrica


# Método Recursivo para verificar si una matriz es simétrica
def es_simetrica_recursiva(matriz, n=None, i=0, j=0):
    # Obtener el tamaño de la matriz (suponemos que es cuadrada)
    if n is None:
        n = len(matriz)

    # Si hemos recorrido toda la matriz
    if i == n:
        return True

    # Si hemos llegado al final de la fila, avanzamos a la siguiente fila
    if j == n:
        return es_simetrica_recursiva(matriz, n - 1, i + 1, i + 1)  # Reducimos n

    # Verificamos si la matriz[i][j] es igual a la matriz[j][i]
    if matriz[i][j] != matriz[j][i]:
        return False

    # Llamada recursiva para la siguiente posición
    return es_simetrica_recursiva(matriz, n - 1, i, j + 1)  # Reducimos n


# Función para generar una matriz con números aleatorios entre 1 y 100
def generar_matriz_aleatoria(tamaño):
    return [[random.randint(1, 100) for _ in range(tamaño)] for _ in range(tamaño)]


def main():
    # Solicitar al usuario el tamaño de la matriz
    tamaño = int(input("Introduce el tamaño de la matriz (por ejemplo, 3 para una matriz 3x3): "))

    # Generar una matriz aleatoria
    matriz = generar_matriz_aleatoria(tamaño)

    # Mostrar la matriz generada
    print("\nMatriz generada:")
    for fila in matriz:
        print(fila)

    # Verificar si la matriz es simétrica usando el método secuencial
    print("\nMétodo Secuencial para la Matriz:")
    print(es_simetrica_secuencial(matriz))  # Devuelve True o False

    # Verificar si la matriz es simétrica usando el método recursivo
    print("\nMétodo Recursivo para la Matriz:")
    print(es_simetrica_recursiva(matriz))  # Devuelve True o False


if __name__ == "__main__":
    main()
