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

    def fibonacci(self, n):
        if not hasattr(self, '_fib_memo'):
            self._fib_memo = {}
        
        if n in self._fib_memo:
            return self._fib_memo[n]
        
        if n <= 1:
            result = n
        else:
            result = self.fibonacci(n - 1) + self.fibonacci(n - 2)
        
        self._fib_memo[n] = result
        return result
    
    def factorial(self, n):
        if not hasattr(self, '_fact_memo'):
            self._fact_memo = {}
            
        if n in self._fact_memo:
            return self._fact_memo[n]
            
        if n <= 1:
            result = 1
        else:
            result = n * self.factorial(n - 1)
            
        self._fact_memo[n] = result
        return result


    def sumar_filas_recursivo(self):
        suma = [0] * len(self.matriz)
        
        def sumar_fila(idx):
            if idx < 0:  # Condición base para detener la recursión
                return
            suma[idx] = _sumar_fila_rec(idx, len(self.matriz[0]) - 1)
            sumar_fila(idx - 1)  # Recursión con fila decrementada (cumple la condición metodo(n-1))

        def _sumar_fila_rec(fila, col):
            if col < 0:
                return 0
            return self.matriz[fila][col] + _sumar_fila_rec(fila, col - 1)
        
        sumar_fila(len(self.matriz) - 1)  # Comenzar desde la última fila
        return suma
    
    def llenar_espiral_fibonacci(self):
        filas = len(self.matriz)
        columnas = len(self.matriz[0])
        self._llenar_fila_espiral(filas - 1, columnas, 1)

    def _llenar_fila_espiral(self, fila, columnas, contador):
        if fila < 0:
            return contador
        
        # Determinar dirección según la fila (desde abajo)
        if (len(self.matriz) - 1 - fila) % 2 == 0:  # Filas pares desde abajo: izquierda a derecha
            contador = self._llenar_fila_direccion(fila, 0, columnas, contador, 1)
        else:  # Filas impares desde abajo: derecha a izquierda
            contador = self._llenar_fila_direccion(fila, columnas - 1, columnas, contador, -1)
        
        # Llamada recursiva para la fila anterior
        return self._llenar_fila_espiral(fila - 1, columnas, contador)
    
    def _llenar_fila_direccion(self, fila, col_inicio, total_cols, contador, direccion):
        """Función recursiva para llenar una fila en una dirección específica"""
        if direccion == 1 and col_inicio >= total_cols:  # Izquierda a derecha
            return contador
        if direccion == -1 and col_inicio < 0:  # Derecha a izquierda
            return contador
        
        # Llenar la celda actual
        fib = self.fibonacci(contador)
        fact = self.factorial(contador)
        self.matriz[fila][col_inicio] = Fraction(fib, fact)
        
        # Llamada recursiva para la siguiente columna
        return self._llenar_fila_direccion(fila, col_inicio + direccion, total_cols, contador + 1, direccion)

    def llenar_fibonacci_secuencial(self):
        """Versión recursiva para llenar secuencialmente con Fib(n)/n!"""
        def llenar_recursivo(fila, col, contador):
            if fila >= len(self.matriz):
                return
            if col >= len(self.matriz[0]):
                return llenar_recursivo(fila + 1, 0, contador)
            
            fib = self.fibonacci(contador)
            fact = self.factorial(contador)
            self.matriz[fila][col] = Fraction(fib, fact)
            llenar_recursivo(fila, col + 1, contador + 1)
        
        llenar_recursivo(0, 0, 1)
    
    def decimal_a_fraccion(self, numero):
        """Función recursiva para convertir diferentes tipos a fracción"""
        def procesar_tipo(valor):
            if isinstance(valor, Fraction):
                return f"{valor.numerator}/{valor.denominator}"
            elif isinstance(valor, (int, float)):
                if abs(valor) < 1e-15:
                    return "0/1"
                fraccion = Fraction(valor).limit_denominator(10**12)
                return f"{fraccion.numerator}/{fraccion.denominator}"
            else:
                try:
                    return procesar_tipo(float(valor))
                except (ValueError, TypeError):
                    return str(valor)
        
        return procesar_tipo(numero)
    
    def sumar_todos_elementos(self):
        """Versión recursiva para sumar todos los elementos"""
        def sumar_recursivo(fila, col, suma_actual):
            if fila >= len(self.matriz):
                return suma_actual
            if col >= len(self.matriz[0]):
                return sumar_recursivo(fila + 1, 0, suma_actual)
            
            elemento = self.matriz[fila][col]
            if isinstance(elemento, Fraction):
                nueva_suma = suma_actual + elemento
            else:
                nueva_suma = suma_actual + Fraction(elemento)
            
            return sumar_recursivo(fila, col + 1, nueva_suma)
        
        return sumar_recursivo(0, 0, Fraction(0))
    
    def __str__(self):
        """Representación recursiva en cadena mostrando fracciones"""
        def fila_a_str(idx):
            if idx == len(self.matriz):
                return ""
            fila_str = self._generar_fila_str(idx, 0, [])
            resto = fila_a_str(idx + 1)
            return fila_str if resto == "" else fila_str + "\n" + resto
        
        return fila_a_str(0)
    
    def _generar_fila_str(self, fila, col, elementos):
        """Función recursiva auxiliar para generar string de una fila"""
        if col >= len(self.matriz[0]):
            return "\t".join(elementos)
        
        elemento_str = self.decimal_a_fraccion(self.matriz[fila][col])
        elementos.append(elemento_str)
        return self._generar_fila_str(fila, col + 1, elementos)
    
    def imprimir(self):
        def fila_a_str(idx):
            if idx == len(self.matriz):
                return ""
            fila_str = self._generar_fila_decimal_str(idx, 0, [])
            resto = fila_a_str(idx + 1)
            return fila_str if resto == "" else fila_str + "\n" + resto
        
        return fila_a_str(0)
    
    def _generar_fila_decimal_str(self, fila, col, elementos):
        """Función recursiva auxiliar para generar string decimal de una fila"""
        if col >= len(self.matriz[0]):
            return "\t".join(elementos)
        
        elemento = self.matriz[fila][col]
        if isinstance(elemento, Fraction):
            elemento_str = str(float(elemento))
        else:
            elemento_str = str(elemento)
        
        elementos.append(elemento_str)
        return self._generar_fila_decimal_str(fila, col + 1, elementos)
