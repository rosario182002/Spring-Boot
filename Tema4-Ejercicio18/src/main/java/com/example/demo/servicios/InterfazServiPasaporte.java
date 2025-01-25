package com.example.demo.servicios;

import java.util.List;

import com.example.demo.modelo.Pasaporte;

public interface InterfazServiPasaporte {

	void crearActualizarPasaporte(Pasaporte pasaporte);

	List<Pasaporte> obtenerListaPasaporte();

	Pasaporte buscarPasaportePorId(Integer id);

	void borrarPasaporte(Integer id);

}
