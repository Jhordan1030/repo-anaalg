#metodo recursivo
def quick_sort(arr):
    if len(arr) <= 1:
        return arr
    else:
        pivote = arr[0]
        izq = [x for x in arr[1:] if x < pivote]
        der = [x for x in arr[1:] if x >= pivote]
        return quick_sort(izq) + [pivote] + quick_sort(der)
