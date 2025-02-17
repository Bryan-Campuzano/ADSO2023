# funcion que se encarga de calcular el factorial de un numero entero dado
def calcFactorial(parNum):
    if parNum == 0:
        return 1
    else:
        resultado = parNum * calcFactorial(parNum -1)
        return resultado
    
# ejecutamos la aplicacion
calcular = calcFactorial(int(input("Bienvenido a la calculadora de Factoriales, por favor, indique el numero entero con el cual quiere calcular: \n")))
print (f"el resultado es: {calcular}")