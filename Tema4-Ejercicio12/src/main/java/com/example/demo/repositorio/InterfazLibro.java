package com.example.demo.repositorio;

import java.util.List;

import com.example.demo.modelo.Libro;

public interface InterfazLibro {

	void insertarLibro(Libro libro);

	Libro buscarLibrosId(Integer id);

	List<Libro> obtenerLibros();

}
