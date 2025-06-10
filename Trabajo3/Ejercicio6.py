def generar_matriz_zigzag_secuencial(n):

    matriz = [[0] * n for _ in range(n)]
    valor = 1
   
    for s in range(2 * (n - 1), -1, -1):
        coords = [(i, s - i) for i in range(n) if 0 <= s - i < n]
        if s % 2 == 0:
            coords.sort(key=lambda x: -x[0])
        else:
            coords.sort(key=lambda x: x[0])
        for i, j in coords:
            matriz[i][j] = valor
            valor += 1
    return matriz

def _llenar_zigzag_recursivo(matriz, n, s, valor):
   
    if s < 0:
        return valor
    coords = [(i, s - i) for i in range(n) if 0 <= s - i < n]
    if s % 2 == 0:
        coords.sort(key=lambda x: -x[0])
    else:
        coords.sort(key=lambda x: x[0])
    for i, j in coords:
        matriz[i][j] = valor
        valor += 1
    return _llenar_zigzag_recursivo(matriz, n, s - 1, valor)

def generar_matriz_zigzag_recursiva(n):
    
    matriz = [[0] * n for _ in range(n)]
    _llenar_zigzag_recursivo(matriz, n, 2 * (n - 1), 1)
    return matriz

def imprimir_matriz(matriz):
    
    for idx, fila in enumerate(matriz, 1):
        print(f"Fila {idx}: {fila}")

def main():
    print("GENERADOR DE MATRIZ N×N (llenado zigzag diagonal)\n")
    # Lectura de n
    while True:
        try:
            n = int(input("Ingrese el tamaño n de la matriz (n > 0): "))
            if n > 0:
                break
            print("¡Error! n debe ser mayor que 0.")
        except ValueError:
            print("¡Error! Ingrese un número entero.")

    # Algoritmo secuencial
    print("\n--- IMPRESIÓN CON ALGORITMO SECUENCIAL ---")
    matriz_seq = generar_matriz_zigzag_secuencial(n)
    imprimir_matriz(matriz_seq)

    # Algoritmo recursivo
    print("\n--- IMPRESIÓN CON ALGORITMO RECURSIVO ---")
    matriz_rec = generar_matriz_zigzag_recursiva(n)
    imprimir_matriz(matriz_rec)

if __name__ == "__main__":
    main()
