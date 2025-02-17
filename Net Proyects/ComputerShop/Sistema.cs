//Bryan Alexander Campuzano Giraldo
//Grupo: 312
//Programa: Ingenieria de Sistemas
//Código Fuente: autoría propia

using System;
using System.Collections.Generic;

public class Sistema
{
    private List<Usuario> Usuarios = new List<Usuario>();
    private List<Producto> Catalogo = new List<Producto>();
    private List<Compra> HistorialCompras = new List<Compra>();

    public Sistema()
    {
        Usuarios.Add(new Usuario("admin@correo.com", "1234"));
    }

    public bool Login(string correo, string contraseña)
    {
        foreach (var usuario in Usuarios)
        {
            if (usuario.Autenticar(correo, contraseña))
            {
                return true;
            }
        }
        return false;
    }

    public void VerCatalogo()
    {
        if (Catalogo.Count == 0)
        {
            Console.WriteLine("El catálogo está vacío.");
        }
        else
        {
            foreach (var producto in Catalogo)
            {
                Console.WriteLine(producto);
            }
        }
    }

    public void AgregarProducto(Producto producto)
    {
        Catalogo.Add(producto);
        Console.WriteLine("Producto agregado exitosamente.");
    }

    public void EliminarProducto(int id)
    {
        var producto = Catalogo.Find(p => p.Id == id);
        if (producto != null)
        {
            Catalogo.Remove(producto);
            Console.WriteLine("Producto eliminado.");
        }
        else
        {
            Console.WriteLine("Producto no encontrado.");
        }
    }

    public void RegistrarCompra(Compra compra)
    {
        HistorialCompras.Add(compra);
        Console.WriteLine("Compra registrada.");
    }

    public void VerHistorial()
    {
        if (HistorialCompras.Count == 0)
        {
            Console.WriteLine("No hay compras registradas.");
        }
        else
        {
            foreach (var compra in HistorialCompras)
            {
                Console.WriteLine(compra);
            }
        }
    }
}
