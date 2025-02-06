package com.example.demo.repositorio;

import java.util.List;

import com.example.demo.modelo.Deportista;

public interface InterRepoDeportista {

	void eliminarDeportista(Deportista deportista);

	Deportista buscarDeportistaPorId(Long id);

	List<Deportista> obtenerTodosLosDeportistas();

	void crearActuDeportista(Deportista deportista);

	Deportista buscarDeportistaPorNombre(String nombre);

}
