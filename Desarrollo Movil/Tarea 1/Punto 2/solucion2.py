""" Resolución Punto 2: 
    a la mama de juan le preguntan su edad, esta contesta: “tengo 3 hijos, 
    a juan pregúntale su edad, Alberto tiene 2/3 de la edad de juan. 
    Ana tiene 4/3 de la edad de juan, mi edad es la suma de los 3” 
    realiza un algoritmo que muestre la edad de los 4.
"""
#------------------------IMPORTACIONES---------------------------
from functools import reduce
#----------------------DECLARACIÓN DE PARÁMETROS---------------------
max_intentos = 3  # Número máximo de intentos
Alberto = 2/3
Ana = 4/3
#------------------------ZONA DE CÓDIGO------------------------
""" Este Método solicita el valor correspondiente a la edad de Juan y verifica 
        return:
            edad: edad de juan indicada por consola, msg de error de lo contrario
"""
def recepcionEdad():
    for intento in range(max_intentos):
        # Entrada de un valor por consola
        edadStr = input("Por favor, ingresa la edad de Juan:")

        # Verificar si la entrada es un número entero válido
        if edadStr.isdigit():
            edad = int(edadStr)
            break  # Salir del bucle si se ingresa un número válido
        else:
            print("Error: Debes ingresar un número entero válido.")

    else:
        print("Has alcanzado el número máximo de intentos.")
        exit()  # Salir del programa si se alcanza el número máximo de intentos

    return edad

""" Este método calcula las edades de los diferentes miembros de la familia de juan
        parámetros: 
            edadJuan: la edad de juan indicada por el usuario mediante consola
        return:
            msg: mensaje con el resultado.
"""
def edadFamiliaJuan(edadJuan):
    edadMamaJuan = (Alberto * edadJuan)+(Ana * edadJuan)+(edadJuan)
    edadAlberto = Alberto * edadJuan
    edadAna = Ana * edadJuan
    msg = f"Las edades de la familia de Juan son: \n Edad de Juan: {edadJuan} \n Edad de Alberto: {edadAlberto} \n Edad de Ana: {edadAna} \n Edad de la Mama de Juan: {edadMamaJuan}"
    return msg
#-------------------------ZONA DE TEST 1-------------------------
"""función encargada de repetir el algoritmo para hacer varios test
"""
def repTest():
    estado = True
    contador = 0
    while estado == True:
        edad_juan = recepcionEdad()  # Llamamos a la función para obtener la edad de Juan
        print(edadFamiliaJuan(edad_juan))
        contador = contador + 1
        if contador == 5:
            estado = False

repTest()

#   appEnd
