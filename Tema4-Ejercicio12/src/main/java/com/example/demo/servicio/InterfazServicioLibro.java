package com.example.demo.servicio;

import java.util.List;

import com.example.demo.modelo.Libro;

public interface InterfazServicioLibro {
	
	public void insertarLibro(Libro libro);
	
	void ActualizarTitulo(String titulo, Integer id);

	List<Libro> obtenerLibros();

}
