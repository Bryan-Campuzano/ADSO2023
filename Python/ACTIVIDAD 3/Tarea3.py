# Bryan Alexander Campuzano Giraldo
# GAES 8
# Programa: ADSO
# Código Fuente: autoría propia

# Desarrolle una aplicación en Python que solicite al usuario ingresar dos números decimales (del tipo float). Luego, realice las cuatro operaciones matemáticas básicas: suma, resta, multiplicación y división. La aplicación debe hacer uso de conceptos avanzados sobre el manejo de funciones en Python, como la asignación de funciones a variables, el paso de funciones como argumentos, el retorno de funciones desde otras funciones y el almacenamiento de funciones en estructuras de datos.

# Requisitos Técnicos
# Uso de Funciones:

#    Defina funciones para cada operación matemática básica (suma, resta, multiplicación, división).
#    Incluya una función para leer números decimales del usuario.
#    Use funciones para organizar el flujo de la aplicación.

# Conceptos Avanzados de Funciones:

#    Asignación a Variables: Asigne las funciones de operación a variables.
#    Paso como Argumentos: Pase las funciones de operación como argumentos a otra función.
#    Retorno desde Otras Funciones: Tenga una función que retorne otra función basada en un nombre.
#    Almacenamiento en Estructuras de Datos: Almacene las funciones de operación en un diccionario y use este diccionario para realizar las operaciones.

# Uso de format():

#    Utilice la función format() para construir y presentar los mensajes de resultados.
#    El formato del mensaje debe seguir este patrón: "El resultado de la {operación} de {a} y {b} es igual a {resultado}".
#    Mantenga la claridad y la coherencia en los mensajes de salida.

# funcion de solicitud de datos
def scaner():
    num1 = float(input("Introduzca el primer factor: "))
    num2 = float(input("Introduzca el primer factor: "))
    scan = [num1,num2]
    return scan

# funcion de suma
def suma(factor1,factor2):
    return factor1 + factor2

# funcion de resta
def resta(factor1,factor2):
    return factor1 - factor2

# funcion de multiplicacion
def multiplicacion(factor1,factor2):
    return factor1 * factor2

# funcion de division
def division(factor1,factor2):
    if factor2 != 0:
        division = factor1 / factor2
    else:
        division = "Indefinida (división por cero no es posible)"
    return division

# diccionario de funciones
funciones = [scaner,suma,resta,multiplicacion,division]
funcionesDef = ["scaner","Suma","Resta","Multiplicacion","Division"]

# funcion principal del fichero, ejecuta todas las funciones de la calculadora
def calculadora (parFunciones,parFuncionesDef):
    msg = ""
    factores = parFunciones[0]()
    seleccion = int(input("Seleccione la operacion a realizar con los valores dados \n SUMA = 1 \n RESTA = 2 \n MULTIPLICACION = 3 \n DIVISION = 4 \n"))
    if seleccion >=1 and seleccion <= 4:
        operacion = parFunciones[seleccion]
        resultado = operacion(factores[0],factores[1])
        msg = "El resultado de la {} de {} y {} es igual a {}".format(parFuncionesDef[seleccion],factores[0],factores[1],resultado)
    else:
        msg = "Introduzca una opcion valida"
    return msg

# ejecutamos la funcion
print(calculadora(funciones,funcionesDef))