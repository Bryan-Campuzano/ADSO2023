//Bryan Alexander Campuzano Giraldo
//Grupo: 312
//Programa: Ingenieria de Sistemas
//Código Fuente: autoría propia

public class Producto
{
    public int Id { get; set; }
    public string Nombre { get; set; }
    public decimal Precio { get; set; }

    public Producto(int id, string nombre, decimal precio)
    {
        Id = id;
        Nombre = nombre;
        Precio = precio;
    }

    public override string ToString()
    {
        return $"ID: {Id}, Nombre: {Nombre}, Precio: {Precio:C}";
    }
}
