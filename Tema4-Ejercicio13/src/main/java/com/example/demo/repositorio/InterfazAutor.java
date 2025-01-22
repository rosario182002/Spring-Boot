package com.example.demo.repositorio;

import java.util.List;

import com.example.demo.modelo.Autor;

public interface InterfazAutor {

	List<Autor> obtenerListaAutores();

	Autor buscarAutorID(Integer id);

	void insertarAutor(Autor autor);

	void borrarAutor(Autor autor);

	List<Autor> obtenerAutoresPorNombre(String nombre);

}
