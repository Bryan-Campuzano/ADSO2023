//Bryan Alexander Campuzano Giraldo
//Grupo: 312
//Programa: Ingenieria de Sistemas
//Código Fuente: autoría propia

using System;

public class Usuario
{
    public string Correo { get; set; }
    private string Contraseña { get; set; }

    public Usuario(string correo, string contraseña)
    {
        Correo = correo;
        Contraseña = contraseña;
    }

    public bool Autenticar(string correo, string contraseña)
    {
        return Correo == correo && Contraseña == contraseña;
    }
}
