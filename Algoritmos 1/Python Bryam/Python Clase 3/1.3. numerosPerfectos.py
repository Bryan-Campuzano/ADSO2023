""" este Script determina si un numero entero positivo dado es perfecto o no, entendiendo un numero perfecto como numero entero positivo que 
    es resultado de la suma de todos sus divisores exactos
        ejemplo: 6 es un numero perfecto pues 6%(1,2 o 3)=0 y la suma de 1,2 y 3 es 6
"""
#------------------------ZONA DE CÓDIGO 1------------------------

""" esta función esta encargada de recibir la informacion necesaria para el funcionamiento del método esPerfecto
    return: radio: el numero a comprobar
"""
def recepcion():
    num = int(input("Indique el numero entero positivo a comprobar "))
    return num

""" esta función determina si un numero es perfecto o no
    parámetros: perfecto: numero entero positivo cualquiera
    return: msg: mensaje de confirmación de la naturaleza del numero
"""
def esPerfecto(perfecto):
    msg = ""
    suma = 0                                                        #   iniciamos la suma de los divisores exactos del numero 'perfecto' dado
    for i in range(1,perfecto):
        if perfecto % i == 0:                                       #   buscamos los divisores exactos, si encontramos alguno lo sumamos a la variable 'suma'
            suma += i
    if suma == perfecto:                                            #   si la suma de los divisores exactos del numero 'perfecto' es igual a a 'perfecto' es un numero perfecto
        msg = f"el numero {perfecto} SI ES UN NUMERO PERFECTO"
    else:
        msg = f"el numero {perfecto} NO ES UN NUMERO PERFECTO"      # si no cumple, indicamos lo contrario
    return msg
    
#-------------------------ZONA DE TEST 1-------------------------

print(esPerfecto(recepcion()))
print(esPerfecto(recepcion()))
print(esPerfecto(recepcion()))
print(esPerfecto(recepcion()))
print(esPerfecto(recepcion()))

#   appEnd