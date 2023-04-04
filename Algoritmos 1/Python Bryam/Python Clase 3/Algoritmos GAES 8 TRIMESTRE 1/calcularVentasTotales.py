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

ventasC1 = [producto1,producto2,producto3]                                                                                       #   Lista contenedora de los productos

#------------------------ZONA DE CÓDIGO 1------------------------

""" esta función calcula las ventas totales de un catalogo de insumos
    parámetros: parCatalogo: informacion de los insumos que se pretende agregar al catalogo
    return: msg: mensaje con el resultado de la Operacion 
"""
def ventasTotales (parCatalogo):
    msg = ""                                                                                        #   inicializamos el mensaje de retorno
    sumaTotal = 0.0
    for i in range (len(parCatalogo)):
        productoActual = parCatalogo[i]
        sumaParcial = 0.0 
        if productoActual is None:
            None
        else:
            sumaParcial = productoActual['cantidadVendida'] * productoActual['valorUnidad']
            sumaTotal += sumaParcial
    msg = f"la suma de las ventas totales del catalogo dado es: {sumaTotal}"
    return msg
#-------------------------ZONA DE TEST 1-------------------------

print(ventasTotales(ventasC1))

#   appEnd