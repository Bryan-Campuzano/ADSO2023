// paquete al que hace parte
package com.app.web.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//importaciones necesarias

// declaramos una nueva entidad de formato tabla, esto nos permitira hacer match mas facil con la base de datos
@Entity
@Table(name = "promocion")
public class Promocion {

// esta etiqueta indica que el id del domicilio es generado automaticamente por la base de datos
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_promocion",nullable = false,length = 50)
	private Long idpromocion;

// atributos de la entidad
	
	@Column(name = "rango_fechas",nullable = false,length = 50)
	private String rangoFechas;
	
	@Column(name = "descripcion",nullable = false,length = 50)
	private String descripcion;

	@Column(name = "titulo",nullable = false,length = 50)
	private String titulo;

    @Column(name = "insumoen_descuento")
	private Long insumoDescuento;

// constructor vacio
	public Promocion() {
		
	}

// metodo constructor con el id para hacer ciertos procesos donde se requiere el id
	public Promocion(Long idpromocion, String rangoFechas, String descripcion, String titulo, Long insumoDescuento) {
		super();
		this.idpromocion = idpromocion;
		this.rangoFechas = rangoFechas;
		this.descripcion = descripcion;
		this.titulo = titulo;
		this.insumoDescuento = insumoDescuento;
	}
	
// metodo constructor sin el id para cuando solo necesitemos alterar valores de la tabla o crearlos pero sin tener que setear un id
	public Promocion(String rangoFechas, String descripcion, String titulo, Long insumoDescuento) {
		super();
		this.rangoFechas = rangoFechas;
		this.descripcion = descripcion;
		this.titulo = titulo;
		this.insumoDescuento = insumoDescuento;
	}

// getters y setters
    public Long getIdpromocion() {
        return idpromocion;
    }

    public void setIdpromocion(Long idpromocion) {
        this.idpromocion = idpromocion;
    }

    public String getRangoFechas() {
        return rangoFechas;
    }

    public void setRangoFechas(String rangoFechas) {
        this.rangoFechas = rangoFechas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getInsumoDescuento() {
        return insumoDescuento;
    }

    public void setInsumoDescuento(Long insumoDescuento) {
        this.insumoDescuento = insumoDescuento;
    }
    
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

//sobreescribimos el metodo toString para retornar todos los valores de la clase en una cadena de caracteres que compone un arreglo
	@Override
	public String toString() {
		return "Promocion [idpromocion=" + idpromocion + ", rangoFechas=" + rangoFechas + ", descripcion=" + descripcion + ", titulo=" + titulo + ", insumoenDescuento=" + insumoDescuento + "]";
	}
}
