""" Este Script, dado un numero por el usuario, determina si este es par o impar
"""
#------------------------IMPORTACIONES---------------------------
import math
#------------------------ZONA DE CÓDIGO 1------------------------
"""Este método se encarga de recibir datos desde consola para generar casos concretos funcionales para el método parImpar
        retorna:    a: es el numero entero del cual se quiere saber si es par o impar 
"""
def recepcion():
    a = int(input("Introduzca el numero a operar"))
    return a
""" Este método se encarga, dados dos valores numéricos y un operador valido. dependiendo el operador, ejecuta la  operación aritmética seleccionada
        parámetros: num: numero entero del cual se quiere saber si es par o impar
        retorna:
"""
def parImpar(num):
    msg = ""
    if num%2==0:
        msg = "El Numero es par"
    else:
        msg = "El numero es Impar"
    return msg
#-------------------------ZONA DE TEST 1-------------------------
print(parImpar(1))
print(parImpar(2))
print(parImpar(3))
print(parImpar(4))
print(parImpar(5))
print(parImpar(recepcion()))

#   appEnd