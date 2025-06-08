from ArbolBinario import ArbolBinario
def main():
    arbol = ArbolBinario()
    tamano = input("Ingrese el tamaño del árbol binario: ")
    
    for i in range(int(tamano)):
        num = int(input(f"Ingrese el número {i + 1}: "))
        arbol.insertar(num)

    print("Recorrido inorden del árbol binario:")
    print(arbol.inorden())
    
    camino = int(input("Ingrese el numero a buscar: "))
    
    print("Camino a nodo ", camino , ":")
    print(arbol.camino_a_nodo(camino))

#main()