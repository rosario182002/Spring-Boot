package com.example.demo.repositorio;

import java.util.List;

import com.example.demo.modelo.Deporte;

public interface InterReporDeporte {

	void crearDeporte(Deporte deporte);

	List<Deporte> obtenerTodosLosDeportes();

	Deporte buscarDeportePorId(Long id);

	Deporte buscarDeportePorNombre(String nombre);

	void eliminarDeporte(Deporte deporte);

}
