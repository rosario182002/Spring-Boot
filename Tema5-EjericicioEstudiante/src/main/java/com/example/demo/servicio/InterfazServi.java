package com.example.demo.servicio;

import java.util.List;

import com.example.demo.modelo.Curso;
import com.example.demo.modelo.Estudiante;

public interface InterfazServi {

	void crearActualizarCurso(Curso curso);

	void crearActualizarEstudiante(Estudiante estudiante);

	void agregarEstudianteaCursos(Estudiante estudiante, Curso curso);

	List<Curso> obtenerTodosCursos();

	List<Estudiante> obtenerTodosEstudiante();

	Curso cursoId(Integer id);

	Estudiante estudianteId(Integer id);

	void EliminarEstudiantedeCurso(Estudiante estu, Curso curso);

	void eliminarCurso(Integer id);

	void actulizarEmail(String email, Integer id);

	List<Estudiante> buscarEstudiantePorCadena(String cadena);

	List<Estudiante> buscarEstudiantePorNombre(String nombre);

}
