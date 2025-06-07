class GeneradorMatrizEspiral:
    def __init__(self, filas, columnas):
        self.filas = filas
        self.columnas = columnas
        self.matriz = [[0 for _ in range(columnas)] for _ in range(filas)]

    def generar_secuencial(self):
        numero = 1
        arriba = 0
        abajo = self.filas - 1
        izquierda = 0
        derecha = self.columnas - 1

        while arriba <= abajo and izquierda <= derecha:
            # Llenar la fila inferior de derecha a izquierda
            for numeroColumna in range(derecha, izquierda - 1, -1):
                self.matriz[abajo][numeroColumna] = numero
                numero += 1
            abajo -= 1
            # Llenar la columna izquierda de abajo hacia arriba
            for numeroFila in range(abajo, arriba - 1, -1):
                self.matriz[numeroFila][izquierda] = numero
                numero += 1
            izquierda += 1
            # Llenar la fila superior de izquierda a derecha
            if arriba <= abajo:
                for numeroColumna in range(izquierda, derecha + 1):
                    self.matriz[arriba][numeroColumna] = numero
                    numero += 1
                arriba += 1
            # Llenar la columna derecha de arriba hacia abajo
            if izquierda <= derecha:
                for numeroFila in range(arriba, abajo + 1):
                    self.matriz[numeroFila][derecha] = numero
                    numero += 1
                derecha -= 1
        return self.matriz

    def generar_recursivo(self, arriba=None, abajo=None, izq=None, der=None, num=None, estado=None, pos=None):

        # Inicialización
        if arriba is None:
            return self.generar_recursivo(0, self.filas-1, 0, self.columnas-1, 1, 'abajo', der)
        # Caso base
        if arriba > abajo or izq > der:
            return self.matriz
        # Estados: 'abajo', 'izquierda', 'arriba', 'derecha'
        if estado == 'abajo':
            if pos is None: pos = der
            if pos >= izq:
                self.matriz[abajo][pos] = num
                return self.generar_recursivo(arriba, abajo, izq, der, num+1, 'abajo', pos-1)
            else:
                return self.generar_recursivo(arriba, abajo, izq, der, num, 'izquierda', abajo-1)
        elif estado == 'izquierda':
            if pos >= arriba:
                self.matriz[pos][izq] = num
                return self.generar_recursivo(arriba, abajo, izq, der, num+1, 'izquierda', pos-1)
            else:
                return self.generar_recursivo(arriba, abajo, izq, der, num, 'arriba', izq+1)
        elif estado == 'arriba':
            if pos <= der and arriba < abajo:
                self.matriz[arriba][pos] = num
                return self.generar_recursivo(arriba, abajo, izq, der, num+1, 'arriba', pos+1)
            else:
                return self.generar_recursivo(arriba, abajo, izq, der, num, 'derecha', arriba+1)
        elif estado == 'derecha':
            if pos < abajo and izq < der:
                self.matriz[pos][der] = num
                return self.generar_recursivo(arriba, abajo, izq, der, num+1, 'derecha', pos+1)
            else:
                return self.generar_recursivo(arriba+1, abajo-1, izq+1, der-1, num, 'abajo', der-1)

    def imprimir_matriz(self):
        for fila in self.matriz:
            print(fila)

if __name__ == "__main__":
    filas = 7
    columnas = 9
    print("Matriz generada de forma secuencial:")
    generador1 = GeneradorMatrizEspiral(filas, columnas)
    generador1.generar_secuencial()
    generador1.imprimir_matriz()
    print("\nMatriz generada de forma recursiva:")
    generador2 = GeneradorMatrizEspiral(filas, columnas)
    generador2.generar_recursivo()
    generador2.imprimir_matriz()
