Algoritmo Dados	
	
	Dimension resultados[6]
	acumulado  = 1
	cantidadSeis = 0
	Mientras acumulado <= 6 Hacer
		Escribir "Escribir tirada # ", acumulado,":"
		leer n
		resultados[acumulado] <- n
		acumulado = acumulado +1
	FinMientras
	
	Para i <- 1 Hasta 6 Con Paso 1 Hacer
		Si resultados[i] == 6
			cantidadSeis = cantidadSeis +1
		FinSi
	FinPara
	
	Si cantidadSeis >= 3
		Escribir "Excelente"
	SiNo
		si cantidadSeis == 2
			Escribir "Muy Bien"
		SiNo 
			Si cantidadSeis == 1
				Escribir "Regular"
			SiNo
				Escribir "Pesimo"
			FinSi
		FinSi
	FinSi
FinAlgoritmo
