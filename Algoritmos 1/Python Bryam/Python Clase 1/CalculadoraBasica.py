
""" Hacemos Las importaciones Necesarias
"""
import math
""" Este Script Modela Una calculadora Basica (suma, resta, multiplicación y división)
"""
a = 10
b = 15
def calculadora(x,y,operador):
    resultado = 0
    if operador == "+":
        # Suma
        resultado = x+y
        print(f'suma: {resultado}')
    elif operador == "-":
        # resta
        resultado = x-y
        print(f'resta: {resultado}')
    elif operador == "*":
        # multiplicacion
        resultado = x*y
        print(f'multiplicación: {resultado}')
    elif operador == "/":
        # division
        resultado = x/y
        print(f'división: {resultado}')
    else:
        print("Indique Operador Valido")

calculadora(a,b,"+")
calculadora(a,b,"-")
calculadora(a,b,"*")
calculadora(a,b,"/")
calculadora(a,b,"a")