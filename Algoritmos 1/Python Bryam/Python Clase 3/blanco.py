def ordenar_palabras(lista):
    """Ordena una lista de palabras en orden alfabético"""
    n = len(lista)
    for i in range(n):
        min_idx = i
        for j in range(i+1, n):
            if lista[j] < lista[min_idx]:
                min_idx = j
        lista[i], lista[min_idx] = lista[min_idx], lista[i]
    return lista

# Definir una lista de palabras desordenada
palabras = ["perro", "gato", "elefante", "tigre", "ratón"]

# Ordenar la lista de palabras
palabras_ordenadas = ordenar_palabras(palabras)

# Imprimir la lista de palabras ordenada
print("Lista ordenada:", palabras_ordenadas)
