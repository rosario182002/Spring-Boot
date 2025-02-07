package com.example.demo.servicio;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Deporte;
import com.example.demo.modelo.Deportista;
import com.example.demo.repositorio.RepoDeporte;
import com.example.demo.repositorio.RepoDeportista;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ServiDeportista implements InterServiDeportista{
	 @Autowired
	    private RepoDeportista repoDeportista;
	 @Autowired
	 	private RepoDeporte repoDeporte;
	 
	 @Override
	    public void crearDeportista(Deportista deportista) {
	        repoDeportista.crearActuDeportista(deportista);
	    }
	 
	 @Override
	    public List<Deportista> obtenerTodosLosDeportistas() {
	        return repoDeportista.obtenerTodosLosDeportistas();
	    }
	 
	 @Override
	    public Deportista obtenerDeportistaPorId(Long id) {
	        return repoDeportista.buscarDeportistaPorId(id);
	    }
	 @Override
	    public void eliminarDeporte(Long deportistaId, String deporteNombre) {
	        Deportista deportista = repoDeportista.buscarDeportistaPorId(deportistaId);
	        if (deportista != null) {
	            deportista.getDeportes().removeIf(deporte -> deporte.getNombre().equals(deporteNombre));
	            repoDeportista.crearActuDeportista(deportista);
	        }
	    }
	 @Override
	    public void agregarDeporte(Long deportistaId, Long deporteId) {
	        Deportista deportista = repoDeportista.buscarDeportistaPorId(deportistaId);
	        Deporte deporte = repoDeporte.buscarDeportePorId(deporteId);

	        if (deportista != null && deporte != null) {
	            Set<Deporte> deportes = deportista.getDeportes();
	            deportes.add(deporte);
	            deportista.setDeportes(deportes);
	            repoDeportista.crearActuDeportista(deportista);
	        }
	    }

	

}
