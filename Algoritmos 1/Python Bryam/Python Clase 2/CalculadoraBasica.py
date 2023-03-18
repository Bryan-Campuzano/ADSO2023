""" Hacemos Las importaciones Necesarias
"""
import math
""" Este Script Modela Una calculadora Básica (suma, resta, multiplicación y división)
"""
def recepcion():
    num1 = int(input("Digite el primer numero a operar: "))
    num2 = int(input("Digite el primer segundo a operar: "))
    op = input("Digite el operador de la operación a realizar")
    lista = [num1,num2,op]
    return lista

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
        # multiplicación
        resultado = x*y
        print(f'multiplicación: {resultado}')
    elif operador == "/":
        # division
        resultado = x/y
        print(f'división: {resultado}')
    else:
        print("Indique Operador Valido")


print(calculadora(10,20,"+"))
print(calculadora(10,20,"-"))
print(calculadora(10,20,"*"))
print(calculadora(10,20,"/"))
print(calculadora(10,20,"g"))
datos = recepcion()
print(calculadora(datos[0],datos[1],datos[2]))