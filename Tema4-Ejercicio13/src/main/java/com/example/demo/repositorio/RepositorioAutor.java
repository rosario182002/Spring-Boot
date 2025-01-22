package com.example.demo.repositorio;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Autor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class RepositorioAutor implements InterfazAutor {

	@PersistenceContext
    private EntityManager entityManager;
	
	
	@Override
	public List<Autor> obtenerListaAutores(){
		return entityManager.createQuery("Select a from Autor a", Autor.class).getResultList();
	}
	
	@Override
	public Autor buscarAutorID(Integer id) {
		return entityManager.find(Autor.class, id);
	}
	
	@Override
	public void insertarAutor(Autor autor) {
		  if (autor.getId() == null) {
              entityManager.persist(autor);   //INSERTA Y GUARDA 
          } else {
              entityManager.merge(autor);     //ACTUALIZA
          }
	}
	
	@Override
	public void borrarAutor(Autor autor) {
		entityManager.remove(autor);
	}
	
	@Override 
	public List<Autor> obtenerAutoresPorNombre(String nombre){
		return entityManager.createQuery("Select a from Autor a where a.nombre like :nombre", Autor.class).setParameter("nombre" , "%" + nombre + "%").getResultList();
	}
	
	
}
