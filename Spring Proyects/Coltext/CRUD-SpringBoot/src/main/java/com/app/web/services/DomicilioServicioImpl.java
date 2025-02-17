// paquete al que hace parte
package com.app.web.services;

// importacions necesarias
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entities.Domicilio;
import com.app.web.repository.DomicilioRepositorio;

// consumimos el servicio para hacer las correctas implementaciones
@Service
public class DomicilioServicioImpl implements DomicilioServicio {

	// enlasamos com el repositorio que relaciona la entidad con la base de datos mediante jpa
	@Autowired
	private DomicilioRepositorio repositorio;

	// reescribimos los metodos del servicio y les damos funcionalidades del repositorio
	@Override
	public List<Domicilio> listarTodosLosDomicilios() {
		return repositorio.findAll();
	}

	@Override
	public Domicilio guardarDomicilio(Domicilio domicilio) {
		return repositorio.save(domicilio);
	}

	@Override
	public Domicilio obtenerDomicilioPorId(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public Domicilio actualizarDomicilio(Domicilio domicilio) {
		return repositorio.save(domicilio);
	}

	@Override
	public void eliminarDomicilio(Long id) {
		repositorio.deleteById(id);

	}

	@Override
    public List<Object[]> getDomiciliosPorEstado() {
        return repositorio.countDomiciliosByEstado();
    }

}
