# Bryan Alexander Campuzano Giraldo
# GAES 8
# Programa: ADSO
# Código Fuente: autoría propia

"""
Descripción:
Desarrolle un sistema para gestionar la información de empleados de una empresa. El sistema debe permitir agregar nuevos empleados, buscar empleados por su ID, eliminar empleados y listar todos los empleados existentes. El sistema debe usar un diccionario para almacenar la información de los empleados, donde la clave es el ID del empleado y el valor es otro diccionario que contiene información sobre el empleado (nombre, edad, departamento).

Requisitos:
Estructura del Diccionario:

    El diccionario principal tendrá como claves los ID de los empleados (números enteros).
    El valor asociado a cada clave será otro diccionario con información sobre el empleado:
    nombre: Nombre del empleado (cadena de caracteres).
    edad: Edad del empleado (entero).
    departamento: Departamento al que pertenece el empleado (cadena de caracteres).

Funciones:
Agregar Empleado:

    Cree una función agregar_empleado que tome como parámetros el ID del empleado, nombre, edad y departamento, y los agregue al diccionario de empleados.

Buscar Empleado:

    Desarrolle una función buscar_empleado que tome un ID como parámetro y devuelva el diccionario con la información del empleado correspondiente, o Empleado no encontrado si el ID no está en el sistema.

Eliminar Empleado:

    Desarrolle una función eliminar_empleado que tome un ID como parámetro y elimine al empleado del diccionario. Si el ID no existe, debe devolver un mensaje indicando que el empleado no se encontró.

Listar Empleados:

    Cree una función listar_empleados que imprima todos los empleados del sistema. Si el diccionario está vacío, debe imprimir "No hay empleados".

Para iniciar:

    Use la función agregar_empleado para agregar al menos cuatro empleados al sistema. Asegúrese de que los empleados tengan diferentes edades y departamentos para mayor diversidad en los datos.

Interacción con el Usuario:

    El sistema debe solicitar al usuario que elija entre agregar, buscar, eliminar o listar empleados.
    Dependiendo de la elección del usuario, debe llamar a la función correspondiente para realizar la acción solicitada.
    Al finalizar, debe mostrar el estado actual del diccionario de empleados.

Entregables:

    El sistema debe estar implementado en un archivo de Python con extensión .py.
    Debe presentar un documento PDF que contenga evidencia del uso de cada una de las funciones. Esto puede incluir:
    Ejemplos de interacción con el sistema.
    Resultados de las operaciones realizadas.
    Capturas de pantalla o transcripciones de la salida del programa.

Tenga en cuenta que el diccionario en formato Json, se vería como la imagen adjunta.
"""

# Definimos el listado de empleados a manejar en un diccionario 
# En la clave tenemos un número identificador y en el valor, un diccionario interno con los datos
empleados = {
    1: {
        "nombre": "Juan Pérez",
        "edad": 30,
        "departamento": "Ventas"
    },
    2: {
        "nombre": "María García",
        "edad": 25,
        "departamento": "Marketing"
    },
    3: {
        "nombre": "Carlos López",
        "edad": 40,
        "departamento": "Recursos Humanos"
    },
    4: {
        "nombre": "Ana Martínez",
        "edad": 35,
        "departamento": "TI"
    }
}

# Función para agregar empleado
def agregar_empleado(id, nombre, edad, departamento):
    if id in empleados:
        print(f"El empleado con ID {id} ya existe.")
    else:
        empleados[id] = {"nombre": nombre, "edad": edad, "departamento": departamento}
        print(f"Empleado {nombre} agregado exitosamente.")

# Función para buscar empleado por ID
def buscar_empleado(id):
    if id in empleados:
        return empleados[id]
    else:
        return "Empleado no encontrado."

# Función para eliminar empleado por ID
def eliminar_empleado(id):
    if id in empleados:
        del empleados[id]
        print(f"Empleado con ID {id} eliminado exitosamente.")
    else:
        print("Empleado no encontrado.")

# Función para listar todos los empleados
def listar_empleados():
    if empleados:
        for id, datos in empleados.items():
            print(f"ID: {id}, Nombre: {datos['nombre']}, Edad: {datos['edad']}, Departamento: {datos['departamento']}")
    else:
        print("No hay empleados.")

# lista de metodos relacionados con el gestor de empleados
metodos = [agregar_empleado,buscar_empleado,eliminar_empleado,listar_empleados]

# metodo principal que modela la ejecucion del gestor de empleados
def gestorEmpleados(funciones):
    activo = True
    while activo:
        print("Bienvenido al Gestor de Empleados COLTEXT por favor seleccione una opcion \n")
        opcion = input("Seleccione una opción: \n 1. Agregar Empleado \n 2. Buscar Empleado \n 3. Eliminar Empleado \n 4. Listar Empleados \n 5. Salir del Sistema \n")
        if opcion == "1":
            parId = int(input("Digite El ID del trabajador a agregar: "))
            parNombre = input("Digite El nombre del trabajador a agregar: ")    
            parEdad = int(input("Digite la Edad del trabajador a agregar: "))
            parDepartamento = input("Digite El departamento del trabajador a agregar: ")
            funciones[0](parId,parNombre,parEdad,parDepartamento)    
        elif opcion == "2":
            parId = int(input("Digite El ID del trabajador a buscar: "))
            buscado = funciones[1](parId)
            print(f"ID: {parId}, Nombre: {buscado['nombre']}, Edad: {buscado['edad']}, Departamento: {buscado['departamento']}")  
        elif opcion == "3":
            parId = int(input("Digite El ID del trabajador a eliminar: "))
            funciones[2](parId)  
        elif opcion == "4":
            funciones[3]()
        elif opcion == "5":
            print("Saliendo del sistema. \n GRACIAS POR USAR EL SISTEMA DE GESTION DE EMPLEADOS COLTEXT")
            activo = False
        else:
            print("Opción no válida, por favor intente de nuevo.")

# ejecutamos el metodo principal para arrancar el sistema
gestorEmpleados(metodos)