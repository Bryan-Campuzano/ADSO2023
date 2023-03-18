""" Hacemos Las importaciones Necesarias
"""
import math
""" Este Script Modela Una calculadora Basica (suma, resta, multiplicación y división)
"""
a = 10
b = 15
def calculadora(x,y,):
    resultado = 0
    
    # Suma
    resultado = x+y
    print(f'suma: {resultado}')
    
    # resta
    resultado = x-y
    print(f'resta: {resultado}')
    
    # multiplicacion
    resultado = x*y
    print(f'multiplicación: {resultado}')
    
    # division
    resultado = x/y
    print(f'División: {resultado}')
    
        

calculadora(a,b)
