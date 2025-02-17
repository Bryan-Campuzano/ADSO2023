// paquete al que hace parte
package com.app.web.entities;

//importaciones necesarias
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// declaramos una nueva entidad de formato tabla, esto nos permitira hacer match mas facil con la base de datos
@Entity
@Table(name = "usuario")
public class Usuario {

    // esta etiqueta indica que el id del domicilio es generado automaticamente por
    // la base de datos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario",nullable = false,length = 50)
    private Long idUsuario;

    //atributos de la entidad
    @Column(name = "nombres",nullable = false,length = 50)
    private String nombres;

    @Column(name = "apellidos",nullable = false,length = 50)
    private String apellidos;

    @Column(name = "correo",nullable = false,length = 50)
    private String correo;

    @Column(name = "celular",nullable = false,length = 50)
    private String celular;

    @Column(name = "direccion",nullable = false,length = 50)
    private String direccion;

    @Column(name = "Rol",nullable = false,length = 50)
    private int rol;

    // contructor vacio
    public Usuario() {
    
    }

    // metodo constructor con el id para hacer ciertos procesos donde se requiere el id
    public Usuario(Long idUsuario, String nombres, String apellidos, String correo, String celular, String direccion,
            int rol) {
        this.idUsuario = idUsuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.celular = celular;
        this.direccion = direccion;
        this.rol = rol;
    }

	// metodo constructor sin el id para cuando solo necesitemos alterar valores de la tabla o crearlos pero sin tener que setear un id
    public Usuario(String nombres, String apellidos, String correo, String celular, String direccion, int rol) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.celular = celular;
        this.direccion = direccion;
        this.rol = rol;
    }

    // getters y setters
    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

	//sobreescribimos el metodo toString para retornar todos los valores de la clase en una cadena de caracteres que compone un arreglo
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombres=" + nombres + ", apellidos=" + apellidos + ", correo=" + correo + ", celular="+ celular + ", direccion=" + direccion + ", rol=" + rol +"]";
	}

}
