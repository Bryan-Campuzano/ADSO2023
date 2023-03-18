""" Este Script convierte la temperatura de Grados Celsius a Farenheit
"""
temp1 = 15
temp2 = 150
temp3 = 300
temp4 = 450
temp5 = -346

def termometro(tempC):
    tempF = (tempC*1.8) + 32
    return tempF 

print(f'La temperatura en Farenheit es: {termometro(temp1)}')
print(f'La temperatura en Farenheit es: {termometro(temp2)}')
print(f'La temperatura en Farenheit es: {termometro(temp3)}')
print(f'La temperatura en Farenheit es: {termometro(temp4)}')
print(f'La temperatura en Farenheit es: {termometro(temp5)}')