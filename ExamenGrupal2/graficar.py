import pandas as pd
import matplotlib.pyplot as plt

# Leer resultados
df = pd.read_csv("ExamenGrupal2/resultados/tiempos.csv", encoding="latin1")

# Graficar
plt.figure(figsize=(10, 6))
for columna in df.columns[1:]:  # Omitimos la columna 'Tamaño'
    plt.plot(df["Tamano"], df[columna], marker='o', label=columna)

plt.title("Comparación de Tiempos por Tamaño de Arreglo")
plt.xlabel("Tamaño del Arreglo")
plt.ylabel("Tiempo de Ejecución (segundos)")
plt.legend()
plt.grid(True)
plt.tight_layout()
plt.savefig("ExamenGrupal2/resultados/grafico_tiempos.png")
plt.show()
