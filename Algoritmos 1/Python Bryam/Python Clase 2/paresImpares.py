""" Hacemos las importaciones necesarias
"""
import math
""" Este Script, dado un numero por el usuario, determina si este es par o impar
"""
def recepcion():
    a = int(input("Introduzca el numero a operar"))
    return a

def parImpar(num):
    msg = ""
    if num%2==0:
        msg = "El Numero es par"
    else:
        msg = "El numero es Impar"
    return msg

print(parImpar(1))
print(parImpar(2))
print(parImpar(3))
print(parImpar(4))
print(parImpar(5))
print(parImpar(recepcion()))
