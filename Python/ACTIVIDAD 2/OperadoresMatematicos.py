# Bryan Alexander Campuzano Giraldo
# GAES 8
# Programa: ADSO
# Código Fuente: autoría propia

# Desarrolle una aplicación en Python que solicite al usuario ingresar dos números decimales (del tipo float).
# Luego, realice las cuatro operaciones matemáticas básicas: suma, resta, multiplicación y división.
# Utilice la función format() para presentar el resultado de cada operación.
# El formato del mensaje debe seguir este patrón: "El resultado de a + b es igual a resultado".

# Solicitar al usuario ingresar dos números decimales
num1 = float(input("Ingrese el primer número decimal: "))
num2 = float(input("Ingrese el segundo número decimal: "))

# Realizar las operaciones matemáticas básicas
suma = num1 + num2
resta = num1 - num2
multiplicacion = num1 * num2
# Manejar el caso de división por cero
if num2 != 0:
    division = num1 / num2
else:
    division = "Indefinida (división por cero no es posible)"

# Presentar los resultados utilizando la función format()
print(format("El resultado de {} + {} es igual a {}".format(num1, num2, suma)))
print(format("El resultado de {} - {} es igual a {}".format(num1, num2, resta)))
print(format("El resultado de {} * {} es igual a {}".format(num1, num2, multiplicacion)))
print(format("El resultado de {} / {} es igual a {}".format(num1, num2, division)))
