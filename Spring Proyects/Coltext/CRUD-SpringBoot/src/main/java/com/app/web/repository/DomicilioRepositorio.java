// paquete al que pertenece
package com.app.web.repository;

import java.util.List;

// importaciones necesarias
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.web.entities.Domicilio;

// repositorio asociado al domicilio, conexion con el controlador jpa
@Repository
public interface DomicilioRepositorio extends JpaRepository<Domicilio, Long>{
@Query("SELECT d.estado, COUNT(d) FROM Domicilio d GROUP BY d.estado")
    List<Object[]> countDomiciliosByEstado();
}
