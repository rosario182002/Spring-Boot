package com.example.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Libro;
import com.example.demo.repositorio.RepositorioLibro;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ServicioLibro implements InterfazServicioLibro{
	
	@Autowired
	public RepositorioLibro repositorio;
	
	@Override
	public void insertarLibro (Libro libro) {
		repositorio.insertarLibro(libro);
	}
	
	@Override
	public void ActualizarTitulo (String titulo, Integer id) {
		Libro libro = repositorio.buscarLibrosId(id);
		if( libro != null) {
			libro.setTitulo(titulo);
			repositorio.insertarLibro(libro);
		}
	}
	
	@Override
	public List<Libro> obtenerLibros(){
		return repositorio.obtenerLibros();
	}

	
	

}
