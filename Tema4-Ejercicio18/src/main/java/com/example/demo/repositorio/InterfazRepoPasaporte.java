package com.example.demo.repositorio;

import java.util.List;

import com.example.demo.modelo.Pasaporte;

public interface InterfazRepoPasaporte {

	void crearActualizarPasaporte(Pasaporte pasaporte);

	List<Pasaporte> obtenerListaPasaporte();

	Pasaporte buscarPasaportePorId(Integer id);

	void borrarPasaporte(Pasaporte pasaporte);

}
