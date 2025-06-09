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
        """Versión iterativa más eficiente de Fibonacci"""
        if n <= 1:
            return n
        a, b = 0, 1
        for _ in range(2, n + 1):
            a, b = b, a + b
        return b
    
    def factorial(self, n):
        """Versión iterativa más eficiente de factorial"""
        if n <= 1:
            return 1
        resultado = 1
        for i in range(2, n + 1):
            resultado *= i
        return resultado
    
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
            suma[idx] = self._sumar_fila_rec(idx, len(self.matriz[0]) - 1)
            sumar_fila(idx + 1)
            
        def _sumar_fila_rec(fila, col):
            if col < 0:
                return 0
            return self.matriz[fila][col] + _sumar_fila_rec(fila, col - 1)
        
        # Definir la función interna antes de usarla
        self._sumar_fila_rec = _sumar_fila_rec
        sumar_fila(0)
        return suma
    
    def llenar_espiral_fibonacci(self):
        """Llena la matriz con fracciones Fibonacci/factorial en patrón espiral desde abajo"""
        filas = len(self.matriz)
        columnas = len(self.matriz[0])
        contador = 1
        
        # Llenar desde la fila inferior hacia arriba
        for fila in range(filas - 1, -1, -1):
            if (filas - 1 - fila) % 2 == 0:  # Filas pares desde abajo: izquierda a derecha
                col_range = range(columnas)
            else:  # Filas impares desde abajo: derecha a izquierda
                col_range = range(columnas - 1, -1, -1)
            
            for col in col_range:
                fib = self.fibonacci(contador)
                fact = self.factorial(contador)
                # Almacenar como Fraction para mantener precisión
                self.matriz[fila][col] = Fraction(fib, fact)
                contador += 1

    def llenar_fibonacci_secuencial(self):
        """Llena la matriz con Fib(n)/n! de forma secuencial (fila por fila)"""
        contador = 1
        for fila in range(len(self.matriz)):
            for col in range(len(self.matriz[0])):
                fib = self.fibonacci(contador)
                fact = self.factorial(contador)
                self.matriz[fila][col] = Fraction(fib, fact)
                contador += 1
    
    def decimal_a_fraccion(self, numero):
        """Convierte un número a fracción, manejando diferentes tipos"""
        if isinstance(numero, Fraction):
            return f"{numero.numerator}/{numero.denominator}"
        elif isinstance(numero, (int, float)):
            if abs(numero) < 1e-15:  # Prácticamente cero
                return "0/1"
            fraccion = Fraction(numero).limit_denominator(10**12)
            return f"{fraccion.numerator}/{fraccion.denominator}"
        else:
            # Para otros tipos, intentar convertir a float primero
            try:
                valor = float(numero)
                fraccion = Fraction(valor).limit_denominator(10**12)
                return f"{fraccion.numerator}/{fraccion.denominator}"
            except (ValueError, TypeError):
                return str(numero)
    
    def sumar_todos_elementos(self):
        """Suma todos los elementos de la matriz y devuelve como Fraction"""
        suma_total = Fraction(0)
        for fila in self.matriz:
            for elemento in fila:
                if isinstance(elemento, Fraction):
                    suma_total += elemento
                else:
                    suma_total += Fraction(elemento)
        return suma_total
    
    def __str__(self):
        """Representación en cadena mostrando fracciones"""
        def fila_a_str(idx):
            if idx == len(self.matriz):
                return ""
            fila_str = "\t".join(self.decimal_a_fraccion(x) for x in self.matriz[idx])
            resto = fila_a_str(idx + 1)
            return fila_str if resto == "" else fila_str + "\n" + resto
        return fila_a_str(0)
    
    def imprimir(self):
        """Imprime la matriz con valores decimales"""
        def fila_a_str(idx):
            if idx == len(self.matriz):
                return ""
            fila_str = "\t".join(str(float(x)) if isinstance(x, Fraction) else str(x) 
                               for x in self.matriz[idx])
            resto = fila_a_str(idx + 1)
            return fila_str if resto == "" else fila_str + "\n" + resto
        return fila_a_str(0)
