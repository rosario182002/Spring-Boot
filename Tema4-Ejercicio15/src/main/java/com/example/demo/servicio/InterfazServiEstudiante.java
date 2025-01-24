package com.example.demo.servicio;

import java.util.List;

import com.example.demo.modelo.Estudiante;

public interface InterfazServiEstudiante {

	List<Estudiante> obtenerEstudiantes();

<<<<<<< HEAD
	Estudiante obtenerEstudiantePorId(Integer id);

	void ActualizarEstudiante(String email, Integer id);

	List<Estudiante> obtenerEstudiantePorNombreConCadenaEspe(String nombre);

	void crearActualizarEstudiante(Estudiante estudiante);

=======
>>>>>>> 4451a31c42c8c2dbbeaf9d071869701a47731704
}
