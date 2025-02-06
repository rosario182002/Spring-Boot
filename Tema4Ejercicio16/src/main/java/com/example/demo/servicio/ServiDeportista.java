package com.example.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.modelo.Deportista;

import com.example.demo.repositorio.RepoDeportista;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ServiDeportista implements InterServiDeportista{
	 @Autowired
	    private RepoDeportista repoDeportista;

	 

	    // Método para crear un nuevo deportista
	    public void crearDeportista(Deportista deportista) {
	        // Llama al repositorio para guardar el deportista en la base de datos
	        repoDeportista.crearActuDeportista(deportista);
	    }

	 // Método para agregar un deporte a un deportista dado su ID y el nombre del deporte
	 
	    /*public void agregarDeporte(Long deportistaId, String deporteNombre) {
	        // Busca el deportista por su ID
	        Deportista deportista = repoDeportista.buscarDeportistaPorId(deportistaId);
	        if (deportista != null) {  // Si el deportista existe
	            // Busca si el deporte ya existe
	            Deporte deporte = repoDeporte.buscarDeportePorNombre(deporteNombre);
	            
	            // Si el deporte no existe, se crea uno nuevo
	            if (deporte == null) {
	                deporte = new Deporte(deporteNombre);  // Crea un nuevo deporte con el nombre proporcionado
	                repoDeporte.crearDeporte(deporte);  // Guarda el nuevo deporte en la base de datos
	            }

	            // Agrega el deporte al deportista
	            deportista.agregarDeporte(deporte);
	            // Actualiza la información del deportista en la base de datos
	            repoDeportista.crearDeportista(deportista);
	        }
	    }
*/


	    // Método para obtener todos los deportistas de la base de datos
	    public List<Deportista> obtenerTodosLosDeportistas() {
	        // Devuelve la lista de todos los deportistas desde el repositorio
	        return repoDeportista.obtenerTodosLosDeportistas();
	    }

	    // Método para obtener un deportista específico por su ID
	    public Deportista obtenerDeportistaPorId(Long id) {
	        // Llama al repositorio para buscar el deportista por su ID
	        return repoDeportista.buscarDeportistaPorId(id);
	    }

	    // Método para eliminar un deporte de un deportista dado su ID y el nombre del deporte
	    public void eliminarDeporte(Long deportistaId, String deporteNombre) {
	        // Busca el deportista por su ID
	        Deportista deportista = repoDeportista.buscarDeportistaPorId(deportistaId);
	        if (deportista != null) {  // Si el deportista existe
	            // Elimina el deporte de la lista de deportes del deportista
	            deportista.getDeportes().removeIf(deporte -> deporte.getNombre().equals(deporteNombre));
	            // Actualiza la información del deportista en la base de datos
	            repoDeportista.crearActuDeportista(deportista);
	        }
	    }
}
