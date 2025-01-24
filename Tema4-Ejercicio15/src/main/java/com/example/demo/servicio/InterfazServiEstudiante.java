package com.example.demo.servicio;

import java.util.List;

import com.example.demo.modelo.Estudiante;

public interface InterfazServiEstudiante {

	List<Estudiante> obtenerEstudiantes();

	Estudiante obtenerEstudiantePorId(Integer id);

	void ActualizarEstudiante(String email, Integer id);

	List<Estudiante> obtenerEstudiantePorNombreConCadenaEspe(String nombre);

	void crearActualizarEstudiante(Estudiante estudiante);


}
