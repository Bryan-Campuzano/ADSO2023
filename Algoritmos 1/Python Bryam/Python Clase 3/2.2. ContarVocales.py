""" este Script permite dividir una palabra en sus caracteres individuales y contar cuantas vocales se encuentran en esta
"""
#------------------------ZONA DE CÓDIGO 1------------------------

""" esta función esta encargada de recibir la informacion necesaria para el funcionamiento del método cuantasVocales
    return: lista: lista de vocales ordenadas que conforman una palabra dada
"""
def recepcion():
    lista = []                                                      #   creamos una lista vacía
    palabra = input("Indique la palabra que quiere analizar: ")     #   solicitamos una palabra por terminal
    lista = list(palabra)                                           #   convertimos la palabra dada en una lista, cada posición de la lista contiene, en orden, un carácter
    return lista                                                    #   retornamos la lista

""" esta función ordena una lista de palabras en orden alfabético
    parámetros: palabras: lista de palabras desordenadas
    return: msg: mensaje con la lista de palabras ordenadas alfabéticamente
"""
def cuantasVocales (listaCaracteres):                                
    vocales = "aeiouAEIOU"                                                      #   creamos una cadena que contiene las vocales, tanto mayúsculas como minúsculas
    cantidadVocales = 0                                                         #   iniciamos un contador
    for i in range (len(listaCaracteres)):                                      #   recorremos la lista de caracteres
        if listaCaracteres[i] in vocales:                                       #   con el operador 'in' identificamos si el carácter actual se encuentra dentro de la cadena donde almacenamos todas las vocales
            cantidadVocales += 1                                                #   si el carácter se encuentra en la cadena, aumentamos el contador
    msg = f"la cantidad de vocales en la palabra dada es: {cantidadVocales}"    #   creamos el mensaje con la informacion resultante del método
    return msg                                                                  #   retornamos el mensaje de respuesta
    
#-------------------------ZONA DE TEST 1-------------------------

"""función encargada de repetir el algoritmo para hacer varios test
"""
def repTest():
    estado = True
    contador = 0
    while estado == True:
        print(cuantasVocales(recepcion()))
        contador = contador + 1
        if contador == 5:
            estado = False

repTest()
#   appEnd