package com.example.demo.repositorio;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Deporte;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class RepoDeporte implements InterReporDeporte{

	 @PersistenceContext
	    private EntityManager entityManager;

	    @Override
	    public void crearDeporte(Deporte deporte) {
	        if (deporte.getId() == null) {
	            entityManager.persist(deporte);
	        } else {
	            entityManager.merge(deporte);
	        }
	    }

	    @Override
	    public List<Deporte> obtenerTodosLosDeportes() {
	        return entityManager.createQuery("SELECT d FROM Deporte d", Deporte.class).getResultList();
	    }


	    @Override
	    public Deporte buscarDeportePorId(Long id) {
	        return entityManager.createQuery(
	                        "SELECT d FROM Deporte d LEFT JOIN FETCH d.deportistas WHERE d.id = :id", Deporte.class)
	                .setParameter("id", id)
	                .getSingleResult();
	    }


	    @Override
	    public Deporte buscarDeportePorNombre(String nombre) {
	        return entityManager.find(Deporte.class, nombre);
	    }


	    @Override
	    public void eliminarDeporte(Deporte deporte) {
	        entityManager.remove(entityManager.contains(deporte) ? deporte : entityManager.merge(deporte));
	    }
	}
