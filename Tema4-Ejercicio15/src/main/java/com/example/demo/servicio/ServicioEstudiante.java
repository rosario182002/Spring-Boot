package com.example.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Estudiante;
import com.example.demo.repositorio.RepositorioEstudiante;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ServicioEstudiante implements InterfazServiEstudiante {

	@Autowired
	public RepositorioEstudiante repositorio;
	
	@Override
	public List<Estudiante> obtenerEstudiantes(){
		return repositorio.obtenerEstudiantes();
	}
	@Override
	public Estudiante obtenerEstudiantePorId(Integer id) {
		return repositorio.buscarEstudiantePorId(id);
	}
	@Override
	public void crearActualizarEstudiante(Estudiante estudiante) {
			repositorio.crearActualizarEstudiante(estudiante);
	}
	@Override
	//3. Actualizar el email de un estudiante dado su ID.
	public void ActualizarEstudiante (String email, Integer id) {
		Estudiante estudiante = repositorio.buscarEstudiantePorId(id);
		if(estudiante != null) {
			estudiante.setEmail(email);
			repositorio.crearActualizarEstudiante(estudiante);
		}
	}
	
	@Override
	public List<Estudiante> obtenerEstudiantePorNombreConCadenaEspe (String nombre){
		return repositorio.obtenerEstudiante(nombre);
	}
	//para git
}
