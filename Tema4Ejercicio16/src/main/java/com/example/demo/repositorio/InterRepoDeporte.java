package com.example.demo.repositorio;

import java.util.List;

import com.example.demo.modelo.Deporte;

public interface InterRepoDeporte {

	void eliminarDeporte(Deporte deporte);

	Deporte buscarDeportePorId(Long id);

	List<Deporte> obtenerTodosLosDeportes();

	void crearDeporte(Deporte deporte);

	Deporte buscarDeportePorNombre(String nombre);

}
