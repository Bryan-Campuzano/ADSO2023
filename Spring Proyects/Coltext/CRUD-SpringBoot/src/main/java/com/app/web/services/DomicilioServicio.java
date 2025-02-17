// paquete al que pertenece
package com.app.web.services;

// importaciones necesarias
import java.util.List;

import com.app.web.entities.Domicilio;

// definimos esta clase como interface 
public interface DomicilioServicio {

	// metodos de la interfaz
	public List<Domicilio> listarTodosLosDomicilios();

	List<Object[]> getDomiciliosPorEstado();
	
	public Domicilio guardarDomicilio(Domicilio estudiante);
	
	public Domicilio obtenerDomicilioPorId(Long id);
	
	public Domicilio actualizarDomicilio(Domicilio estudiante);
	
	public void eliminarDomicilio(Long id);
}
