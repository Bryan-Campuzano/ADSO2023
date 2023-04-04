""" este Script permite saber si una cadena de caracteres contiene un pangrama. un pangrama es una oración que contiene todas las letras del
    alfabeto
"""
#------------------------ZONA DE CÓDIGO 1------------------------

""" esta función esta encargada de recibir la informacion necesaria para el funcionamiento del método esPangrama
    return: palabra: cadena de caracteres del pangrama a analizar
"""
def recepcion():
    palabra = input("Indique el pangrama a analizar: ")      
    return palabra

""" esta función dictamina si una frase dada es un pangrama o no
    parámetros: pangrama: frase a comprobar
    return: msg: mensaje con la respuesta del proceso
"""
def esPangrama (pangrama):
    msg = ""
    abecedario = "abcdefghijklmnñopqrstuvwxyz"          #   banco de las letras del abecedario
    listaAbecedario = list(abecedario)                  #   se crea una lista con todas las letras del abecedario
    cantidadLetras = 0                                  #   cantidad de letras presentes en el posible pangrama
    for i in range (len(listaAbecedario)):              #   recorremos la lista del abecedario
        if listaAbecedario[i] in pangrama.lower():      #   miramos si la letra actual del abecedario SE ENCUENTRA dentro del pangrama
            cantidadLetras += 1                         #   si encuentra la letra dentro, suma 1 al contador de letra
    if cantidadLetras == 27:                            #   si encuentra las 27 letras dentro del pangrama, confirma que es un pangrama autentico
        msg = "la frase introducida SI ES UN PANGRAMA"
    else:                                               #   si no coincide la cantidad de letras, confirma que NO es un pangrama autentico
        msg = "la frase introducida NO ES UN PANGRAMA"
    return msg
    
#-------------------------ZONA DE TEST 1-------------------------

print(esPangrama("El veloz murciélago hindú comía feliz cardillo y kiwi. La cigüeña tocaba el saxofón detrás del palenque de paja."))   #   SI ES UN PANGRAMA
print(esPangrama("El pingüino Wenceslaus hizo kilómetros bajo exhaustiva lluvia y frío, añoraba a su querido cachorro."))               #   SI ES UN PANGRAMA
print(esPangrama("Jovencillo emponzoñado de whisky, ¡qué figurota exhibe!"))                                                            #   SI ES UN PANGRAMA
print(esPangrama("El obsceno jade del pingüino emperador cautivaba a la gris comunidad antártica."))                                    #   aquí falta la letra 'ñ' por lo que no es un pangrama
print(esPangrama(recepcion()))


#   appEnd