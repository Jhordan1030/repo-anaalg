# Examen Grupal - Análisis de Algoritmos de Ordenamiento

## 📋 Descripción del proyecto

Este proyecto implementa y compara cinco algoritmos de ordenamiento, evaluando su rendimiento en función del tamaño del arreglo a ordenar.  
El objetivo es analizar y graficar los tiempos de ejecución en diferentes condiciones, utilizando los mismos conjuntos de datos para garantizar comparabilidad.

---

## 🧮 Algoritmos implementados

- **Burbuja (Bubble Sort)** – Ordenamiento por intercambio secuencial.
- **Selección (Selection Sort)** – Ordenamiento por intercambio secuencial.
- **Merge Sort** – Algoritmo recursivo de ordenamiento por división y conquista.
- **Quick Sort** – Algoritmo recursivo basado en pivote.
- **Merge Sort Paralelo** – Implementación de Merge Sort con paralelismo (multiprocessing).

---

## 🗂️ Estructura del proyecto

ExamenGrupal2/
│
├── datasets/ # Archivos de entrada con arreglos aleatorios
│ ├── arr_10.txt # Arreglo con 10 elementos
│ ├── arr_20.txt # Arreglo con 20 elementos
│ └── ... # Hasta arr_100.txt
│
├── resultados/ # Resultados y gráficos generados
│ ├── tiempos.csv # Tiempos de ejecución de cada algoritmo
│ └── grafico_tiempos.png # Gráfica comparativa de tiempos
│
├── ordenamientos/ # Implementación de algoritmos
│ ├── burbuja.py
│ ├── seleccion.py
│ ├── mergesort.py
│ ├── quicksort.py
│ └── mergesort_paralelo.py
│
├── main.py # Script principal que ejecuta las pruebas y mide tiempos
├── graficar.py # Script para graficar resultados
└── README.md # Este archivo

---

## 🚀 Cómo ejecutar

1. **Generar los archivos de datos**  
   Ejecuta el script para crear los archivos `arr_10.txt` hasta `arr_100.txt` en `datasets/`.  
   Si ya están generados, puedes omitir este paso.

2. **Ejecutar las pruebas de ordenamiento**  
```bash
   python main.py
```
Esto ejecutará todos los algoritmos sobre cada archivo y guardará los tiempos en resultados/tiempos.csv.

3. **Generar el gráfico comparativo**  
```bash
    python graficar.py
```
Esto creará la imagen resultados/grafico_tiempos.png con el comportamiento de cada algoritmo según el tamaño del arreglo.

## ⚙️ Requisitos
Python 3.8 o superior

Paquetes Python:
    pandas
    matplotlib

Instálalos con:

```bash
    pip install pandas matplotlib
```