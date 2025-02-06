package com.example.demo.repositorio;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Deportista;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class RepoDeportista implements InterRepoDeportista {

	@PersistenceContext
	private EntityManager entitymanager; 
	
	//1º Crear un deportista y actualizar
	 @Override
	public void crearActuDeportista(Deportista deportista) {
		if(deportista.getId() == null) {
			entitymanager.persist(deportista);
		}else {
			entitymanager.merge(deportista);
		}
	}
	
	//2º Obtener lista de deportistas
	 @Override
	public List<Deportista> obtenerTodosLosDeportistas(){
		return entitymanager.createQuery("SELECT d FROM Deportista d", Deportista.class).getResultList();
	}
	
	//3º Buscar deportista por id
	 @Override
	public Deportista buscarDeportistaPorId(Long id) {
		return entitymanager.find(Deportista.class, id);
	}
	 
	 @Override
	 public Deportista buscarDeportistaPorNombre(String nombre) {
		 return entitymanager.find(Deportista.class, nombre);
	 }
	
	//4º Eliminar Deportista 
	 @Override
	public void eliminarDeportista(Deportista deportista) {
		entitymanager.remove(deportista);
	}
	
}
