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
def es_simetrica_recursiva(matriz, n=None):
    # Inicialización: la primera vez, n = tamaño de la matriz
    if n is None:
        n = len(matriz)
    # Caso base: si la submatriz es de tamaño 0 ó 1, siempre es simétrica
    if n <= 1:
        return True

    # 1) Comprobamos la última fila vs la última columna (índice n-1)
    for i in range(n):
        if matriz[n-1][i] != matriz[i][n-1]:
            return False

    # 2) Reducimos el problema: ahora verificamos la submatriz (n-1)x(n-1)
    return es_simetrica_recursiva(matriz, n-1)

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
