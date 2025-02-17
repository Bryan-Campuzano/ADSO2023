# Bryan Alexander Campuzano Giraldo
# GAES 8
# Programa: ADSO
# Código Fuente: autoría propia

# Creamos la clase que modela la entidad cuenta
class Cuenta:
# modelamos el constructor de la entidad
    def __init__(self,nombre_titular,saldo):
        self.nombre_titular = nombre_titular
        self.saldo = saldo

# Método que imprime los datos de la cuenta (nombre del titular y saldo)
    def consultar(self):
        return f"Los datos de la cuenta son los siguientes: \n Titular: {self.nombre_titular} \n Saldo: {self.saldo}"

# Método que agrega un monto al saldo de la cuenta
    def consignar(self,monto):
        total = self.saldo + monto
        self.saldo = total
        return f"el monto {monto} ha sido agregado con exito \n Saldo actual: {total}"
    
# Método que resta un monto del saldo de la cuenta si hay fondos suficientes. Si el monto a retirar es mayor que el saldo actual, mostrar un mensaje indicando que no hay fondos suficientes para realizar la operación.
    def retirar(self,monto):
        msg = ""
        if monto <= self.saldo:
            total = self.saldo - monto
            self.saldo = total
            msg = f"el monto {monto} ha sido retirado con exito \n Saldo actual: {total}"
        else:
            msg = "Saldo Insuficiente para efectuar la operacion"
        return msg

# Método que transfiere un monto desde la cuenta actual a otra cuenta destino. Si el monto a transferir es mayor que el saldo actual, mostrar un mensaje indicando que no hay fondos suficientes para realizar la operación.
    def transferir(self,monto,cuenta_destino):
        msg = ""
        if monto <= self.saldo:
            self.retirar(monto)
            cuenta_destino.consignar(monto)
            msg = f"Saldo Transferido de {self.nombre_titular} a {cuenta_destino.nombre_titular}"
        else:
            msg = "Saldo Insuficiente para efectuar la operacion"
        return msg