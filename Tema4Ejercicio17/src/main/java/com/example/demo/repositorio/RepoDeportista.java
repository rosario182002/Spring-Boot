package com.example.demo.repositorio;

import java.util.List;

import com.example.demo.modelo.Deportista;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class RepoDeportista implements InterRepoDeportista{
	 @PersistenceContext
	    private EntityManager entitymanager;

	    @Override
	    public void crearActuDeportista(Deportista deportista) {
	        if (deportista.getId() == null) {
	            entitymanager.persist(deportista);
	        } else {
	            entitymanager.merge(deportista);
	        }
	    }

	    @Override
	    public List<Deportista> obtenerTodosLosDeportistas() {
	        return entitymanager.createQuery(
	                        "SELECT d FROM Deportista d LEFT JOIN FETCH d.deportes", Deportista.class)
	                .getResultList();
	    }

	    @Override
	    public Deportista buscarDeportistaPorId(Long id) {
	        return entitymanager.createQuery(
	                        "SELECT d FROM Deportista d LEFT JOIN FETCH d.deportes WHERE d.id = :id", Deportista.class)
	                .setParameter("id", id)
	                .getSingleResult();
	    }

	    @Override
	    public Deportista buscarDeportistaPorNombre(String nombre) {
	        return entitymanager.find(Deportista.class, nombre);
	    }

	    @Override
	    public void eliminarDeportista(Deportista deportista) {
	        entitymanager.remove(entitymanager.contains(deportista) ? deportista : entitymanager.merge(deportista));
	    }
}

