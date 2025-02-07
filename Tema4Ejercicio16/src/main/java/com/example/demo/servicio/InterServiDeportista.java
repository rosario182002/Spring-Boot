package com.example.demo.servicio;

import java.util.List;

import com.example.demo.modelo.Deportista;

public interface InterServiDeportista {

	void crearDeportista(Deportista deportista);

	List<Deportista> obtenerTodosLosDeportistas();

	Deportista obtenerDeportistaPorId(Long id);

	void eliminarDeporte(Long deportistaId, String deporteNombre);

	void agregarDeporte(Long deportistaId, Long deporteId);


}
