""" Este Script Modela Una calculadora Básica (suma, resta, multiplicación y división)
"""
#------------------------IMPORTACIONES---------------------------
import math
#------------------------ZONA DE CÓDIGO 1------------------------
""" Este método se encarga de recibir datos desde consola para generar casos concretos funcionales para el método calculadora
        retorna:    lista: retorna los datos necesarios para la operación del método calculadora en una lista ordenada
"""
def recepcion():
    num1 = int(input("Digite el primer numero a operar: "))
    num2 = int(input("Digite el primer segundo a operar: "))
    op = input("Digite el operador de la operación a realizar")
    lista = [num1,num2,op]
    return lista

""" Este método se encarga, dados dos valores numéricos y un operador valido. dependiendo el operador, ejecuta la  operación aritmética seleccionada
        parámetros: x: primer numero a operar
                    y: segundo numero a operar
                    operador: indica la operación a ejecutar
        retorna:    msg: mensaje en cadena de caracteres con la respuesta de la ecuación 
"""
def calculadora(x,y,operador):
    resultado = 0
    msg = ""
    if operador == "+":
        # Suma
        resultado = x+y
        msg = f'suma: {resultado}'
    elif operador == "-":
        # resta
        resultado = x-y
        msg = f'resta: {resultado}'
    elif operador == "*":
        # multiplicación
        resultado = x*y
        msg = f'multiplicación: {resultado}'
    elif operador == "/":
        # division
        resultado = x/y
        msg = f'división: {resultado}'
    else:
        print("Indique Operador Valido")
    return msg

#-------------------------ZONA DE TEST 1-------------------------
print(calculadora(10,20,"+"))
print(calculadora(10,20,"-"))
print(calculadora(10,20,"*"))
print(calculadora(10,20,"/"))
print(calculadora(10,20,"g"))
datos = recepcion()
print(calculadora(datos[0],datos[1],datos[2]))

#   appEnd