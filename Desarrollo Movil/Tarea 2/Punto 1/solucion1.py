""" Resolución Punto 1: 
    Jose David, se encuentra ahorrando para comprar una maleta que vale 105.000$ 
    En la casa le han dado para sus gastos 24.000$ pesos durante 4 semanas
    Por atender la tienda recibió 36.000$ 
    Sur hermano Juan Antonio gano 23.000$ por limpiar la piscina  y cuidar la tienda.
    ¿Jose David tiene el dinero suficiente para comprar la maleta o aun le falta?

    Resolvemos el problema con pseudo-codigo:

INICIO
    Total_Ahorros = 0
    Maleta_Precio = 105000
    Dinero_Semanal = 24000
    Semanas = 4
    Dinero_Por_Atender_Tienda = 36000
    Dinero_Hermano = 23000 (este no cuenta porque no indica que se lo de a su hermano)

    Total_Ahorros = Dinero_Semanal * Semanas + Dinero_Por_Atender_Tienda

    SI Total_Ahorros >= Maleta_Precio ENTONCES
        ESCRIBIR "Jose David tiene suficiente dinero para comprar la maleta."
    SINO
        ESCRIBIR "Jose David no tiene suficiente dinero para comprar la maleta. Le falta dinero."
    FIN SI
FIN

"""
#----------------------DECLARACIÓN DE PARÁMETROS---------------------
Total_Ahorros = 0           #   dinero ahorrado total
Maleta_Precio = 105000      #   precio de la maleta a comprar
Dinero_Semanal = 24000      #   dinero que recibe Jose cada semana para sus gastos
#Semanas = 1                 #   semanas que lleva ahorrando Jose
Dinero_Por_Atender_Tienda = 36000   #   dinero extra ganado por tareas concretas
Dinero_Hermano = 23000      #   dinero del hermano (dato no computable porque no dice en el problema que se lo de)
#------------------------ZONA DE CÓDIGO------------------------
""" Este Método Indica si Jose tiene el dinero suficiente para la maneta o no dependiendo de una cantidad de semanas ahorradas
        parámetros: 
            Total_Ahorros: dinero ahorrado total
            Maleta_Precio: precio de la maleta a comprar
            Dinero_Semanal: dinero que recibe Jose cada semana para sus gastos
            Semanas: semanas que lleva ahorrando Jose
            Dinero_Por_Atender_Tienda: dinero extra ganado por tareas concretas
        return:
            msg: mensaje con el resultado.
"""
def calcular_ahorros(Semanas):
    Total_Ahorros = (Dinero_Semanal * Semanas) + Dinero_Por_Atender_Tienda 

    if Total_Ahorros >= Maleta_Precio:
        print("Jose David tiene suficiente dinero para comprar la maleta.")
    else:
        print("Jose David no tiene suficiente dinero para comprar la maleta. Le falta dinero.")

#-------------------------ZONA DE TEST 1-----------------------
""" Función encargada de repetir el algoritmo para hacer varios tests para ver el comportamiento del ahorro al correr de las semanas
"""
def repTest():
    estado = True
    contador = 0
    Semanas = 0
    while estado:
        print (calcular_ahorros(Semanas))
        contador += 1
        Semanas += 1
        if contador == 5:
            estado = False

repTest()

#   appEnd
