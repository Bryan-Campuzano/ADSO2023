""" Resolución Punto 1: 
    
    Elaborar un programa para  calcular e imprimir el precio 

    Resolvemos el problema con pseudo-codigo:

"""
#----------------------DECLARACIÓN DE PARÁMETROS---------------------
max_intentos = 3    # Número máximo de intentos
anio1 = 0           # primera fecha para el calculo de meses
anio2 = 0           # segunda fecha para el calculo de meses
#------------------------ZONA DE CÓDIGO------------------------
""" Este Método solicita el valor correspondiente a las fechas limites de la cantidad de meses a calcular
        return:
            anio1: fecha de inicio de la cuenta
            anio2: fecha del final de la cuenta
"""
def recepcionFechas():
    for intento in range(max_intentos):
        # Entrada de un valor por consola
        anio1Str = input("Por favor, ingresa el primer el primer año:")
        anio2Str = input("Por favor, ingresa el primer el segundo año:")

        # Verificar si la entrada es un número entero válido
        if anio1Str.isdigit() and anio2Str.isdigit():
            anio1 = int(anio1Str)
            anio2 = int(anio2Str)
            break  # Salir del bucle si se ingresa un número válido
        else:
            print("Error: Debes ingresar un número entero válido.")

    else:
        print("Has alcanzado el número máximo de intentos.")
        exit()  # Salir del programa si se alcanza el número máximo de intentos

    return anio1,anio2

""" Este Método calcula la diferencia en meses entre dos fechas
        parámetros: 
            anio1: fecha de inicio de la cuenta
            anio2: fecha del final de la cuenta
        return:
            msg: mensaje con el resultado.
"""
def calcularDiferenciaEnMeses(anio1, anio2):
    fecha1 = datetime(anio1, 1, 1)  #   indicamos con este método una fecha con un año dado e indicamos el primero de enero con el 1,1 de los siguientes parámetros
    fecha2 = datetime(anio2, 1, 1)
    diferencia = fecha2 - fecha1    #   cantidad de Dias transcurridos entre ambas fechas
    meses_transcurridos = int(diferencia.days / 30.44)  # Promedio de días por mes
    msg = f"Los meses transcurridos entre {anio1} y {anio2} son: \n{meses_transcurridos} meses"
    return msg
#-------------------------ZONA DE TEST 1-----------------------
""" Función encargada de repetir el algoritmo para hacer varios tests
"""
def repTest():
    estado = True
    contador = 0
    while estado:
        anio1, anio2 = recepcionFechas()  # Llamamos a la función para obtener los años
        meses_transcurridos = calcularDiferenciaEnMeses(anio1, anio2)
        print(meses_transcurridos)
        contador += 1
        if contador == 5:
            estado = False

repTest()

#   appEnd
