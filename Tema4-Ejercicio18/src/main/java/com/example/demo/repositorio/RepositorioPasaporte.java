package com.example.demo.repositorio;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Pasaporte;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class RepositorioPasaporte implements InterfazRepoPasaporte{
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	//crear Pasaporte o actualiza 
	public void crearActualizarPasaporte(Pasaporte pasaporte) {
		if(pasaporte.getId()== null) {
			entityManager.persist(pasaporte);
		}else {
			entityManager.merge(pasaporte);
		}
	}
	
	@Override
	//Lista de pasaporte
	public List<Pasaporte>obtenerListaPasaporte(){
		return entityManager.createQuery("Select pa from Pasaporte pa", Pasaporte.class).getResultList();
	}
	
	@Override
	//Buscar pasaporte por id
	public Pasaporte buscarPasaportePorId(Integer id) {
		return entityManager.find(Pasaporte.class, id);
	}
	
	@Override
	//Borrar pasaporte
	public void borrarPasaporte(Pasaporte pasaporte) {
		entityManager.remove(pasaporte);
	}
	
	
}
