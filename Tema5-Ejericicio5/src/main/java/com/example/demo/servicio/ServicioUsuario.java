package com.example.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Perfil;
import com.example.demo.modelo.Usuario;
import com.example.demo.repositorio.RepositorioPerfil;
import com.example.demo.repositorio.RepositorioUsuario;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ServicioUsuario implements InterServiUsuario {

	 @Autowired
	    private RepositorioUsuario usuarioRepositorio; 

	    @Autowired
	    private RepositorioPerfil perfilRepositorio;

	    // 1. Obtener la lista de todos los usuarios.
	    public List<Usuario> obtenerTodosLosUsuarios() {
	        return usuarioRepositorio.obtenerTodosLosUsuarios();
	    }

	    // 2. Obtener los datos de un usuario dado su ID.
	    public Usuario obtenerUsuarioPorId(Integer id) {
	        return usuarioRepositorio.obtenerUsuarioPorId(id);
	    }

	    // 3. Insertar un nuevo usuario.
 
	    public Usuario insertarUsuario(Usuario usuario) {
	        //Primero guardamos el perfil
	        Perfil perfil = perfilRepositorio.crearGuardarPerfil(usuario.getPerfil());
	        usuario.setPerfil(perfil); //Asignamos el perfil guardado al usuario
	        return usuarioRepositorio.crearGuardarUsuario(usuario);
	    }

	    // 4. Actualizar los datos de un usuario.

	    public Usuario actualizarUsuario(Integer id, Usuario usuarioActualizado) {
	        Usuario usuarioExistente = usuarioRepositorio.obtenerUsuarioPorId(id);
	        if (usuarioExistente != null) {
	            usuarioExistente.setNombre(usuarioActualizado.getNombre());
	            usuarioExistente.setEmail(usuarioActualizado.getEmail());
	            return usuarioRepositorio.crearGuardarUsuario(usuarioExistente);
	        }
	        return null; // O lanzar una excepción
	    }

	    // 5. Eliminar un usuario dado su ID.

	    public void eliminarUsuario(Integer id) {
	        usuarioRepositorio.eliminarUsuario(id);
	    }

	    // 6. Actualizar el perfil de un usuario. Recibe el id del usuario y su nuevo perfil.
	
	    public Usuario actualizarPerfilDeUsuario(Integer idUsuario, Perfil nuevoPerfil) {
	        Usuario usuarioExistente = usuarioRepositorio.obtenerUsuarioPorId(idUsuario);
	        if (usuarioExistente != null) {
	            nuevoPerfil = perfilRepositorio.crearGuardarPerfil(nuevoPerfil); //Guardamos el nuevo perfil primero
	            usuarioExistente.setPerfil(nuevoPerfil);
	            return usuarioRepositorio.crearGuardarUsuario(usuarioExistente);
	        }
	        return null;
	    }

	    // 7. Obtener el perfil de un usuario dado su ID.
	    public Perfil obtenerPerfilDeUsuario(Integer idUsuario) {
	        Usuario usuario = usuarioRepositorio.obtenerUsuarioPorId(idUsuario);
	        if (usuario != null) {
	            return usuario.getPerfil();
	        }
	        return null;
	    }

	    // 8. Actualizar el estado de un perfil a ‘DISPONIBLE’ dado el id del usuario.

	    public void actualizarEstadoDePerfil(Integer idUsuario, String estado) {
	        Usuario usuario = usuarioRepositorio.obtenerUsuarioPorId(idUsuario);
	        if (usuario != null && usuario.getPerfil() != null) {
	            usuario.getPerfil().setEstado(estado);
	            perfilRepositorio.crearGuardarPerfil(usuario.getPerfil()); //Guardamos el perfil directamente
	        }
	    }

	    // 9. Obtener la lista de usuarios cuya biografía contenga la palabra ‘edad’
	    public List<Usuario> obtenerUsuariosConBiografiaConteniendo(String palabra) {
	        return usuarioRepositorio.obtenerPorBiografiaContenido(palabra);
	    }

	    // 10. Obtener el primer usuario cuyo estado sea ‘DISPONIBLE’.
	    public Usuario obtenerPrimerUsuarioDisponible() {
	        return usuarioRepositorio.obtenerPrimeroPorEstadoDelPerfil("DISPONIBLE");
	    }

	    // 11. Buscar todos los usuarios cuyo estado sea ‘NO DISPONIBLE’
	    public List<Usuario> buscarUsuariosNoDisponibles() {
	        return usuarioRepositorio.obtenerPorEstadoDelPerfil("NO DISPONIBLE");
	    }

	    // 12. Poner el estado de todos los usuarios a ‘DISPONIBLE’
	   
	    public void ponerTodosLosUsuariosDisponibles() {
	        List<Usuario> usuarios = usuarioRepositorio.obtenerTodosLosUsuarios();
	        for (Usuario usuario : usuarios) {
	            if (usuario.getPerfil() != null) {
	                usuario.getPerfil().setEstado("DISPONIBLE");
	                perfilRepositorio.crearGuardarPerfil(usuario.getPerfil()); //Guardamos el perfil directamente
	            }
	        }
	    }
}
