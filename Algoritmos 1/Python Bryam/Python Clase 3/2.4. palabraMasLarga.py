""" este Script permite identificar la palabra mas larga dentro de una frase
"""
#------------------------ZONA DE CÓDIGO 1------------------------

""" esta función esta encargada de recibir la informacion necesaria para el funcionamiento del método masLarga
    return: frase: la frase a procesar
"""
def recepcion():
    frase = input("Indique Una oración cualquiera ")                #   solicitamos una oración por terminal
    return frase                                                    #   retornamos la frase

""" esta función identifica la palabra mas larga en una oración dada
    parámetros: frase: frase a procesar
    return: msg: mensaje con la palabra mas larga identificada
"""
def masLarga (frase):
    masLarga = ""
    fraseSeparada = frase.split()
    for i in range (len(fraseSeparada)):
        if len(fraseSeparada[i]) > len(masLarga):
            masLarga = fraseSeparada[i]
    msg = f"la palabra mas larga de la frase dada es {masLarga}"
    return msg
    
#-------------------------ZONA DE TEST 1-------------------------

print(masLarga("La casa de papel es una serie española de televisión creada por Alex Pina"))            # la palabra mas larga de la frase dada es televisión
print(masLarga("El maravilloso mago de Oz es una novela infantil escrita por Lyman Frank Baum"))        # la palabra mas larga de la frase dada es maravilloso
print(masLarga("No dejes para mañana lo que puedas hacer hoy"))                                         # la palabra mas larga de la frase dada es mañana
print(masLarga("La vida es aquello que te va sucediendo mientras te empeñas en hacer otros planes"))    # la palabra mas larga de la frase dada es sucediendo
print(masLarga("El éxito no es la clave de la felicidad, la felicidad es la clave del éxito"))          # la palabra mas larga de la frase dada es felicidad,
print(masLarga("La única manera de hacer un gran trabajo es amar lo que haces"))                        # la palabra mas larga de la frase dada es trabajo
print(masLarga("La mente es como un paracaídas, solo funciona si la tenemos abierta"))                  # la palabra mas larga de la frase dada es paracaídas,
print(masLarga("La educación es el arma más poderosa que puedes usar para cambiar el mundo"))           # la palabra mas larga de la frase dada es educación
print(masLarga("La creatividad es la inteligencia divirtiéndose"))                                      # la palabra mas larga de la frase dada es creatividad
print(masLarga("La felicidad no es algo hecho. Viene de tus propias acciones"))                         # la palabra mas larga de la frase dada es felicidad

print(masLarga(recepcion()))

#   appEnd