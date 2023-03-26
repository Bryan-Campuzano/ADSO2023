""" este Script determina si un numero dado es perfecto o no
"""
#------------------------IMPORTACIONES---------------------------
""" importamos las librerias necesarias
"""
import math
#------------------------ZONA DE CÓDIGO 1------------------------

""" esta funcion esta encargada de recibir la informacion necesaria para el funcionamiento del metodo calcularArea
    return: radio: el radio de un cirulo cualquiera indicado por el usuario
"""
def recepcion():
    perfecto = int(input("Indique el numero a comprobar "))
    return perfecto

""" esta funcion calcula el area de un circulo dado su radio
    parametros: rad: radio de un circulo cualquiera
    return: msg: mensaje personalizado con el resultado de la operacion
"""
def calcularArea(rad):
    area = math.pi**radio
    msg = "El Area del circulo es: "
    return msg
#-------------------------ZONA DE TEST 1-------------------------
print(calcularArea(6))
print(calcularArea(5))
print(calcularArea(4))
print(calcularArea(3))
print(calcularArea(recepcion()))

#   appEnd