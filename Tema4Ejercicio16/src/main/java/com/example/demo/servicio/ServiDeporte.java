package com.example.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Deporte;
import com.example.demo.repositorio.RepoDeporte;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ServiDeporte implements InterServiDeporte{

	 @Autowired
	    private RepoDeporte repoDeporte;

	    // Método para crear un nuevo deporte
	 @Override
	    public void crearDeporte(Deporte deporte) {
	        // Llama al método del repositorio para guardar el deporte en la base de datos
	        repoDeporte.crearDeporte(deporte);
	    }

	    // Método para obtener todos los deportes de la base de datos
	 @Override
	    public List<Deporte> obtenerTodosLosDeportes() {
	        // Devuelve la lista de todos los deportes desde el repositorio
	        return repoDeporte.obtenerTodosLosDeportes();
	    }

	    // Método para obtener un deporte específico por su ID
	 @Override
	    public Deporte obtenerDeportePorId(Long id) {
	        // Llama al repositorio para buscar un deporte por su ID
	        return repoDeporte.buscarDeportePorId(id);
	    }

	    // Método para eliminar un deporte por su ID
	 @Override
	    public void eliminarDeporte(Long id) {
	        // Busca el deporte en la base de datos por su ID
	        Deporte deporte = repoDeporte.buscarDeportePorId(id);
	        if (deporte != null) {  // Si el deporte existe
	            // Llama al repositorio para eliminar el deporte
	            repoDeporte.eliminarDeporte(deporte);
	        }
	    }
	
	
}
