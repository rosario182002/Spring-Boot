package com.example.demo.repositorio;

import java.util.List;

import com.example.demo.modelo.Curso;
import com.example.demo.modelo.Estudiante;

public interface Interfaz {

	void crearActualizarCurso(Curso curso);

	void crearActualizarCurso(Estudiante estudiante);

	Curso CursoId(Integer id);

	Estudiante estudianteId(Integer id);

	List<Curso> obtenerTodosCursos();

	List<Estudiante> obtenerTodosEstudiantes();

	void eliminarCurso(Integer id);

	List<Estudiante> buscarEstudiantePorCadena(String cadena);

	List<Estudiante> buscarEstudiantesPorNombre(String nombre);

}
