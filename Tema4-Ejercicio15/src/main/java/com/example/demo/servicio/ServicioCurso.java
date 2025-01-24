package com.example.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Curso;
import com.example.demo.modelo.Estudiante;
import com.example.demo.repositorio.RepositorioCurso;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ServicioCurso implements InterfazServiCurso {

	@Autowired
	public RepositorioCurso repositorio;
	
	@Override
	//1. Crear un curso con o sin estudiantes.
	public void crearCurso(Curso curso){
		repositorio.crearCurso(curso);
	}
	
	@Override
	//2. Agregar un estudiante a un curso.
	public void añadirEstudianteACurso(Estudiante estudiante, Integer id) {
		Curso curso = repositorio.buscarCursoId(id);
		if(curso != null) {
			curso.getEstudiante().add(estudiante);
			repositorio.crearCurso(curso);
		}
	}
	
	@Override
	//3. Consultar todos los cursos.
	public List<Curso> obtenerListaCursos(){
		return repositorio.obtenerListaCursos();
	}
	
	@Override
	//4º Buscar curso por id
	public Curso buscarCursoPorId(Integer id) {
		return repositorio.buscarCursoId(id);
	}
	
	@Override
	// 5º Buscar los cursos cuyo nombre contenga una palabra.
	public List<Curso> obtenerCursoNombreUnaPalabra(String nombre){
		return repositorio.obtenerCursoNombreUnaPalabra(nombre);
	}
	
	@Override
	//6. Eliminar un estudiante de un curso.
	public void borrarEstudianteDeUnCurso(Estudiante estudiante, Integer id) {
		Curso curso = repositorio.buscarCursoPorId(id); //buscamos el id delcurso
		List<Estudiante> estudiantes = curso.getEstudiante(); //guardamos lalista de estudiantes
		if(curso != null) { //Comprobamos que existe el curso
			for(Estudiante estudiantes1 : estudiantes ) { //Recorremos la lista de los estudiantes
				if(estudiantes1.equals(estudiante)) { //Comprobamos que es el estudiante que hemos pasado
					estudiantes.remove(estudiantes1); //borramos el estudiante
					repositorio.crearCurso(curso); //Actualixamos el curso
				}
			}
			
		}
	}
	
	@Override
	//7. Eliminar un curso dado su ID
	public void borrarCursoPorId(Integer id) {
		Curso curso = repositorio.buscarCursoId(id);
		if(curso != null) {
			repositorio.borrarCurso(curso);
		}
	}
	
	
}
