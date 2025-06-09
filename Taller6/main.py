from Matriz import Matriz

def main():
    # Crear una matriz de 3x3
    matriz = Matriz(filas=3, columnas=3)
    
    # Llenar la matriz con números aleatorios entre 1 y 100
    matriz.llenar_espiral_fibonacci()
    
    # Imprimir la matriz
    print("Matriz original:")
    print(matriz)
    
    # Sumar las filas y columnas
    suma_filas = matriz.sumar_filas()
    suma_columnas = matriz.sumar_columnas()
    
    print("\nSuma de las filas:", suma_filas)
    print("Suma de las columnas:", suma_columnas)
main()