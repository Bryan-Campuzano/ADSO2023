""" este Script determina si un numero dado es primo o no
"""
#------------------------ZONA DE CÓDIGO 1------------------------

""" esta funcion esta encargada de recibir la informacion necesaria para el funcionamiento del metodo esPrimo
    return: num1: un numero entero cualquiera indicado por el usuario
"""
def recepcion():
    num1 = int(input("Indique cualquier numero: "))
    return num1

""" esta funcion determina si un numero dado es primo o no
    parametros: numero: radio de un circulo cualquiera
    return: msg: mensaje personalizado con el resultado de la operacion
"""
def esPrimo (numero):
    estado = True
    for i in range (2,numero):
        if numero % i == 0:
            estado = False
    return estado

def sumaPrimos(nCantidad):
    total = 0
    cantidadPrimos = 0
    msg = ""
    for i in range(2,nCantidad):
        if esPrimo(i) == True:
            total = total + i
            cantidadPrimos = cantidadPrimos + 1
        msg = f"la suma de los primos menores a {nCantidad} es: {total} con un total de {cantidadPrimos} numeros primos"
    return msg

#-------------------------ZONA DE TEST 1-------------------------
print(sumaPrimos(recepcion()))

#   appEnd