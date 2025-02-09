package com.example.demo.repositorio;

import java.util.List;

import com.example.demo.modelo.Usuario;

public interface InterRepoUsuario {

	List<Usuario> obtenerTodosLosUsuarios();

	Usuario obtenerUsuarioPorId(Integer id);

	Usuario crearGuardarUsuario(Usuario usuario);

	void eliminarUsuario(Integer id);

	List<Usuario> obtenerPorBiografiaContenido(String palabra);

	Usuario obtenerPrimeroPorEstadoDelPerfil(String estado);

	List<Usuario> obtenerPorEstadoDelPerfil(String estado);

}
