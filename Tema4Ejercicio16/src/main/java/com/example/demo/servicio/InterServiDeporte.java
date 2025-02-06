package com.example.demo.servicio;

import java.util.List;

import com.example.demo.modelo.Deporte;

public interface InterServiDeporte {

	void eliminarDeporte(Long id);

	Deporte obtenerDeportePorId(Long id);

	List<Deporte> obtenerTodosLosDeportes();

	void crearDeporte(Deporte deporte);

}
