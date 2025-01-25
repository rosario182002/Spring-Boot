package com.example.demo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Persona;
import com.example.demo.repositorio.RepositorioPersona;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ServicioPersona implements InterfazServiPersona{
	@Autowired
	public RepositorioPersona repositorio;
	
	@Override
	//Crear o actualizar Persona
	public void crearActualizarPersona(Persona persona) {
		repositorio.crearActualizarPersona(persona);
	}
	
	@Override
	//Obtener lista de personas
	public List<Persona>obtenerListaPersona(){
		return repositorio.obtenerListaPersonas();
	}
	
	@Override
	//Buscar personas por id
	public Persona buscarPersonaId(Integer id) {
		return repositorio.buscarPersonaPorId(id);
	}
	
	@Override
	//Borrar persona
	public void borrarPersona(Integer id) {
		Persona persona = repositorio.buscarPersonaPorId(id); // Guarda la persona, en una variable, lo traes a local para ver si existe 
		if(persona != null) { //comprueba si existe y si existe lo borra.
			repositorio.borrarPersona(persona);
		}
	}
	public void eliminarProyectoDePersona(Integer id_persona, Integer id_proyecto) {
		 Persona persona = repositorio.buscarPersonaPorId(id_persona);
		    if (persona != null) {
		        persona.getProyectos().removeIf(proyecto -> proyecto.getId().equals(id_proyecto));
		        repositorio.crearActualizarPersona(persona); // Guardar los cambios
		    }
	}
	
	@Override
	 public List<Object[]> obtenerNombresPersonasConProyectos() {
	        return repositorio.obtenerNombresPersonasConProyectos();
	    }
	
}
