# Bryan Alexander Campuzano Giraldo
# GAES 8
# Programa: ADSO
# Código Fuente: autoría propia

# importanciones necesarias para el funcionamiento
import numpy as np
from numpy.linalg import inv
from numpy.linalg import det

matriz = np.zeros((5,5))

#metodo que se encarga de poblar la matriz de datos mediante terminal
def poblar():
    print("Introduce los elementos de la matriz 5x5:")
    for i in range(5):
        for j in range(5):
            while True:
                try:
                    valor = int(input(f"Introduce el valor para la posición ({i}, {j}): "))
                    matriz[i, j] = valor
                    break
                except ValueError:
                    print("Por favor, introduce un número válido.")
    print("Matriz poblada de datos satisfactoriamente")
    return matriz

# funcion que calcula la transpuestas
def traspuesta (parMatriz):
    return parMatriz.transpose()

# funcion que calcula la inversas
def inversa (parMatriz):
    return inv(parMatriz)

# funcion que calcula el determinante
def determinante (parMatriz):
    return det(parMatriz)

# lista de metodos relacionados con el gestor de Matrices
metodos = [poblar,traspuesta,inversa,determinante]

# metodo principal que modela la ejecucion del Operador de matrices
def gestorMatrices(funciones):
    activo = True
    while activo:
        print("Bienvenido al Gestor de Matrices por favor seleccione una opcion: \n")
        opcion = input("Seleccione una opción: \n 1. Poblar matriz de datos \n 2. Calcular traspuesta \n 3. Calcular inversa \n 4. Calcular Determinante \n 5. Salir del Sistema \n")
        if opcion == "1":
            funciones[0]()    
        elif opcion == "2":
            buscado = funciones[1](matriz)
            print(f"la traspuesta de la matriz \n {matriz} es \n {buscado}")  
        elif opcion == "3":
            buscado = funciones[2](matriz)
            print(f"la inversa de la matriz \n {matriz} es \n {buscado}") 
        elif opcion == "4":
            buscado = funciones[3](matriz)
            print(f"el determinante de la matriz \n {matriz} es \n {buscado}") 
        elif opcion == "5":
            print("Saliendo del sistema. \n GRACIAS POR USAR EL SISTEMA DE GESTION DE MATRICES")
            activo = False
        else:
            print("Opción no válida, por favor intente de nuevo.")

# ejecutamos el metodo principal para arrancar el sistema
gestorMatrices(metodos)