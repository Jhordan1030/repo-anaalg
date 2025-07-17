import random
import os

# Crear carpeta si no existe
os.makedirs("ExamenGrupal2/datasets", exist_ok=True)

for n in range(10, 101, 10):  # Desde 10 hasta 100, de 10 en 10
    arreglo = [str(random.randint(1, 1000)) for _ in range(n)]
    nombre_archivo = f"ExamenGrupal2/datasets/arr_{n}.txt"

    with open(nombre_archivo, 'w') as f:
        f.write(', '.join(arreglo))

    print(f"Archivo generado: {nombre_archivo}")
