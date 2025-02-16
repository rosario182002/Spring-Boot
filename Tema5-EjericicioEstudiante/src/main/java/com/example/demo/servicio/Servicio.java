package com.example.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Curso;
import com.example.demo.modelo.Estudiante;
import com.example.demo.repositorio.Repositorio;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class Servicio implements InterfazServi {

	@Autowired
	private Repositorio repositorio;

	@Override
	public void crearActualizarCurso(Curso curso) {
		repositorio.crearActualizarCurso(curso);

	}

	@Override
	public void crearActualizarEstudiante(Estudiante estudiante) {
		repositorio.crearActualizarCurso(estudiante);

	}
	
	@Override
	public void agregarEstudianteaCursos(Estudiante estudiante, Curso curso) {
		Estudiante estudiante1 = repositorio.estudianteId(estudiante.getId());
		Curso curso1 = repositorio.CursoId(curso.getId());
		
		if(estudiante1 != null && curso1 != null) {
			curso1.getEstudiantes().add(estudiante1);
			repositorio.crearActualizarCurso(curso1);
		}
		
	}
	
	@Override
	public Curso cursoId(Integer id) {
		return repositorio.CursoId(id);
	}
	
	@Override
	public Estudiante estudianteId(Integer id) {
		return repositorio.estudianteId(id);
	}
	
	
	@Override
	public List<Curso>obtenerTodosCursos(){
		return repositorio.obtenerTodosCursos();
	}
	
	@Override
	public List<Estudiante>obtenerTodosEstudiante(){
		return repositorio.obtenerTodosEstudiantes();
	}
	
	@Override
	public void EliminarEstudiantedeCurso(Estudiante estu, Curso curso) {
		Estudiante estudiante = repositorio.estudianteId(estu.getId()); 
		Curso curso1 = repositorio.CursoId(curso.getId());
		
		if(estudiante != null && curso1 != null) {
			curso1.getEstudiantes().remove(estudiante); 
			repositorio.crearActualizarCurso(curso1);
		}
	}
	
	@Override
	public void eliminarCurso(Integer id) {
		repositorio.eliminarCurso(id);
	}
	
	@Override
	public void actulizarEmail(String email, Integer id) {
		Estudiante estu = repositorio.estudianteId(id);
		
		if( estu != null) {
			estu.setEmail(email);
			repositorio.crearActualizarCurso(estu);
			
		}
	}
	
	@Override
	public List<Estudiante>buscarEstudiantePorCadena(String cadena){
		return repositorio.buscarEstudiantePorCadena(cadena);
	}

	@Override
	public List<Estudiante>buscarEstudiantePorNombre(String nombre){
		return repositorio.buscarEstudiantesPorNombre(nombre);
	}
}
