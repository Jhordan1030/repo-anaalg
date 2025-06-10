import random

def suma_secuencial(arreglo): #1
    suma = 0 #1
    for elemento in arreglo: #1 #n+1 #n
        suma += elemento #n
    return suma #1
#T(n) = 1+1+1+n+1+n+n+1= 3n+5
def suma_recursiva(arreglo, indice):
    if indice < 0:
        return 0
    else:
        return arreglo[indice] + suma_recursiva(arreglo, indice - 1)
    
def main():
       
    # Pedir cuántos números se quieren generar
    n = int(input("¿Cuántos números(n) deseas generar en su arreglo? "))

    # Generar los números aleatorios y guardarlos en un arreglo
    mi_arreglo = [random.randint(1, 500) for _ in range(n)]
    print("Arreglo generado:", mi_arreglo)

    print("Suma secuencial:",suma_secuencial(mi_arreglo))               
    print( "Suma recursiva:",suma_recursiva(mi_arreglo, len(mi_arreglo) - 1))  

