#paralelo
from multiprocessing import Pool

def merge(left, right):
    result = []
    i = j = 0
    while i < len(left) and j < len(right):
        if left[i] <= right[j]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1
    return result + left[i:] + right[j:]

def merge_sort(arr):
    if len(arr) <= 1:
        return arr
    mid = len(arr) // 2
    left = merge_sort(arr[:mid])
    right = merge_sort(arr[mid:])
    return merge(left, right)

def parallel_merge_sort(arr):
    if len(arr) <= 100000:  # Umbral para usar multiproceso
        return merge_sort(arr)
    else:
        mid = len(arr) // 2
        with Pool(2) as p:
            left, right = p.map(parallel_merge_sort, [arr[:mid], arr[mid:]])
        return merge(left, right)
