def calcImpar(num):
    if num == 1:
        return "el numero es impar"
    elif num == 0:
        return "el numero es par"
    else:
        resultado = num - 2
        return calcImpar(resultado)
    
# ejecutamos la aplicacion
calcular = calcImpar(int(input("Bienvenido a la calculadora de impares, por favor, indique el numero entero con el cual quiere calcular: \n")))
print (calcular)