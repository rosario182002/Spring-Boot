package com.example.demo.repositorio;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Animal;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class AnimalesRepositorio {

	@PersistenceContext
	private EntityManager  entityManager;
	
	//Metodo para guardar un nuevo animal
	
	public Animal guardarAnimal(Animal animal) {
		entityManager.persist(animal);
		return animal;
	}
	
	//Metodo para obtener todos los animales
	public List<Animal>obtenerTodoslosAnimales(){
		return entityManager.createQuery("SELECT a FROM Animal a", Animal.class).getResultList();
	}
	
	//Metodo para buscar un animal por su ID
	public Optional<Animal>buscarAnimalPorId(Long id){
		Animal animal = entityManager.find(Animal.class, id);
		return Optional.ofNullable(animal);	
	}
	
	//Metodo para actualizar un animal
	public Animal actualizarAnimal(Animal animal) {
		return entityManager.merge(animal);
	}
	
	//Metodo para borrar un animal
	public void eliminarAnimalporId(Long id) {
		Animal animal = entityManager.find(Animal.class, id);
		if( animal != null) {
			entityManager.remove(animal);
		}
	}
	
	//Metodo para buscar animales por especie
	public List<Animal>buscarAnimalPorEspecie(String especie){
		return entityManager.createQuery("SELECT a FROM Animal a WHERE a.especie = :especie", Animal.class)
				.setParameter("especie", especie).getResultList();
	}
	
	//Metodo para buscar animales por edad exacta 
	public List<Animal> buscarAnimalesPorEdad(int edad){
		return entityManager.createQuery("SELECT a FROM Animal a WHERE a.edad = :edad", Animal.class)
				.setParameter("edad", edad).getResultList();
	}
	
	//Metodos para buscar animales ingresados en los últimos x años
	public List<Animal> buscarAnimalesRecientes(int fechaIngreso){
		LocalDate fechaInicio = LocalDate.now().minusYears(fechaIngreso);
		return entityManager.createQuery("SELECT a.fechaIngreso, a.especie, a.nombre FROM Animal  a WHERE a.fechaIngreso >= :fecha", Animal.class)
				.setParameter("fecha", fechaInicio).getResultList();
	}
	
	//Metodo para guardar una lista de animales
	public List<Animal>guardarListaDeAnimales(List<Animal>animales){
		for (Animal animal: animales) {
			entityManager.persist(animal);
		}
		return animales;
	}

	
	
}
