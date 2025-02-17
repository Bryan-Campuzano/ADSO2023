// paquete al que pertenece
package com.app.web.repository;

import java.util.List;

// importaciones necesarias
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.web.entities.Usuario;

// repositorio asociado al domicilio, conexion con el controlador jpa
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{

// hacemos una consulta personalisada al repositorio jpa para que esta la haga al DB
    @Query("SELECT u FROM Usuario u WHERE u.celular = :celular")
    Usuario buscarPorCelular(String celular);

    @Query("SELECT u.rol, COUNT(u) FROM Usuario u GROUP BY u.rol")
    List<Object[]> countUsuariosByRol();
}
