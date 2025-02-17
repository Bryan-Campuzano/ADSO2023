// paquete al que pertenece
package com.app.web.services;

// importaciones necesarias
import java.util.List;

import com.app.web.entities.Usuario;

// definimos esta clase como interface 
public interface UsuarioServicio {

	// metodos de la interfaz
	public List<Usuario> listarTodosLosUsuarios();
	
	public Usuario guardarUsuario(Usuario estudiante);
	
	public Usuario obtenerUsuarioPorId(Long id);
	
	public Usuario actualizarUsuario(Usuario estudiante);

	public Usuario autenticarUsuario(String correo, String celular);
	
	public void eliminarUsuario(Long id);

	List<Object[]> getUsuariosPorRol();
}
