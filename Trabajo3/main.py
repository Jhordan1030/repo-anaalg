from ArbolBinario import ArbolBinario

def main():
    arbol = ArbolBinario()
    numeros = [8, 3, 10, 1, 6, 14, 4, 7, 13]

    for num in numeros:
        arbol.insertar(num)

    print("Recorrido inorden del árbol binario:")
    print(arbol.inorden())
    
    print("Número de hojas en el árbol binario:")
    print(arbol.contar_hojas())
    
    print("Camino a nodo 7:")
    print(arbol.camino_a_nodo(7))

    print("Imprimir árbol:")
    arbol.imprimir_arbol()

if __name__ == "__main__":
    main()