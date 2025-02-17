// paquete al que hace parte
package com.app.web.entities;

//importaciones necesarias
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.app.web.validators.DomicilioAnotacion;
import com.app.web.validators.EstadoAnotacion;
import com.app.web.validators.IdDomiciliarioAnotacion;

// declaramos una nueva entidad de formato tabla, esto nos permitira hacer match mas facil con la base de datos
@Entity
@Table(name = "domicilio")
public class Domicilio {

	// esta etiqueta indica que el id del domicilio es generado automaticamente por la base de datos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	// atributos de la entidad
	@DomicilioAnotacion
	@Column(name = "resumen",nullable = false,length = 50)
	private String resumen;
	
	@Column(name = "fecha",nullable = false,length = 50)
	private String fecha;
	
	@EstadoAnotacion
	@Column(name = "estado",nullable = false,length = 50,unique = true)
	private int estado;

	@IdDomiciliarioAnotacion
	@Column(name = "id_domiciliario",nullable = false,length = 50,unique = true)
	private int idDomiciliario;
	
	// constructor vacio
	public Domicilio() {
		
	}

	// metodo constructor con el id para hacer ciertos procesos donde se requiere el id
	public Domicilio(Long id, String resumen, String fecha, int estado, int idDomiciliario) {
		super();
		this.id = id;
		this.resumen = resumen;
		this.fecha = fecha;
		this.estado = estado;
		this.idDomiciliario = idDomiciliario;
	}
	
	// metodo constructor sin el id para cuando solo necesitemos alterar valores de la tabla o crearlos pero sin tener que setear un id
	public Domicilio( String resumen, String fecha, int estado, int idDomiciliario) {
		super();
		this.resumen = resumen;
		this.fecha = fecha;
		this.estado = estado;
		this.idDomiciliario = idDomiciliario;
	}

	// getters y setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String nombre) {
		this.resumen = nombre;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getIdDomiciliario() {
		return idDomiciliario;
	}

	public void setIdDomiciliario(int idDomiciliario) {
		this.idDomiciliario = idDomiciliario;
	}

	//sobreescribimos el metodo toString para retornar todos los valores de la clase en una cadena de caracteres que compone un arreglo
	@Override
	public String toString() {
		return "Domicilio [id=" + id + ", resumen=" + resumen + ", fecha=" + fecha + ", estado=" + estado + ", idDomiciliario="+ idDomiciliario + "]";
	}
	
	
}
