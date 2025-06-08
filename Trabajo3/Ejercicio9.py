from ArbolBinario import ArbolBinario
def main():
    arbol = ArbolBinario()
    tamano = input("Ingrese el tamaño del árbol binario: ")
    
    for i in range(int(tamano)):
        num = int(input(f"Ingrese el número {i + 1}: "))
        arbol.insertar(num)

    print("Recorrido inorden del árbol binario:")
    print(arbol.inorden())
    
    print("Número de hojas en el árbol binario:")
    print(arbol.contar_hojas())

#main()