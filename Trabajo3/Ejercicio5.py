import random

def generar_matriz_aleatoria(filas, columnas, rango_min=1, rango_max=100):
    
    return [
        [random.randint(rango_min, rango_max) for _ in range(columnas)]
        for _ in range(filas)
    ]

def calcular_suma_filas_impares(matriz):
    """
    Calcula la suma de filas impares de forma secuencial (iterativa).
    """
    suma_total = 0
    print("\nDetalle de filas impares (secuencial):")
    for i in range(0, len(matriz), 2):
        numero_fila = i + 1
        fila_actual = matriz[i]
        suma_fila = sum(fila_actual)
        suma_total += suma_fila
        print(f"Fila {numero_fila}: {fila_actual} → Suma = {suma_fila}")
    return suma_total

def suma_filas_impares_recursiva(matriz, index=None, suma_total=0):
   
    if index is None:
        index = len(matriz) - 1

    if index < 0:
        return suma_total

    if index % 2 == 0:
        suma_fila = sum(matriz[index])
        print(f"Fila {index+1}: {matriz[index]} → Suma = {suma_fila}")
        suma_total += suma_fila

    return suma_filas_impares_recursiva(matriz, index - 1, suma_total)

def main():
    print("SUMA DE FILAS IMPARES DE MATRIZ ALEATORIA\n")
    

    while True:
        try:
            filas = int(input("Ingrese número de filas (mayor que 0): "))
            columnas = int(input("Ingrese número de columnas (mayor que 0): "))
            if filas > 0 and columnas > 0:
                break
            print("¡Error! Las dimensiones deben ser mayores que 0.")
        except ValueError:
            print("¡Error! Ingrese solo números enteros.")
    

    matriz = generar_matriz_aleatoria(filas, columnas)
    
    
    print("\nMatriz generada:")
    for i, fila in enumerate(matriz, 1):
        print(f" {fila}")
    
    
    print("\n--- MÉTODO SECUENCIAL ---")
    suma_secuencial = calcular_suma_filas_impares(matriz)
    print(f"\nSuma secuencial total: {suma_secuencial}")
    
    print("\n--- MÉTODO RECURSIVO (DECREMENTAL) ---")
    print("Detalle de filas impares (recursivo):")
    suma_recursiva = suma_filas_impares_recursiva(matriz)
    print(f"\nSuma recursiva total: {suma_recursiva}")

if __name__ == "__main__":
    main()
