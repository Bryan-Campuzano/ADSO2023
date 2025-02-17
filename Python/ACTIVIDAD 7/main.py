# Bryan Alexander Campuzano Giraldo
# GAES 8
# Programa: ADSO
# Código Fuente: autoría propia

# importaciones necesarias
from cuenta import Cuenta

# Creamos las instancias de las cuentas a trabajar 

#cuenta 1
cuenta1 = Cuenta("Titular 1", 0)

#cuenta 2
cuenta2 = Cuenta("",0)

# Establecer nombre del titular y saldo utilizando los setters
cuenta2.nombre_titular = "Titular 2"
cuenta2.consignar(0)  # Inicia con saldo 0

# Consignación inicial de $5,000,000 en cada cuenta
print(cuenta1.consignar(5000000))
print(cuenta1.consultar())
print("-" * 40)
    
print(cuenta2.consignar(5000000))
print(cuenta2.consultar())
print("-" * 40)

# Retirar un monto de $500,000 de cuenta1 y consignar en cuenta2
print(cuenta1.retirar(500000))
print(cuenta2.consignar(500000))
print(cuenta1.consultar())
print(cuenta2.consultar())
print("-" * 40)

# Transferir un monto de $800,000 de cuenta1 a cuenta2
print(cuenta1.transferir(800000, cuenta2))
print(cuenta1.consultar())
print(cuenta2.consultar())
print("-" * 40)
