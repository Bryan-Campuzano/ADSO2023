""" Este Script modela un conversor de divisas, las divisas pueden ser escogidas por el usuario
"""
#------------------------ZONA DE CÓDIGO 1------------------------
""" Este método se encarga de recibir datos desde consola para generar casos concretos funcionales para el método conversor
        retorna:    lista: retorna los datos necesarios para la operación del método conversor en una lista ordenada
"""
def recepcion ():
    entrada = input("Digite la Divisa de Origen(COP, USD o MXN)")
    salida = input("Digite la Divisa de salida(COP, USD o MXN)")
    cantidad = float(input("Digite la cantidad a convertir"))
    lista1 = [entrada,salida,cantidad]
    return lista1

""" Este método se encarga, dados dos siglas que indicar una divisa y una cantidad. dependiendo las divisas y el orden
    convierte la cantidad de una divisa de entrada a una divisa de salida
        parámetros: entrada: divisa de origen
                    salida: divisa de salida
                    cantidad: dinero a convertir
        retorna:    msg: mensaje en cadena de caracteres con la respuesta de la ecuación
"""
def conversor(entrada,salida,cantidad):
    canSal = 0
    msg = ""
    
    if   entrada == "COP" and salida == "USD":
        canSal = cantidad * 0.00021    
        msg = f"la cantidad de {salida} equivalente a {cantidad} {entrada} es: {canSal}"    
    elif entrada == "COP"and salida == "MXN":
        canSal = cantidad * 0.0039
        msg = f"la cantidad de {salida} equivalente a {cantidad} {entrada} es: {canSal}" 
    elif entrada == "USD" and salida == "COP":
        canSal = cantidad * 4850.50
        msg = f"la cantidad de {salida} equivalente a {cantidad} {entrada} es: {canSal}" 
    elif entrada == "USD" and salida == "MXN":
        canSal = cantidad * 18.91  
        msg = f"la cantidad de {salida} equivalente a {cantidad} {entrada} es: {canSal}"  
    elif entrada == "MXN" and salida == "COP":
        canSal = cantidad * 256.51
        msg = f"la cantidad de {salida} equivalente a {cantidad} {entrada} es: {canSal}" 
    elif entrada == "MXN" and salida == "USD":
        canSal = cantidad * 0.053
        msg = f"la cantidad de {salida} equivalente a {cantidad} {entrada} es: {canSal}" 
    else:
        msg = "Digite una Divisa Valida"
    
    return msg

#-------------------------ZONA DE TEST 1-------------------------
print(conversor("USD","COP",50))
print(conversor("USD","MXN",50))
print(conversor("COP","USD",50))
print(conversor("COP","MXN",50))
print(conversor("MXN","USD",50))
print(conversor("MXN","COP",50))
datos = recepcion()
print(conversor(datos[0],datos[1],datos[2]))

#   appEnd













