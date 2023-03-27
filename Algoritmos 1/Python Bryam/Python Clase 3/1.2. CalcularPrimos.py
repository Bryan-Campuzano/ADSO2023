""" este Script determina dato un numero n, encuentra todos los primos menores a este y brinda la suma total de estos primos
"""
#------------------------ZONA DE CÓDIGO 1------------------------

""" esta función esta encargada de recibir la informacion necesaria para el funcionamiento del método sumaPrimos
    return: num1: un numero entero cualquiera indicado por el usuario
"""
def recepcion():
    num1 = int(input("Indique cualquier numero entero positivo: "))
    return num1

""" esta función determina si un numero dado es primo o no
    parámetros: numero: radio de un circulo cualquiera
    return: estado: variable tipo bool que indica si el numero dado es primo o no, retornando 'True' si es primo, 'False' de lo contrario
"""
def esPrimo (numero):
    estado = True                               #   asumimos en un inicio que el numero es primo, asi que establecemos su estado inicial en 'True'
    divisores = 0
    for i in range (1,numero+1):                #   Evaluamos todos los números de 1 al numero consultado, sumamos 1 al numero porque el indice empieza normalmente de (0,numero-1) asi buscamos todos los posibles divisores exactos
        if numero % i == 0:                     
            divisores += 1                      
    if divisores != 2:                          #   si la cantidad de divisores es mayor a 2, significa que el numero no es primo y cambiamos su estado a 'False'
        estado = False
    return estado

""" este método, dado un numero cualquiera n suma todos los primos menores a 
    parámetros: nCantidad: numero limite de la suma
    return: msg: mensaje con la informacion resultante del proceso
"""
def sumaPrimos(nCantidad):
    total = 0                                   #   iniciamos el contador de la suma total en 0
    cantidadPrimos = 0                          #   iniciamos el contador de la cantidad de números primos menores a 'nCantidad' en 0
    msg = ""
    for i in range(1,nCantidad):
        if esPrimo(i) == True:                  #   verificamos si hay números primos menores al numero dado en nCantidad
            total = total + i                   #   actualizamos los contadores
            cantidadPrimos = cantidadPrimos + 1
    msg = f"la suma de los primos menores a {nCantidad} es: {total} con un total de {cantidadPrimos} Numeros primos"
    return msg

#-------------------------ZONA DE TEST 1-------------------------

print(sumaPrimos(recepcion()))

#   appEnd