from NodoBi import NodoBi

class ArbolBinario:
    def __init__(self):
        self.raiz = None

    def insertar(self, valor):
        if self.raiz is None:
            self.raiz = NodoBi(valor)
        else:
            self._insertar_rec(self.raiz, valor)

    def _insertar_rec(self, nodo, valor):
        if valor < nodo.get_valor():
            if nodo.get_izquierdo() is None:
                nodo.set_izquierdo(NodoBi(valor))
            else:
                self._insertar_rec(nodo.get_izquierdo(), valor)
        else:
            if nodo.get_derecho() is None:
                nodo.set_derecho(NodoBi(valor))
            else:
                self._insertar_rec(nodo.get_derecho(), valor)

    def buscar(self, valor):
        return self._buscar_rec(self.raiz, valor)

    def _buscar_rec(self, nodo, valor):
        if nodo is None:
            return None
        if nodo.get_valor() == valor:
            return nodo
        elif valor < nodo.get_valor():
            return self._buscar_rec(nodo.get_izquierdo(), valor)
        else:
            return self._buscar_rec(nodo.get_derecho(), valor)

    def inorden(self):
        resultado = []
        self._inorden_rec(self.raiz, resultado)
        return resultado

    def _inorden_rec(self, nodo, resultado):
        if nodo is not None:
            self._inorden_rec(nodo.get_izquierdo(), resultado)
            resultado.append(nodo.get_valor())
            self._inorden_rec(nodo.get_derecho(), resultado)
            
    #ejercicio 9 - Pablo Jiménez
    def contar_hojas(self):
        return self._contar_hojas_rec(self.raiz)

    def _contar_hojas_rec(self, nodo):
        if nodo is None:
            return 0
        if nodo.get_izquierdo() is None and nodo.get_derecho() is None:
            return 1 #a
        return self._contar_hojas_rec(nodo.get_izquierdo()) + self._contar_hojas_rec(nodo.get_derecho()) #b+2T(n/2)
    #n*a+b(n-1)
    def contar_hojas_secuencial(self): #1
        if self.raiz is None: #1
            return 0
        hojas = 0 #1
        stack = [self.raiz] #1
        #8n+1
        while stack: #n+1 n
            nodo = stack.pop() #2n
            if nodo.get_izquierdo() is None and nodo.get_derecho() is None:
                hojas += 1
            if nodo.get_derecho() is not None: #2n
                stack.append(nodo.get_derecho())
            if nodo.get_izquierdo() is not None: #2n
                stack.append(nodo.get_izquierdo())
        return hojas #1
        #8n+6
    #fin ejercicio 9
    
    #ejercicio 10 - Pablo Jiménez
    def camino_a_nodo(self, valor):
        camino = []
        if self._camino_a_nodo_rec(self.raiz, valor, camino):
            return camino
        else:
            return None
        
    def _camino_a_nodo_rec(self, nodo, valor, camino):
        if nodo is None:
            return False
        camino.append(nodo.get_valor())
        if nodo.get_valor() == valor:
            return True #a
        if (self._camino_a_nodo_rec(nodo.get_izquierdo(), valor, camino) or
            self._camino_a_nodo_rec(nodo.get_derecho(), valor, camino)):
            return True #b+2T(n/2)
        camino.pop()
        return False
    
    def camino_a_nodo_secuencial(self, valor): #2
        if self.raiz is None: #1
            return None
        stack = [(self.raiz, [self.raiz.get_valor()])] #1
        while stack: #n+1 n
            nodo, camino = stack.pop() #2n
            if nodo.get_valor() == valor:
                return camino
            if nodo.get_derecho() is not None: #2n
                stack.append((nodo.get_derecho(), camino + [nodo.get_derecho().get_valor()]))
            if nodo.get_izquierdo() is not None: #2n
                stack.append((nodo.get_izquierdo(), camino + [nodo.get_izquierdo().get_valor()]))
        return None #1
    #8n+6
    #fin ejercicio 10
    #Evaluar tiempos:
    #a
    #b+2T(n/2)

    #T(1) = a
    #T(2) = b+2a
    #T(4) = b+2(b+2a) = 3b+4a
    #T(8) = 7b+8a
    #T(16) = 15b+16a
    #T(n) = n*a+b(n-1)
    
    #imprimir arbol
    def imprimir_arbol(self):
        self._imprimir_arbol_rec(self.raiz, nivel=0, padre=None)

    def _imprimir_arbol_rec(self, nodo, nivel, padre):
        if nodo is not None:
            if nivel == 0:
                print(f"r{nivel}: {nodo.get_valor()}")
            else:
                print(f"r{nivel}: {nodo.get_valor()} padre: {padre}")
            self._imprimir_arbol_rec(nodo.get_izquierdo(), nivel + 1, nodo.get_valor())
            self._imprimir_arbol_rec(nodo.get_derecho(), nivel + 1, nodo.get_valor())