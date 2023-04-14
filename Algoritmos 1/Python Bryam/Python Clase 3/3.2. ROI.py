""" este Script permite calcular el ROI(Return on Investment, en inglés) de una campaña publicitaria
"""
#------------------------ZONA DE CÓDIGO 1------------------------

""" esta función esta encargada de recibir la informacion necesaria para el funcionamiento del método ROI
    return: lista: lista de registros de ingresos y gastos
"""
def recepcion():
    elemento = {'inversion' :0 ,'ganancias' :0}
    invIn = float(input("indique la inversion de la campaña: "))
    ganIn = float(input("indique las ganancias de la campaña: "))
    elemento['inversion'] = invIn
    elemento['ganancias'] = ganIn
    return elemento

""" esta función calcula el beneficio neto de un registro de ingresos y gastos
    parámetros: registro: 
    return: msg: mensaje con el resultado de la operación
"""
def ROI(invGan):
    inversion = invGan['inversion']
    ganancias = invGan['ganancias']
    roi = (ganancias - inversion) / inversion * 100
    return f"El Retorno de inversion de la campaña es: {roi}"    
    
#-------------------------ZONA DE TEST 1-------------------------

print(ROI(recepcion()))

#   appEnd