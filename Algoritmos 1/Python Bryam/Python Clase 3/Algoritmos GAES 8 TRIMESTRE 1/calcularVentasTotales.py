""" Este algoritmo se encarga de calcular las ventas totales del modulo de ventas
"""
#------------------------INICIALIZACION--------------------------

producto1 = {                                                                                       #   creamos variables operables para este caso
    'codigo' : 'bnd123',
    'nombre' : 'papelBond',
    'cantidadVendida' : 15,
    'valorUnidad': 600.0
}
producto2 = {
    'codigo' : 'car123',
    'nombre' : 'cartulina',
    'cantidadVendida' : 34,
    'valorUnidad': 200.0
}
producto3 = {
    'codigo' : 'lpz123',
    'nombre' : 'lápiz',
    'cantidadVendida' : 40,
    'valorUnidad': 1000.0
}

ventasC1 = [producto1,producto2,producto3]                                                          #   Lista contenedora de los productos

#------------------------ZONA DE CÓDIGO 1------------------------

""" esta función calcula las ventas totales de un catalogo de insumos
    parámetros: parCatalogo: informacion de los insumos que se pretende agregar al catalogo
    return: msg: mensaje con el resultado de la Operacion 
"""
def ventasTotales (parCatalogo):
    msg = ""                                                                                        #   inicializamos el mensaje de retorno
    sumaTotal = 0.0                                                                                 #   inicializamos una suma en cero para almacenar el total del valor de las ventas
    for i in range (len(parCatalogo)):                                                              #   recorremos el catalogo de ventas
        productoActual = parCatalogo[i]                                                             #   creamos una variable temporal con el diccionario (producto) actual
        sumaParcial = 0.0                                                                           #   inicializamos una suma parcial en cero, esta suma es el producto de la cantidad de elementos vendidos y su valor unitario
        if productoActual is None:                                                                  #   si el producto actual esta vacío, no hacemos nada
            None
        else:
            sumaParcial = productoActual['cantidadVendida'] * productoActual['valorUnidad']         #   hacemos el producto y lo guardamos en la suma total
            sumaTotal += sumaParcial
    msg = f"la suma de las ventas totales del catalogo dado es: {sumaTotal}"                        #   actualizamos el mensaje
    return msg                                                                                      #   retornamos el mensaje con el resultado de la operación
#-------------------------ZONA DE TEST 1-------------------------

print(ventasTotales(ventasC1))

#   appEnd