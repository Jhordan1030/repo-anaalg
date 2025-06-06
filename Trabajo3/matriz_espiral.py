class GeneradorMatrizEspiral:
    def __init__(self, filas, columnas):
        self.filas = filas
        self.columnas = columnas
        self.matriz = [[0 for _ in range(columnas)] for _ in range(filas)]

    def generar_secuencial(self):
        '''Genera la matriz en espiral de forma secuencial.'''
        numero = 1
        arriba = 0
        abajo = self.filas - 1
        izquierda = 0
        derecha = self.columnas - 1

        while arriba <= abajo and izquierda <= derecha:
            # Llenar la fila inferior de derecha a izquierda
            for j in range(derecha, izquierda - 1, -1):
                self.matriz[abajo][j] = numero
                numero += 1
            abajo -= 1
            # Llenar la columna izquierda de abajo hacia arriba
            for i in range(abajo, arriba - 1, -1):
                self.matriz[i][izquierda] = numero
                numero += 1
            izquierda += 1
            # Llenar la fila superior de izquierda a derecha
            if arriba <= abajo:
                for j in range(izquierda, derecha + 1):
                    self.matriz[arriba][j] = numero
                    numero += 1
                arriba += 1
            # Llenar la columna derecha de arriba hacia abajo
            if izquierda <= derecha:
                for i in range(arriba, abajo + 1):
                    self.matriz[i][derecha] = numero
                    numero += 1
                derecha -= 1
        return self.matriz

    def generar_recursivo(self):
        """
        Genera la matriz en espiral de forma recursiva, usando solo recursión y sin bucles.
        El código es claro, con nombres descriptivos y comentarios para mayor comprensión.
        """
        self._llenar_espiral_recursivo(
            fila_inferior=self.filas - 1,
            fila_superior=0,
            columna_izquierda=0,
            columna_derecha=self.columnas - 1,
            numero_actual=1
        )
        return self.matriz

    def _llenar_espiral_recursivo(self, fila_inferior, fila_superior, columna_izquierda, columna_derecha, numero_actual):
        # Caso base: si ya no hay filas o columnas por llenar
        if fila_superior > fila_inferior or columna_izquierda > columna_derecha:
            return

        # Llenar la fila inferior de derecha a izquierda
        self._llenar_fila_inferior(fila_inferior, columna_derecha, columna_izquierda, numero_actual)
        numero_actual += (columna_derecha - columna_izquierda + 1)
        fila_inferior -= 1

        # Llenar la columna izquierda de abajo hacia arriba
        self._llenar_columna_izquierda(fila_inferior, fila_superior, columna_izquierda, numero_actual)
        numero_actual += (fila_inferior - fila_superior + 1)
        columna_izquierda += 1

        # Llenar la fila superior de izquierda a derecha
        if fila_superior <= fila_inferior:
            self._llenar_fila_superior(fila_superior, columna_izquierda, columna_derecha, numero_actual)
            numero_actual += (columna_derecha - columna_izquierda + 1)
            fila_superior += 1

        # Llenar la columna derecha de arriba hacia abajo
        if columna_izquierda <= columna_derecha:
            self._llenar_columna_derecha(fila_superior, fila_inferior, columna_derecha, numero_actual)
            numero_actual += (fila_inferior - fila_superior + 1)
            columna_derecha -= 1

        # Llamada recursiva para el siguiente "anillo" de la espiral
        self._llenar_espiral_recursivo(fila_inferior, fila_superior, columna_izquierda, columna_derecha, numero_actual)

    def _llenar_fila_inferior(self, fila, col_inicio, col_fin, numero):
        if col_inicio < col_fin:
            return
        self.matriz[fila][col_inicio] = numero
        self._llenar_fila_inferior(fila, col_inicio - 1, col_fin, numero + 1)

    def _llenar_columna_izquierda(self, fila_inicio, fila_fin, columna, numero):
        if fila_inicio < fila_fin:
            return
        self.matriz[fila_inicio][columna] = numero
        self._llenar_columna_izquierda(fila_inicio - 1, fila_fin, columna, numero + 1)

    def _llenar_fila_superior(self, fila, col_inicio, col_fin, numero):
        if col_inicio > col_fin:
            return
        self.matriz[fila][col_inicio] = numero
        self._llenar_fila_superior(fila, col_inicio + 1, col_fin, numero + 1)

    def _llenar_columna_derecha(self, fila_inicio, fila_fin, columna, numero):
        if fila_inicio > fila_fin:
            return
        self.matriz[fila_inicio][columna] = numero
        self._llenar_columna_derecha(fila_inicio + 1, fila_fin, columna, numero + 1)

    def imprimir_matriz(self):
        for fila in self.matriz:
            print(fila)

if __name__ == "__main__":
    filas = 6
    columnas = 8
    print("Matriz generada de forma secuencial:")
    generador1 = GeneradorMatrizEspiral(filas, columnas)
    generador1.generar_secuencial()
    generador1.imprimir_matriz()
    print("\nMatriz generada de forma recursiva:")
    generador2 = GeneradorMatrizEspiral(filas, columnas)
    generador2.generar_recursivo()
    generador2.imprimir_matriz()
