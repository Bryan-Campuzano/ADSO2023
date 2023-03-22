""" Este Script indica una nota Alfabética a una nota numérica dada
"""
#------------------------ZONA DE CÓDIGO 1------------------------
"""Este método se encarga de, dada una nota en numérico, dar su valor en un mensaje calificativo
        parámetros: nota: la nota en numérico
        retorna:    msg: mensaje con la calificacion en literales
"""
def calificacion(nota):
    msg = ""
    if nota >= 90:
        msg = "Excelente"
    elif nota >= 80:
        msg = "Bueno"
    elif nota >= 70:
        msg = "Aceptable"
    else:
        msg = "Reprobado"
    return msg
#-------------------------ZONA DE TEST 1-------------------------
print(f'Su Nota Es: {calificacion(95)}')
print(f'Su Nota Es: {calificacion(90)}')
print(f'Su Nota Es: {calificacion(85)}')
print(f'Su Nota Es: {calificacion(80)}')
print(f'Su Nota Es: {calificacion(75)}')
print(f'Su Nota Es: {calificacion(70)}')
print(f'Su Nota Es: {calificacion(60)}')
print(f'Su Nota Es: {calificacion(55)}')

#   appEnd