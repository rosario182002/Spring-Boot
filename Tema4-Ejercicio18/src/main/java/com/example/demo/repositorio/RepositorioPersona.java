package com.example.demo.repositorio;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Persona;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class RepositorioPersona implements InterfazRepoPersona {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	//crear Personas o actualizar
	public void crearActualizarPersona(Persona persona) {
		if(persona.getId() == null) {
			entityManager.persist(persona);//inserta y guarda persona
		}else {
			entityManager.merge(persona); //actualiza la persona.
		}
	}
	
	@Override
	//Lista de personas
	public List<Persona>obtenerListaPersonas(){
		return entityManager.createQuery("Select p from Persona p", Persona.class).getResultList();
	}
	
	@Override
	//Buscar persona por id
	public Persona buscarPersonaPorId(Integer id) {
		return entityManager.find(Persona.class, id);
	}
	
	@Override
	//Borrar persona
	public void borrarPersona(Persona persona) {
		entityManager.remove(persona);
	}
	@Override
	 public List<Object[]> obtenerNombresPersonasConProyectos() {
	        return entityManager.createQuery(
	            "SELECT p.nombre, pr.nombre FROM Persona p JOIN p.proyectos pr", Object[].class)
	            .getResultList();
	    }
	
	
	
	

}
