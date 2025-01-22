package com.example.demo.repositorio;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Curso;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class RepositorioCurso implements InterfazRepoCurso {

	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	//1. Crear un curso con o sin estudiantes.
	public void crearCurso(Curso curso) {
		if(curso.getId() == null) {
			entityManager.persist(curso); //guarda y inserta curso
		}else {
			entityManager.merge(curso); //actualiza el curso 
		}
	}
	
	@Override
	// 3. Consultar todos los cursos.
	public List<Curso> obtenerListaCursos(){
		return entityManager.createQuery("Select c from Curso c", Curso.class).getResultList();
	}
	
	@Override
	public Curso buscarCursoId(Integer id) {
		return entityManager.find(Curso.class, id);
	}
	
	@Override
	// 4º Buscar curso por id
	public Curso buscarCursoPorId(Integer id) {
		return entityManager.find(Curso.class, id);
	}
	
	@Override
	// 5º Buscar los cursos cuyo nombre contenga una palabra.
	public List<Curso> obtenerCursoNombreUnaPalabra(String nombre){
		return entityManager.createQuery("Select c from Curso c where c.nombre like :nombre ", Curso.class).setParameter("nombre" , "%" + nombre + "%").getResultList();
	}
	
	@Override
	//7. Eliminar un curso dado su ID
	public void borrarCurso(Curso curso) {
		entityManager.remove(curso);
	}
	
	
}
