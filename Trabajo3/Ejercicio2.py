import random

# Metod secuencial para encontrar el número mayor
def maximo_secuencial(arreglo): #1
    maximo = arreglo[0] #1
    for elemento in arreglo: #1 #n+1 #n
        if elemento > maximo: #n
            maximo = elemento #n
    return maximo #1

#T(n) = 1+1+1+n+1+n+n+n+1= 4n+5

# Metodo recursivo para encontrar el número mayor
def maximo_recursivo(arreglo, indice):
    if indice == 0:
        return arreglo[0]
    else:
        max_anterior = maximo_recursivo(arreglo, indice - 1)
        return arreglo[indice] if arreglo[indice] > max_anterior else max_anterior
    
def main():
    # Pedir cuántos números se quieren generar en el arreglo
    n = int(input("¿Cuántos números(n) deseas generar en su arreglo? "))

    # Generar los números aleatorios y guardarlos en un arreglo
    mi_arreglo = [random.randint(1, 500) for _ in range(n)]
    print("Arreglo generado:", mi_arreglo)

    # Imprimir los resultados
    print("Mayor (secuencial):", maximo_secuencial(mi_arreglo))
    print("Mayor (recursivo):", maximo_recursivo(mi_arreglo, len(mi_arreglo) - 1))
