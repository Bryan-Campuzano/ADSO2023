""" este Script permite encontrar el MCD (Máximo Común Divisor) entre dos números, el MCD es el numero de mayor valor que es capaz
    de dividir sin residuo los dos números dados 
"""
#------------------------ZONA DE CÓDIGO 1------------------------

""" esta función esta encargada de recibir la informacion necesaria para el funcionamiento del método mcd
    return: lista: pareja de números a operar
"""
def recepcion():
    num1 = int(input("Indique el primero numero entero a comprobar "))
    num2 = int(input("Indique el segundo numero entero a comprobar "))
    lista = [num1,num2]
    return lista

""" esta función determina el máximo común divisor entre 2 números dados
    parámetros: num1: numero entero positivo 
                num2: numero entero positivo 
    return: msg: mensaje con el resultado de la operación
"""
def mcd(num1,num2):
    divComunes = []                                     #   creamos una lista que guarde los divisores exactos de ambos números
    maxDiv = 1                                          #   variable que guarda el MCD de ambos números
    limite = 0                                          #   establecemos un limite para el recorrido igual al numero mas grande, esto lo hacemos para poder encontrar todos los divisores
    if num1 > num2:                                     #   por ejemplo, si usáramos 12 y 24, estableciendo el numero 12 como limite, perderíamos informacion de los divisores del 24
        limite = num1
    else:
        limite = num2
        
    for j in range(1,limite+1):
            if num1 % j == 0 and num2 % j == 0:         #   la condición para agregar un divisor común a la lista es que, lógicamente, sea un divisor exacto de ambos
                divComunes.append(j)    
    
    for k in range(len(divComunes)):                    #   buscamos en la lista de divisores comunes, el numero mas grande con este ciclo
        if divComunes[k] >= maxDiv:
            maxDiv = divComunes[k]
    msg = f"el MCD de {num1} y {num2} es: {maxDiv}"     #   retornamos el mensaje con el resultado de la operación
    return msg
    
    
#-------------------------ZONA DE TEST 1-------------------------

datos = recepcion()                     #   creamos una lista temporal con los valores dados por el usuario
print(mcd(datos[0],datos[1]))           #   ejecutamos el método 'mcd' con la informacion suministrada


#   appEnd