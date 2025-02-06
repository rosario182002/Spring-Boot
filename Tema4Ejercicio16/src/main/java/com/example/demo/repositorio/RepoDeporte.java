package com.example.demo.repositorio;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Deporte;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class RepoDeporte implements InterRepoDeporte {

	 @PersistenceContext
	    private EntityManager entityManager;

	    // 1. Crear un deporte
	 @Override
	    public void crearDeporte(Deporte deporte) {
	        if (deporte.getId() == null) {
	            entityManager.persist(deporte); // Guardar un nuevo deporte
	        } else {
	            entityManager.merge(deporte); // Actualizar un deporte existente
	        }
	    }

	    // 2. Obtener la lista de todos los deportes
	 @Override
	    public List<Deporte> obtenerTodosLosDeportes() {
	        return entityManager.createQuery("SELECT d FROM Deporte d", Deporte.class).getResultList();
	    }

	    // 3. Buscar un deporte por ID
	 @Override
	    public Deporte buscarDeportePorId(Long id) {
	        return entityManager.find(Deporte.class, id);
	    }
	 @Override
	 	public Deporte buscarDeportePorNombre(String nombre) {
		 return entityManager.find(Deporte.class, nombre);
	 }

	    // 4. Eliminar un deporte
	 @Override
	    public void eliminarDeporte(Deporte deporte) {
	        entityManager.remove(deporte);
	    }
}
