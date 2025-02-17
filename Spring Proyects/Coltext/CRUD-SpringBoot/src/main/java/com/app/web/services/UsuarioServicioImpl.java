 // paquete al que hace parte
package com.app.web.services;

// importacions necesarias
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entities.Usuario;
import com.app.web.repository.UsuarioRepositorio;

// consumimos el servicio para hacer las correctas implementaciones
@Service
public class UsuarioServicioImpl implements UsuarioServicio {

	// enlasamos com el repositorio que relaciona la entidad con la base de datos mediante jpa
	@Autowired
	private UsuarioRepositorio repositorio;

	// reescribimos los metodos del servicio y les damos funcionalidades del repositorio
	@Override
	public List<Usuario> listarTodosLosUsuarios() {
		return repositorio.findAll();
	}

	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		return repositorio.save(usuario);
	}

	@Override
	public Usuario obtenerUsuarioPorId(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public Usuario actualizarUsuario(Usuario usuario) {
		return repositorio.save(usuario);
	}

	@Override
	public Usuario autenticarUsuario(String correo, String celular){

		Usuario temporal  = repositorio.buscarPorCelular(celular);
		
		if (temporal != null && temporal.getCorreo().equals(correo) ) {
            return temporal;
        }
		else {
			return null;
		}
       
	}

	@Override
	public void eliminarUsuario(Long id) {
		repositorio.deleteById(id);

	}

	@Override
    public List<Object[]> getUsuariosPorRol() {
        return repositorio.countUsuariosByRol();
    }

}
