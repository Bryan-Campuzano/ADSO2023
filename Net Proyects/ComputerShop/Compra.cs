//Bryan Alexander Campuzano Giraldo
//Grupo: 312
//Programa: Ingenieria de Sistemas
//Código Fuente: autoría propia

using System;
using System.Collections.Generic;

public class Compra
{
    public int Id { get; set; }
    public List<Producto> Productos { get; private set; }
    public DateTime Fecha { get; private set; }

    public Compra(int id)
    {
        Id = id;
        Productos = new List<Producto>();
        Fecha = DateTime.Now;
    }

    public void AgregarProducto(Producto producto)
    {
        Productos.Add(producto);
    }

    public override string ToString()
    {
        string productos = string.Join(", ", Productos);
        return $"Compra ID: {Id}, Fecha: {Fecha}, Productos: [{productos}]";
    }
}
