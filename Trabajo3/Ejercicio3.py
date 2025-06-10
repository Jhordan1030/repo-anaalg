import random

# Método Secuencial para sumar los dígitos múltiplos de un número
def suma_digitos_multiplo_secuencial(numero, n):
    suma = 0
    for digito in str(numero):
        if int(digito) % n == 0:
            suma += int(digito)
    return suma

# Función para procesar el arreglo A usando el método Secuencial
def procesar_arreglo_secuencial(A, n):
    B = []
    for num in A:
        B.append(suma_digitos_multiplo_secuencial(num, n))  # Sumamos los múltiplos de n para cada número
    return B

# Método Recursivo para sumar los dígitos múltiplos de un número cumpliendo la condición T(n-1)
def suma_digitos_multiplo_recursivo(numero, n, indice=0, suma=0):
    digitos = str(numero)

    # Condición de salida: si hemos procesado todos los dígitos o si n llega a 0
    if indice == len(digitos) or n == 0:
        return suma

    digito = int(digitos[indice])
    if digito % n == 0:
        suma += digito

    # Llamada recursiva con índice incrementado y n decrementado
    return suma_digitos_multiplo_recursivo(numero, n - 1, indice + 1, suma)

# Función para procesar el arreglo A usando recursión con la condición T(n-1)
def procesar_arreglo_recursivo(A, n, indice=0, B=None):
    if B is None:
        B = []

    # Condición de salida para la recursión
    if indice == len(A):
        return B

    # Llamar a la función recursiva para calcular la suma de los dígitos múltiplos
    suma = suma_digitos_multiplo_recursivo(A[indice], n)

    # Agregar el resultado al arreglo B
    B.append(suma)

    # Llamada recursiva al siguiente número en el arreglo
    return procesar_arreglo_recursivo(A, n, indice + 1, B)

# Función para generar arreglo aleatorio entre 1 y 100
def generar_arreglo_aleatorio(tamaño):
    return [random.randint(1, 100) for _ in range(tamaño)]

def main():
    # Solicitar al usuario el tamaño del arreglo y el número n para buscar múltiplos de sus dígitos
    tamaño_arreglo = int(input("Introduce el tamaño del arreglo: "))

    # Generar el arreglo aleatorio con números entre 1 y 100
    A = generar_arreglo_aleatorio(tamaño_arreglo)

    # Imprimir el arreglo A primero
    print("\nArreglo A:", A)
    n = int(input("Introduce el número para buscar múltiplos de sus dígitos: "))

    # Llamada recursiva para procesar el arreglo
    B_recursivo = procesar_arreglo_recursivo(A, n)

    # Llamada secuencial para procesar el arreglo
    B_secuencial = procesar_arreglo_secuencial(A, n)

    # Imprimir los resultados en el orden solicitado
    print("\nNúmero para múltiplos de los dígitos:", n)
    print("Arreglo B (Secuencial):", B_secuencial)
    print("Arreglo B (Recursivo):", B_recursivo)

if __name__ == "__main__":
    main()

