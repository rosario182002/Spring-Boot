package com.example.demo.repositorio;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Empleado;
import com.example.demo.modelo.Oficina;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class OficinaRepositorio implements OficinaRepositorioInterfaz{
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Oficina obtenerOficina(Oficina oficina) {
		entityManager.persist(oficina);
		return oficina;
	}
	
	@Override
	public List<Oficina> listaOficinas(){
		return entityManager.createQuery("SELECT o FROM Oficina o", Oficina.class).getResultList();
	}

	@Override
	public Oficina obtenerOficinaPorId(Integer id) {
		return entityManager.find(Oficina.class, id);
	}
	
	@Override
	public void borrarOficina(Oficina oficina) {
		entityManager.remove(oficina);
	}
	@Override
	public long contarEmpleados(Integer id) {
		String jpql = "SELECT e FROM Empleado e WHERE e.oficina.id :id";
		Query<Empleado> query = (Query<Empleado>) entityManager.createQuery(jpql, Empleado.class).setParameter("id",id);
		return query.getResultCount();
	}
}
