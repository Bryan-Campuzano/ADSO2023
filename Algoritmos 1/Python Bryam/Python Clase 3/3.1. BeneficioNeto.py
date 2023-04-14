""" este Script permite calcular el beneficio neto de una empresa procesando los ingresos y los gastos de la misma
"""
#------------------------ZONA DE CÓDIGO 1------------------------

""" esta función esta encargada de recibir la informacion necesaria para el funcionamiento del método calcularNeto
    return: lista: lista de registros de ingresos y gastos
"""
def recepcion():
    estado = True
    lista = []
    while estado == True:
        elemento = {'tipo' :"gasto",'cant' :0} 
        tipoIn = input("indique el tipo de valor a registrar (ingreso o gasto): ")
        cantIn = float(input("indique el valor a registrar: "))
        elemento['tipo'] = tipoIn
        elemento['cant'] = cantIn
        lista.append(elemento)
        seguir = input("¿desea agregar otro movimiento (si/no)?: ")
        if seguir.lower() == "no":
            estado = False
    return lista

""" esta función calcula el beneficio neto de un registro de ingresos y gastos
    parámetros: registro: 
    return: msg: mensaje con el resultado de la operación
"""
def calcularNeto(registro):
    ingresos = 0
    gastos = 0
    for movimiento in registro:
        if movimiento['tipo'] == 'ingreso':
            ingresos += movimiento['cant']
        else:
            gastos += movimiento['cant']
    beneficio_neto = ingresos - gastos
    return f"El beneficio neto de la empresa es: {beneficio_neto}"    
    
#-------------------------ZONA DE TEST 1-------------------------

print(calcularNeto(recepcion()))
print(recepcion())

#   appEnd