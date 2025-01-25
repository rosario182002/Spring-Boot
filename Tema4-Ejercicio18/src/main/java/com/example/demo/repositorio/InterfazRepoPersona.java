package com.example.demo.repositorio;

import java.util.List;

import com.example.demo.modelo.Persona;

public interface InterfazRepoPersona {

	void crearActualizarPersona(Persona persona);

	List<Persona> obtenerListaPersonas();

	Persona buscarPersonaPorId(Integer id);

	void borrarPersona(Persona persona);

	List<Object[]> obtenerNombresPersonasConProyectos();

}
