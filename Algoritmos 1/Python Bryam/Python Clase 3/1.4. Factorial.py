""" este Script calcula el Factorial de un numero entero positivo dado, el factorial es el producto consecutivo de todos
    los enteros positivos menores o iguales al limite dado
        ejemplo: el factorial de 6 = 1*2*3*4*5*6 = 720
"""
#------------------------ZONA DE CÓDIGO 1------------------------

""" esta función esta encargada de recibir la informacion necesaria para el funcionamiento del método calFactorial
    return: radio: el numero a comprobar
"""
def recepcion():
    num = int(input("Indique el numero a calcular: "))
    return num

""" esta función determina si un numero es perfecto o no
    parámetros: perfecto: numero entero positivo cualquiera
    return: msg: mensaje de confirmación de la naturaleza del numero
"""
def calFactorial(limite):
    producto = 1                                                #   como vamos a hacer multiplicaciones consecutivas, el elemento neutro (que no cambia el valor de la multiplicación) es el 1
    for i in range (1,limite+1):                                #   por eso inicializamos la variable 'producto' como 1, asi mismo establecemos los limites del recorrido en 1 hasta el numero dado
        if i <= limite:
            producto = producto * i                             #   ejecutamos las multiplicaciones consecutivas
    msg = f"El factorial del numero {limite} es {producto}"     #   ofrecemos el resultado
    return msg
    
#-------------------------ZONA DE TEST 1-------------------------

print(calFactorial(recepcion()))

#   appEnd