package com.example.demo.repositorio;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Proyectos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class RepositorioProyecto  implements InterfazRepoProyecto{
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	//crear Proyecto o actualiza
	public void crearActualizarProyecto (Proyectos proyecto) {
		if(proyecto.getId()==null) {
			entityManager.persist(proyecto);
		}else {
			entityManager.merge(proyecto);
		}
	}
	
	@Override
	//Lista de Proyectos
	public List<Proyectos> obtenerListaProyectos(){
		return entityManager.createQuery("Select pro from Proyecto pro", Proyectos.class).getResultList();
	}
	
	@Override
	//Buscarr proyecto por id
	public Proyectos buscarProyectoPorId(Integer id) {
		return entityManager.find(Proyectos.class, id);
	}
	
	@Override
	//borrar proyectos
	public void borrarProyectos(Proyectos proyecto) {
		entityManager.remove(proyecto);
	}
}
