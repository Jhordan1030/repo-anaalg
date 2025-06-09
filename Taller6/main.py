from Matriz import Matriz

def main():
    # Crear una matriz de 3x3
    fil = int(input("Ingrese el número de filas: "))
    col = int(input("Ingrese el número de columnas: "))
    matriz = Matriz(filas=fil, columnas=col)
    
    # Llenar la matriz con números aleatorios entre 1 y 100
    matriz.llenar_espiral_fibonacci()
    
    # Imprimir la matriz
    print("Matriz original:")
    print(matriz)
    
    # Sumar las filas y columnas
    print("Suma de las filas:")
    fila = int(input("Ingrese el número de fila a sumar: "))
    suma_filas = matriz.sumar_filas_recursivo()
    #mapear la suma de las filas
    if 1 <= fila <= len(suma_filas):
        print(f"Suma de la fila {fila}: {suma_filas[fila - 1]}")
    else:
        print("Número de fila fuera de rango.")
main()