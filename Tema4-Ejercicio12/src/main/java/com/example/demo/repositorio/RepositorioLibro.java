package com.example.demo.repositorio;

import java.util.List;

import org.springframework.stereotype.Repository;


import com.example.demo.modelo.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class RepositorioLibro implements InterfazLibro{
 
	@PersistenceContext
	public EntityManager entityManager;
	
	@Override
	public void insertarLibro(Libro libro) {
		  if (libro.getId() == null) {
              entityManager.persist(libro);   //INSERTA Y GUARDA 
          } else {
              entityManager.merge(libro);     //ACTUALIZA
          }
	}
	
	@Override
	public Libro buscarLibrosId (Integer id) {
		return entityManager.find(Libro.class, id);
	}
	
	@Override
	public List<Libro> obtenerLibros(){
		return entityManager.createQuery("Select l from Libro l", Libro.class).getResultList();
	}
	

}
