package com.example.demo.repositorio;

import java.util.List;

import com.example.demo.modelo.Curso;

public interface InterfazRepoCurso {

	void crearCurso(Curso curso);

	Curso buscarCursoId(Integer id);

	List<Curso> obtenerListaCursos();

	Curso buscarCursoPorId(Integer id);

	List<Curso> obtenerCursoNombreUnaPalabra(String nombre);

	void borrarCurso(Curso curso);

}
