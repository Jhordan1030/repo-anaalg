import time
import csv
import os

from ordenamientos.burbuja import bubble_sort
from ordenamientos.seleccion import selection_sort
from ordenamientos.mergesort import merge_sort
from ordenamientos.quicksort import quick_sort
from ordenamientos.mergesort_paralelo import parallel_merge_sort

# Lista de algoritmos a ejecutar
algoritmos = {
    "Burbuja": bubble_sort,
    "Selección": selection_sort,
    "MergeSort": merge_sort,
    "QuickSort": quick_sort,
    "MergeSortParalelo": parallel_merge_sort
}

# Ruta de los archivos
carpeta_datasets = "ExamenGrupal2/datasets"
archivos = [f for f in os.listdir(carpeta_datasets) if f.startswith("arr_") and f.endswith(".txt")]
archivos.sort(key=lambda x: int(x.split("_")[1].split(".")[0]))  # Ordenar por tamaño

# Crear carpeta resultados si no existe
os.makedirs("ExamenGrupal2/resultados", exist_ok=True)

# Abrir archivo CSV para guardar resultados
with open("ExamenGrupal2/resultados/tiempos.csv", mode="w", newline='') as archivo_csv:
    writer = csv.writer(archivo_csv)
    encabezado = ["Tamaño"] + list(algoritmos.keys())
    writer.writerow(encabezado)

    # Procesar cada archivo
    for archivo in archivos:
        tamano = int(archivo.split("_")[1].split(".")[0])
        ruta = os.path.join(carpeta_datasets, archivo)

        # Leer los datos del archivo
        with open(ruta, "r") as f:
            contenido = f.read()
            datos_originales = [int(x.strip()) for x in contenido.split(",")]

        fila = [tamano]

        # Ejecutar cada algoritmo
        for nombre, algoritmo in algoritmos.items():
            datos = datos_originales.copy()

            inicio = time.perf_counter()
            if nombre == "QuickSort":
                _ = algoritmo(datos)
            else:
                algoritmo(datos)
            fin = time.perf_counter()

            tiempo = round(fin - inicio, 6)
            fila.append(tiempo)
            print(f"Tamaño {tamano} - {nombre}: {tiempo} segundos")

        writer.writerow(fila)

print("Ejecución completa. Resultados guardados en tiempos.csv")
