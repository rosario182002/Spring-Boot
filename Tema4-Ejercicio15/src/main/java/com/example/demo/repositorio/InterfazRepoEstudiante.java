package com.example.demo.repositorio;

import java.util.List;

import com.example.demo.modelo.Estudiante;

public interface InterfazRepoEstudiante {

	List<Estudiante> obtenerEstudiantes();

	Estudiante buscarEstudiantePorId(Integer id);

	void crearActualizarEstudiante(Estudiante estudiante);

	List<Estudiante> obtenerEstudiante(String nombre);

}
