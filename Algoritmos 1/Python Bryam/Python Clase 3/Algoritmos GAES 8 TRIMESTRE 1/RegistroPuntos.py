""" Este algoritmo se encarga de consultar la cantidad de puntos asociada a un cliente
"""
#------------------------INICIALIZACION--------------------------

puntos1 = {                                                                                         #   creamos variables operables para este caso
    'cédula' : 12345678,
    'cantPuntos' : 100
}
puntos2 = {                                                                                       
    'cédula' : 87654321,
    'cantPuntos' : 230
}
puntos3 = {                                                                                       
    'cédula' : 12349876,
    'cantPuntos' : 20
}

registroPuntos = [puntos1,puntos2,puntos3]                                                          #   Lista contenedora de los registros de puntos por cliente

#------------------------ZONA DE CÓDIGO 1------------------------

""" esta función esta encargada de recibir la informacion necesaria para el funcionamiento del método consultaPuntos
    return: datos: listas con los datos necesarios para registrar los puntos
"""
def recepcion():
    cedula = input("Ingrese la cedula del usuario: ")                                               #   solicitamos los datos al usuario                                                                                #   los unificamos en una lista
    return int(cedula)                                                                              #   retornamos los datos

""" esta función calcula busca un usuario registrado y retorna la cantidad de puntos de este usuario
    parámetros: parCedula: cedula del usuario para consultar
    return: msg: mensaje con el resultado de la Operacion 
"""
def ventasTotales (parCedula):
    msg = "la cedula indicada no se encuentra registrada en el sistema"                             #   creamos un mensaje estándar en caso de no encontrar el usuario buscado
    for i in range (len(registroPuntos)):                                                           #   recorremos la lista de los usuarios                      
        usuarioActual = registroPuntos[i]                                                           #   solicitamos el usuario actual
        if usuarioActual['cédula'] == parCedula:                                                    #   comparamos si este es el usuario que buscamos mediante comparación de su cedula
            puntosRetorno = usuarioActual['cantPuntos']                                             #   retornamos los puntos almacenados
            msg = f"el usuario con el numero de cedula {parCedula} tiene un total de: {puntosRetorno} puntos."  #   mensaje con el resultado de la operación
    return msg
#-------------------------ZONA DE TEST 1-------------------------

print(ventasTotales(12345678))
print(ventasTotales(87654321))
print(ventasTotales(12349876))
print(ventasTotales(recepcion()))

#   appEnd