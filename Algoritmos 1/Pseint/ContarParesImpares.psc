Algoritmo ContarParesImpares
	// Declaramos las variables que vamos a usar
	Definir largo como entero 
	Definir pares como entero 
	Definir impares como entero
	largo <- 100
	Dimension arreglo[largo]
	//Poblamos el arreglo con n�meros enteros aleatorios
	Para i <- 1 hasta largo Hacer
		arreglo[i] <- azar(100)
	FinPara
	
	//Contamos cu�ntos n�meros son pares e impares
	pares <- 0
	impares <- 0
	Para i <- 1 hasta largo Hacer
		Si arreglo[i] MOD 2 = 0 Entonces
			pares <- pares + 1
		Sino
			impares <- impares + 1
		FinSi
	FinPara
	
	// Imprimimos los resultados
	Escribir "Cantidad de n�meros pares: ", pares
	Escribir "Cantidad de n�meros impares: ", impares
FinAlgoritmo

