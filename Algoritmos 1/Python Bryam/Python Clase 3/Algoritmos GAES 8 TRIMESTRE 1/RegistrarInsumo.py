""" Este algoritmo se encarga de registrar nuevos productos a un catalogo de productos existentes
"""
#------------------------INICIALIZACION--------------------------

catalogo = []                                                                                       #   Lista contenedora de los productos

#------------------------ZONA DE CÓDIGO 1------------------------

""" esta función esta encargada de recibir la informacion necesaria para el funcionamiento del método agregarInsumo
    return: datos: listas con los datos necesarios para crear un insumo
"""
def recepcion():
    cod = input("Ingrese el codigo del insumo: ")                                                   #   solicitamos los datos del insumo al usuario
    nombre = input("Ingrese el Nombre del insumo: ")
    cant = input("Ingrese la cantidad de unidades: ")
    datos = [cod,nombre,cant]                                                                       #   los unificamos en una lista
    return datos                                                                                    #   la retornamos

""" esta función agrega un Insumo al catalogo dados unos datos de entrada
    parámetros: listaDatos: informacion de los insumos que se pretende agregar al catalogo
    return: msg: mensaje con el resultado de la Operacion 
"""
def agregarInsumo (listaDatos):
    msg = ""                                                                                        #   inicializamos el mensaje de retorno
    producto = {                                                                                    #   creamos un diccionario llamado 'producto' con los datos brindados
        'codigo' : listaDatos [0],
        'nombre' : listaDatos[1],
        'cantidad' : listaDatos[2]
    }
    
    if listaDatos[0] is None:                                                                       #   verificamos si los datos dados son validos, si no lo son, retornamos mensaje de error
        msg = "*** INSUMO NO INGRESADO *** \n Tiene que indicar un valor para el CODIGO"
    elif listaDatos[1] is None:
        msg = "*** INSUMO NO INGRESADO *** \n Tiene que indicar un valor para el NOMBRE"
    elif listaDatos[2] is None:
        msg = "*** INSUMO NO INGRESADO *** \n Tiene que indicar un valor para la CANTIDAD"
    else:                                                                                           #   si los datos son validos, retornamos mensaje afirmativo y agregamos el producto al catalogo
        msg = f"***INSUMO INGRESADO CORRECTAMENTE *** \n el insumo con codigo: {listaDatos [0]} \n nombre: {listaDatos [1]} \n y cantidad: {listaDatos [2]} ha sido agregado correctamente"
        catalogo.append(producto) 
    return msg
    
#-------------------------ZONA DE TEST 1-------------------------

""" método para hacer test reiterativos una cantidad estipulada de repeticiones
"""
def repTest():
    estado = True
    contador = 0
    while estado == True:
        print(agregarInsumo(recepcion()))
        print(catalogo)
        contador = contador + 1
        if contador == 5:
            estado = False

repTest()

#   appEnd