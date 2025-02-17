// paquete al que pertenece
package com.app.web.repository;

// importaciones necesarias
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.web.entities.Promocion;

// repositorio asociado al domicilio, conexion con el controlador jpa
@Repository
public interface PromocionRepositorio extends JpaRepository<Promocion, Long>{

}