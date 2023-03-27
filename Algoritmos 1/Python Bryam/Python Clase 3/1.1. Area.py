""" este Script Calcula el área de un círculo dado su radio
"""
#------------------------IMPORTACIONES---------------------------
""" importamos las librerías necesarias
"""
import math
#------------------------ZONA DE CÓDIGO 1------------------------

""" esta función esta encargada de recibir la informacion necesaria para el funcionamiento del método calcularArea
    return: radio: el radio de un circulo cualquiera indicado por el usuario
"""
def recepcion():
    radio = float(input("Indique el radio del circulo: "))  #   solicitamos un valor float para poder manejar decimales en el proceso
    return radio

""" esta función calcula el area de un circulo dado su radio
    parámetros: rad: radio de un circulo cualquiera
    return: msg: mensaje personalizado con el resultado de la operación
"""
def calcularArea(rad):
    area = math.pi * rad * rad                              #   hacemos el calculo del area, solicitando el valor de pi a la librería math para ejecutar 
    msg = f"El Area del circulo es: {area}"                 #   la operación matemática area = π * r^2,al multiplicar pi dos veces por el radio, logramos que
    return msg                                              #   en esencia es lo mismo que multiplicar por r^2
#-------------------------ZONA DE TEST 1-------------------------

print(calcularArea(6))  # VALOR ESPERADO: 113.1
print(calcularArea(5))  # VALOR ESPERADO: 78.54
print(calcularArea(34))  # VALOR ESPERADO: 3631.68
print(calcularArea(30.5))  # VALOR ESPERADO: 2922.47
print(calcularArea(recepcion()))    # VALOR ESPERADO: indicado por el usuario

#   fuente de los valores esperados: http://www.calculararea.com/circulo.htm

#   appEnd