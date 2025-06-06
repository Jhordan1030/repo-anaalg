class NodoBi:
    def __init__(self, valor):
        self.valor = valor
        self.izquierdo = None
        self.derecho = None

    def get_valor(self):
        return self.valor

    def set_valor(self, valor):
        self.valor = valor

    def get_izquierdo(self):
        return self.izquierdo

    def set_izquierdo(self, izquierdo):
        self.izquierdo = izquierdo

    def get_derecho(self):
        return self.derecho

    def set_derecho(self, derecho):
        self.derecho = derecho