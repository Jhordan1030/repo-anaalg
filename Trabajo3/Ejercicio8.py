class NodoArbol:
    def __init__(self, valor):
        self.valor = valor
        self.izquierdo = None
        self.derecho = None

class ArbolBinario:
    
    def __init__(self):
        self.raiz = None
    
    #METODO SECUENCIAL PREORDEN
    def preorden_secuencial(self, nodo_raiz=None):#1 vez
        if nodo_raiz is None: # 1vez
            nodo_raiz = self.raiz # 1vez
        
        if nodo_raiz is None: # 1vez
            return [] # 1vez
        
        resultado = [] # 1vez
        pila = [nodo_raiz] # 1vez
        
        while pila: # n+1 veces
            nodo_actual = pila.pop() # n veces
            resultado.append(nodo_actual.valor) # n veces
            
            # Agregar hijos a la pila (derecho primero para que izquierdo salga primero)
            if nodo_actual.derecho: # n veces
                pila.append(nodo_actual.derecho) # n veces
            if nodo_actual.izquierdo: # n veces
                pila.append(nodo_actual.izquierdo) # n veces
            #T(n1) = n+1+n+n+n+n+n+n
            #T(n1) = 7n+1
        
        return resultado # 1 vez

        #========== Resultado Final ==========
        #T(n) = 8 + 7n + 1
        #T(n) = 7n + 9
    

    
    #METODO RECURSIVO PREORDEN
    def preorden_recursivo(self, nodo=None, resultado=None):
        if resultado is None:
            resultado = []
            nodo = self.raiz
        
        if nodo is None:
            return resultado
        
        resultado.append(nodo.valor)
        
        self.preorden_recursivo(nodo.izquierdo, resultado)
        
        self.preorden_recursivo(nodo.derecho, resultado)
        
        return resultado
    
    def insertar(self, valor):
        if self.raiz is None:
            self.raiz = NodoArbol(valor)
        else:
            self._insertar_recursivo(self.raiz, valor)
    
    def _insertar_recursivo(self, nodo, valor):
        if valor < nodo.valor:
            if nodo.izquierdo is None:
                nodo.izquierdo = NodoArbol(valor)
            else:
                self._insertar_recursivo(nodo.izquierdo, valor)
        else:
            if nodo.derecho is None:
                nodo.derecho = NodoArbol(valor)
            else:
                self._insertar_recursivo(nodo.derecho, valor)

def main():
    arbol = ArbolBinario()
    valores = [4, 2, 6, 1, 3, 5, 7]
    for valor in valores:
        arbol.insertar(valor)

    print("=== MÉTODOS SECUENCIALES ===")
    print("Preorden:", arbol.preorden_secuencial())

    print("\n=== MÉTODOS RECURSIVOS ===")
    print("Preorden:", arbol.preorden_recursivo()) 
