from Matriz import Matriz #1

#11+9n²+12n+12+3n²+3n+27n³+63n²+90n+90 = 27n³+75n²+105n+113
# Pedir al usuario las dimensiones de las tres matrices 6
print("Ingrese las dimensiones de la matriz:")
filas1 = int(input("Filas: "))
columnas1 = int(input("Columnas: "))

# Crear las tres matrices 3
matriz1 = Matriz(filas=filas1, columnas=columnas1)
matriz1.llenar_aleatorio(min=1, max=100)
matriz2 = matriz1.transpuesta()
matriz3 = matriz1.multiplicacion_recursiva(matriz2)
# Llenar las matrices con números aleatorios 3(3n²+4n+4) = 9n²+12n+12

# Imprimir las matrices 3(n²+1) = 3n²+3n
print("\nMatriz:")
print(matriz1)

print("\nMatriz Traspuesta:")
print(matriz2)

print("\nMatriz Multiplicada Recursivamente:")
print(matriz3)