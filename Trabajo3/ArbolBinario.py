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
            return 1
        return self._contar_hojas_rec(nodo.get_izquierdo()) + self._contar_hojas_rec(nodo.get_derecho())

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
            return True
        if (self._camino_a_nodo_rec(nodo.get_izquierdo(), valor, camino) or
            self._camino_a_nodo_rec(nodo.get_derecho(), valor, camino)):
            return True
        camino.pop()
        return False
    
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