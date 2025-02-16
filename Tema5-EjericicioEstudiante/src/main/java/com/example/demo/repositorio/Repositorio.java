package com.example.demo.repositorio;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Curso;
import com.example.demo.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class Repositorio implements Interfaz{
	
	@PersistenceContext
	private EntityManager entityManager; 
	
	@Override
	public void crearActualizarCurso(Curso curso) {
		if(curso.getId() == null) {
			entityManager.persist(curso);
		}else {
			entityManager.merge(curso);
		}
	}
	
	@Override
	public void crearActualizarCurso(Estudiante estudiante) {
		if(estudiante.getId() == null) {
			entityManager.persist(estudiante);
		}else {
			entityManager.merge(estudiante);
		}
	}
	
	@Override
	public Estudiante estudianteId(Integer id) {
		return entityManager.find(Estudiante.class, id);
	}
	
	@Override
	public Curso CursoId(Integer id) {
		return entityManager.find(Curso.class, id);
	}
	
	@Override
	public List<Curso> obtenerTodosCursos(){
		return  entityManager.createQuery("SELECT c FROM Curso c", Curso.class).getResultList();
	}
	
	@Override
	public List<Estudiante> obtenerTodosEstudiantes(){
		return  entityManager.createQuery("SELECT e FROM Estudiante e", Estudiante.class).getResultList();
	}
	
	
	@Override
	public void eliminarCurso(Integer id) {
		Curso curso = CursoId(id);
		if(curso != null) {
			entityManager.remove(curso);
		}
		
	}
	
	@Override
	public List<Estudiante> buscarEstudiantePorCadena(String cadena) {
		String sql = "SELECT e FROM Estudiante e WHERE e.nombre LIKE :cadena"; 
		return entityManager.createQuery(sql, Estudiante.class).setParameter("cadena", "%" + cadena + "%").getResultList();
	}
	
	@Override
	  public List<Estudiante> buscarEstudiantesPorNombre(String nombre) {
        String sql = "SELECT e FROM Estudiante e WHERE e.nombre LIKE :nombre";
        return entityManager.createQuery(sql, Estudiante.class)
                .setParameter("nombre", "%" + nombre + "%")
                .getResultList();
    }
	
}
