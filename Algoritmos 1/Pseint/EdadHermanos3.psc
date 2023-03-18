Algoritmo EdadHermanos3
	
	Dimension edades[3]
	Dimension diferencias[3]
	acumulado <- 1
	acumulado2 <- 1
	Definir hermanoMayor Como Entero
	
	Mientras acumulado <= 3 Hacer
		Escribir "Indique la edad del hermano #", acumulado,":"
		leer n
		edades[acumulado] <- n
		acumulado = acumulado + 1
	FinMientras
	
	Para i <- 1 Hasta 3 Con Paso 1 Hacer
		Si edades[i] > hermanoMayor
			hermanoMayor <- i
		FinSi
	FinPara
	
	Para k <- 1 Hasta 4 Con Paso 1 Hacer
		Para j <- 2 Hasta 4 Con Paso 1 Hacer
			diferencias[k] <- abs(edades[k]-edades[j])
			Si k == 3 Y j == 4
				diferencias[k] <- abs(edades[k]-edades[1])
			FinSi
		FinPara
	FinPara
	
	Escribir "el Hermano mayor de los 3 es el #: ", hermanoMayor
	
	Escribir "Ladifenrencia del Hermano 1 y 2 es: " diferencias[1]
	Escribir "Ladifenrencia del Hermano 1 y 3 es: " diferencias[2]
	Escribir "Ladifenrencia del Hermano 2 y 3 es: " diferencias[3]
	
FinAlgoritmo
