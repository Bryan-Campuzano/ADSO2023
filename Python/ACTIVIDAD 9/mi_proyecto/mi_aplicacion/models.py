from django.db import models

class Domicilio(models.Model):
    ciudad = models.CharField(max_length=100)
    localidad = models.CharField(max_length=100)
    barrio = models.CharField(max_length=100)
    direccion = models.CharField(max_length=255)
    estrato = models.IntegerField()

    def __str__(self):
        return f"{self.direccion}, {self.barrio}, {self.localidad}, {self.ciudad}"

class Persona(models.Model):
    nombre = models.CharField(max_length=100)
    apellido = models.CharField(max_length=100)
    domicilio = models.ForeignKey(Domicilio, on_delete=models.CASCADE, related_name='personas')

    def __str__(self):
        return f"{self.nombre} {self.apellido}"
