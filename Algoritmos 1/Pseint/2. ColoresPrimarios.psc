Algoritmo ColoresPrimarios
	Dimension combinaciones[3]
	combinaciones[1] <- "amarilloazul"
	combinaciones[2] <- "amarillorojo"
	combinaciones[3] <- "azulrojo"
	Dimension combinacionesMezcla[3]
	combinacionesMezcla[1] <- "Verde"
	combinacionesMezcla[2] <- "Naranja"
	combinacionesMezcla[3] <- "Morado"
	color1 = ""
	color2 = ""
	Escribir "indica el Primer color Primario en orden alfabetico"
	Leer color1
	Escribir "indica el Segundo color Primario en orden alfabetico"
	Leer color2
	Para i <- 1 Hasta 3 Con Paso 1 Hacer
		mezcla <- Concatenar(color1,color2)	
		Si mezcla == combinaciones[i] Entonces
			Escribir "El color resultado de mezclar", color1, "y", color2, "es: ", combinacionesMezcla[i]
		SiNo
			Escribir "Indique los valores en el orden correcto"
		FinSi
	FinPara
FinAlgoritmo
