package com.example.demo.servicio;

import java.util.List;

import com.example.demo.modelo.Curso;
import com.example.demo.modelo.Estudiante;

public interface InterfazServiCurso {

	void crearCurso(Curso curso);

	void añadirEstudianteACurso(Estudiante estudiante, Integer id);

	List<Curso> obtenerListaCursos();

	Curso buscarCursoPorId(Integer id);

	List<Curso> obtenerCursoNombreUnaPalabra(String nombre);

	void borrarEstudianteDeUnCurso(Estudiante estudiante, Integer id);

	void borrarCursoPorId(Integer id);

}
