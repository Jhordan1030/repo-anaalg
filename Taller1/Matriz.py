import random
class Matriz:
    def __init__(self, matriz=None, filas=None, columnas=None):
        if matriz is not None:
            self.matriz = matriz
        elif filas is not None and columnas is not None:
            self.matriz = [[0 for _ in range(columnas)] for _ in range(filas)]
        elif filas is not None:
            self.matriz = [[0 for _ in range(filas)] for _ in range(filas)]
        else:
            self.matriz = [[0 for _ in range(3)] for _ in range(3)]

    def get_matriz(self):
        return self.matriz

    def set_matriz(self, matriz):
        self.matriz = matriz

    def filas(self):
        return len(self.matriz)

    def columnas(self):
        return len(self.matriz[0])

    def get_valor(self, m, n):
        return self.matriz[m][n]

    def ingresar(self, num, fil, col):
        self.matriz[fil][col] = num
    
    def llenar_aleatorio(self, min=1, max=100):
        for fila in range(len(self.matriz)):
            for columna in range(len(self.matriz[0])):
                self.matriz[fila][columna] = random.randint(min, max)

    def verificar_distributiva(self, A, C):
        # Verificar dimensiones compatibles
        if len(self.matriz[0]) != len(A.matriz) or len(self.matriz[0]) != len(C.matriz) or len(A.matriz) != len(C.matriz):
            print("Las dimensiones de las matrices no son compatibles para la operación.")
            return False

        # Calcular A + C
        suma = Matriz(filas=len(A.matriz), columnas=len(A.matriz[0]))
        for i in range(len(A.matriz)):
            for j in range(len(A.matriz[0])):
                suma.matriz[i][j] = A.matriz[i][j] + C.matriz[i][j]

        # Calcular B(A + C)
        izquierda = self.multiplicacion(suma)

        # Calcular BA
        BA = self.multiplicacion(A)

        # Calcular BC
        BC = self.multiplicacion(C)

        # Calcular BA + BC
        derecha = Matriz(filas=len(BA.matriz), columnas=len(BA.matriz[0]))
        for i in range(len(BA.matriz)):
            for j in range(len(BA.matriz[0])):
                derecha.matriz[i][j] = BA.matriz[i][j] + BC.matriz[i][j]

        # Verificar si B(A + C) == BA + BC
        for i in range(len(izquierda.matriz)):
            for j in range(len(izquierda.matriz[0])):
                if izquierda.matriz[i][j] != derecha.matriz[i][j]:
                    return False

        return True

    def transpuesta(self):
        filas = len(self.matriz)
        columnas = len(self.matriz[0])
        trans = Matriz(filas=columnas, columnas=filas)
        for fila in range(filas):
            for columna in range(columnas):
                trans.matriz[columna][fila] = self.matriz[fila][columna]
        return trans

    def simetrica(self):
        if len(self.matriz) == len(self.matriz[0]):
            for fila in range(len(self.matriz)):
                for columna in range(len(self.matriz[0])):
                    if self.matriz[fila][columna] != self.matriz[columna][fila]:
                        return False
            return True
        return False

    def sumar_columnas(self):
        suma = [0] * len(self.matriz[0])
        for columna in range(len(self.matriz[0])):
            for fila in range(len(self.matriz)):
                suma[columna] += self.matriz[fila][columna]
        return suma

    def sumar_filas(self):
        suma = [0] * len(self.matriz)
        for fila in range(len(self.matriz)):
            for columna in range(len(self.matriz[0])):
                suma[fila] += self.matriz[fila][columna]
        return suma

    def triangular_superior(self):
        for fila in range(len(self.matriz)):
            for columna in range(fila):
                if self.matriz[fila][columna] != 0:
                    return False
        return True

    def triangular_inferior(self):
        for fila in range(len(self.matriz)):
            for columna in range(fila + 1, len(self.matriz[0])):
                if self.matriz[fila][columna] != 0:
                    return False
        return True

    def marco(self, num):
        for fila in range(len(self.matriz)):
            for columna in range(len(self.matriz[0])):
                if fila == 0 or columna == 0 or fila == len(self.matriz) - 1 or columna == len(self.matriz[0]) - 1:
                    self.matriz[fila][columna] = num

    def llenar_con_salto(self, inicio, salto):
        for fila in range(len(self.matriz)):
            for columna in range(len(self.matriz[0])):
                self.matriz[fila][columna] = inicio
                inicio += salto

    def generar_triangular_superior(self):
        num = 1
        for fila in range(len(self.matriz)):
            for columna in range(len(self.matriz[0])):
                if fila > columna:
                    self.matriz[fila][columna] = 0
                else:
                    self.matriz[fila][columna] = num
                    num += 1

    def generar_triangular_inferior(self):
        num = 1
        for fila in range(len(self.matriz)):
            for columna in range(len(self.matriz[0])):
                if fila < columna:
                    self.matriz[fila][columna] = 0
                else:
                    self.matriz[fila][columna] = num
                    num += 1

    def multiplicacion(self, otra):
        if len(self.matriz[0]) != len(otra.matriz):
            raise ValueError("No es válida la multiplicación porque las dimensiones no coinciden.")
        resultado = Matriz(filas=len(self.matriz), columnas=len(otra.matriz[0]))
        for i in range(len(self.matriz)):
            for j in range(len(otra.matriz[0])):
                for k in range(len(self.matriz[0])):
                    resultado.matriz[i][j] += self.matriz[i][k] * otra.matriz[k][j]
        return resultado
    
    def multiplicacion_recursiva(self, otra):
        if len(self.matriz[0]) != len(otra.matriz):
            raise ValueError("No es válida la multiplicación porque las dimensiones no coinciden.")
        resultado = Matriz(filas=len(self.matriz), columnas=len(otra.matriz[0]))

        def calcular_elemento(i, j, k):
            if k < 0:
                return 0
            return self.matriz[i][k] * otra.matriz[k][j] + calcular_elemento(i, j, k - 1)
            # b + T(n-1)  --> n+1 sería el cambio, pero le revertimos porque va de 0 a n, y evaluamos como si fuese de n a 0
            # T(-1:tam) = a
            # T(0) = b + a
            # T(1) = 2b + a
            # T(2) = 3b + a
            # T(3) = 4b + a
            # T(n) = bn + a   b(n+1)+a
        def llenar(i, j):
            if i < 0:
                return
            if j < 0:
                llenar(i - 1, len(otra.matriz[0]) - 1)
                return
            resultado.matriz[i][j] = calcular_elemento(i, j, len(self.matriz[0]) - 1) #bn+a
            llenar(i, j - 1)
            # b + T(n-1)  --> n+1 sería el cambio, pero le revertimos porque va de 0 a n, y evaluamos como si fuese de n a 0
            # T(-1:tam) = a
            # T(0) = b + a
            # T(1) = 2b + a
            # T(2) = 3b + a
            # T(n) = bn + a  b(n+1)+a
            # b = bn+b+a
            # T(n) = n(bn+b+a) + a = bn²+an+bn+a = bn+n(a+b)+a

        llenar(len(self.matriz) - 1, len(otra.matriz[0]) - 1)
        return resultado

    def __str__(self):
        return "\n".join(["\t".join(map(str, fila)) for fila in self.matriz])