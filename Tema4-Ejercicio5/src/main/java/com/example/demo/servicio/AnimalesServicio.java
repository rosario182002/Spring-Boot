package com.example.demo.servicio;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Animal;
import com.example.demo.repositorio.AnimalesRepositorio;



@Service
public class AnimalesServicio {
	
	@Autowired
	private AnimalesRepositorio animalRepositorio;
	
	public Animal crearAnimal (Animal animal){
		return animalRepositorio.guardarAnimal(animal);
	}
	public List<Animal> obtenerTodosLosAnimales() {
		return  animalRepositorio.obtenerTodoslosAnimales();
	}
	public Optional<Animal>obtenerAnimalPorId(Long id){
		return animalRepositorio.buscarAnimalPorId(id);
	}
	public Optional<Animal> actualizarAnimal(Long id, Animal detallesAnimal) {
	    Optional<Animal> animalExistente = animalRepositorio.buscarAnimalPorId(id);

	    if (animalExistente.isPresent()) {
	        Animal animal = animalExistente.get();
	        animal.setNombre(detallesAnimal.getNombre());
	        animal.setEspecie(detallesAnimal.getEspecie());
	        animal.setEdad(detallesAnimal.getEdad());
	        animal.setHabitat(detallesAnimal.getHabitat());
	        animal.setFechaIngreso(detallesAnimal.getFechaIngreso());
	        return Optional.of(animalRepositorio.actualizarAnimal(animal));
	    } else {
	        return Optional.empty();
	    }
	}
	
	  public void eliminarAnimal(Long id) {
		  animalRepositorio.eliminarAnimalporId(id);
	    }

	    public List<Animal> obtenerAnimalesPorEspecie(String especie) {
	        return animalRepositorio.buscarAnimalPorEspecie(especie);
	    }

	    public List<Animal> obtenerAnimalesPorEdad(int edad) {
	        return animalRepositorio.buscarAnimalesPorEdad(edad);
	    }

	    public List<Animal> obtenerAnimalesRecientes(int fechaIngreso) {
	        return animalRepositorio.buscarAnimalesRecientes(fechaIngreso);
	    } 
	
}
