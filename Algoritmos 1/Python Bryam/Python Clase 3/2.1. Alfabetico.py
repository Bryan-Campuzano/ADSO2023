""" este Script permite ordenar una lista de palabras en orden alfabético, permite crear una lista de palabras dadas por el usuario
    o procesar listas prefabricadas
"""
#------------------------ZONA DE CÓDIGO 1------------------------

""" esta función esta encargada de recibir la informacion necesaria para el funcionamiento del método organizar
    return: lista: lista de palabras desordenadas
"""
def recepcion():
    estado = True
    lista = []
    while estado == True:
        palabra = input("Indique la palabra que quiere agregar a la lista, o escriba '1234' para terminar: ")
        if palabra != '1234':
            lista.append(palabra)
        else:
            estado = False
    return lista

""" esta función ordena una lista de palabras en orden alfabético
    parámetros: palabras: lista de palabras desordenadas
    return: msg: mensaje con la lista de palabras ordenadas alfabéticamente
"""
def organizar (palabras):
    msg = ""
    ordenadas = sorted(palabras)
    msg = f"El orden alfabético de la lista dada es {ordenadas}"
    return msg
    
#-------------------------ZONA DE TEST 1-------------------------

print(organizar(recepcion()))

animales = ["perro", "gato", "elefante", "tigre", "ratón"]
print(organizar(animales))

#   appEnd