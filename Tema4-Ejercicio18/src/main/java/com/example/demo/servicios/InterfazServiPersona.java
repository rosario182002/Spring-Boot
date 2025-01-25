package com.example.demo.servicios;

import java.util.List;

import com.example.demo.modelo.Persona;

public interface InterfazServiPersona {

	void crearActualizarPersona(Persona persona);

	List<Persona> obtenerListaPersona();

	Persona buscarPersonaId(Integer id);

	void borrarPersona(Integer id);

	List<Object[]> obtenerNombresPersonasConProyectos();

}
