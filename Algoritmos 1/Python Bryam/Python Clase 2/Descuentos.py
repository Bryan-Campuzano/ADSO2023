""" Este Script modela una calculadora de descuentos, dados un valor y un porcentaje de descuento, arroja el precio final calculado
"""
#------------------------ZONA DE CÓDIGO 1------------------------
""" Este método se encarga de recibir datos desde consola para generar casos concretos funcionales para el método calDescuentos
        retorna:    lista: retorna los datos necesarios para la operación del método calDescuentos en una lista ordenada
"""
def recepcion():
    val = float(input("Digite el precio del articulo en promoción: "))
    porc = int(input("Digite El porcentaje de descuento a aplicar: "))
    lista = [val,porc]
    return lista

""" Este método se encarga de, dado el valor de un producto y un porcentaje de descuento, calcular y entregar el precio con el descuento realizado. si el descuento es mayor 
    al 30, retorna un mensaje de error
        parámetros: valor: valor del producto
                    porcentaje: descuento a realizar 
        retorna:    msg: mensaje en cadena de caracteres con la respuesta de la ecuación
"""
def calDescuentos(valor,porcentaje):
    
    msg = ""

    if porcentaje <= 30:
        descuento = (valor/100) * porcentaje
        total = valor - descuento
        msg = f"El Valor final después del descuento es: {total}"
    else:
        msg = "El descuento es Incorrecto, la promoción es de máximo 30 por ciento de descuento"
    return msg

#-------------------------ZONA DE TEST 1-------------------------
datos = recepcion()
print(calDescuentos(datos[0],datos[1]))

#   appEnd