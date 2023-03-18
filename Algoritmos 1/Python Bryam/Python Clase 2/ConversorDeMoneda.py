""" Este Script modela un conversor de divisas, las divisas pueden ser escogidas por el usuario
"""
def recepcion ():
    entrada = input("Digite la Divisa de Origen(COP, USD o MXN)")
    salida = input("Digite la Divisa de salida(COP, USD o MXN)")
    cantidad = float(input("Digite la cantidad a convertir"))
    lista1 = [entrada,salida,cantidad]
    return lista1

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

print(conversor("USD","COP",50))
print(conversor("USD","MXN",50))
print(conversor("COP","USD",50))
print(conversor("COP","MXN",50))
print(conversor("MXN","USD",50))
print(conversor("MXN","COP",50))
datos = recepcion()
print(conversor(datos[0],datos[1],datos[2]))













