import random
from fractions import Fraction
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
        
    def fibonacci(self, n):
        if n <= 1:
            return n
        return self.fibonacci(n - 1) + self.fibonacci(n - 2)
    
    def factorial(self, n):
        if n <= 1:
            return 1
        return n * self.factorial(n - 1)
    
    def llenar_aleatorio(self, min=1, max=100):
        for fila in range(len(self.matriz)):
            for columna in range(len(self.matriz[0])):
                self.matriz[fila][columna] = random.randint(min, max)

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

    def sumar_filas_recursivo(self):
        suma = [0] * len(self.matriz)
        def sumar_fila(idx):
            if idx == len(self.matriz):
                return
            suma[idx] = _sumar_fila_rec(idx, len(self.matriz[0]) - 1)
            sumar_fila(idx + 1)
        def _sumar_fila_rec(fila, col):
            if col < 0:
                return 0
            return self.matriz[fila][col] + _sumar_fila_rec(fila, col - 1)
        sumar_fila(0)
        return suma
    
    def llenar_espiral_fibonacci(self):
        filas = len(self.matriz)
        columnas = len(self.matriz[0])
        contador = 1
        
        for fila in range(filas - 1, -1, -1):  # Comenzamos desde abajo
            if (filas - 1 - fila) % 2 == 0:  # Si es una fila par desde abajo
                for col in range(columnas):  # Movimiento hacia la derecha
                    self.matriz[fila][col] = self.fibonacci(contador)/ self.factorial(contador)
                    contador += 1
            else:  # Si es una fila impar desde abajo
                for col in range(columnas - 1, -1, -1):  # Movimiento hacia la izquierda
                    self.matriz[fila][col] = self.fibonacci(contador)/ self.factorial(contador)
                    contador += 1
                    
    def decimal_a_fraccion(self, numero):
        fraccion = Fraction(numero).limit_denominator()
        return f"{fraccion.numerator}/{fraccion.denominator}"
    
    def __str__(self):
        def fila_a_str(idx):
            if idx == len(self.matriz):
                return ""
            fila_str = "\t".join(self.decimal_a_fraccion(x) for x in self.matriz[idx])
            resto = fila_a_str(idx + 1)
            return fila_str if resto == "" else fila_str + "\n" + resto
        return fila_a_str(0)