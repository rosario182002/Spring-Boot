package com.example.demo.servicio;

import java.util.List;

import com.example.demo.modelo.Autor;
import com.example.demo.modelo.Libro;

public interface InterfazServicioAutor {

	List<Autor> obtenerListaAutor();

	Autor buscarAutorId(Integer id);

	void insertarAutor(Autor autor);

	void borrarAutor(Integer id);

	void añadirLibroConAutorExit(Libro libro, Integer id);

	void borrarLibrodeUnAutor(Libro libro, Integer id);

	List<Libro> ObtenerLibrosIdAutor(Integer id);

	List<Autor> obtenerAutoresPorNombre(String nombre);

	void actualizarNombredeTodosAutoresConLibros(String nombre, String nuevo);

}
