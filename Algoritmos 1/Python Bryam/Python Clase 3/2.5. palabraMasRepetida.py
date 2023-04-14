""" este Script permite identificar la palabra mas repetida dentro de una frase
"""
#------------------------ZONA DE CÓDIGO 1------------------------

""" esta función esta encargada de recibir la informacion necesaria para el funcionamiento del método masRepetida
    return: frase: la frase a procesar
"""
def recepcion():
    frase = input("Indique Una oración cualquiera ")                                #   solicitamos una oración por terminal
    return frase                                                                    #   retornamos la frase

""" esta función separa la cadena de entrada en una lista conformada por las palabras que le conforman sin comas ni espacios
    parámetros: frase: la cadena sin separar, aun conservando el tipo str
    return: fraseSeparadaSinComas: frase en forma de lista de las palabras que le conforman comas ni espacios
"""
def separador(frase):                                                               #   esperamos un parámetro de tipo cadena 'str'
    fraseSeparada = frase.split()                                                   #   usamos el método 'split' para separar la cadena y conformar una lista con las palabras que la conforman, si no le definimos un parámetro, va a dividir la cadena en sus espacios vacíos ' '
    fraseSeparadaSinComas = []                                                      #   inicializamos una lista vacía nueva
    for i in fraseSeparada:                                                         #   recorremos la lista 
        fraseSeparadaSinComas.extend(i.split(','))                                  #   usamos el método 'extend' para agregar a la lista, los elementos generados de separar las palabras que tengan una coma por consecuencia de la division por espacios blancos
    return fraseSeparadaSinComas                                                    #   retornamos la lista de palabras sin espacios ni comas

""" esta función identifica la palabra mas repetida en una oración dada
    parámetros: fraseLista: frase en forma de lista de las palabras que le conforman sin signos de puntuación ni espacios
    return: msg: mensaje con la palabra mas común identificada
"""
def masRepetida (fraseLista):                                                       #   le definimos como parámetro una lista de palabras
    masRepetida = ""                                                                #   inicializamos una variable como vacía donde se va a asignar la palabra mas repetida
    repeticionMax = 0                                                               #   contador que define la cantidad de veces que se repite la palabra mas repetida
    for palabra in fraseLista:                                                      #   recorremos la lista dada por parámetro
        repeticionAct = fraseLista.count(palabra)                                   #   creamos una variable temporal y le asignados el valor de la la cantidad de veces que se encuentra la palabra actual en la lista. el método 'count' busca la palabra en las posiciones de la lista y retorna la cantidad de veces que se encuentra repetida
        if repeticionAct > repeticionMax:                                           #   si la cantidad de veces que se repite la palabra actual es mayor que la cantidad de veces que se repite la palabra mas común
            masRepetida = palabra                                                   #   la palabra actual se convierte en la palabra mas repetida
            repeticionMax = repeticionAct                                           #   y la cantidad de veces que se repite esta palabra, se asigna a la variable 'masRepetida' estableciendo un nuevo limite
    return f"La palabra más repetida de la oración es: {masRepetida}"               #   al terminar de recorrer la lista, retorna la palabra mas repetida en la lista en forma de mensaje

    
#-------------------------ZONA DE TEST 1-------------------------

print(masRepetida(separador("El perro marrón saltó sobre el perro perezoso")))      # resultado esperado = perro
print(masRepetida(separador("Los pájaros, cantan en los árboles")))                 # resultado esperado = los
print(masRepetida(separador("la, lo la lo la")))                                    # resultado esperado = la
print(masRepetida(separador("La comida está en la mesa, sírvete")))                 # resultado esperado = La
print(masRepetida(separador("el el el el el")))                                     # resultado esperado = el

#   appEnd