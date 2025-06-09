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
        
    def fibonacci(self, n):
        if n <= 1:
            return n
        return self.fibonacci(n - 1) + self.fibonacci(n - 2)
    
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
            suma[idx] = self._sumar_fila_rec(idx, 0)
            sumar_fila(idx + 1)
        def _sumar_fila_rec(fila, col):
            if col == len(self.matriz[0]):
                return 0
            return self.matriz[fila][col] + _sumar_fila_rec(fila, col + 1)
        self._sumar_fila_rec = _sumar_fila_rec  # Para acceso interno
        sumar_fila(0)
        return suma
    
    def llenar_espiral_fibonacci(self):
        n = len(self.matriz)
        m = len(self.matriz[0])
        total = n * m

        def siguiente_direccion(direccion):
            # derecha -> arriba -> izquierda -> abajo
            return {
                (0, 1): (-1, 0),   # derecha a arriba
                (-1, 0): (0, -1),  # arriba a izquierda
                (0, -1): (1, 0),   # izquierda a abajo
                (1, 0): (0, 1),    # abajo a derecha
            }[direccion]

        def en_limite(fila, col):
            return (0 <= fila < n) and (0 <= col < m) and self.matriz[fila][col] == 0

        def llenar(fila, col, direccion, contador):
            if contador > total:
                return
            self.matriz[fila][col] = self.fibonacci(contador)
            # Calcular siguiente posición
            sig_fila = fila + direccion[0]
            sig_col = col + direccion[1]
            if not en_limite(sig_fila, sig_col):
                direccion = siguiente_direccion(direccion)
                sig_fila = fila + direccion[0]
                sig_col = col + direccion[1]
            llenar(sig_fila, sig_col, direccion, contador + 1)

        # Comienza en la esquina inferior izquierda, dirección derecha
        llenar(n - 1, 0, (0, 1), 1)
    
    def __str__(self):
        def fila_a_str(idx):
            if idx == len(self.matriz):
                return ""
            fila_str = "\t".join(map(str, self.matriz[idx]))
            resto = fila_a_str(idx + 1)
            return fila_str if resto == "" else fila_str + "\n" + resto
        return fila_a_str(0)