package com.example.demo.repositorio;

import java.util.List;

import com.example.demo.modelo.Deportista;

public interface InterRepoDeportista {

	void crearActuDeportista(Deportista deportista);

	List<Deportista> obtenerTodosLosDeportistas();

	Deportista buscarDeportistaPorId(Long id);

	Deportista buscarDeportistaPorNombre(String nombre);

	void eliminarDeportista(Deportista deportista);

}
