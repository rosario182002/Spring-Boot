package com.example.demo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Proyectos;
import com.example.demo.repositorio.RepositorioProyecto;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ServicioProyecto implements InterfazServiProyecto {

	@Autowired
	public RepositorioProyecto repositorio;
	@Override
	//Crear o actualizar Persona
	public void crearActualizarProyecto(Proyectos proyecto) {
		repositorio.crearActualizarProyecto(proyecto);
	}
	
	@Override
	//Obtener lista de personas
	public List<Proyectos>obtenerListaProyecto(){
		return repositorio.obtenerListaProyectos();
	}
	
	@Override
	//Buscar personas por id
	public Proyectos buscarProyectoId(Integer id) {
		return repositorio.buscarProyectoPorId(id);
	}
	
	@Override
	//Borrar persona
	public void borrarProyecto(Integer id) {
		Proyectos  proyecto = repositorio.buscarProyectoPorId(id); // Guarda el proyecto, en una variable, lo traes a local para ver si existe 
		if(proyecto != null) { //comprueba si existe y si existe lo borra.
			repositorio.borrarProyectos(proyecto);
		}
	}
}
