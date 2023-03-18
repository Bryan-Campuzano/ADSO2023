""" Este Script indica una nota Alfabetica a una nota numerica dada
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

print(f'Su Nota Es: {calificacion(95)}')
print(f'Su Nota Es: {calificacion(90)}')
print(f'Su Nota Es: {calificacion(85)}')
print(f'Su Nota Es: {calificacion(80)}')
print(f'Su Nota Es: {calificacion(75)}')
print(f'Su Nota Es: {calificacion(70)}')
print(f'Su Nota Es: {calificacion(60)}')
print(f'Su Nota Es: {calificacion(55)}')
