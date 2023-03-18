Algoritmo HorasSemana
	Escribir "Escriba la cantidad de Horas:"
	Leer numH
	
	Escribir "Escriba F si son Horas de fin de semana, S de lo contrario"
	Leer tipo
	
	Total = 0
	
	Si tipo=='F'
		total = numH * 30000
	SiNo
		Si tipo=='S'
			total = numH * 25000
		SiNo
			Escribir "ingrese un operador valido"
		Fin Si
	Fin Si
	Escribir "el valor total calculado es: ", total
FinAlgoritmo