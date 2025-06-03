from Matriz import Matriz #1

#11+9n²+12n+12+3n²+3n+27n³+63n²+90n+90 = 27n³+75n²+105n+113
# Pedir al usuario las dimensiones de las tres matrices 6
print("Ingrese las dimensiones de la primera matriz:")
filas1 = int(input("Filas: "))
columnas1 = int(input("Columnas: "))

print("\nIngrese las dimensiones de la segunda matriz:")
filas2 = int(input("Filas: "))
columnas2 = int(input("Columnas: "))

print("\nIngrese las dimensiones de la tercera matriz:")
filas3 = int(input("Filas: "))
columnas3 = int(input("Columnas: "))

# Crear las tres matrices 3
matriz1 = Matriz(filas=filas1, columnas=columnas1)
matriz2 = Matriz(filas=filas2, columnas=columnas2)
matriz3 = Matriz(filas=filas3, columnas=columnas3)

# Llenar las matrices con números aleatorios 3(3n²+4n+4) = 9n²+12n+12
matriz1.llenar_aleatorio(min=1, max=100)
matriz2.llenar_aleatorio(min=1, max=100)
matriz3.llenar_aleatorio(min=1, max=100)

# Imprimir las matrices 3(n²+1) = 3n²+3n
print("\nPrimera matriz:")
print(matriz1)

print("\nSegunda matriz:")
print(matriz2)

print("\nTercera matriz:")
print(matriz3)

# Verificar la propiedad distributiva para cada matriz como B 1
print("\nVerificando la propiedad distributiva B(A + C) = BA + BC:")

# Primera matriz como B
resultado1 = matriz1.verificar_distributiva(matriz2, matriz3) #9n³+21n²+30n+30
print(f"Primera matriz como B: {'Verdadero' if resultado1 else 'Falso'}")

# Segunda matriz como B
resultado2 = matriz2.verificar_distributiva(matriz1, matriz3) #9n³+21n²+30n+30
print(f"Segunda matriz como B: {'Verdadero' if resultado2 else 'Falso'}")

# Tercera matriz como B
resultado3 = matriz3.verificar_distributiva(matriz1, matriz2) #9n³+21n²+30n+30
print(f"Tercera matriz como B: {'Verdadero' if resultado3 else 'Falso'}")
#3(9n³+21n²+30n+30) = 27n³+63n²+90n+90