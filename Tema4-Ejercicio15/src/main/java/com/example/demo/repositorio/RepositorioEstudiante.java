package com.example.demo.repositorio;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Estudiante;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class RepositorioEstudiante implements InterfazRepoEstudiante {
	@PersistenceContext
	public EntityManager entityManager;
	

	@Override
	//1. Consultar todos los estudiantes.
	public List<Estudiante> obtenerEstudiantes(){
		return entityManager.createQuery("Select e from Estudiante e", Estudiante.class).getResultList();
	}

	@Override
	//2. Obtener Estudiantes por id
	public Estudiante buscarEstudiantePorId(Integer id) {
		return entityManager.find(Estudiante.class, id);
	}

	@Override 
	public void crearActualizarEstudiante(Estudiante estudiante) {
		if(estudiante.getId() == null) {
			entityManager.persist(estudiante); //Inserta y guarda
		}else {
			entityManager.merge(estudiante);//Actualiza
		}
	}
	
	@Override
	public List<Estudiante> obtenerEstudiante(String nombre){
		return entityManager.createQuery("Select e from Estudiante e where e.nombre like :nombre ", Estudiante.class).setParameter("nombre" , "%" + nombre + "%").getResultList();
		
	}
	

}
