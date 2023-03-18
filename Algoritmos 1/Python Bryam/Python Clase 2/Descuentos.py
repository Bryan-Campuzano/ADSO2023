""" Este Script modela una calculadora de descuentos, dados un valor y un porcentage de descuento, arroja el precio final calculado
"""
def recepcion():
    val = float(input("Digite el precio del articulo en promoción: "))
    porc = int(input("Digite El porcentage de descuento a aplicar: "))
    lista = [val,porc]
    return lista

def calDescuentos(valor,porcentaje):
    
    msg = ""

    if porcentaje <= 30:
        descuento = (valor/100) * porcentaje
        total = valor - descuento
        msg = f"El Valor final despues del descuento es: {total}"
    else:
        msg = "El descuento es Incorrecto, la promoción es de máximo 30 porciento de descuento"
    return msg

datos = recepcion()
print(calDescuentos(datos[0],datos[1]))